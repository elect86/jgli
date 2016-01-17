/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgli.detail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import jgli.Dx;
import static jgli.Dx.D3dFormat.D3DFMT_DX10;
import static jgli.Dx.Ddpf.*;
import static jgli.Dx.DxgiFormat.DXGI_FORMAT_UNKNOWN;
import static jgli.Format.*;
import jgli.Glm;
import static jgli.Target.*;
import jgli.Texture;
import static jgli.detail.LoadDds.D3d10ResourceDimension.*;
import static jgli.detail.LoadDds.DdsCubemapFlag.*;
import static jgli.detail.LoadDds.DdsFlag.*;

/**
 *
 * @author GBarbieri
 */
public class LoadDds {

    public static final int fourCC_Dds = Dx.D3dFormat.jgliMakeFourCC('D', 'D', 'S', ' ');

    public enum DdsCubemapFlag {

        DDSCAPS2_CUBEMAP(0x00000200),
        DDSCAPS2_CUBEMAP_POSITIVEX(0x00000400),
        DDSCAPS2_CUBEMAP_NEGATIVEX(0x00000800),
        DDSCAPS2_CUBEMAP_POSITIVEY(0x00001000),
        DDSCAPS2_CUBEMAP_NEGATIVEY(0x00002000),
        DDSCAPS2_CUBEMAP_POSITIVEZ(0x00004000),
        DDSCAPS2_CUBEMAP_NEGATIVEZ(0x00008000),
        DDSCAPS2_VOLUME(0x00200000),
        DDSCAPS2_CUBEMAP_ALLFACES(DDSCAPS2_CUBEMAP_POSITIVEX.value | DDSCAPS2_CUBEMAP_NEGATIVEX.value
                | DDSCAPS2_CUBEMAP_POSITIVEY.value | DDSCAPS2_CUBEMAP_NEGATIVEY.value
                | DDSCAPS2_CUBEMAP_POSITIVEZ.value | DDSCAPS2_CUBEMAP_NEGATIVEZ.value);

        public final int value;

        private DdsCubemapFlag(int value) {
            this.value = value;
        }

        private DdsCubemapFlag(DdsCubemapFlag ddsCubemapFlag) {
            value = ddsCubemapFlag.value;
        }
    }

    public enum DdsFlag {

        DDSD_CAPS(0x00000001),
        DDSD_HEIGHT(0x00000002),
        DDSD_WIDTH(0x00000004),
        DDSD_PITCH(0x00000008),
        DDSD_PIXELFORMAT(0x00001000),
        DDSD_MIPMAPCOUNT(0x00020000),
        DDSD_LINEARSIZE(0x00080000),
        DDSD_DEPTH(0x00800000);

        public final int value;

        private DdsFlag(int value) {
            this.value = value;
        }
    }

    public enum DdsSurfaceFlag {

        DDSCAPS_COMPLEX(0x00000008),
        DDSCAPS_MIPMAP(0x00400000),
        DDSCAPS_TEXTURE(0x00001000);

        public final int value;

        private DdsSurfaceFlag(int value) {
            this.value = value;
        }
    }

    public enum D3d10ResourceDimension {

        D3D10_RESOURCE_DIMENSION_UNKNOWN(0),
        D3D10_RESOURCE_DIMENSION_BUFFER(1),
        D3D10_RESOURCE_DIMENSION_TEXTURE1D(2),
        D3D10_RESOURCE_DIMENSION_TEXTURE2D(3),
        D3D10_RESOURCE_DIMENSION_TEXTURE3D(4);

        public final int value;

        private D3d10ResourceDimension(int value) {
            this.value = value;
        }
    }

    public enum D3d10ResourceMiscFlag {

        D3D10_RESOURCE_MISC_GENERATE_MIPS(0x01),
        D3D10_RESOURCE_MISC_SHARED(0x02),
        D3D10_RESOURCE_MISC_TEXTURECUBE(0x04),
        D3D10_RESOURCE_MISC_SHARED_KEYEDMUTEX(0x10),
        D3D10_RESOURCE_MISC_GDI_COMPATIBLE(0x20);

        public final int value;

        private D3d10ResourceMiscFlag(int value) {
            this.value = value;
        }
    }

    public enum DdsAlphaMode {

