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
import jgli.Gl;
import jgli.Glm;
import static jgli.Target.*;
import jgli.Texture;

/**
 *
 * @author GBarbieri
 */
public class LoadKtx {

    public static jgli.Target getTarget(KtxHeader header) {

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

        if (!(byteBuffer.capacity() >= KtxHeader.sizeOf)) {
            throw new Error("Data size smaller than dds header size");
        }

        KtxHeader header = new KtxHeader(byteBuffer);

        byte[] identifier = new byte[]{(byte) 0xAB, (byte) 0x4B, (byte) 0x54, (byte) 0x58, (byte) 0x20, (byte) 0x31,
            (byte) 0x31, (byte) 0xBB, (byte) 0x0D, (byte) 0x0A, (byte) 0x1A, (byte) 0x0A};

        for (int i = 0; i < identifier.length; i++) {
            if (header.identifier[i] != identifier[i]) {
                return new Texture();
            }
        }

        int offset = KtxHeader.sizeOf;

        // Skip key value data
        offset += header.bytesOfKeyValueData;

        jgli.Format format = Gl.find(Gl.InternalFormat.get(header.glInternalFormat),
                Gl.ExternalFormat.get(header.glFormat), Gl.TypeFormat.get(header.glType));

        if (format == jgli.Format.FORMAT_INVALID) {
            throw new Error("format invalid!");
        }

        int blockSize = format.blockSize();

        Texture texture = new Texture(getTarget(header), format, new int[]{header.pixelWidth,
            Math.max(header.pixelHeight, 1), Math.max(header.pixelDepth, 1)},
                Math.max(header.numberOfArrayElements, 1), Math.max(header.numberOfFaces, 1),
                Math.max(header.numberOfMipmapLevels, 1));
        
        for (int level = 0; level < texture.levels(); level++) {

            System.out.println("offset " + offset);
            System.out.println("Size " + byteBuffer.getInt(offset));
            offset += Integer.BYTES;

            for (int layer = 0; layer < texture.layers(); layer++) {

                for (int face = 0; face < texture.faces(); face++) {

                    int faceSize = texture.size(level);

                    System.out.println("texture.data(" + layer + ", " + face + ", " + level + ").capacity() "
                            + texture.data(layer, face, level).capacity());

                    System.out.println("Math.max(" + blockSize + ", Glm.ceilMultiple(" + faceSize + ", 4)) "
                            + Math.max(blockSize, Glm.ceilMultiple(faceSize, 4)));

                    byteBuffer.position(offset);
                    byteBuffer.limit(offset + faceSize);
//                    {
                        ByteBuffer data = byteBuffer.slice();
//                    }
                    byteBuffer.position(0);
                    byteBuffer.limit(byteBuffer.capacity());

                    texture.setData(data, layer, face, level);

                    offset += Math.max(blockSize, Glm.ceilMultiple(faceSize, 4));
                }
            }
        }

        return texture;
    }

    public static void main(String[] args) {
        System.out.println("" + ceilMultiple1(32768, 4));
        System.out.println("" + ceilMultiple2(32768, 4));
        System.out.println("" + ceilMultiple3(32768, 4));
    }

    private static float ceilMultiple1(float source, float multiple) {
        if (source > 0) {
            return source + (multiple - (source % multiple));
        } else {
            return source + (-source % multiple);
        }
    }

    private static float ceilMultiple2(float source, float multiple) {
        float tmp = source - 1;
        return tmp + (multiple - (tmp % multiple));
    }

    private static float ceilMultiple3(float source, float multiple) {
        if (source > 0) {
            float tmp = source - 1;
            return tmp + (multiple - (tmp % multiple));
        } else {
            return source + (-source % multiple);
        }
    }
}
