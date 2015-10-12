/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgli.detail;

import static jgli.Format.FORMAT_COUNT;
import static jgli.Format.FORMAT_INVALID;

/**
 *
 * @author GBarbieri
 */
public class Format {

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

    private static final FormatInfo[] table = new FormatInfo[]{
        new FormatInfo((byte) 1, (byte) 1, (byte) 2, (short) (CAP_PACKED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R4G4_UNORM,
        new FormatInfo((byte) 1, (byte) 1, (byte) 2, (short) (CAP_PACKED_BIT | CAP_SCALED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R4G4_USCALED,
        new FormatInfo((byte) 2, (byte) 1, (byte) 4, (short) (CAP_PACKED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R4G4B4A4_UNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 4, (short) (CAP_PACKED_BIT | CAP_SCALED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R4G4B4A4_USCALED,
        new FormatInfo((byte) 2, (byte) 1, (byte) 3, (short) (CAP_PACKED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R5G6B5_UNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 3, (short) (CAP_PACKED_BIT | CAP_SCALED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R5G6B5_USCALED,
        new FormatInfo((byte) 2, (byte) 1, (byte) 4, (short) (CAP_PACKED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R5G5B5A1_UNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 4, (short) (CAP_PACKED_BIT | CAP_SCALED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R5G5B5A1_USCALED,

        new FormatInfo((byte) 1, (byte) 1, (byte) 1, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R8_UNORM,
        new FormatInfo((byte) 1, (byte) 1, (byte) 1, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_R8_SNORM,
        new FormatInfo((byte) 1, (byte) 1, (byte) 1, (short) (CAP_SCALED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R8_USCALED,
        new FormatInfo((byte) 1, (byte) 1, (byte) 1, (short) (CAP_SCALED_BIT | CAP_SIGNED_BIT)), //FORMAT_R8_SSCALED,
        new FormatInfo((byte) 1, (byte) 1, (byte) 1, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R8_UINT,
        new FormatInfo((byte) 1, (byte) 1, (byte) 1, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT)), //FORMAT_R8_SINT,
        new FormatInfo((byte) 1, (byte) 1, (byte) 3, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_COLORSPACE_SRGB_BIT)), //FORMAT_R8_SRGB,

        new FormatInfo((byte) 2, (byte) 1, (byte) 2, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RG8_UNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 2, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_RG8_SNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 2, (short) (CAP_SCALED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RG8_USCALED,
        new FormatInfo((byte) 2, (byte) 1, (byte) 2, (short) (CAP_SCALED_BIT | CAP_SIGNED_BIT)), //FORMAT_RG8_SSCALED,
        new FormatInfo((byte) 2, (byte) 1, (byte) 2, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RG8_UINT,
        new FormatInfo((byte) 2, (byte) 1, (byte) 2, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT)), //FORMAT_RG8_SINT,
        new FormatInfo((byte) 2, (byte) 1, (byte) 2, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT | CAP_COLORSPACE_SRGB_BIT)), //FORMAT_RG8_SRGB,

        new FormatInfo((byte) 3, (byte) 1, (byte) 3, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB8_UNORM,
        new FormatInfo((byte) 3, (byte) 1, (byte) 3, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_RGB8_SNORM,
        new FormatInfo((byte) 3, (byte) 1, (byte) 3, (short) (CAP_SCALED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB8_USCALED,
        new FormatInfo((byte) 3, (byte) 1, (byte) 3, (short) (CAP_SCALED_BIT | CAP_SIGNED_BIT)), //FORMAT_RGB8_SSCALED,
        new FormatInfo((byte) 3, (byte) 1, (byte) 3, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB8_UINT,
        new FormatInfo((byte) 3, (byte) 1, (byte) 3, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT)), //FORMAT_RGB8_SINT,
        new FormatInfo((byte) 3, (byte) 1, (byte) 3, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_COLORSPACE_SRGB_BIT)), //FORMAT_RGB8_SRGB,

        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA8_UNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_RGBA8_SNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_SCALED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA8_USCALED,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_SCALED_BIT | CAP_SIGNED_BIT)), //FORMAT_RGBA8_SSCALED,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA8_UINT,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT)), //FORMAT_RGBA8_SINT,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_COLORSPACE_SRGB_BIT)), //FORMAT_RGBA8_SRGB,

        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_PACKED_BIT)), //FORMAT_RGB10A2_UNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT | CAP_PACKED_BIT)), //FORMAT_RGB10A2_SNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_SCALED_BIT | CAP_UNSIGNED_BIT | CAP_PACKED_BIT)), //FORMAT_RGB10A2_USCALE,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_SCALED_BIT | CAP_SIGNED_BIT | CAP_PACKED_BIT)), //FORMAT_RGB10A2_SSCALE,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT | CAP_PACKED_BIT)), //FORMAT_RGB10A2_UINT,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT | CAP_PACKED_BIT)), //FORMAT_RGB10A2_SINT,

        new FormatInfo((byte) 2, (byte) 1, (byte) 1, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R16_UNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 1, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_R16_SNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 1, (short) (CAP_SCALED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R16_USCALE,
        new FormatInfo((byte) 2, (byte) 1, (byte) 1, (short) (CAP_SCALED_BIT | CAP_SIGNED_BIT)), //FORMAT_R16_SSCALE,
        new FormatInfo((byte) 2, (byte) 1, (byte) 1, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R16_UINT,
        new FormatInfo((byte) 2, (byte) 1, (byte) 1, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT)), //FORMAT_R16_SINT,
        new FormatInfo((byte) 2, (byte) 1, (byte) 1, (short) (CAP_FLOAT_BIT | CAP_SIGNED_BIT)), //FORMAT_R16_SFLOAT,

        new FormatInfo((byte) 4, (byte) 1, (byte) 2, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RG16_UNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 2, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_RG16_SNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 2, (short) (CAP_SCALED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RG16_USCALE,
        new FormatInfo((byte) 4, (byte) 1, (byte) 2, (short) (CAP_SCALED_BIT | CAP_SIGNED_BIT)), //FORMAT_RG16_SSCALE,
        new FormatInfo((byte) 4, (byte) 1, (byte) 2, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RG16_UINT,
        new FormatInfo((byte) 4, (byte) 1, (byte) 2, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT)), //FORMAT_RG16_SINT,
        new FormatInfo((byte) 4, (byte) 1, (byte) 2, (short) (CAP_FLOAT_BIT | CAP_SIGNED_BIT)), //FORMAT_RG16_SFLOAT,

        new FormatInfo((byte) 6, (byte) 1, (byte) 3, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB16_UNORM,
        new FormatInfo((byte) 6, (byte) 1, (byte) 3, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_RGB16_SNORM,
        new FormatInfo((byte) 6, (byte) 1, (byte) 3, (short) (CAP_SCALED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB16_USCALE,
        new FormatInfo((byte) 6, (byte) 1, (byte) 3, (short) (CAP_SCALED_BIT | CAP_SIGNED_BIT)), //FORMAT_RGB16_SSCALE,
        new FormatInfo((byte) 6, (byte) 1, (byte) 3, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB16_UINT,
        new FormatInfo((byte) 6, (byte) 1, (byte) 3, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT)), //FORMAT_RGB16_SINT,
        new FormatInfo((byte) 6, (byte) 1, (byte) 3, (short) (CAP_FLOAT_BIT | CAP_SIGNED_BIT)), //FORMAT_RGB16_SFLOAT,

        new FormatInfo((byte) 8, (byte) 1, (byte) 4, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA16_UNORM,
        new FormatInfo((byte) 8, (byte) 1, (byte) 4, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_RGBA16_SNORM,
        new FormatInfo((byte) 8, (byte) 1, (byte) 4, (short) (CAP_SCALED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA16_USCALE,
        new FormatInfo((byte) 8, (byte) 1, (byte) 4, (short) (CAP_SCALED_BIT | CAP_SIGNED_BIT)), //FORMAT_RGBA16_SSCALE,
        new FormatInfo((byte) 8, (byte) 1, (byte) 4, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA16_UINT,
        new FormatInfo((byte) 8, (byte) 1, (byte) 4, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT)), //FORMAT_RGBA16_SINT,
        new FormatInfo((byte) 8, (byte) 1, (byte) 4, (short) (CAP_FLOAT_BIT | CAP_SIGNED_BIT)), //FORMAT_RGBA16_SFLOAT,

        new FormatInfo((byte) 4, (byte) 1, (byte) 1, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R32_UINT,
        new FormatInfo((byte) 4, (byte) 1, (byte) 1, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT)), //FORMAT_R32_SINT,
        new FormatInfo((byte) 4, (byte) 1, (byte) 1, (short) (CAP_FLOAT_BIT | CAP_SIGNED_BIT)), //FORMAT_R32_SFLOAT,

        new FormatInfo((byte) 8, (byte) 1, (byte) 2, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RG32_UINT,
        new FormatInfo((byte) 8, (byte) 1, (byte) 2, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT)), //FORMAT_RG32_SINT,
        new FormatInfo((byte) 8, (byte) 1, (byte) 2, (short) (CAP_FLOAT_BIT | CAP_SIGNED_BIT)), //FORMAT_RG32_SFLOAT,

        new FormatInfo((byte) 12, (byte) 1, (byte) 3, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB32_UINT,
        new FormatInfo((byte) 12, (byte) 1, (byte) 3, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT)), //FORMAT_RGB32_SINT,
        new FormatInfo((byte) 12, (byte) 1, (byte) 3, (short) (CAP_FLOAT_BIT | CAP_SIGNED_BIT)), //FORMAT_RGB32_SFLOAT,

        new FormatInfo((byte) 16, (byte) 1, (byte) 4, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA32_UINT,
        new FormatInfo((byte) 16, (byte) 1, (byte) 4, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT)), //FORMAT_RGBA32_SINT,
        new FormatInfo((byte) 16, (byte) 1, (byte) 4, (short) (CAP_FLOAT_BIT | CAP_SIGNED_BIT)), //FORMAT_RGBA32_SFLOAT,

        new FormatInfo((byte) 8, (byte) 1, (byte) 1, (short) (CAP_FLOAT_BIT | CAP_SIGNED_BIT)), //FORMAT_R64_SFLOAT,
        new FormatInfo((byte) 16, (byte) 1, (byte) 2, (short) (CAP_FLOAT_BIT | CAP_SIGNED_BIT)), //FORMAT_RG64_SFLOAT,
        new FormatInfo((byte) 24, (byte) 1, (byte) 3, (short) (CAP_FLOAT_BIT | CAP_SIGNED_BIT)), //FORMAT_RGB64_SFLOAT,
        new FormatInfo((byte) 32, (byte) 1, (byte) 4, (short) (CAP_FLOAT_BIT | CAP_SIGNED_BIT)), //FORMAT_RGBA64_SFLOAT,

        new FormatInfo((byte) 4, (byte) 1, (byte) 3, (short) (CAP_PACKED_BIT | CAP_FLOAT_BIT | CAP_SIGNED_BIT)), //FORMAT_RG11B10_UFLOAT,
        new FormatInfo((byte) 4, (byte) 1, (byte) 3, (short) (CAP_PACKED_BIT | CAP_FLOAT_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB9E5_UFLOAT,

        new FormatInfo((byte) 2, (byte) 1, (byte) 1, (short) (CAP_DEPTH_BIT | CAP_INTEGER_BIT)), //FORMAT_D16_UNORM,
        new FormatInfo((byte) 3, (byte) 1, (byte) 1, (short) (CAP_DEPTH_BIT | CAP_INTEGER_BIT)), //FORMAT_D24_UNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 1, (short) (CAP_DEPTH_BIT | CAP_FLOAT_BIT)), //FORMAT_D32_UFLOAT,
        new FormatInfo((byte) 1, (byte) 1, (byte) 1, (short) (CAP_DEPTH_BIT | CAP_STENCIL_BIT)), //FORMAT_S8_UNORM,
        new FormatInfo((byte) 3, (byte) 1, (byte) 2, (short) (CAP_DEPTH_BIT | CAP_INTEGER_BIT | CAP_STENCIL_BIT)), //FORMAT_D16_UNORM_S8_UINT,
        new FormatInfo((byte) 4, (byte) 1, (byte) 2, (short) (CAP_DEPTH_BIT | CAP_INTEGER_BIT | CAP_STENCIL_BIT)), //FORMAT_D24_UNORM_S8_UINT,
        new FormatInfo((byte) 5, (byte) 1, (byte) 2, (short) (CAP_DEPTH_BIT | CAP_FLOAT_BIT | CAP_STENCIL_BIT)), //FORMAT_D32_SFLOAT_S8_UINT,

        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_DXT1_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_DXT1_SRGB,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_DXT1_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_DXT1_SRGB,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_DXT3_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_DXT3_SRGB,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_DXT5_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_DXT5_SRGB,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 1, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R_ATI1N_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 1, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_R_ATI1N_SNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 2, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RG_ATI2N_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 2, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_RG_ATI2N_SNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_FLOAT_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_BP_UFLOAT,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_FLOAT_BIT | CAP_SIGNED_BIT)), //FORMAT_RGB_BP_SFLOAT,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_BP_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_BP_SRGB,

        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_ETC2_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_ETC2_SRGB,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ETC2_PUNCHTHROUGH_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ETC2_PUNCHTHROUGH_SRGB,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ETC2_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ETC2_SRGB,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 1, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R11_EAC_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 1, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_R11_EAC_SNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 2, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RG11_EAC_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 2, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_RG11_EAC_SNORM,

        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC4X4_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC4X4_SRGB,
        new FormatInfo((byte) 16, new byte[]{5, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC5X4_UNORM,
        new FormatInfo((byte) 16, new byte[]{5, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC5X4_SRGB,
        new FormatInfo((byte) 16, new byte[]{5, 5, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC5X5_UNORM,
        new FormatInfo((byte) 16, new byte[]{5, 5, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC5X5_SRGB,
        new FormatInfo((byte) 16, new byte[]{6, 5, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC6X5_UNORM,
        new FormatInfo((byte) 16, new byte[]{6, 5, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC6X5_SRGB,
        new FormatInfo((byte) 16, new byte[]{6, 6, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC6X6_UNORM,
        new FormatInfo((byte) 16, new byte[]{6, 6, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC6X6_SRGB,
        new FormatInfo((byte) 16, new byte[]{8, 5, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC8X5_UNORM,
        new FormatInfo((byte) 16, new byte[]{8, 5, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC8X5_SRGB,
        new FormatInfo((byte) 16, new byte[]{8, 6, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC8X6_UNORM,
        new FormatInfo((byte) 16, new byte[]{8, 6, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC8X6_SRGB,
        new FormatInfo((byte) 16, new byte[]{8, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC8X8_UNORM,
        new FormatInfo((byte) 16, new byte[]{8, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC8X8_SRGB,
        new FormatInfo((byte) 16, new byte[]{10, 5, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC10X5_UNORM,
        new FormatInfo((byte) 16, new byte[]{10, 5, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC10X5_SRGB,
        new FormatInfo((byte) 16, new byte[]{10, 6, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC10X6_UNORM,
        new FormatInfo((byte) 16, new byte[]{10, 6, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC10X6_SRGB,
        new FormatInfo((byte) 16, new byte[]{10, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC10X8_UNORM,
        new FormatInfo((byte) 16, new byte[]{10, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC10X8_SRGB,
        new FormatInfo((byte) 16, new byte[]{10, 10, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC10X10_UNORM,
        new FormatInfo((byte) 16, new byte[]{10, 10, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC10X10_SRGB,
        new FormatInfo((byte) 16, new byte[]{12, 10, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC12X10_UNORM,
        new FormatInfo((byte) 16, new byte[]{12, 10, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC12X10_SRGB,
        new FormatInfo((byte) 16, new byte[]{12, 12, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC12X12_UNORM,
        new FormatInfo((byte) 16, new byte[]{12, 12, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC12X12_SRGB,

        new FormatInfo((byte) 2, (byte) 1, (byte) 4, (short) (CAP_PACKED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGRA4_UNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 4, (short) (CAP_PACKED_BIT | CAP_SCALED_BIT | CAP_UNSIGNED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGRA4_USCALED,
        new FormatInfo((byte) 2, (byte) 1, (byte) 3, (short) (CAP_PACKED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_B5G6R5_UNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 3, (short) (CAP_PACKED_BIT | CAP_SCALED_BIT | CAP_UNSIGNED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_B5G6R5_USCALED,
        new FormatInfo((byte) 2, (byte) 1, (byte) 4, (short) (CAP_PACKED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGR5A1_UNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 4, (short) (CAP_PACKED_BIT | CAP_SCALED_BIT | CAP_UNSIGNED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGRA1_USCALED,

        new FormatInfo((byte) 3, (byte) 1, (byte) 3, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGR8_UNORM,
        new FormatInfo((byte) 3, (byte) 1, (byte) 3, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGR8_SNORM,
        new FormatInfo((byte) 3, (byte) 1, (byte) 3, (short) (CAP_SCALED_BIT | CAP_UNSIGNED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGR8_USCALED,
        new FormatInfo((byte) 3, (byte) 1, (byte) 3, (short) (CAP_SCALED_BIT | CAP_SIGNED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGR8_SSCALED,
        new FormatInfo((byte) 3, (byte) 1, (byte) 3, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGR8_UINT,
        new FormatInfo((byte) 3, (byte) 1, (byte) 3, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGR8_SINT,
        new FormatInfo((byte) 3, (byte) 1, (byte) 3, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGR8_SRGB,

        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGRA8_UNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGRA8_SNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_SCALED_BIT | CAP_UNSIGNED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGRA8_USCALED,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_SCALED_BIT | CAP_SIGNED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGRA8_SSCALED,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGRA8_UINT,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGRA8_SINT,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGRA8_SRGB,

        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_PACKED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGR10A2_UNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_NORMALIZED_BIT | CAP_SIGNED_BIT | CAP_PACKED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGR10A2_SNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_SCALED_BIT | CAP_UNSIGNED_BIT | CAP_PACKED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGR10A2_USCALE,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_SCALED_BIT | CAP_SIGNED_BIT | CAP_PACKED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGR10A2_SSCALE,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT | CAP_PACKED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGR10A2_UINT,
        new FormatInfo((byte) 4, (byte) 1, (byte) 4, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT | CAP_PACKED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGR10A2_SINT,

        new FormatInfo((byte) 1, (byte) 1, (byte) 3, (short) (CAP_PACKED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RG3B2_UNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 3, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGRX8_UNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 3, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_SWIZZLE_BIT | CAP_COLORSPACE_SRGB_BIT)), //FORMAT_BGRX8_SRGB,

        new FormatInfo((byte) 1, (byte) 1, (byte) 1, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_LUMINANCE_ALPHA_BIT)), //FORMAT_L8_UNORM,
        new FormatInfo((byte) 1, (byte) 1, (byte) 1, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_LUMINANCE_ALPHA_BIT)), //FORMAT_A8_UNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 2, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_LUMINANCE_ALPHA_BIT)), //FORMAT_LA8_UNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 1, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_LUMINANCE_ALPHA_BIT)), //FORMAT_L16_UNORM,
        new FormatInfo((byte) 2, (byte) 1, (byte) 1, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_LUMINANCE_ALPHA_BIT)), //FORMAT_A16_UNORM,
        new FormatInfo((byte) 4, (byte) 1, (byte) 2, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_LUMINANCE_ALPHA_BIT)), //FORMAT_LA16_UNORM,

        new FormatInfo((byte) 32, new byte[]{8, 8, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_PVRTC1_8X8_UNORM,
        new FormatInfo((byte) 32, new byte[]{8, 8, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_PVRTC1_8X8_SRGB,
        new FormatInfo((byte) 32, new byte[]{16, 8, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_PVRTC1_16X8_UNORM,
        new FormatInfo((byte) 32, new byte[]{16, 8, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_PVRTC1_16X8_SRGB,
        new FormatInfo((byte) 32, new byte[]{8, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_PVRTC1_8X8_UNORM,
        new FormatInfo((byte) 32, new byte[]{8, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_PVRTC1_8X8_SRGB,
        new FormatInfo((byte) 32, new byte[]{16, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_PVRTC1_16X8_UNORM,
        new FormatInfo((byte) 32, new byte[]{16, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_PVRTC1_16X8_SRGB,
        new FormatInfo((byte) 32, new byte[]{8, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_PVRTC2_8X8_UNORM,
        new FormatInfo((byte) 32, new byte[]{8, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_PVRTC2_8X8_SRGB,
        new FormatInfo((byte) 32, new byte[]{16, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_PVRTC2_16X8_UNORM,
        new FormatInfo((byte) 32, new byte[]{16, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_PVRTC2_16X8_SRGB,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_ETC_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_ATC_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ATC_EXPLICIT_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)) //FORMAT_RGBA_ATC_INTERPOLATED_UNORM,
    };

    private static final Format instance = new Format();

    private Format() {
        if (table.length != FORMAT_COUNT.value) {
            throw new Error("GLI error: format descriptor list doesn't match number of supported formats");
        }
    }

    public static FormatInfo getFormatInfo(jgli.Format format) {
        if (format == FORMAT_INVALID) {
            throw new Error("Format invalid");
        }
        return table[format.value - jgli.Format.FORMAT_FIRST.value];
    }

    public static final int bitsPerPixel(int format) {

        FormatInfo info = table[format];

        return info.blockSize * 8 / (info.blockDimensions[0] * info.blockDimensions[1] * info.blockDimensions[2]);
    }

    public static final boolean isCompressed(jgli.Format format) {
        return (getFormatInfo(format).flags & CAP_COMPRESSED_BIT) != 0;
    }
}