        DDS_ALPHA_MODE_UNKNOWN(0x0),
        DDS_ALPHA_MODE_STRAIGHT(0x1),
        DDS_ALPHA_MODE_PREMULTIPLIED(0x2),
        DDS_ALPHA_MODE_OPAQUE(0x3),
        DDS_ALPHA_MODE_CUSTOM(0x4);

        public final int value;

        private DdsAlphaMode(int value) {
            this.value = value;
        }

        public static DdsAlphaMode get(int value) {
            if (value >= DDS_ALPHA_MODE_UNKNOWN.value && value <= DDS_ALPHA_MODE_CUSTOM.value) {
                return DdsAlphaMode.values()[value];
            } else {
                return DDS_ALPHA_MODE_UNKNOWN;
            }
        }
    }

    private static jgli.Target getTarget(DdsHeader header, DdsHeader10 header10) {

        if ((header.cubemapFlags & DDSCAPS2_CUBEMAP.value) != 0) {

            if (header10.arraySize > 1) {
                return TARGET_CUBE_ARRAY;
            } else {
                return TARGET_CUBE;
            }

        } else if (header10.arraySize > 1) {

            if ((header.flags & DDSD_HEIGHT.value) != 0) {
                return TARGET_2D_ARRAY;
            } else {
                return TARGET_1D_ARRAY;
            }

        } else if (header10.resourceDimension == D3D10_RESOURCE_DIMENSION_TEXTURE1D) {
            return TARGET_1D;
        } else if (header10.resourceDimension == D3D10_RESOURCE_DIMENSION_TEXTURE3D
                || ((header.flags & DDSD_DEPTH.value) != 0)) {
            return TARGET_3D;
        } else {
            return TARGET_2D;
        }
    }

//    public static Texture loadDds(String filename) throws IOException {
//        return loadDds(new File(LoadDds.class.getResource(filename).getFile()));
//    }
    public static Texture loadDds(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();

        return loadDds(fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, (int) file.length()));
    }

    public static Texture loadDds(ByteBuffer byteBuffer) throws IOException {

        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);

        if (!(byteBuffer.capacity() >= DdsHeader.sizeOf)) {
            throw new Error("Data size smaller than dds header size");
        }

        DdsHeader header = new DdsHeader(byteBuffer);

        if (header.magic != fourCC_Dds) {
            return new Texture();
        }

        int offset = DdsHeader.sizeOf;

        DdsHeader10 header10 = new DdsHeader10();

        if ((header.format.flags & DDPF_FOURCC.value) != 0 && header.format.fourCC == D3DFMT_DX10) {

            header10 = new DdsHeader10(byteBuffer);
            offset += DdsHeader10.sizeOf;
        }

        Dx dx = new Dx();

        jgli.Format format = FORMAT_INVALID;

