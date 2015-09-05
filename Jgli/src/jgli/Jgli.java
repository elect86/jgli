/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgli;

/**
 *
 * @author gbarbieri
 */
public class Jgli {
    
    /**
     * Formats.
     */
    // unorm formats
    public static final int FORMAT_R8_UNORM = 0;
    public static final int FORMAT_FIRST = FORMAT_R8_UNORM;
    public static final int FORMAT_RG8_UNORM = 1;
    public static final int FORMAT_RGB8_UNORM = 2;
    public static final int FORMAT_RGBA8_UNORM = 3;

    public static final int FORMAT_R16_UNORM = 4;
    public static final int FORMAT_RG16_UNORM = 5;
    public static final int FORMAT_RGB16_UNORM = 6;
    public static final int FORMAT_RGBA16_UNORM = 7;

    // snorm formats
    public static final int FORMAT_R8_SNORM = 8;
    public static final int FORMAT_RG8_SNORM = 9;
    public static final int FORMAT_RGB8_SNORM = 10;
    public static final int FORMAT_RGBA8_SNORM = 11;

    public static final int FORMAT_R16_SNORM = 12;
    public static final int FORMAT_RG16_SNORM = 13;
    public static final int FORMAT_RGB16_SNORM = 14;
    public static final int FORMAT_RGBA16_SNORM = 15;

