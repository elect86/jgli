/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgli.detail;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 *
 * @author GBarbieri
 */
public class KtxHeader {

    public byte[] identifier = new byte[12];
    public int endianness;
    public int glType;
    public int glTypeSize;
    public int glFormat;
    public int glInternalFormat;
    public int glBaseInternalFormat;
    public int pixelWidth;
    public int pixelHeight;
    public int pixelDepth;
    public int numberOfArrayElements;
    public int numberOfFaces;
    public int numberOfMipmapLevels;
    public int bytesOfKeyValueData;

    public static final int sizeOf = 12 * Byte.BYTES + 13 * Integer.BYTES;
    private static final int littleEndian = 0x01020304;

    public KtxHeader(ByteBuffer byteBuffer) {

        for (int i = 0; i < identifier.length; i++) {
            identifier[i] = byteBuffer.get();
        }
        endianness = byteBuffer.getInt();
        
        if(endianness == littleEndian) {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        }
        
        glType = byteBuffer.getInt();
        glTypeSize = byteBuffer.getInt();
        glFormat = byteBuffer.getInt();
        glInternalFormat = byteBuffer.getInt();
        glBaseInternalFormat = byteBuffer.getInt();
        pixelWidth = byteBuffer.getInt();
        pixelHeight = byteBuffer.getInt();
        pixelDepth = byteBuffer.getInt();
        numberOfArrayElements = byteBuffer.getInt();
        numberOfFaces = byteBuffer.getInt();
        numberOfMipmapLevels = byteBuffer.getInt();
        bytesOfKeyValueData = byteBuffer.getInt();
    }
}
