/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgli;

import jgli.Jgli;
import static jgli.Jgli.FORMAT_COUNT;
import static jgli.Jgli.FORMAT_INVALID;

/**
 *
 * @author elect
 */
public class Dx {

    Format[] translation;

    public Dx() {

        Format[] table = new Format[]{
            // unorm formats
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R8_UNORM, new int[]{0x00FF0000, 0x00000000, 0x00000000, 0x00000000}), //R8_UNORM,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R8G8_UNORM, new int[]{0x00FF0000, 0x0000FF00, 0x00000000, 0x00000000}), //RG8_UNORM,
            new Format(DDPF_RGB, D3DFMT_R8G8B8, DXGI_FORMAT_UNKNOWN, new int[]{0x00FF0000, 0x0000FF00, 0x000000FF, 0x00000000}), //RGB8_UNORM,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R8G8B8A8_UNORM, new int[]{0x00FF0000, 0x0000FF00, 0x000000FF, 0xFF000000}), //RGBA8_UNORM,

            new Format(DDPF_FOURCC, D3DFMT_L16, DXGI_FORMAT_R16_UNORM, new int[]{0x0000FFFF, 0x00000000, 0x00000000, 0x00000000}), //R16_UNORM,
            new Format(DDPF_FOURCC, D3DFMT_G16R16, DXGI_FORMAT_R16G16_UNORM, new int[]{0x0000FFFF, 0xFFFF0000, 0x00000000, 0x00000000}), //RG16_UNORM,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //RGB16_UNORM,
            new Format(DDPF_FOURCC, D3DFMT_A16B16G16R16, DXGI_FORMAT_R16G16B16A16_UNORM, new int[]{0, 0, 0, 0}), //RGBA16_UNORM,

            // snorm formats
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R8_SNORM, new int[]{0, 0, 0, 0}), //R8_SNORM,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R8G8_SNORM, new int[]{0, 0, 0, 0}), //RG8_SNORM,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //RGB8_SNORM,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R8G8B8A8_SNORM, new int[]{0, 0, 0, 0}), //RGBA8_SNORM,

            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R16_SNORM, new int[]{0, 0, 0, 0}), //R16_SNORM,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R16G16_SNORM, new int[]{0, 0, 0, 0}), //RG16_SNORM,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //RGB16_SNORM,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R16G16B16A16_SNORM, new int[]{0, 0, 0, 0}), //RGBA16_SNORM,

            // Unsigned integer formats
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R8_UINT, new int[]{0, 0, 0, 0}), //R8U,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R8G8_UINT, new int[]{0, 0, 0, 0}), //RG8U,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //RGB8U,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R8G8B8A8_UINT, new int[]{0, 0, 0, 0}), //RGBA8U,

            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R16_UINT, new int[]{0, 0, 0, 0}), //R16U,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R16G16_UINT, new int[]{0, 0, 0, 0}), //RG16U,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //RGB16U,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R16G16B16A16_UINT, new int[]{0, 0, 0, 0}), //RGBA16U,

            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R32_UINT, new int[]{0, 0, 0, 0}), //R32U,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R32G32_UINT, new int[]{0, 0, 0, 0}), //RG32U,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R32G32B32_UINT, new int[]{0, 0, 0, 0}), //RGB32U,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R32G32B32A32_UINT, new int[]{0, 0, 0, 0}), //RGBA32U,

            /// Signed integer formats
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R8_SINT, new int[]{0, 0, 0, 0}), //R8I,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R8G8_SINT, new int[]{0, 0, 0, 0}), //RG8I,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //RGB8I,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R8G8B8A8_SINT, new int[]{0, 0, 0, 0}), //RGBA8I,

            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R16_SINT, new int[]{0, 0, 0, 0}), //R16I,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R16G16_SINT, new int[]{0, 0, 0, 0}), //RG16I,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //RGB16I,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R16G16B16A16_SINT, new int[]{0, 0, 0, 0}), //RGBA16I,

            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R32_SINT, new int[]{0, 0, 0, 0}), //R32I,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R32G32_SINT, new int[]{0, 0, 0, 0}), //RG32I,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R32G32B32_SINT, new int[]{0, 0, 0, 0}), //RGB32I,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R32G32B32A32_SINT, new int[]{0, 0, 0, 0}), //RGBA32I,

            /// Floating formats
            new Format(DDPF_FOURCC, D3DFMT_R16F, DXGI_FORMAT_R16_FLOAT, new int[]{0, 0, 0, 0}), //R16F,
            new Format(DDPF_FOURCC, D3DFMT_G16R16F, DXGI_FORMAT_R16G16_FLOAT, new int[]{0, 0, 0, 0}), //RG16F,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //RGB16F,
            new Format(DDPF_FOURCC, D3DFMT_A16B16G16R16F, DXGI_FORMAT_R16G16B16A16_FLOAT, new int[]{0, 0, 0, 0}), //RGBA16F,

            new Format(DDPF_FOURCC, D3DFMT_R32F, DXGI_FORMAT_R32_FLOAT, new int[]{0xFFFFFFFF, 0x0000000, 0x0000000, 0x0000000}), //R32F,
            new Format(DDPF_FOURCC, D3DFMT_G32R32F, DXGI_FORMAT_R32G32_FLOAT, new int[]{0, 0, 0, 0}), //RG32F,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R32G32B32_FLOAT, new int[]{0, 0, 0, 0}), //RGB32F,
            new Format(DDPF_FOURCC, D3DFMT_A32B32G32R32F, DXGI_FORMAT_R32G32B32A32_FLOAT, new int[]{0, 0, 0, 0}), //RGBA32F,

            /// sRGB formats
            new Format(DDPF_FOURCC, D3DFMT_UNKNOWN, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //SR8,
            new Format(DDPF_FOURCC, D3DFMT_UNKNOWN, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //SRG8,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_B8G8R8X8_UNORM_SRGB, new int[]{0, 0, 0, 0}), //SRGB8,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R8G8B8A8_UNORM_SRGB, new int[]{0, 0, 0, 0}), //SRGB8_ALPHA8,

            /// Packed formats
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R10G10B10A2_UNORM, new int[]{0x3FF00000, 0x000FFC00, 0x000003FF, 0xC0000000}), //RGB10A2_UNORM,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R10G10B10A2_UINT, new int[]{0, 0, 0, 0}), //RGB10A2U,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R9G9B9E5_SHAREDEXP, new int[]{0, 0, 0, 0}), //RGB9E5,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_R11G11B10_FLOAT, new int[]{0, 0, 0, 0}), //RG11B10F,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_UNKNOWN, new int[]{0x70, 0x38, 0xC0, 0x00}), //RG3B2,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_B5G6R5_UNORM, new int[]{0xf800, 0x07e0, 0x001f, 0x0000}), //R5G6B5,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_B5G5R5A1_UNORM, new int[]{0x7c00, 0x03e0, 0x001f, 0x8000}), //RGB5A1,
            new Format(DDPF_FOURCC, D3DFMT_A4R4G4B4, DXGI_FORMAT_B4G4R4A4_UNORM, new int[]{0x0F00, 0x00F0, 0x000F, 0xF000}), //RGBA4,

            /// Swizzle formats
            new Format(DDPF_RGB, D3DFMT_R8G8B8, DXGI_FORMAT_B8G8R8X8_UNORM, new int[]{0x00FF0000, 0x0000FF00, 0x000000FF, 0x00000000}), //FORMAT_BGRX8_UNORM,
            new Format(DDPF_RGBA, D3DFMT_A8R8G8B8, DXGI_FORMAT_B8G8R8A8_UNORM, new int[]{0x00FF0000, 0x0000FF00, 0x000000FF, 0xFF000000}), //BGRA8_UNORM,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_B8G8R8X8_UNORM_SRGB, new int[]{0x00FF0000, 0x0000FF00, 0x000000FF, 0x00000000}), //SBGR8_UNORM,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_B8G8R8A8_UNORM_SRGB, new int[]{0x00FF0000, 0x0000FF00, 0x000000FF, 0xFF000000}), //SBGR8_ALPHA8_UNORM,

            /// Luminance Alpha formats
            new Format(DDPF_LUMINANCE, D3DFMT_L8, DXGI_FORMAT_R8_UNORM, new int[]{0x000000FF, 0x00000000, 0x00000000, 0x00000000}), //L8_UNORM,
            new Format(DDPF_ALPHA, D3DFMT_A8, DXGI_FORMAT_R8_UNORM, new int[]{0x00000000, 0x00000000, 0x00000000, 0x000000FF}), //A8_UNORM,
            new Format(DDPF_LUMINANCE_ALPHA, D3DFMT_A8L8, DXGI_FORMAT_R8G8_UNORM, new int[]{0x000000FF, 0x00000000, 0x00000000, 0x0000FF00}), //LA8_UNORM,
            new Format(DDPF_LUMINANCE, D3DFMT_L16, DXGI_FORMAT_R16_UNORM, new int[]{0x0000FFFF, 0x00000000, 0x00000000, 0x00000000}), //L16_UNORM,
            new Format(DDPF_ALPHA, D3DFMT_UNKNOWN, DXGI_FORMAT_R16_UNORM, new int[]{0x00000000, 0x00000000, 0x00000000, 0x0000FFFF}), //A16_UNORM,
            new Format(DDPF_LUMINANCE_ALPHA, D3DFMT_UNKNOWN, DXGI_FORMAT_R16_UNORM, new int[]{0x0000FFFF, 0x00000000, 0x00000000, 0xFFFF0000}), //LA16_UNORM,

            /// Depth formats
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_D16_UNORM, new int[]{0, 0, 0, 0}), //D16,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //D24X8,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_D24_UNORM_S8_UINT, new int[]{0, 0, 0, 0}), //D24S8,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_D32_FLOAT, new int[]{0, 0, 0, 0}), //D32F,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_D32_FLOAT_S8X24_UINT, new int[]{0, 0, 0, 0}), //D32FS8X24,

            /// Compressed formats
            new Format(DDPF_FOURCC, D3DFMT_DXT1, DXGI_FORMAT_BC1_UNORM, new int[]{0, 0, 0, 0}), //RGB_DXT1,
            new Format(DDPF_FOURCC_ALPHAPIXELS, D3DFMT_DXT1, DXGI_FORMAT_BC1_UNORM, new int[]{0, 0, 0, 0}), //RGBA_DXT1,
            new Format(DDPF_FOURCC_ALPHAPIXELS, D3DFMT_DXT3, DXGI_FORMAT_BC2_UNORM, new int[]{0, 0, 0, 0}), //RGBA_DXT3,
            new Format(DDPF_FOURCC_ALPHAPIXELS, D3DFMT_DXT5, DXGI_FORMAT_BC3_UNORM, new int[]{0, 0, 0, 0}), //RGBA_DXT5,
            new Format(DDPF_FOURCC, D3DFMT_ATI1, DXGI_FORMAT_BC4_UNORM, new int[]{0, 0, 0, 0}), //R_ATI1N_UNORM,
            new Format(DDPF_FOURCC, D3DFMT_AT1N, DXGI_FORMAT_BC4_SNORM, new int[]{0, 0, 0, 0}), //R_ATI1N_SNORM,
            new Format(DDPF_FOURCC, D3DFMT_ATI2, DXGI_FORMAT_BC5_UNORM, new int[]{0, 0, 0, 0}), //RG_ATI2N_UNORM,
            new Format(DDPF_FOURCC, D3DFMT_AT2N, DXGI_FORMAT_BC5_SNORM, new int[]{0, 0, 0, 0}), //RG_ATI2N_SNORM,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_BC6H_UF16, new int[]{0, 0, 0, 0}), //RGB_BP_UF16,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_BC6H_SF16, new int[]{0, 0, 0, 0}), //RGB_BP_SF16,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_BC7_UNORM, new int[]{0, 0, 0, 0}), //RGB_BP_UNORM,
            new Format(DDPF_FOURCC, D3DFMT_POWERVR_4BPP, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //RGB_PVRTC_4BPP,
            new Format(DDPF_FOURCC, D3DFMT_POWERVR_2BPP, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //RGB_PVRTC_2BPP,
            new Format(DDPF_FOURCC, D3DFMT_POWERVR_4BPP, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //RGBA_PVRTC_4BPP,
            new Format(DDPF_FOURCC, D3DFMT_POWERVR_2BPP, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //RGBA_PVRTC_2BPP,
            new Format(DDPF_FOURCC, D3DFMT_UNKNOWN, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //RGBA_PVRTC2_4BPP,
            new Format(DDPF_FOURCC, D3DFMT_UNKNOWN, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //RGBA_PVRTC2_2BPP,
            new Format(DDPF_FOURCC, D3DFMT_ATC, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //ATC_RGB,
            new Format(DDPF_FOURCC, D3DFMT_ATCA, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //ATC_RGBA_EXPLICIT_ALPHA,
            new Format(DDPF_FOURCC, D3DFMT_ATCI, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //ATC_RGBA_INTERPOLATED_ALPHA,
            new Format(DDPF_FOURCC, D3DFMT_ETC, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //FORMAT_RGB_ETC_UNORM,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //FORMAT_RGB2_ETC_UNORM,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //RGBA_ETC2_PUNCHTHROUGH_UNORM,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //RGBA_ETC2_UNORM,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //R11_EAC_UNORM,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //R11_EAC_SNORM,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //RG11_EAC_UNORM,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //RG11_EAC_SNORM,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_4X4_UNORM, new int[]{0, 0, 0, 0}), //RGBA_ASTC_4x4,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_5X4_UNORM, new int[]{0, 0, 0, 0}), //RGBA_ASTC_5x4,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_5X5_UNORM, new int[]{0, 0, 0, 0}), //RGBA_ASTC_5x5,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_6X5_UNORM, new int[]{0, 0, 0, 0}), //RGBA_ASTC_6x5,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_6X6_UNORM, new int[]{0, 0, 0, 0}), //RGBA_ASTC_6x6,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_8X5_UNORM, new int[]{0, 0, 0, 0}), //RGBA_ASTC_8x5,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_8X6_UNORM, new int[]{0, 0, 0, 0}), //RGBA_ASTC_8x6,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_8X8_UNORM, new int[]{0, 0, 0, 0}), //RGBA_ASTC_8x8,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_10X5_UNORM, new int[]{0, 0, 0, 0}), //RGBA_ASTC_10x5,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_10X6_UNORM, new int[]{0, 0, 0, 0}), //RGBA_ASTC_10x6,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_10X8_UNORM, new int[]{0, 0, 0, 0}), //RGBA_ASTC_10x8,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_10X10_UNORM, new int[]{0, 0, 0, 0}), //RGBA_ASTC_10x10,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_12X10_UNORM, new int[]{0, 0, 0, 0}), //RGBA_ASTC_12x10,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_12X12_UNORM, new int[]{0, 0, 0, 0}), //RGBA_ASTC_12x12,

            // Compressed sRGB formats
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_BC1_UNORM_SRGB, new int[]{0, 0, 0, 0}), //FORMAT_RGB_DXT1_SRGB,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_BC1_UNORM_SRGB, new int[]{0, 0, 0, 0}), //FORMAT_RGBA_DXT1_SRGB,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_BC2_UNORM_SRGB, new int[]{0, 0, 0, 0}), //FORMAT_RGBA_DXT3_SRGB,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_BC3_UNORM_SRGB, new int[]{0, 0, 0, 0}), //FORMAT_RGBA_DXT5_SRGB,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_BC7_UNORM_SRGB, new int[]{0, 0, 0, 0}), //FORMAT_RGB_BP_SRGB,
            new Format(DDPF_FOURCC, D3DFMT_UNKNOWN, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //FORMAT_RGB_PVRTC1_8X8_SRGB,
            new Format(DDPF_FOURCC, D3DFMT_UNKNOWN, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //FORMAT_RGB_PVRTC1_16X8_SRGB,
            new Format(DDPF_FOURCC, D3DFMT_UNKNOWN, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //FORMAT_RGBA_PVRTC1_8X8_SRGB,
            new Format(DDPF_FOURCC, D3DFMT_UNKNOWN, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //FORMAT_RGBA_PVRTC1_16X8_SRGB,
            new Format(DDPF_FOURCC, D3DFMT_UNKNOWN, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //FORMAT_RGBA_PVRTC2_8X8_SRGB,
            new Format(DDPF_FOURCC, D3DFMT_UNKNOWN, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //FORMAT_RGBA_PVRTC2_16X8_SRGB,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //FORMAT_RGB_ETC_SRGB,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //FORMAT_RGBA_ETC2_PUNCHTHROUGH_SRGB,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_UNKNOWN, new int[]{0, 0, 0, 0}), //FORMAT_RGBA_ETC2_SRGB,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_4X4_UNORM_SRGB, new int[]{0, 0, 0, 0}), //SRGB_ALPHA_ASTC_4x4,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_5X4_UNORM_SRGB, new int[]{0, 0, 0, 0}), //SRGB_ALPHA_ASTC_5x4,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_5X5_UNORM_SRGB, new int[]{0, 0, 0, 0}), //SRGB_ALPHA_ASTC_5x5,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_6X5_UNORM_SRGB, new int[]{0, 0, 0, 0}), //SRGB_ALPHA_ASTC_6x5,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_6X6_UNORM_SRGB, new int[]{0, 0, 0, 0}), //SRGB_ALPHA_ASTC_6x6,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_8X5_UNORM_SRGB, new int[]{0, 0, 0, 0}), //SRGB_ALPHA_ASTC_8x5,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_8X6_UNORM_SRGB, new int[]{0, 0, 0, 0}), //SRGB_ALPHA_ASTC_8x6,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_8X8_UNORM_SRGB, new int[]{0, 0, 0, 0}), //SRGB_ALPHA_ASTC_8x8,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_10X5_UNORM_SRGB, new int[]{0, 0, 0, 0}), //SRGB_ALPHA_ASTC_10x5,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_10X6_UNORM_SRGB, new int[]{0, 0, 0, 0}), //SRGB_ALPHA_ASTC_10x6,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_10X8_UNORM_SRGB, new int[]{0, 0, 0, 0}), //SRGB_ALPHA_ASTC_10x8,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_10X10_UNORM_SRGB, new int[]{0, 0, 0, 0}), //SRGB_ALPHA_ASTC_10x10,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_12X10_UNORM_SRGB, new int[]{0, 0, 0, 0}), //SRGB_ALPHA_ASTC_12x10,
            new Format(DDPF_FOURCC, D3DFMT_DX10, DXGI_FORMAT_ASTC_12X12_UNORM_SRGB, new int[]{0, 0, 0, 0}), //SRGB_ALPHA_ASTC_12x12,
        };

        if (!(table.length == Jgli.FORMAT_COUNT)) {
            throw new Error("GLI error: format descriptor list doesn't match number of supported formats");
        }

        translation = table;
    }

    public Format translate(int format) {
        return translation[format];
    }

    public int find(int format, boolean isD3dformat) {

        for (int formatIndex = 0; formatIndex < FORMAT_COUNT; formatIndex++) {

            if (isD3dformat ? translation[formatIndex].d3DFormat != format
                    : translation[formatIndex].dxgiFormat != format) {
                continue;
            }
            return formatIndex;
        }
        return FORMAT_INVALID;
    }

    public class Format {

        public int ddPixelFormat;
        public int d3DFormat;
        public int dxgiFormat;
        public int[] mask;

        public Format(int DDPixelFormat, int D3DFormat, int DXGIFormat, int[] Mask) {
            this.ddPixelFormat = DDPixelFormat;
            this.d3DFormat = D3DFormat;
            this.dxgiFormat = DXGIFormat;
            this.mask = Mask;
        }
    }

    /**
     * DDPF.
     */
    public static final int DDPF_ALPHAPIXELS = 0x1;
    public static final int DDPF_ALPHA = 0x2;
    public static final int DDPF_FOURCC = 0x4;
    public static final int DDPF_RGB = 0x40;
    public static final int DDPF_YUV = 0x200;
    public static final int DDPF_LUMINANCE = 0x20000;
    public static final int DDPF_LUMINANCE_ALPHA = DDPF_LUMINANCE | DDPF_ALPHA;
    public static final int DDPF_FOURCC_ALPHAPIXELS = DDPF_FOURCC | DDPF_ALPHAPIXELS;
    public static final int DDPF_RGBAPIXELS = DDPF_RGB | DDPF_ALPHAPIXELS;
    public static final int DDPF_RGBA = DDPF_RGB | DDPF_ALPHA;
    public static final int DDPF_LUMINANCE_ALPHAPIXELS = DDPF_LUMINANCE | DDPF_ALPHAPIXELS;

    /**
     * D3d format.
     */
    public static final int D3DFMT_UNKNOWN = 0;

    public static final int D3DFMT_R8G8B8 = 20;
    public static final int D3DFMT_A8R8G8B8 = 21;
    public static final int D3DFMT_X8R8G8B8 = 22;
    public static final int D3DFMT_R5G6B5 = 23;
    public static final int D3DFMT_X1R5G5B5 = 24;
    public static final int D3DFMT_A1R5G5B5 = 25;
    public static final int D3DFMT_A4R4G4B4 = 26;
    public static final int D3DFMT_R3G3B2 = 27;
    public static final int D3DFMT_A8 = 28;
    public static final int D3DFMT_A8R3G3B2 = 29;
    public static final int D3DFMT_X4R4G4B4 = 30;
    public static final int D3DFMT_A2B10G10R10 = 31;
    public static final int D3DFMT_A8B8G8R8 = 32;
    public static final int D3DFMT_X8B8G8R8 = 33;
    public static final int D3DFMT_G16R16 = 34;
    public static final int D3DFMT_A2R10G10B10 = 35;
    public static final int D3DFMT_A16B16G16R16 = 36;

    public static final int D3DFMT_A8P8 = 40;
    public static final int D3DFMT_P8 = 41;

    public static final int D3DFMT_L8 = 50;
    public static final int D3DFMT_A8L8 = 51;
    public static final int D3DFMT_A4L4 = 52;

    public static final int D3DFMT_V8U8 = 60;
    public static final int D3DFMT_L6V5U5 = 61;
    public static final int D3DFMT_X8L8V8U8 = 62;
    public static final int D3DFMT_Q8W8V8U8 = 63;
    public static final int D3DFMT_V16U16 = 64;
    public static final int D3DFMT_A2W10V10U10 = 67;

    public static final int D3DFMT_UYVY = 1498831189;       //makeFourCC('U', 'Y', 'V', 'Y');
    public static final int D3DFMT_R8G8_B8G8 = 1195525970;  //makeFourCC('R', 'G', 'B', 'G');
    public static final int D3DFMT_YUY2 = 844715353;        //makeFourCC('Y', 'U', 'Y', '2');
    public static final int D3DFMT_G8R8_G8B8 = 1111970375;  //makeFourCC('G', 'R', 'G', 'B');
    public static final int D3DFMT_DXT1 = 827611204;        //makeFourCC('D', 'X', 'T', '1');
    public static final int D3DFMT_DXT2 = 844388420;        //makeFourCC('D', 'X', 'T', '2');
    public static final int D3DFMT_DXT3 = 861165636;        //makeFourCC('D', 'X', 'T', '3');
    public static final int D3DFMT_DXT4 = 877942852;        //makeFourCC('D', 'X', 'T', '4');
    public static final int D3DFMT_DXT5 = 894720068;        //makeFourCC('D', 'X', 'T', '5');

    public static final int D3DFMT_ATI1 = 826889281;        //makeFourCC('A', 'T', 'I', '1');
    public static final int D3DFMT_AT1N = 1311855681;       //makeFourCC('A', 'T', '1', 'N');
    public static final int D3DFMT_ATI2 = 843666497;        //makeFourCC('A', 'T', 'I', '2');
    public static final int D3DFMT_AT2N = 1311921217;       //makeFourCC('A', 'T', '2', 'N');

    public static final int D3DFMT_ETC = 541283397;         //makeFourCC('E', 'T', 'C', ' ');
    public static final int D3DFMT_ETC1 = 826496069;        //makeFourCC('E', 'T', 'C', '1');
    public static final int D3DFMT_ATC = 541283393;         //makeFourCC('A', 'T', 'C', ' ');
    public static final int D3DFMT_ATCA = 1094931521;       //makeFourCC('A', 'T', 'C', 'A');
    public static final int D3DFMT_ATCI = 1229149249;       //makeFourCC('A', 'T', 'C', 'I');

    public static final int D3DFMT_POWERVR_2BPP = 843273296;//makeFourCC('P', 'T', 'C', '2');
    public static final int D3DFMT_POWERVR_4BPP = 876827728;//makeFourCC('P', 'T', 'C', '4');

    public static final int D3DFMT_D16_LOCKABLE = 70;
    public static final int D3DFMT_D32 = 71;
    public static final int D3DFMT_D15S1 = 73;
    public static final int D3DFMT_D24S8 = 75;
    public static final int D3DFMT_D24X8 = 77;
    public static final int D3DFMT_D24X4S4 = 79;
    public static final int D3DFMT_D16 = 80;

    public static final int D3DFMT_L16 = 81;

    public static final int D3DFMT_D32F_LOCKABLE = 82;
    public static final int D3DFMT_D24FS8 = 83;

    public static final int D3DFMT_D32_LOCKABLE = 84;
    public static final int D3DFMT_S8_LOCKABLE = 85;

    public static final int D3DFMT_VERTEXDATA = 100;
    public static final int D3DFMT_INDEX16 = 101;
    public static final int D3DFMT_INDEX32 = 102;

    public static final int D3DFMT_Q16W16V16U16 = 110;

    public static final int D3DFMT_MULTI2_ARGB8 = 827606349;//makeFourCC('M', 'E', 'T', '1');

    public static final int D3DFMT_R16F = 111;
    public static final int D3DFMT_G16R16F = 112;
    public static final int D3DFMT_A16B16G16R16F = 113;

    public static final int D3DFMT_R32F = 114;
    public static final int D3DFMT_G32R32F = 115;
    public static final int D3DFMT_A32B32G32R32F = 116;

    public static final int D3DFMT_CxV8U8 = 117;

    public static final int D3DFMT_A1 = 118;
    public static final int D3DFMT_A2B10G10R10_XR_BIAS = 119;
    public static final int D3DFMT_BINARYBUFFER = 199;

    public static final int D3DFMT_DX10 = 808540228;        //makeFourCC('D', 'X', '1', '0');

    public static final int D3DFMT_FORCE_DWORD = 0x7fffffff;

    /**
     * Dxgi format.
     */
    public final static int DXGI_FORMAT_UNKNOWN = 0;
    public final static int DXGI_FORMAT_R32G32B32A32_TYPELESS = 1;
    public final static int DXGI_FORMAT_R32G32B32A32_FLOAT = 2;
    public final static int DXGI_FORMAT_R32G32B32A32_UINT = 3;
    public final static int DXGI_FORMAT_R32G32B32A32_SINT = 4;
    public final static int DXGI_FORMAT_R32G32B32_TYPELESS = 5;
    public final static int DXGI_FORMAT_R32G32B32_FLOAT = 6;
    public final static int DXGI_FORMAT_R32G32B32_UINT = 7;
    public final static int DXGI_FORMAT_R32G32B32_SINT = 8;
    public final static int DXGI_FORMAT_R16G16B16A16_TYPELESS = 9;
    public final static int DXGI_FORMAT_R16G16B16A16_FLOAT = 10;
    public final static int DXGI_FORMAT_R16G16B16A16_UNORM = 11;
    public final static int DXGI_FORMAT_R16G16B16A16_UINT = 12;
    public final static int DXGI_FORMAT_R16G16B16A16_SNORM = 13;
    public final static int DXGI_FORMAT_R16G16B16A16_SINT = 14;
    public final static int DXGI_FORMAT_R32G32_TYPELESS = 15;
    public final static int DXGI_FORMAT_R32G32_FLOAT = 16;
    public final static int DXGI_FORMAT_R32G32_UINT = 17;
    public final static int DXGI_FORMAT_R32G32_SINT = 18;
    public final static int DXGI_FORMAT_R32G8X24_TYPELESS = 19;
    public final static int DXGI_FORMAT_D32_FLOAT_S8X24_UINT = 20;
    public final static int DXGI_FORMAT_R32_FLOAT_X8X24_TYPELESS = 21;
    public final static int DXGI_FORMAT_X32_TYPELESS_G8X24_UINT = 22;
    public final static int DXGI_FORMAT_R10G10B10A2_TYPELESS = 23;
    public final static int DXGI_FORMAT_R10G10B10A2_UNORM = 24;
    public final static int DXGI_FORMAT_R10G10B10A2_UINT = 25;
    public final static int DXGI_FORMAT_R11G11B10_FLOAT = 26;
    public final static int DXGI_FORMAT_R8G8B8A8_TYPELESS = 27;
    public final static int DXGI_FORMAT_R8G8B8A8_UNORM = 28;
    public final static int DXGI_FORMAT_R8G8B8A8_UNORM_SRGB = 29;
    public final static int DXGI_FORMAT_R8G8B8A8_UINT = 30;
    public final static int DXGI_FORMAT_R8G8B8A8_SNORM = 31;
    public final static int DXGI_FORMAT_R8G8B8A8_SINT = 32;
    public final static int DXGI_FORMAT_R16G16_TYPELESS = 33;
    public final static int DXGI_FORMAT_R16G16_FLOAT = 34;
    public final static int DXGI_FORMAT_R16G16_UNORM = 35;
    public final static int DXGI_FORMAT_R16G16_UINT = 36;
    public final static int DXGI_FORMAT_R16G16_SNORM = 37;
    public final static int DXGI_FORMAT_R16G16_SINT = 38;
    public final static int DXGI_FORMAT_R32_TYPELESS = 39;
    public final static int DXGI_FORMAT_D32_FLOAT = 40;
    public final static int DXGI_FORMAT_R32_FLOAT = 41;
    public final static int DXGI_FORMAT_R32_UINT = 42;
    public final static int DXGI_FORMAT_R32_SINT = 43;
    public final static int DXGI_FORMAT_R24G8_TYPELESS = 44;
    public final static int DXGI_FORMAT_D24_UNORM_S8_UINT = 45;
    public final static int DXGI_FORMAT_R24_UNORM_X8_TYPELESS = 46;
    public final static int DXGI_FORMAT_X24_TYPELESS_G8_UINT = 47;
    public final static int DXGI_FORMAT_R8G8_TYPELESS = 48;
    public final static int DXGI_FORMAT_R8G8_UNORM = 49;
    public final static int DXGI_FORMAT_R8G8_UINT = 50;
    public final static int DXGI_FORMAT_R8G8_SNORM = 51;
    public final static int DXGI_FORMAT_R8G8_SINT = 52;
    public final static int DXGI_FORMAT_R16_TYPELESS = 53;
    public final static int DXGI_FORMAT_R16_FLOAT = 54;
    public final static int DXGI_FORMAT_D16_UNORM = 55;
    public final static int DXGI_FORMAT_R16_UNORM = 56;
    public final static int DXGI_FORMAT_R16_UINT = 57;
    public final static int DXGI_FORMAT_R16_SNORM = 58;
    public final static int DXGI_FORMAT_R16_SINT = 59;
    public final static int DXGI_FORMAT_R8_TYPELESS = 60;
    public final static int DXGI_FORMAT_R8_UNORM = 61;
    public final static int DXGI_FORMAT_R8_UINT = 62;
    public final static int DXGI_FORMAT_R8_SNORM = 63;
    public final static int DXGI_FORMAT_R8_SINT = 64;
    public final static int DXGI_FORMAT_A8_UNORM = 65;
    public final static int DXGI_FORMAT_R1_UNORM = 66;
    public final static int DXGI_FORMAT_R9G9B9E5_SHAREDEXP = 67;
    public final static int DXGI_FORMAT_R8G8_B8G8_UNORM = 68;
    public final static int DXGI_FORMAT_G8R8_G8B8_UNORM = 69;
    public final static int DXGI_FORMAT_BC1_TYPELESS = 70;
    public final static int DXGI_FORMAT_BC1_UNORM = 71;
    public final static int DXGI_FORMAT_BC1_UNORM_SRGB = 72;
    public final static int DXGI_FORMAT_BC2_TYPELESS = 73;
    public final static int DXGI_FORMAT_BC2_UNORM = 74;
    public final static int DXGI_FORMAT_BC2_UNORM_SRGB = 75;
    public final static int DXGI_FORMAT_BC3_TYPELESS = 76;
    public final static int DXGI_FORMAT_BC3_UNORM = 77;
    public final static int DXGI_FORMAT_BC3_UNORM_SRGB = 78;
    public final static int DXGI_FORMAT_BC4_TYPELESS = 79;
    public final static int DXGI_FORMAT_BC4_UNORM = 80;
    public final static int DXGI_FORMAT_BC4_SNORM = 81;
    public final static int DXGI_FORMAT_BC5_TYPELESS = 82;
    public final static int DXGI_FORMAT_BC5_UNORM = 83;
    public final static int DXGI_FORMAT_BC5_SNORM = 84;
    public final static int DXGI_FORMAT_B5G6R5_UNORM = 85;
    public final static int DXGI_FORMAT_B5G5R5A1_UNORM = 86;
    public final static int DXGI_FORMAT_B8G8R8A8_UNORM = 87;
    public final static int DXGI_FORMAT_B8G8R8X8_UNORM = 88;
    public final static int DXGI_FORMAT_R10G10B10_XR_BIAS_A2_UNORM = 89;
    public final static int DXGI_FORMAT_B8G8R8A8_TYPELESS = 90;
    public final static int DXGI_FORMAT_B8G8R8A8_UNORM_SRGB = 91;
    public final static int DXGI_FORMAT_B8G8R8X8_TYPELESS = 92;
    public final static int DXGI_FORMAT_B8G8R8X8_UNORM_SRGB = 93;
    public final static int DXGI_FORMAT_BC6H_TYPELESS = 94;
    public final static int DXGI_FORMAT_BC6H_UF16 = 95;
    public final static int DXGI_FORMAT_BC6H_SF16 = 96;
    public final static int DXGI_FORMAT_BC7_TYPELESS = 97;
    public final static int DXGI_FORMAT_BC7_UNORM = 98;
    public final static int DXGI_FORMAT_BC7_UNORM_SRGB = 99;
    public final static int DXGI_FORMAT_AYUV = 100;
    public final static int DXGI_FORMAT_Y410 = 101;
    public final static int DXGI_FORMAT_Y416 = 102;
    public final static int DXGI_FORMAT_NV12 = 103;
    public final static int DXGI_FORMAT_P010 = 104;
    public final static int DXGI_FORMAT_P016 = 105;
    public final static int DXGI_FORMAT_420_OPAQUE = 106;
    public final static int DXGI_FORMAT_YUY2 = 107;
    public final static int DXGI_FORMAT_Y210 = 108;
    public final static int DXGI_FORMAT_Y216 = 109;
    public final static int DXGI_FORMAT_NV11 = 110;
    public final static int DXGI_FORMAT_AI44 = 111;
    public final static int DXGI_FORMAT_IA44 = 112;
    public final static int DXGI_FORMAT_P8 = 113;
    public final static int DXGI_FORMAT_A8P8 = 114;
    public final static int DXGI_FORMAT_B4G4R4A4_UNORM = 115;
    public final static int DXGI_FORMAT_P208 = 130;
    public final static int DXGI_FORMAT_V208 = 131;
    public final static int DXGI_FORMAT_V408 = 132;
    public final static int DXGI_FORMAT_ASTC_4X4_TYPELESS = 133;
    public final static int DXGI_FORMAT_ASTC_4X4_UNORM = 134;
    public final static int DXGI_FORMAT_ASTC_4X4_UNORM_SRGB = 135;
    public final static int DXGI_FORMAT_ASTC_5X4_TYPELESS = 137;
    public final static int DXGI_FORMAT_ASTC_5X4_UNORM = 138;
    public final static int DXGI_FORMAT_ASTC_5X4_UNORM_SRGB = 139;
    public final static int DXGI_FORMAT_ASTC_5X5_TYPELESS = 141;
    public final static int DXGI_FORMAT_ASTC_5X5_UNORM = 142;
    public final static int DXGI_FORMAT_ASTC_5X5_UNORM_SRGB = 143;
    public final static int DXGI_FORMAT_ASTC_6X5_TYPELESS = 145;
    public final static int DXGI_FORMAT_ASTC_6X5_UNORM = 146;
    public final static int DXGI_FORMAT_ASTC_6X5_UNORM_SRGB = 147;
    public final static int DXGI_FORMAT_ASTC_6X6_TYPELESS = 149;
    public final static int DXGI_FORMAT_ASTC_6X6_UNORM = 150;
    public final static int DXGI_FORMAT_ASTC_6X6_UNORM_SRGB = 151;
    public final static int DXGI_FORMAT_ASTC_8X5_TYPELESS = 153;
    public final static int DXGI_FORMAT_ASTC_8X5_UNORM = 154;
    public final static int DXGI_FORMAT_ASTC_8X5_UNORM_SRGB = 155;
    public final static int DXGI_FORMAT_ASTC_8X6_TYPELESS = 157;
    public final static int DXGI_FORMAT_ASTC_8X6_UNORM = 158;
    public final static int DXGI_FORMAT_ASTC_8X6_UNORM_SRGB = 159;
    public final static int DXGI_FORMAT_ASTC_8X8_TYPELESS = 161;
    public final static int DXGI_FORMAT_ASTC_8X8_UNORM = 162;
    public final static int DXGI_FORMAT_ASTC_8X8_UNORM_SRGB = 163;
    public final static int DXGI_FORMAT_ASTC_10X5_TYPELESS = 165;
    public final static int DXGI_FORMAT_ASTC_10X5_UNORM = 166;
    public final static int DXGI_FORMAT_ASTC_10X5_UNORM_SRGB = 167;
    public final static int DXGI_FORMAT_ASTC_10X6_TYPELESS = 169;
    public final static int DXGI_FORMAT_ASTC_10X6_UNORM = 170;
    public final static int DXGI_FORMAT_ASTC_10X6_UNORM_SRGB = 171;
    public final static int DXGI_FORMAT_ASTC_10X8_TYPELESS = 173;
    public final static int DXGI_FORMAT_ASTC_10X8_UNORM = 174;
    public final static int DXGI_FORMAT_ASTC_10X8_UNORM_SRGB = 175;
    public final static int DXGI_FORMAT_ASTC_10X10_TYPELESS = 177;
    public final static int DXGI_FORMAT_ASTC_10X10_UNORM = 178;
    public final static int DXGI_FORMAT_ASTC_10X10_UNORM_SRGB = 179;
    public final static int DXGI_FORMAT_ASTC_12X10_TYPELESS = 181;
    public final static int DXGI_FORMAT_ASTC_12X10_UNORM = 182;
    public final static int DXGI_FORMAT_ASTC_12X10_UNORM_SRGB = 183;
    public final static int DXGI_FORMAT_ASTC_12X12_TYPELESS = 185;
    public final static int DXGI_FORMAT_ASTC_12X12_UNORM = 186;
    public final static int DXGI_FORMAT_ASTC_12X12_UNORM_SRGB = 187;
    public final static int DXGI_FORMAT_LAST = DXGI_FORMAT_ASTC_12X12_UNORM_SRGB;
    public final static int DXGI_FORMAT_FORCE_UINT = 0xffffffff;
}
