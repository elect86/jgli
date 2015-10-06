/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgli.detail;

import java.nio.ByteBuffer;

/**
 *
 * @author GBarbieri
 */
public class KtxHeader {

    public char[] identifier = new char[12];
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

    public static final int sizeOf = 12 * Character.BYTES + 13 * Integer.BYTES;

    public KtxHeader(ByteBuffer byteBuffer) {

        for (int i = 0; i < identifier.length; i++) {
            identifier[i] = byteBuffer.getChar();
        }
        endianness = byteBuffer.getInt();
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
