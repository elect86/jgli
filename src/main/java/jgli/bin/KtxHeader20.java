/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgli.bin;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 *
 * @author GBarbieri
 */
public class KtxHeader20 {
    
    public byte[] identifier = new byte[12];
    public int endianness;
    public int format;
    public int target;
    public int swizzleRed;
    public int SwizzleGreen;
    public int swizzleBlue;
    public int swizzleAlpha;
    public int pixelWidth;
    public int pixelHeight;
    public int pixelDepth;
    public int numberOfLayers;
    public int numberOfFaces;
    public int numberOfLevels;

    public static final int sizeOf = 12 * Byte.BYTES + 13 * Integer.BYTES;
    private static final int littleEndian = 0x01020304;

    public KtxHeader20(ByteBuffer byteBuffer) {

        for (int i = 0; i < identifier.length; i++) {
            identifier[i] = byteBuffer.get();
        }
        endianness = byteBuffer.getInt();
        
        if(endianness == littleEndian) {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        }
        
        format = byteBuffer.getInt();
        target = byteBuffer.getInt();
        swizzleRed = byteBuffer.getInt();
        SwizzleGreen = byteBuffer.getInt();
        swizzleBlue = byteBuffer.getInt();
        swizzleAlpha = byteBuffer.getInt();
        pixelWidth = byteBuffer.getInt();
        pixelHeight = byteBuffer.getInt();
        pixelDepth = byteBuffer.getInt();
        numberOfLayers = byteBuffer.getInt();
        numberOfFaces = byteBuffer.getInt();
        numberOfLevels = byteBuffer.getInt();
    }
}
