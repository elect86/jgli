/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgli.detail;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import jgli.Gl;
import jgli.Target;
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

    public static Texture loadKtx(ByteBuffer byteBuffer) throws IOException {

        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);

        if (!(byteBuffer.capacity() >= KtxHeader.sizeOf)) {
            throw new Error("Data size smaller than dds header size");
        }

        KtxHeader header = new KtxHeader(byteBuffer);

        char[] identifier = new char[]{0xAB, 0x4B, 0x54, 0x58, 0x20, 0x31, 0x31, 0xBB, 0x0D, 0x0A, 0x1A, 0x0A};

        for (int i = 0; i < identifier.length; i++) {
            if (header.identifier[i] != identifier[i]) {
                return new Texture();
            }
        }

        int offset = KtxHeader.sizeOf;

        // Skip key value data
        offset += header.bytesOfKeyValueData;

        Gl gl;

        jgli.Format format = Gl.find(Gl.InternalFormat.get(header.glInternalFormat),
                Gl.ExternalFormat.get(header.glFormat), Gl.TypeFormat.get(header.glType));

        if (format == jgli.Format.FORMAT_INVALID) {
            throw new Error("format invalid!");
        }

        int blockSize = format.blockSize();

        texture = new Texture(Target.TARGET_1D, format, dimensions, offset, offset, offset)
    }
}