//        System.out.println("(header.format.flags & (DDPF_RGB.value | DDPF_ALPHAPIXELS.value | DDPF_ALPHA.value "
//                + "| DDPF_YUV.value | DDPF_LUMINANCE.value)) " + (header.format.flags & (DDPF_RGB.value
//                | DDPF_ALPHAPIXELS.value | DDPF_ALPHA.value | DDPF_YUV.value | DDPF_LUMINANCE.value)));
        if (((header.format.flags & (DDPF_RGB.value | DDPF_ALPHAPIXELS.value | DDPF_ALPHA.value
                | DDPF_YUV.value | DDPF_LUMINANCE.value))) != 0 && format == FORMAT_INVALID
                && header.format.flags != DDPF_FOURCC_ALPHAPIXELS.value) {

            switch (header.format.bpp) {

                case 8:

                    if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_L8_UNORM).mask))) {
                        format = FORMAT_L8_UNORM;
                    } else if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_A8_UNORM).mask))) {
                        format = FORMAT_A8_UNORM;
                    } else if (Glm.all(
                            Glm.equal(header.format.mask, dx.translate(FORMAT_R8_UNORM_PACK8).mask))) {
                        format = FORMAT_R8_UNORM_PACK8;
                    } else if (Glm.all(Glm.equal(
                            header.format.mask, dx.translate(FORMAT_RG3B2_UNORM_PACK8).mask))) {
                        format = FORMAT_RG3B2_UNORM_PACK8;
                    }
                    break;

                case 16:

                    if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_LA8_UNORM).mask))) {
                        format = FORMAT_LA8_UNORM;
                    } else if (Glm.all(Glm.equal(
                            header.format.mask, dx.translate(FORMAT_RG8_UNORM_PACK8).mask))) {
                        format = FORMAT_RG8_UNORM_PACK8;
                    } else if (Glm.all(Glm.equal(
                            header.format.mask, dx.translate(FORMAT_R5G6B5_UNORM_PACK16).mask))) {
                        format = FORMAT_R5G6B5_UNORM_PACK16;
                    } else if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_L16_UNORM).mask))) {
                        format = FORMAT_L16_UNORM;
                    } else if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_A16_UNORM).mask))) {
                        format = FORMAT_A16_UNORM;
                    } else if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_R16_UNORM).mask))) {
                        format = FORMAT_R16_UNORM;
                    } else if (Glm.all(Glm.equal(
                            header.format.mask, dx.translate(FORMAT_RGB5A1_UNORM_PACK16).mask))) {
                        format = FORMAT_RGB5A1_UNORM_PACK16;
                    }
                    break;

                case 24:

                    Dx.Format dxFormat = dx.translate(FORMAT_RGB8_UNORM_PACK8);
                    if (Glm.all(Glm.equal(header.format.mask, dxFormat.mask))) {
                        format = FORMAT_RGB8_UNORM_PACK8;
                    }
                    break;

                case 32:

                    if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_BGR8_UNORM_PACK32).mask))) {
                        format = FORMAT_BGR8_UNORM_PACK32;
                    } else if (Glm.all(Glm.equal(
                            header.format.mask, dx.translate(FORMAT_BGRA8_UNORM_PACK8).mask))) {
                        format = FORMAT_BGRA8_UNORM_PACK8;
                    } else if (Glm.all(Glm.equal(
                            header.format.mask, dx.translate(FORMAT_RGBA8_UNORM_PACK8).mask))) {
                        format = FORMAT_RGBA8_UNORM_PACK8;
                    } else if (Glm.all(Glm.equal(
                            header.format.mask, dx.translate(FORMAT_RGB10A2_UNORM_PACK32).mask))) {
                        format = FORMAT_RGB10A2_UNORM_PACK32;
                    } else if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_LA16_UNORM).mask))) {
                        format = FORMAT_LA16_UNORM;
                    } else if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_RG16_UNORM).mask))) {
                        format = FORMAT_RG16_UNORM;
                    } else if (Glm.all(Glm.equal(header.format.mask, dx.translate(FORMAT_R32_SFLOAT).mask))) {
                        format = FORMAT_R32_SFLOAT;
                    }
                    break;
            }
        } else if (((header.format.flags & DDPF_FOURCC.value) != 0) && (header.format.fourCC != D3DFMT_DX10)
                && (format == FORMAT_INVALID)) {
            format = dx.find(header.format.fourCC, header.format.flags);
        } else if ((header.format.fourCC == D3DFMT_DX10) && (header10.format != DXGI_FORMAT_UNKNOWN)) {
            format = dx.find(header10.format, header.format.flags);
        }

        if (format == FORMAT_INVALID) {
            throw new Error("format invalid");
        }

        int mipmapCount = (header.flags & DDSD_MIPMAPCOUNT.value) != 0 ? header.mipMapLevels : 1;
        int faceCount = 1;
        if ((header.cubemapFlags & DDSCAPS2_CUBEMAP.value) != 0) {
            faceCount = Integer.bitCount(header.cubemapFlags & DDSCAPS2_CUBEMAP_ALLFACES.value);
        }

        int depthCount = 1;
        if ((header.cubemapFlags & DDSCAPS2_VOLUME.value) != 0) {
            depthCount = header.depth;
        }

        Texture texture = new Texture(getTarget(header, header10), format, new int[]{header.width,
            header.height, depthCount}, Math.max(header10.arraySize, 1), faceCount, mipmapCount);

        int sourceSize = offset + texture.size();

        if (!(sourceSize == byteBuffer.capacity())) {
            throw new Error("!(offset " + offset + " + texture.size " + texture.size()
                    + " == byteBuffer.capacity()) " + byteBuffer.capacity());
        }

        byteBuffer.position(offset);
        texture.setData(byteBuffer.slice());
        byteBuffer.position(0);

        return texture;
    }
}
