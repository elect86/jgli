/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gli.detail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import gli.Gl;
import gli.Glm;
import static gli.Target.*;
import gli.Texture;

/**
 *
 * @author GBarbieri
 */
public class LoadKtx {

    public static final byte[] fourCC_Ktx10 = new byte[]{(byte) 0xAB, (byte) 0x4B, (byte) 0x54, (byte) 0x58,
        (byte) 0x20, (byte) 0x31, (byte) 0x31, (byte) 0xBB, (byte) 0x0D, (byte) 0x0A, (byte) 0x1A, (byte) 0x0A};
    public static final byte[] fourCC_Ktx20 = new byte[]{(byte) 0xAB, (byte) 0x4B, (byte) 0x54, (byte) 0x58,
        (byte) 0x20, (byte) 0x32, (byte) 0x30, (byte) 0xBB, (byte) 0x0D, (byte) 0x0A, (byte) 0x1A, (byte) 0x0A};

    public static gli.Target getTarget(KtxHeader10 header) {

        if (header.numberOfFaces > 1) {

            if (header.numberOfArrayElements > 0) {
                return TARGET_CUBE_ARRAY;
            } else {
                return TARGET_CUBE;
            }
        } else if (header.numberOfArrayElements > 0) {

            if (header.pixelHeight == 0) {
                return TARGET_1D_ARRAY;
            } else {
                return TARGET_2D_ARRAY;
            }
        } else if (header.pixelHeight == 0) {
            return TARGET_1D;
        } else if (header.pixelDepth > 0) {
            return TARGET_3D;
        } else {
            return TARGET_2D;
        }
    }

    public static Texture loadKtx(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();

        return loadKtx(fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, (int) file.length()));
    }

    public static Texture loadKtx(ByteBuffer byteBuffer) throws IOException {

        if (!(byteBuffer.capacity() >= KtxHeader10.sizeOf)) {
            throw new Error("Data size smaller than dds header size");
        }

        // KTX10
        {
            KtxHeader10 header = new KtxHeader10(byteBuffer);

            for (int i = 0; i < fourCC_Ktx10.length; i++) {
                if (header.identifier[i] != fourCC_Ktx10[i]) {
                    return new Texture();
                }
            }
            return loadKtx10(header, byteBuffer);
        }
    }

    public static Texture loadKtx10(KtxHeader10 header, ByteBuffer byteBuffer) throws IOException {

        int offset = KtxHeader10.sizeOf;

        // Skip key value data
        offset += header.bytesOfKeyValueData;

        gli.Gl.InternalFormat internalFormat = Gl.InternalFormat.get(header.glInternalFormat);
        gli.Gl.ExternalFormat externalFormat = Gl.ExternalFormat.get(header.glFormat);
        gli.Gl.TypeFormat typeFormat = Gl.TypeFormat.get(header.glType);
        gli.Format format = Gl.find(internalFormat, externalFormat, typeFormat);

        if (format == gli.Format.FORMAT_INVALID) {
            throw new Error("format invalid!");
        }

        int blockSize = format.blockSize();

        Texture texture = new Texture(getTarget(header), format, new int[]{header.pixelWidth,
            Math.max(header.pixelHeight, 1), Math.max(header.pixelDepth, 1)},
                Math.max(header.numberOfArrayElements, 1), Math.max(header.numberOfFaces, 1),
                Math.max(header.numberOfMipmapLevels, 1));

        for (int level = 0; level < texture.levels(); level++) {

//            System.out.println("offset " + offset);
//            System.out.println("Size " + byteBuffer.getInt(offset));
            offset += Integer.BYTES;

            for (int layer = 0; layer < texture.layers(); layer++) {

                for (int face = 0; face < texture.faces(); face++) {

                    int faceSize = texture.size(level);

//                    System.out.println("texture.data(" + layer + ", " + face + ", " + level + ").capacity() "
//                            + texture.data(layer, face, level).capacity());
//
//                    System.out.println("Math.max(" + blockSize + ", Glm.ceilMultiple(" + faceSize + ", 4)) "
//                            + Math.max(blockSize, Glm.ceilMultiple(faceSize, 4)));
                    byteBuffer.position(offset);
                    byteBuffer.limit(offset + faceSize);
                    {
                        ByteBuffer data = byteBuffer.slice();
                        texture.setData(data, layer, face, level);
                    }
                    byteBuffer.position(0);
                    byteBuffer.limit(byteBuffer.capacity());

                    offset += Math.max(blockSize, Glm.ceilMultiple(faceSize, 4));
                }
            }
        }
        
        System.out.println(texture.toString());

        return texture;
    }
}
