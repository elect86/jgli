/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgli;

import static jgli.Format.Cap.*;
import static jgli.Swizzles.Swizzle.*;

/**
 *
 * @author GBarbieri
 */
public enum Format {

    FORMAT_UNDEFINED,
    FORMAT_RG4_UNORM, FORMAT_FIRST(FORMAT_RG4_UNORM),
    FORMAT_RG4_USCALED,
    FORMAT_RGBA4_UNORM,
    FORMAT_RGBA4_USCALED,
    FORMAT_R5G6B5_UNORM,
    FORMAT_R5G6B5_USCALED,
    FORMAT_RGB5A1_UNORM,
    FORMAT_RGB5A1_USCALED,
    //
    FORMAT_R8_UNORM,
    FORMAT_R8_SNORM,
    FORMAT_R8_USCALED,
    FORMAT_R8_SSCALED,
    FORMAT_R8_UINT,
    FORMAT_R8_SINT,
    FORMAT_R8_SRGB,
    //    
    FORMAT_RG8_UNORM,
    FORMAT_RG8_SNORM,
    FORMAT_RG8_USCALED,
    FORMAT_RG8_SSCALED,
    FORMAT_RG8_UINT,
    FORMAT_RG8_SINT,
    FORMAT_RG8_SRGB,
    //    
    FORMAT_RGB8_UNORM,
    FORMAT_RGB8_SNORM,
    FORMAT_RGB8_USCALED,
    FORMAT_RGB8_SSCALED,
    FORMAT_RGB8_UINT,
    FORMAT_RGB8_SINT,
    FORMAT_RGB8_SRGB,
    //    
    FORMAT_RGBA8_UNORM,
    FORMAT_RGBA8_SNORM,
    FORMAT_RGBA8_USCALED,
    FORMAT_RGBA8_SSCALED,
    FORMAT_RGBA8_UINT,
    FORMAT_RGBA8_SINT,
    FORMAT_RGBA8_SRGB,
    //    
    FORMAT_RGB10A2_UNORM,
    FORMAT_RGB10A2_SNORM,
    FORMAT_RGB10A2_USCALED,
    FORMAT_RGB10A2_SSCALED,
    FORMAT_RGB10A2_UINT,
    FORMAT_RGB10A2_SINT,
    //    
    FORMAT_R16_UNORM,
    FORMAT_R16_SNORM,
    FORMAT_R16_USCALED,
    FORMAT_R16_SSCALED,
    FORMAT_R16_UINT,
    FORMAT_R16_SINT,
    FORMAT_R16_SFLOAT,
    //    
    FORMAT_RG16_UNORM,
    FORMAT_RG16_SNORM,
    FORMAT_RG16_USCALED,
    FORMAT_RG16_SSCALED,
    FORMAT_RG16_UINT,
    FORMAT_RG16_SINT,
    FORMAT_RG16_SFLOAT,
    FORMAT_RGB16_UNORM,
    FORMAT_RGB16_SNORM,
    FORMAT_RGB16_USCALED,
    FORMAT_RGB16_SSCALED,
    FORMAT_RGB16_UINT,
    FORMAT_RGB16_SINT,
    FORMAT_RGB16_SFLOAT,
    //    
    FORMAT_RGBA16_UNORM,
    FORMAT_RGBA16_SNORM,
    FORMAT_RGBA16_USCALED,
    FORMAT_RGBA16_SSCALED,
    FORMAT_RGBA16_UINT,
    FORMAT_RGBA16_SINT,
    FORMAT_RGBA16_SFLOAT,
    //    
    FORMAT_R32_UINT,
    FORMAT_R32_SINT,
    FORMAT_R32_SFLOAT,
    FORMAT_RG32_UINT,
    FORMAT_RG32_SINT,
    FORMAT_RG32_SFLOAT,
    FORMAT_RGB32_UINT,
    FORMAT_RGB32_SINT,
    FORMAT_RGB32_SFLOAT,
    FORMAT_RGBA32_UINT,
    FORMAT_RGBA32_SINT,
    FORMAT_RGBA32_SFLOAT,
    //    
    FORMAT_R64_SFLOAT,
    FORMAT_RG64_SFLOAT,
    FORMAT_RGB64_SFLOAT,
    FORMAT_RGBA64_SFLOAT,
    //    
    FORMAT_RG11B10_UFLOAT,
    FORMAT_RGB9E5_UFLOAT,
    //    
    FORMAT_D16_UNORM,
    FORMAT_D24_UNORM,
    FORMAT_D32_SFLOAT,
    FORMAT_S8_UINT,
    FORMAT_D16_UNORM_S8_UINT,
    FORMAT_D24_UNORM_S8_UINT,
    FORMAT_D32_SFLOAT_S8_UINT,
    //
    FORMAT_RGB_DXT1_UNORM,
    FORMAT_RGB_DXT1_SRGB,
    FORMAT_RGBA_DXT1_UNORM,
    FORMAT_RGBA_DXT1_SRGB,
    FORMAT_RGBA_DXT3_UNORM,
    FORMAT_RGBA_DXT3_SRGB,
    FORMAT_RGBA_DXT5_UNORM,
    FORMAT_RGBA_DXT5_SRGB,
    FORMAT_R_ATI1N_UNORM,
    FORMAT_R_ATI1N_SNORM,
    FORMAT_RG_ATI2N_UNORM,
    FORMAT_RG_ATI2N_SNORM,
    FORMAT_RGB_BP_UFLOAT,
    FORMAT_RGB_BP_SFLOAT,
    FORMAT_RGBA_BP_UNORM,
    FORMAT_RGBA_BP_SRGB,
    //
    FORMAT_RGB_ETC2_UNORM,
    FORMAT_RGB_ETC2_SRGB,
    FORMAT_RGBA_ETC2_A1_UNORM,
    FORMAT_RGBA_ETC2_A1_SRGB,
    FORMAT_RGBA_ETC2_UNORM,
    FORMAT_RGBA_ETC2_SRGB,
    FORMAT_R_EAC_UNORM,
    FORMAT_R_EAC_SNORM,
    FORMAT_RG_EAC_UNORM,
    FORMAT_RG_EAC_SNORM,
    FORMAT_ASTC_4x4_UNORM,
    FORMAT_ASTC_4x4_SRGB,
    FORMAT_ASTC_5x4_UNORM,
    FORMAT_ASTC_5x4_SRGB,
    FORMAT_ASTC_5x5_UNORM,
    FORMAT_ASTC_5x5_SRGB,
    FORMAT_ASTC_6x5_UNORM,
    FORMAT_ASTC_6x5_SRGB,
    FORMAT_ASTC_6x6_UNORM,
    FORMAT_ASTC_6x6_SRGB,
    FORMAT_ASTC_8x5_UNORM,
    FORMAT_ASTC_8x5_SRGB,
    FORMAT_ASTC_8x6_UNORM,
    FORMAT_ASTC_8x6_SRGB,
    FORMAT_ASTC_8x8_UNORM,
    FORMAT_ASTC_8x8_SRGB,
    FORMAT_ASTC_10x5_UNORM,
    FORMAT_ASTC_10x5_SRGB,
    FORMAT_ASTC_10x6_UNORM,
    FORMAT_ASTC_10x6_SRGB,
    FORMAT_ASTC_10x8_UNORM,
    FORMAT_ASTC_10x8_SRGB,
    FORMAT_ASTC_10x10_UNORM,
    FORMAT_ASTC_10x10_SRGB,
    FORMAT_ASTC_12x10_UNORM,
    FORMAT_ASTC_12x10_SRGB,
    FORMAT_ASTC_12x12_UNORM,
    FORMAT_ASTC_12x12_SRGB,
    //
    FORMAT_BGRA4_UNORM,
    FORMAT_BGRA4_USCALED,
    FORMAT_B5G6R5_UNORM,
    FORMAT_B5G6R5_USCALED,
    FORMAT_BGR5A1_UNORM,
    FORMAT_BGR5A1_USCALED,
    //    
    FORMAT_BGR8_UNORM,
    FORMAT_BGR8_SNORM,
    FORMAT_BGR8_USCALED,
    FORMAT_BGR8_SSCALED,
    FORMAT_BGR8_UINT,
    FORMAT_BGR8_SINT,
    FORMAT_BGR8_SRGB,
    //    
    FORMAT_BGRA8_UNORM,
    FORMAT_BGRA8_SNORM,
    FORMAT_BGRA8_USCALED,
    FORMAT_BGRA8_SSCALED,
    FORMAT_BGRA8_UINT,
    FORMAT_BGRA8_SINT,
    FORMAT_BGRA8_SRGB,
    //    
    FORMAT_BGR10A2_UNORM,
    FORMAT_BGR10A2_SNORM,
    FORMAT_BGR10A2_USCALED,
    FORMAT_BGR10A2_SSCALED,
    FORMAT_BGR10A2_UINT,
    FORMAT_BGR10A2_SINT,
    //
    FORMAT_RG3B2_UNORM,
    FORMAT_BGRX8_UNORM,
    FORMAT_BGRX8_SRGB,
    //
    FORMAT_L8_UNORM,
    FORMAT_A8_UNORM,
    FORMAT_LA8_UNORM,
    FORMAT_L16_UNORM,
    FORMAT_A16_UNORM,
    FORMAT_LA16_UNORM,
    //
    FORMAT_RGB_PVRTC1_8X8_UNORM,
    FORMAT_RGB_PVRTC1_8X8_SRGB,
    FORMAT_RGB_PVRTC1_16X8_UNORM,
    FORMAT_RGB_PVRTC1_16X8_SRGB,
    FORMAT_RGBA_PVRTC1_8X8_UNORM,
    FORMAT_RGBA_PVRTC1_8X8_SRGB,
    FORMAT_RGBA_PVRTC1_16X8_UNORM,
    FORMAT_RGBA_PVRTC1_16X8_SRGB,
    FORMAT_RGBA_PVRTC2_4X4_UNORM,
    FORMAT_RGBA_PVRTC2_4X4_SRGB,
    FORMAT_RGBA_PVRTC2_8X4_UNORM,
    FORMAT_RGBA_PVRTC2_8X4_SRGB,
    //    
    FORMAT_RGB_ETC_UNORM,
    FORMAT_RGB_ATC_UNORM,
    FORMAT_RGBA_ATC_EXPLICIT_UNORM,
    FORMAT_RGBA_ATC_INTERPOLATED_UNORM, FORMAT_LAST(FORMAT_RGBA_ATC_INTERPOLATED_UNORM),
    //    
    FORMAT_INVALID(-1),
    FORMAT_COUNT(FORMAT_LAST.value - FORMAT_FIRST.value + 1);

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

