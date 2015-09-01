/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgli;

/**
 *
 * @author elect
 */
public class Detail {

    public static final short CAP_COMPRESSED_BIT = (1 << 0);
    public static final short CAP_PACKED_BIT = (1 << 1);
    public static final short CAP_NORMALIZED_BIT = (1 << 2);
    public static final short CAP_SCALED_BIT = (1 << 3);
    public static final short CAP_UNSIGNED_BIT = (1 << 4);
    public static final short CAP_SIGNED_BIT = (1 << 5);
    public static final short CAP_INTEGER_BIT = (1 << 6);
    public static final short CAP_FLOAT_BIT = (1 << 7);
    public static final short CAP_DEPTH_BIT = (1 << 8);
    public static final short CAP_STENCIL_BIT = (1 << 9);
    public static final short CAP_COLORSPACE_SRGB_BIT = (1 << 10);
    public static final short CAP_SWIZZLE_BIT = (1 << 11);
    public static final short CAP_LUMINANCE_ALPHA_BIT = (1 << 12);

    public static final FormatInfo[] table = new FormatInfo[]{
        // snorm formats
        new FormatInfo((byte) 1, new byte[]{1, 1, 1}, (byte) 1, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R8_UNORM,
        new FormatInfo((byte) 2, new byte[]{1, 1, 1}, (byte) 2, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_RG8_SNORM,
        new FormatInfo((byte) 3, new byte[]{1, 1, 1}, (byte) 3, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_RGB8_SNORM,
        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 4, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_RGBA8_SNORM,

        new FormatInfo((byte) 2, new byte[]{1, 1, 1}, (byte) 1, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_R16_SNORM,
        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 2, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_RG16_SNORM,
        new FormatInfo((byte) 6, new byte[]{1, 1, 1}, (byte) 3, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_RGB16_SNORM,
        new FormatInfo((byte) 8, new byte[]{1, 1, 1}, (byte) 4, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_RGBA16_SNORM,

        // snorm formats
        new FormatInfo((byte) 1, new byte[]{1, 1, 1}, (byte) 1, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_R8_SNORM,
        new FormatInfo((byte) 2, new byte[]{1, 1, 1}, (byte) 2, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_RG8_SNORM,
        new FormatInfo((byte) 3, new byte[]{1, 1, 1}, (byte) 3, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_RGB8_SNORM,
        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 4, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_RGBA8_SNORM,

        new FormatInfo((byte) 2, new byte[]{1, 1, 1}, (byte) 1, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_R16_SNORM,
        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 2, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_RG16_SNORM,
        new FormatInfo((byte) 6, new byte[]{1, 1, 1}, (byte) 3, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_RGB16_SNORM,
        new FormatInfo((byte) 8, new byte[]{1, 1, 1}, (byte) 4, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_RGBA16_SNORM,
    };

    public static final int bitsPerPixel(int format) {

        FormatInfo info = table[format];

        return info.blockSize * 8 / (info.blockDimension[0] * info.blockDimension[1] * info.blockDimension[2]);
    }
    
    public static byte blockSize(int format) {
        return table[format].blockSize;
    }
    
    public static byte[] blockDimension(int format) {
        return table[format].blockDimension;
    }
    
    public static int componentCount(int format) {
        return table[format].component;
    }
}