    // Unsigned integer formats
    public static final int FORMAT_R8_UINT = 16;
    public static final int FORMAT_RG8_UINT = 17;
    public static final int FORMAT_RGB8_UINT = 18;
    public static final int FORMAT_RGBA8_UINT = 19;
    public static final int FORMAT_R16_UINT = 20;
    public static final int FORMAT_RG16_UINT = 21;
    public static final int FORMAT_RGB16_UINT = 22;
    public static final int FORMAT_RGBA16_UINT = 23;
    public static final int FORMAT_R32_UINT = 24;
    public static final int FORMAT_RG32_UINT = 25;
    public static final int FORMAT_RGB32_UINT = 26;
    public static final int FORMAT_RGBA32_UINT = 27;
    // Signed integer formats
    public static final int FORMAT_R8_SINT = 28;
    public static final int FORMAT_RG8_SINT = 29;
    public static final int FORMAT_RGB8_SINT = 30;
    public static final int FORMAT_RGBA8_SINT = 31;
    public static final int FORMAT_R16_SINT = 32;
    public static final int FORMAT_RG16_SINT = 33;
    public static final int FORMAT_RGB16_SINT = 34;
    public static final int FORMAT_RGBA16_SINT = 35;
    public static final int FORMAT_R32_SINT = 36;
    public static final int FORMAT_RG32_SINT = 37;
    public static final int FORMAT_RGB32_SINT = 38;
    public static final int FORMAT_RGBA32_SINT = 39;
    // Floating formats
    public static final int FORMAT_R16_SFLOAT = 40;
    public static final int FORMAT_RG16_SFLOAT = 41;
    public static final int FORMAT_RGB16_SFLOAT = 42;
    public static final int FORMAT_RGBA16_SFLOAT = 43;
    public static final int FORMAT_R32_SFLOAT = 44;
    public static final int FORMAT_RG32_SFLOAT = 45;
    public static final int FORMAT_RGB32_SFLOAT = 46;
    public static final int FORMAT_RGBA32_SFLOAT = 47;
    // sRGB formats
    public static final int FORMAT_R8_SRGB = 48;
    public static final int FORMAT_RG8_SRGB = 49;
    public static final int FORMAT_RGB8_SRGB = 50;
    public static final int FORMAT_RGBA8_SRGB = 51;
    // Packed formats
    public static final int FORMAT_RGB10A2_UNORM = 52;
    public static final int FORMAT_RGB10A2_UINT = 53;
    public static final int FORMAT_RGB9E5_UFLOAT = 54;
    public static final int FORMAT_RG11B10_UFLOAT = 55;
    public static final int FORMAT_RG3B2_UNORM = 56;
    public static final int FORMAT_R5G6B5_UNORM = 57;
    public static final int FORMAT_RGB5A1_UNORM = 58;
    public static final int FORMAT_RGBA4_UNORM = 59;
    // Swizzle formats
    public static final int FORMAT_BGRX8_UNORM = 60;
    public static final int FORMAT_BGRA8_UNORM = 61;
    public static final int FORMAT_BGRX8_SRGB = 62;
    public static final int FORMAT_BGRA8_SRGB = 63;
    // Luminance Alpha formats
    public static final int FORMAT_L8_UNORM = 64;
    public static final int FORMAT_A8_UNORM = 65;
    public static final int FORMAT_LA8_UNORM = 66;
    public static final int FORMAT_L16_UNORM = 67;
    public static final int FORMAT_A16_UNORM = 68;
    public static final int FORMAT_LA16_UNORM = 69;
    // Depth formats
    public static final int FORMAT_D16_UNORM = 70;
    public static final int FORMAT_D24_UNORM = 71;
    public static final int FORMAT_D24S8_UNORM = 72;
    public static final int FORMAT_D32_UFLOAT = 73;
    public static final int FORMAT_D32_UFLOAT_S8_UNORM = 74;
    // Compressed formats
    public static final int FORMAT_RGB_DXT1_UNORM = 75;
    public static final int FORMAT_COMPRESSED_FIRST = FORMAT_RGB_DXT1_UNORM;
    public static final int FORMAT_RGBA_DXT1_UNORM = 76;
    public static final int FORMAT_RGBA_DXT3_UNORM = 77;
    public static final int FORMAT_RGBA_DXT5_UNORM = 78;
    public static final int FORMAT_R_ATI1N_UNORM = 79;
    public static final int FORMAT_R_ATI1N_SNORM = 80;
    public static final int FORMAT_RG_ATI2N_UNORM = 81;
    public static final int FORMAT_RG_ATI2N_SNORM = 82;
    public static final int FORMAT_RGB_BP_UFLOAT = 83;
    public static final int FORMAT_RGB_BP_SFLOAT = 84;
    public static final int FORMAT_RGB_BP_UNORM = 85;
    public static final int FORMAT_RGB_PVRTC_8X8_UNORM = 86;
    public static final int FORMAT_RGB_PVRTC_16X8_UNORM = 87;
    public static final int FORMAT_RGBA_PVRTC_8X8_UNORM = 88;
    public static final int FORMAT_RGBA_PVRTC_16X8_UNORM = 89;
    public static final int FORMAT_RGBA_PVRTC2_8X8_UNORM = 90;
    public static final int FORMAT_RGBA_PVRTC2_16X8_UNORM = 91;
    public static final int FORMAT_RGB_ATC_UNORM = 92;
    public static final int FORMAT_RGBA_ATC_EXPLICIT_UNORM = 93;
    public static final int FORMAT_RGBA_ATC_INTERPOLATED_UNORM = 94;
    public static final int FORMAT_RGB_ETC_UNORM = 95;
    public static final int FORMAT_RGB_ETC2_UNORM = 96;
    public static final int FORMAT_RGBA_ETC2_PUNCHTHROUGH_UNORM = 97;
    public static final int FORMAT_RGBA_ETC2_UNORM = 98;
    public static final int FORMAT_R11_EAC_UNORM = 99;
    public static final int FORMAT_R11_EAC_SNORM = 100;
    public static final int FORMAT_RG11_EAC_UNORM = 101;
    public static final int FORMAT_RG11_EAC_SNORM = 102;
    public static final int FORMAT_RGBA_ASTC_4X4_UNORM = 103;
    public static final int FORMAT_RGBA_ASTC_5X4_UNORM = 104;
    public static final int FORMAT_RGBA_ASTC_5X5_UNORM = 105;
    public static final int FORMAT_RGBA_ASTC_6X5_UNORM = 106;
    public static final int FORMAT_RGBA_ASTC_6X6_UNORM = 107;
    public static final int FORMAT_RGBA_ASTC_8X5_UNORM = 108;
    public static final int FORMAT_RGBA_ASTC_8X6_UNORM = 109;
    public static final int FORMAT_RGBA_ASTC_8X8_UNORM = 110;
    public static final int FORMAT_RGBA_ASTC_10X5_UNORM = 111;
    public static final int FORMAT_RGBA_ASTC_10X6_UNORM = 112;
    public static final int FORMAT_RGBA_ASTC_10X8_UNORM = 113;
    public static final int FORMAT_RGBA_ASTC_10X10_UNORM = 114;
    public static final int FORMAT_RGBA_ASTC_12X10_UNORM = 115;
    public static final int FORMAT_RGBA_ASTC_12X12_UNORM = 116;
    // Compressed sRGB formats
    public static final int FORMAT_RGB_DXT1_SRGB = 117;
    public static final int FORMAT_RGBA_DXT1_SRGB = 118;
    public static final int FORMAT_RGBA_DXT3_SRGB = 119;
    public static final int FORMAT_RGBA_DXT5_SRGB = 120;
    public static final int FORMAT_RGB_BP_SRGB = 121;
    public static final int FORMAT_RGB_PVRTC_8X8_SRGB = 122;
    public static final int FORMAT_RGB_PVRTC_16X8_SRGB = 123;
    public static final int FORMAT_RGBA_PVRTC_8X8_SRGB = 124;
    public static final int FORMAT_RGBA_PVRTC_16X8_SRGB = 125;
    public static final int FORMAT_RGBA_PVRTC2_8X8_SRGB = 126;
    public static final int FORMAT_RGBA_PVRTC2_16X8_SRGB = 127;
    public static final int FORMAT_RGB_ETC_SRGB = 128;
    public static final int FORMAT_RGBA_ETC2_PUNCHTHROUGH_SRGB = 129;
    public static final int FORMAT_RGBA_ETC2_SRGB = 130;
    public static final int FORMAT_RGBA_ASTC_4X4_SRGB = 131;
    public static final int FORMAT_RGBA_ASTC_5X4_SRGB = 132;
    public static final int FORMAT_RGBA_ASTC_5X5_SRGB = 133;
    public static final int FORMAT_RGBA_ASTC_6X5_SRGB = 134;
    public static final int FORMAT_RGBA_ASTC_6X6_SRGB = 135;
    public static final int FORMAT_RGBA_ASTC_8X5_SRGB = 136;
    public static final int FORMAT_RGBA_ASTC_8X6_SRGB = 137;
    public static final int FORMAT_RGBA_ASTC_8X8_SRGB = 138;
    public static final int FORMAT_RGBA_ASTC_10X5_SRGB = 139;
    public static final int FORMAT_RGBA_ASTC_10X6_SRGB = 140;
    public static final int FORMAT_RGBA_ASTC_10X8_SRGB = 141;
    public static final int FORMAT_RGBA_ASTC_10X10_SRGB = 142;
    public static final int FORMAT_RGBA_ASTC_12X10_SRGB = 143;
    public static final int FORMAT_RGBA_ASTC_12X12_SRGB = 144;
    public static final int FORMAT_COMPRESSED_LAST = FORMAT_RGBA_ASTC_12X12_SRGB;
    public static final int FORMAT_LAST = FORMAT_RGBA_ASTC_12X12_SRGB;

    public static final int FORMAT_INVALID = -1;
    public static final int FORMAT_COUNT = FORMAT_LAST - FORMAT_FIRST + 1;
    public static final int FORMAT_COMPRESSED_COUNT = FORMAT_COMPRESSED_LAST - FORMAT_COMPRESSED_FIRST + 1;

    public static boolean isCompressed(int format) {
        return format >= FORMAT_COMPRESSED_FIRST && format <= FORMAT_COMPRESSED_LAST;
    }

    public static boolean isValid(int format) {
        return format >= FORMAT_FIRST && format <= FORMAT_LAST;
    }
    
    public int block_size(int format) {
        
    }
}