    public boolean isValid() {
        return value >= FORMAT_FIRST.value && value <= FORMAT_LAST.value;
    }

    public FormatInfo getFormatInfo() {

        if (!isValid()) {
            throw new Error("not valid format");
        }
        if (table.length != FORMAT_COUNT.value) {
            throw new Error("GLI error: format descriptor list doesn't match number of supported formats");
        }
        if (this == FORMAT_INVALID) {
            throw new Error("FORMAT_INVALID");
        }
        return table[value - FORMAT_FIRST.value];
    }

    public int bitsPerPixel() {

        FormatInfo info = getFormatInfo();

        return info.blockSize * 8 / (info.blockDimensions[0] * info.blockDimensions[1] * info.blockDimensions[2]);
    }

    public boolean isCompressed() {

        return (getFormatInfo().flags & CAP_COMPRESSED_BIT.value) != 0;
    }

    public int blockSize() {

        return getFormatInfo().blockSize;
    }

    public short[] blockDimensions() {

        return getFormatInfo().blockDimensions;
    }

    public int componentCount() {

        return getFormatInfo().component;
    }

    public static Format get(int value) {
        for (Format format : values()) {
            if (format.value == value) {
                return format;
            }
        }
        return FORMAT_INVALID;
    }

    /**
     * Trick to get automatic incremental values.
     */
    private static class Counter {

