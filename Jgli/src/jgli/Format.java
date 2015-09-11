/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgli;

import static jgli.detail.Format.getFormatInfo;

/**
 *
 * @author GBarbieri
 */
public enum Format {

    FORMAT_R8_UNORM,
    FORMAT_FIRST(FORMAT_R8_UNORM),
    FORMAT_RG8_UNORM,
    FORMAT_RGB8_UNORM,
    FORMAT_RGBA8_UNORM,
    FORMAT_R16_UNORM,
    FORMAT_RG16_UNORM,
    FORMAT_RGB16_UNORM,
    FORMAT_RGBA16_UNORM,
    // snorm formats
    FORMAT_R8_SNORM,
    FORMAT_RG8_SNORM,
    FORMAT_RGB8_SNORM,
    FORMAT_RGBA8_SNORM,
    FORMAT_R16_SNORM,
    FORMAT_RG16_SNORM,
    FORMAT_RGB16_SNORM,
    FORMAT_RGBA16_SNORM,
    // Unsigned integer formats
    FORMAT_R8_UINT,
    FORMAT_RG8_UINT,
    FORMAT_RGB8_UINT,
    FORMAT_RGBA8_UINT,
    FORMAT_R16_UINT,
    FORMAT_RG16_UINT,
    FORMAT_RGB16_UINT,
    FORMAT_RGBA16_UINT,
    FORMAT_R32_UINT,
    FORMAT_RG32_UINT,
    FORMAT_RGB32_UINT,
    FORMAT_RGBA32_UINT,
    // Signed integer formats
    FORMAT_R8_SINT,
    FORMAT_RG8_SINT,
    FORMAT_RGB8_SINT,
    FORMAT_RGBA8_SINT,
    FORMAT_R16_SINT,
    FORMAT_RG16_SINT,
    FORMAT_RGB16_SINT,
    FORMAT_RGBA16_SINT,
    FORMAT_R32_SINT,
    FORMAT_RG32_SINT,
    FORMAT_RGB32_SINT,
    FORMAT_RGBA32_SINT,
    // Floating formats
    FORMAT_R16_SFLOAT,
    FORMAT_RG16_SFLOAT,
    FORMAT_RGB16_SFLOAT,
    FORMAT_RGBA16_SFLOAT,
    FORMAT_R32_SFLOAT,
    FORMAT_RG32_SFLOAT,
    FORMAT_RGB32_SFLOAT,
    FORMAT_RGBA32_SFLOAT,
    // sRGB formats
    FORMAT_R8_SRGB,
    FORMAT_RG8_SRGB,
    FORMAT_RGB8_SRGB,
    FORMAT_RGBA8_SRGB,
    // Packed formats
    FORMAT_RGB10A2_UNORM,
    FORMAT_RGB10A2_UINT,
    FORMAT_RGB9E5_UFLOAT,
    FORMAT_RG11B10_UFLOAT,
    FORMAT_RG3B2_UNORM,
    FORMAT_R5G6B5_UNORM,
    FORMAT_RGB5A1_UNORM,
    FORMAT_RGBA4_UNORM,
    // Swizzle formats
    FORMAT_BGRX8_UNORM,
    FORMAT_BGRA8_UNORM,
    FORMAT_BGRX8_SRGB,
    FORMAT_BGRA8_SRGB,
    // Luminance Alpha formats
    FORMAT_L8_UNORM,
    FORMAT_A8_UNORM,
    FORMAT_LA8_UNORM,
    FORMAT_L16_UNORM,
    FORMAT_A16_UNORM,
    FORMAT_LA16_UNORM,
    // Depth formats
    FORMAT_D16_UNORM,
    FORMAT_D24_UNORM,
    FORMAT_D24S8_UNORM,
    FORMAT_D32_UFLOAT,
    FORMAT_D32_UFLOAT_S8_UNORM,
    // Compressed formats
    FORMAT_RGB_DXT1_UNORM, 
    FORMAT_COMPRESSED_FIRST(FORMAT_RGB_DXT1_UNORM),
    FORMAT_RGBA_DXT1_UNORM,
    FORMAT_RGBA_DXT3_UNORM,
    FORMAT_RGBA_DXT5_UNORM,
    FORMAT_R_ATI1N_UNORM,
    FORMAT_R_ATI1N_SNORM,
    FORMAT_RG_ATI2N_UNORM,
    FORMAT_RG_ATI2N_SNORM,
    FORMAT_RGB_BP_UFLOAT,
    FORMAT_RGB_BP_SFLOAT,
    FORMAT_RGB_BP_UNORM,
    FORMAT_RGB_PVRTC_8X8_UNORM,
    FORMAT_RGB_PVRTC_16X8_UNORM,
    FORMAT_RGBA_PVRTC_8X8_UNORM,
    FORMAT_RGBA_PVRTC_16X8_UNORM,
    FORMAT_RGBA_PVRTC2_8X8_UNORM,
    FORMAT_RGBA_PVRTC2_16X8_UNORM,
    FORMAT_RGB_ATC_UNORM,
    FORMAT_RGBA_ATC_EXPLICIT_UNORM,
    FORMAT_RGBA_ATC_INTERPOLATED_UNORM,
    FORMAT_RGB_ETC_UNORM,
    FORMAT_RGB_ETC2_UNORM,
    FORMAT_RGBA_ETC2_PUNCHTHROUGH_UNORM,
    FORMAT_RGBA_ETC2_UNORM,
    FORMAT_R11_EAC_UNORM,
    FORMAT_R11_EAC_SNORM,
    FORMAT_RG11_EAC_UNORM,
    FORMAT_RG11_EAC_SNORM,
    FORMAT_RGBA_ASTC_4X4_UNORM,
    FORMAT_RGBA_ASTC_5X4_UNORM,
    FORMAT_RGBA_ASTC_5X5_UNORM,
    FORMAT_RGBA_ASTC_6X5_UNORM,
    FORMAT_RGBA_ASTC_6X6_UNORM,
    FORMAT_RGBA_ASTC_8X5_UNORM,
    FORMAT_RGBA_ASTC_8X6_UNORM,
    FORMAT_RGBA_ASTC_8X8_UNORM,
    FORMAT_RGBA_ASTC_10X5_UNORM,
    FORMAT_RGBA_ASTC_10X6_UNORM,
    FORMAT_RGBA_ASTC_10X8_UNORM,
    FORMAT_RGBA_ASTC_10X10_UNORM,
    FORMAT_RGBA_ASTC_12X10_UNORM,
    FORMAT_RGBA_ASTC_12X12_UNORM,
    // Compressed sRGB formats
    FORMAT_RGB_DXT1_SRGB,
    FORMAT_RGBA_DXT1_SRGB,
    FORMAT_RGBA_DXT3_SRGB,
    FORMAT_RGBA_DXT5_SRGB,
    FORMAT_RGB_BP_SRGB,
    FORMAT_RGB_PVRTC_8X8_SRGB,
    FORMAT_RGB_PVRTC_16X8_SRGB,
    FORMAT_RGBA_PVRTC_8X8_SRGB,
    FORMAT_RGBA_PVRTC_16X8_SRGB,
    FORMAT_RGBA_PVRTC2_8X8_SRGB,
    FORMAT_RGBA_PVRTC2_16X8_SRGB,
    FORMAT_RGB_ETC_SRGB,
    FORMAT_RGBA_ETC2_PUNCHTHROUGH_SRGB,
    FORMAT_RGBA_ETC2_SRGB,
    FORMAT_RGBA_ASTC_4X4_SRGB,
    FORMAT_RGBA_ASTC_5X4_SRGB,
    FORMAT_RGBA_ASTC_5X5_SRGB,
    FORMAT_RGBA_ASTC_6X5_SRGB,
    FORMAT_RGBA_ASTC_6X6_SRGB,
    FORMAT_RGBA_ASTC_8X5_SRGB,
    FORMAT_RGBA_ASTC_8X6_SRGB,
    FORMAT_RGBA_ASTC_8X8_SRGB,
    FORMAT_RGBA_ASTC_10X5_SRGB,
    FORMAT_RGBA_ASTC_10X6_SRGB,
    FORMAT_RGBA_ASTC_10X8_SRGB,
    FORMAT_RGBA_ASTC_10X10_SRGB,
    FORMAT_RGBA_ASTC_12X10_SRGB,
    FORMAT_RGBA_ASTC_12X12_SRGB,
    FORMAT_COMPRESSED_LAST(FORMAT_RGBA_ASTC_12X12_SRGB),
    FORMAT_LAST(FORMAT_RGBA_ASTC_12X12_SRGB),
    //
    FORMAT_INVALID(-1),
    FORMAT_COUNT(FORMAT_LAST.value - FORMAT_FIRST.value + 1),
    FORMAT_COMPRESSED_COUNT(FORMAT_COMPRESSED_LAST.value - FORMAT_COMPRESSED_FIRST.value + 1);

    public final int value;

    private Format() {
        value = Counter.nextValue;
        Counter.nextValue++;
    }

    private Format(Format e) {
        this.value = e.value;
    }

    private Format(int value) {
        this.value = value;
    }

    public boolean isCompressed() {
        return value >= FORMAT_COMPRESSED_FIRST.value && value <= FORMAT_COMPRESSED_LAST.value;
    }

    public boolean isValid() {
        return value >= FORMAT_FIRST.value && value <= FORMAT_LAST.value;
    }

    public int blockSize() {
        return getFormatInfo(this).blockSize;
    }

    public int[] blockDimensions() {
        return getFormatInfo(this).blockDimensions;
    }

    public int componentCount() {
        return getFormatInfo(this).component;
    }

    /**
     * Trick to get automatic incremental values.
     */
    private static class Counter {

        private static int nextValue = 0;
    }
}
