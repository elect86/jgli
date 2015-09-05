/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgli;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import static jgli.Detail.D3D10_RESOURCE_DIMENSION_TEXTURE1D;
import static jgli.Jgli.*;
import static jgli.Target.*;
import resources.Dx;

/**
 *
 * @author gbarbieri
 */
public class LoadDds {

    public static Texture loadDds(String filename) throws IOException {
        return loadDds(new File(filename));
    }

    public static Texture loadDds(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();

        return loadDds(fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, (int) file.length()));
    }
    
    private static int getTarget(Detail.DdsHeader header, Detail.DdsHeader10 header10) {

        if ((header.cubemapFlags & Detail.DDSCAPS2_CUBEMAP) != 0) {

            if (header10.arraySize > 1) {
                return TARGET_CUBE_ARRAY;
            } else {
                return TARGET_CUBE;
            }

        } else if (header10.arraySize > 1) {

            if ((header.flags & Detail.DDSD_HEIGHT) != 0) {
                return TARGET_2D_ARRAY;
            } else {
                return TARGET_1D_ARRAY;
            }

        } else if (header10.resourceDimension == D3D10_RESOURCE_DIMENSION_TEXTURE1D) {
            return TARGET_1D;
        } else if (header10.resourceDimension == Detail.D3D10_RESOURCE_DIMENSION_TEXTURE3D
                || ((header.flags & Detail.DDSD_DEPTH) != 0)) {
            return TARGET_3D;
        } else {
            return TARGET_2D;
        }
    }

    public static Texture loadDds(ByteBuffer byteBuffer) throws IOException {

        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);

        if (byteBuffer.capacity() < Detail.DdsHeader.sizeOf) {
            throw new Error("Data size smaller than dds header size");
        }

        Detail.DdsHeader header = new Detail.DdsHeader(byteBuffer);

        if (header.magic != makeFourCC('D', 'D', 'S', ' ')) {
            return new Texture();
        }

        int offset = Detail.DdsHeader.sizeOf;

        Detail.DdsHeader10 header10 = null;

        if ((header.format.flags & Dx.DDPF_FOURCC) != 0
                && header.format.fourCC == Dx.D3DFMT_DX10) {

            header10 = new Detail.DdsHeader10(byteBuffer);
            offset += Detail.DdsHeader10.sizeOf;
        }

        Dx dx = new Dx();

        int format = FORMAT_INVALID;

        if (((header.format.flags & (Dx.DDPF_RGB | Dx.DDPF_ALPHAPIXELS
                | Dx.DDPF_ALPHA | Dx.DDPF_YUV | Dx.DDPF_LUMINANCE))) != 0
                && format == FORMAT_INVALID
                && header.format.flags != Dx.DDPF_FOURCC_ALPHAPIXELS) {

            switch (header.format.bpp) {

                case 8:

                    if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_L8_UNORM).mask))) {
                        format = FORMAT_L8_UNORM;
                    } else if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_A8_UNORM).mask))) {
                        format = FORMAT_A8_UNORM;
                    } else if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_R8_UNORM).mask))) {
                        format = FORMAT_R8_UNORM;
                    } else if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_RG3B2_UNORM).mask))) {
                        format = FORMAT_RG3B2_UNORM;
                    }
                    break;

                case 16:

                    if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_LA8_UNORM).mask))) {
                        format = FORMAT_LA8_UNORM;
                    } else if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_RG8_UNORM).mask))) {
                        format = FORMAT_RG8_UNORM;
                    } else if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_R5G6B5_UNORM).mask))) {
                        format = FORMAT_R5G6B5_UNORM;
                    } else if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_L16_UNORM).mask))) {
                        format = FORMAT_L16_UNORM;
                    } else if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_A16_UNORM).mask))) {
                        format = FORMAT_A16_UNORM;
                    } else if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_R16_UNORM).mask))) {
                        format = FORMAT_R16_UNORM;
                    } else if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_RGB5A1_UNORM).mask))) {
                        format = FORMAT_RGB5A1_UNORM;
                    }
                    break;

                case 24:

                    Dx.Format dxFormat = dx.translate(FORMAT_RGB8_UNORM);
                    if (Glm.all(Glm.equal(header.format.mask, dxFormat.mask))) {
                        format = FORMAT_RGB8_UNORM;
                    }
                    break;

                case 32:

                    if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_BGRX8_UNORM).mask))) {
                        format = FORMAT_BGRX8_UNORM;
                    } else if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_BGRA8_UNORM).mask))) {
                        format = FORMAT_BGRA8_UNORM;
                    } else if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_RGB10A2_UNORM).mask))) {
                        format = FORMAT_RGB10A2_UNORM;
                    } else if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_LA16_UNORM).mask))) {
                        format = FORMAT_LA16_UNORM;
                    } else if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_RG16_UNORM).mask))) {
                        format = FORMAT_RG16_UNORM;
                    } else if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_R32_SFLOAT).mask))) {
                        format = FORMAT_R32_SFLOAT;
                    }
                    break;
            }
        } else if (((header.format.flags & Dx.DDPF_FOURCC) != 0)
                && (header.format.fourCC != Dx.D3DFMT_DX10)
                && (format == Jgli.FORMAT_INVALID)) {
            format = dx.find(header.format.fourCC, true);
        } else if ((header.format.fourCC == Dx.D3DFMT_DX10)
                && (header10.format != Dx.DXGI_FORMAT_UNKNOWN)) {
            format = dx.find(header10.format, false);
        }

        if (format == Jgli.FORMAT_INVALID) {
            throw new Error("format invalid");
        }

        int mipmapCount = (header.flags & Detail.DDSD_MIPMAPCOUNT) != 0 ? header.mipMapLevels : 1;
        int faceCount = 1;

        if ((header.cubemapFlags & Detail.DDSCAPS2_CUBEMAP) != 0) {

            faceCount = Integer.bitCount(header.cubemapFlags & Detail.DDSCAPS2_CUBEMAP_ALLFACES);
        }

        int depthCount = 1;
        if ((header.cubemapFlags & Detail.DDSCAPS2_VOLUME) != 0) {

            depthCount = header.depth;
        }

        return null;
    }

    

    public static final int makeFourCC(char ch0, char ch1, char ch2, char ch3) {
        return (((int) ch0)) | (((int) ch1) << 8) | (((int) ch2) << 16) | (((int) ch3) << 24);
    }
}