        private static int nextValue = 0;
    }

    public enum Cap {

        CAP_COMPRESSED_BIT((short) (1 << 0)),
        CAP_PACKED_BIT((short) (1 << 1)),
        CAP_NORMALIZED_BIT((short) (1 << 2)),
        CAP_SCALED_BIT((short) (1 << 3)),
        CAP_UNSIGNED_BIT((short) (1 << 4)),
        CAP_SIGNED_BIT((short) (1 << 5)),
        CAP_INTEGER_BIT((short) (1 << 6)),
        CAP_FLOAT_BIT((short) (1 << 7)),
        CAP_DEPTH_BIT((short) (1 << 8)),
        CAP_STENCIL_BIT((short) (1 << 9)),
        CAP_COLORSPACE_SRGB_BIT((short) (1 << 10)),
        CAP_SWIZZLE_BIT((short) (1 << 11)),
        CAP_LUMINANCE_ALPHA_BIT((short) (1 << 12));

        public final int value;

        private Cap(short value) {
            this.value = value;
        }
    }

    public class FormatInfo {

        public byte blockSize;
        public short[] blockDimensions;
        public byte component;
        public Swizzles swizzles;
        public short flags;

        public FormatInfo(byte blockSize, byte blockDimension, byte component, Swizzles swizzles, short flags) {
            this(blockSize, new short[]{blockDimension, blockDimension, blockDimension}, component, swizzles, flags);
        }

        public FormatInfo(byte blockSize, byte[] blockDimensions, byte component, Swizzles swizzles, short flags) {
            this(blockSize, new short[]{blockDimensions[0], blockDimensions[1], blockDimensions[2]}, component, swizzles, flags);
        }

        public FormatInfo(byte blockSize, short[] blockDimensions, byte component, Swizzles swizzles, short flags) {
            this.blockSize = blockSize;
            this.blockDimensions = blockDimensions;
            this.component = component;
            this.swizzles = swizzles;
            this.flags = flags;
        }
    }

    private final FormatInfo[] table = new FormatInfo[]{
        new FormatInfo((byte) 1, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_PACKED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_R4G4_UNORM,
        new FormatInfo((byte) 1, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_PACKED_BIT.value | CAP_SCALED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_R4G4_USCALED,
        new FormatInfo((byte) 2, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_PACKED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_R4G4B4A4_UNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_PACKED_BIT.value | CAP_SCALED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_R4G4B4A4_USCALED,
        new FormatInfo((byte) 2, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_PACKED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_R5G6B5_UNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_PACKED_BIT.value | CAP_SCALED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_R5G6B5_USCALED,
        new FormatInfo((byte) 2, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_PACKED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_R5G5B5A1_UNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_PACKED_BIT.value | CAP_SCALED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_R5G5B5A1_USCALED,

        new FormatInfo((byte) 1, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_R8_UNORM,
        new FormatInfo((byte) 1, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_NORMALIZED_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_R8_SNORM,
        new FormatInfo((byte) 1, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_SCALED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_R8_USCALED,
        new FormatInfo((byte) 1, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_SCALED_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_R8_SSCALED,
        new FormatInfo((byte) 1, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_INTEGER_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_R8_UINT,
        new FormatInfo((byte) 1, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_INTEGER_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_R8_SINT,
        new FormatInfo((byte) 1, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value)), //FORMAT_R8_SRGB,

        new FormatInfo((byte) 2, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RG8_UNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_NORMALIZED_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RG8_SNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_SCALED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RG8_USCALED,
        new FormatInfo((byte) 2, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_SCALED_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RG8_SSCALED,
        new FormatInfo((byte) 2, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_INTEGER_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RG8_UINT,
        new FormatInfo((byte) 2, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_INTEGER_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RG8_SINT,
        new FormatInfo((byte) 2, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_NORMALIZED_BIT.value | CAP_SIGNED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value)), //FORMAT_RG8_SRGB,

        new FormatInfo((byte) 3, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGB8_UNORM,
        new FormatInfo((byte) 3, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_NORMALIZED_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RGB8_SNORM,
        new FormatInfo((byte) 3, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_SCALED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGB8_USCALED,
        new FormatInfo((byte) 3, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_SCALED_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RGB8_SSCALED,
        new FormatInfo((byte) 3, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_INTEGER_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGB8_UINT,
        new FormatInfo((byte) 3, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_INTEGER_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RGB8_SINT,
        new FormatInfo((byte) 3, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value)), //FORMAT_RGB8_SRGB,

        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA8_UNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_NORMALIZED_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RGBA8_SNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_SCALED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA8_USCALED,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_SCALED_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RGBA8_SSCALED,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_INTEGER_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA8_UINT,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_INTEGER_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RGBA8_SINT,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value)), //FORMAT_RGBA8_SRGB,

        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_PACKED_BIT.value)), //FORMAT_RGB10A2_UNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_NORMALIZED_BIT.value | CAP_SIGNED_BIT.value | CAP_PACKED_BIT.value)), //FORMAT_RGB10A2_SNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_SCALED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_PACKED_BIT.value)), //FORMAT_RGB10A2_USCALE,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_SCALED_BIT.value | CAP_SIGNED_BIT.value | CAP_PACKED_BIT.value)), //FORMAT_RGB10A2_SSCALE,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_INTEGER_BIT.value | CAP_UNSIGNED_BIT.value | CAP_PACKED_BIT.value)), //FORMAT_RGB10A2_UINT,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_INTEGER_BIT.value | CAP_SIGNED_BIT.value | CAP_PACKED_BIT.value)), //FORMAT_RGB10A2_SINT,

        new FormatInfo((byte) 2, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_R16_UNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_NORMALIZED_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_R16_SNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_SCALED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_R16_USCALE,
        new FormatInfo((byte) 2, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_SCALED_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_R16_SSCALE,
        new FormatInfo((byte) 2, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_INTEGER_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_R16_UINT,
        new FormatInfo((byte) 2, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_INTEGER_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_R16_SINT,
        new FormatInfo((byte) 2, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_FLOAT_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_R16_SFLOAT,

        new FormatInfo((byte) 4, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RG16_UNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_NORMALIZED_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RG16_SNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_SCALED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RG16_USCALE,
        new FormatInfo((byte) 4, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_SCALED_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RG16_SSCALE,
        new FormatInfo((byte) 4, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_INTEGER_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RG16_UINT,
        new FormatInfo((byte) 4, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_INTEGER_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RG16_SINT,
        new FormatInfo((byte) 4, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_FLOAT_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RG16_SFLOAT,

        new FormatInfo((byte) 6, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGB16_UNORM,
        new FormatInfo((byte) 6, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_NORMALIZED_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RGB16_SNORM,
        new FormatInfo((byte) 6, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_SCALED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGB16_USCALE,
        new FormatInfo((byte) 6, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_SCALED_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RGB16_SSCALE,
        new FormatInfo((byte) 6, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_INTEGER_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGB16_UINT,
        new FormatInfo((byte) 6, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_INTEGER_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RGB16_SINT,
        new FormatInfo((byte) 6, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_FLOAT_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RGB16_SFLOAT,

        new FormatInfo((byte) 8, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA16_UNORM,
        new FormatInfo((byte) 8, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_NORMALIZED_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RGBA16_SNORM,
        new FormatInfo((byte) 8, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_SCALED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA16_USCALE,
        new FormatInfo((byte) 8, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_SCALED_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RGBA16_SSCALE,
        new FormatInfo((byte) 8, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_INTEGER_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA16_UINT,
        new FormatInfo((byte) 8, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_INTEGER_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RGBA16_SINT,
        new FormatInfo((byte) 8, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_FLOAT_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RGBA16_SFLOAT,

        new FormatInfo((byte) 4, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_INTEGER_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_R32_UINT,
        new FormatInfo((byte) 4, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_INTEGER_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_R32_SINT,
        new FormatInfo((byte) 4, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_FLOAT_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_R32_SFLOAT,

        new FormatInfo((byte) 8, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_INTEGER_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RG32_UINT,
        new FormatInfo((byte) 8, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_INTEGER_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RG32_SINT,
        new FormatInfo((byte) 8, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_FLOAT_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RG32_SFLOAT,

        new FormatInfo((byte) 12, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_INTEGER_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGB32_UINT,
        new FormatInfo((byte) 12, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_INTEGER_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RGB32_SINT,
        new FormatInfo((byte) 12, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_FLOAT_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RGB32_SFLOAT,

        new FormatInfo((byte) 16, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_INTEGER_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA32_UINT,
        new FormatInfo((byte) 16, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_INTEGER_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RGBA32_SINT,
        new FormatInfo((byte) 16, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_FLOAT_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RGBA32_SFLOAT,

        new FormatInfo((byte) 8, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_FLOAT_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_R64_SFLOAT,
        new FormatInfo((byte) 16, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_FLOAT_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RG64_SFLOAT,
        new FormatInfo((byte) 24, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_FLOAT_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RGB64_SFLOAT,
        new FormatInfo((byte) 32, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_FLOAT_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RGBA64_SFLOAT,

        new FormatInfo((byte) 4, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_PACKED_BIT.value | CAP_FLOAT_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RG11B10_UFLOAT,
        new FormatInfo((byte) 4, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_PACKED_BIT.value | CAP_FLOAT_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGB9E5_UFLOAT,

        new FormatInfo((byte) 2, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_DEPTH_BIT.value | CAP_INTEGER_BIT.value)), //FORMAT_D16_UNORM,
        new FormatInfo((byte) 3, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_DEPTH_BIT.value | CAP_INTEGER_BIT.value)), //FORMAT_D24_UNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_DEPTH_BIT.value | CAP_FLOAT_BIT.value)), //FORMAT_D32_UFLOAT,
        new FormatInfo((byte) 1, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_DEPTH_BIT.value | CAP_STENCIL_BIT.value)), //FORMAT_S8_UNORM,
        new FormatInfo((byte) 3, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_DEPTH_BIT.value | CAP_INTEGER_BIT.value | CAP_STENCIL_BIT.value)), //FORMAT_D16_UNORM_S8_UINT,
        new FormatInfo((byte) 4, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_DEPTH_BIT.value | CAP_INTEGER_BIT.value | CAP_STENCIL_BIT.value)), //FORMAT_D24_UNORM_S8_UINT,
        new FormatInfo((byte) 5, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_DEPTH_BIT.value | CAP_FLOAT_BIT.value | CAP_STENCIL_BIT.value)), //FORMAT_D32_SFLOAT_S8_UINT,

        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGB_DXT1_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGB_DXT1_SRGB,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_DXT1_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_DXT1_SRGB,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_DXT3_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_DXT3_SRGB,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_DXT5_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_DXT5_SRGB,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_R_ATI1N_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_R_ATI1N_SNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RG_ATI2N_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RG_ATI2N_SNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_COMPRESSED_BIT.value | CAP_FLOAT_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGB_BP_UFLOAT,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_COMPRESSED_BIT.value | CAP_FLOAT_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RGB_BP_SFLOAT,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGB_BP_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGB_BP_SRGB,

        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGB_ETC2_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGB_ETC2_SRGB,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ETC2_PUNCHTHROUGH_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ETC2_PUNCHTHROUGH_SRGB,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ETC2_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ETC2_SRGB,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_R11_EAC_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_R11_EAC_SNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RG11_EAC_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_SIGNED_BIT.value)), //FORMAT_RG11_EAC_SNORM,

        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC4X4_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC4X4_SRGB,
        new FormatInfo((byte) 16, new byte[]{5, 4, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC5X4_UNORM,
        new FormatInfo((byte) 16, new byte[]{5, 4, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC5X4_SRGB,
        new FormatInfo((byte) 16, new byte[]{5, 5, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC5X5_UNORM,
        new FormatInfo((byte) 16, new byte[]{5, 5, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC5X5_SRGB,
        new FormatInfo((byte) 16, new byte[]{6, 5, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC6X5_UNORM,
        new FormatInfo((byte) 16, new byte[]{6, 5, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC6X5_SRGB,
        new FormatInfo((byte) 16, new byte[]{6, 6, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC6X6_UNORM,
        new FormatInfo((byte) 16, new byte[]{6, 6, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC6X6_SRGB,
        new FormatInfo((byte) 16, new byte[]{8, 5, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC8X5_UNORM,
        new FormatInfo((byte) 16, new byte[]{8, 5, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC8X5_SRGB,
        new FormatInfo((byte) 16, new byte[]{8, 6, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC8X6_UNORM,
        new FormatInfo((byte) 16, new byte[]{8, 6, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC8X6_SRGB,
        new FormatInfo((byte) 16, new byte[]{8, 8, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC8X8_UNORM,
        new FormatInfo((byte) 16, new byte[]{8, 8, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC8X8_SRGB,
        new FormatInfo((byte) 16, new byte[]{10, 5, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC10X5_UNORM,
        new FormatInfo((byte) 16, new byte[]{10, 5, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC10X5_SRGB,
        new FormatInfo((byte) 16, new byte[]{10, 6, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC10X6_UNORM,
        new FormatInfo((byte) 16, new byte[]{10, 6, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC10X6_SRGB,
        new FormatInfo((byte) 16, new byte[]{10, 8, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC10X8_UNORM,
        new FormatInfo((byte) 16, new byte[]{10, 8, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC10X8_SRGB,
        new FormatInfo((byte) 16, new byte[]{10, 10, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC10X10_UNORM,
        new FormatInfo((byte) 16, new byte[]{10, 10, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC10X10_SRGB,
        new FormatInfo((byte) 16, new byte[]{12, 10, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC12X10_UNORM,
        new FormatInfo((byte) 16, new byte[]{12, 10, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC12X10_SRGB,
        new FormatInfo((byte) 16, new byte[]{12, 12, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC12X12_UNORM,
        new FormatInfo((byte) 16, new byte[]{12, 12, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ASTC12X12_SRGB,

        new FormatInfo((byte) 2, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ALPHA), (short) (CAP_PACKED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGRA4_UNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ALPHA), (short) (CAP_PACKED_BIT.value | CAP_SCALED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGRA4_USCALED,
        new FormatInfo((byte) 2, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ONE), (short) (CAP_PACKED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_B5G6R5_UNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ONE), (short) (CAP_PACKED_BIT.value | CAP_SCALED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_B5G6R5_USCALED,
        new FormatInfo((byte) 2, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ALPHA), (short) (CAP_PACKED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGR5A1_UNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ALPHA), (short) (CAP_PACKED_BIT.value | CAP_SCALED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGRA1_USCALED,

        new FormatInfo((byte) 3, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ONE), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGR8_UNORM,
        new FormatInfo((byte) 3, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ONE), (short) (CAP_NORMALIZED_BIT.value | CAP_SIGNED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGR8_SNORM,
        new FormatInfo((byte) 3, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ONE), (short) (CAP_SCALED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGR8_USCALED,
        new FormatInfo((byte) 3, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ONE), (short) (CAP_SCALED_BIT.value | CAP_SIGNED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGR8_SSCALED,
        new FormatInfo((byte) 3, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ONE), (short) (CAP_INTEGER_BIT.value | CAP_UNSIGNED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGR8_UINT,
        new FormatInfo((byte) 3, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ONE), (short) (CAP_INTEGER_BIT.value | CAP_SIGNED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGR8_SINT,
        new FormatInfo((byte) 3, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ONE), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGR8_SRGB,

        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ALPHA), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGRA8_UNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ALPHA), (short) (CAP_NORMALIZED_BIT.value | CAP_SIGNED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGRA8_SNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ALPHA), (short) (CAP_SCALED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGRA8_USCALED,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ALPHA), (short) (CAP_SCALED_BIT.value | CAP_SIGNED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGRA8_SSCALED,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ALPHA), (short) (CAP_INTEGER_BIT.value | CAP_UNSIGNED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGRA8_UINT,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ALPHA), (short) (CAP_INTEGER_BIT.value | CAP_SIGNED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGRA8_SINT,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ALPHA), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGRA8_SRGB,

        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ALPHA), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_PACKED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGR10A2_UNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ALPHA), (short) (CAP_NORMALIZED_BIT.value | CAP_SIGNED_BIT.value | CAP_PACKED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGR10A2_SNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ALPHA), (short) (CAP_SCALED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_PACKED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGR10A2_USCALE,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ALPHA), (short) (CAP_SCALED_BIT.value | CAP_SIGNED_BIT.value | CAP_PACKED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGR10A2_SSCALE,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ALPHA), (short) (CAP_INTEGER_BIT.value | CAP_UNSIGNED_BIT.value | CAP_PACKED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGR10A2_UINT,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ALPHA), (short) (CAP_INTEGER_BIT.value | CAP_SIGNED_BIT.value | CAP_PACKED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGR10A2_SINT,

        new FormatInfo((byte) 1, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_PACKED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RG3B2_UNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ONE), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_SWIZZLE_BIT.value)), //FORMAT_BGRX8_UNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 3, new Swizzles(SWIZZLE_BLUE, SWIZZLE_GREEN, SWIZZLE_RED, SWIZZLE_ONE), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_SWIZZLE_BIT.value | CAP_COLORSPACE_SRGB_BIT.value)), //FORMAT_BGRX8_SRGB,

        new FormatInfo((byte) 1, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_LUMINANCE_ALPHA_BIT.value)), //FORMAT_L8_UNORM,
        new FormatInfo((byte) 1, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_RED), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_LUMINANCE_ALPHA_BIT.value)), //FORMAT_A8_UNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_GREEN), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_LUMINANCE_ALPHA_BIT.value)), //FORMAT_LA8_UNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ONE), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_LUMINANCE_ALPHA_BIT.value)), //FORMAT_L16_UNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 1, new Swizzles(SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_RED), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_LUMINANCE_ALPHA_BIT.value)), //FORMAT_A16_UNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 2, new Swizzles(SWIZZLE_RED, SWIZZLE_ZERO, SWIZZLE_ZERO, SWIZZLE_GREEN), (short) (CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value | CAP_LUMINANCE_ALPHA_BIT.value)), //FORMAT_LA16_UNORM,

        new FormatInfo((byte) 32, new byte[]{8, 8, 1}, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGB_PVRTC1_8X8_UNORM,
        new FormatInfo((byte) 32, new byte[]{8, 8, 1}, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGB_PVRTC1_8X8_SRGB,
        new FormatInfo((byte) 32, new byte[]{16, 8, 1}, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGB_PVRTC1_16X8_UNORM,
        new FormatInfo((byte) 32, new byte[]{16, 8, 1}, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGB_PVRTC1_16X8_SRGB,
        new FormatInfo((byte) 32, new byte[]{8, 8, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_PVRTC1_8X8_UNORM,
        new FormatInfo((byte) 32, new byte[]{8, 8, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_PVRTC1_8X8_SRGB,
        new FormatInfo((byte) 32, new byte[]{16, 8, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_PVRTC1_16X8_UNORM,
        new FormatInfo((byte) 32, new byte[]{16, 8, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_PVRTC1_16X8_SRGB,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_PVRTC2_4X4_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_PVRTC2_4X4_SRGB,
        new FormatInfo((byte) 8, new byte[]{8, 4, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_PVRTC2_8X4_UNORM,
        new FormatInfo((byte) 8, new byte[]{8, 4, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_COLORSPACE_SRGB_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_PVRTC2_8X4_SRGB,

        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGB_ETC_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 3, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ONE), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGB_ATC_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)), //FORMAT_RGBA_ATC_EXPLICIT_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, new Swizzles(SWIZZLE_RED, SWIZZLE_GREEN, SWIZZLE_BLUE, SWIZZLE_ALPHA), (short) (CAP_COMPRESSED_BIT.value | CAP_NORMALIZED_BIT.value | CAP_UNSIGNED_BIT.value)) //FORMAT_RGBA_ATC_INTERPOLATED_UNORM,
    };
}