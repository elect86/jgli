# JGLI

Java porting of the [g-truc GLI](https://github.com/g-truc/gli)

Every texture listed here works except where differently specified 

            /**
             * To test.
             */
            tests.add(new Test(gl4, "array_r8_unorm.dds"));
            tests.add(new Test(gl4, "array_r8_unorm.ktx"));
            
            tests.add(new Test(gl4, "cube_rgba8_unorm.dds"));
            tests.add(new Test(gl4, "cube_rgba8_unorm.ktx"));
            tests.add(new Test(gl4, "kueken7_a8_unorm.dds"));
            tests.add(new Test(gl4, "kueken7_bgra8_srgb.dds"));
            tests.add(new Test(gl4, "kueken7_bgra8_unorm.dds"));
            /**
             * Bug, getting FORMAT_RGB8_SRGB instead that FORMAT_BGRX8_SRGB.
             * This will lead to a wrong exstimated texture size.
             */
            tests.add(new Test(gl4, "kueken7_bgrx8_srgb.dds"));
            
            tests.add(new Test(gl4, "kueken7_bgrx8_unorm.dds"));
            tests.add(new Test(gl4, "kueken7_l8_unorm.dds"));
            /**
             * Wrong header, header.format.fourCC is D3DFMT_DX10 but
             * header10.format is DXGI_FORMAT_UNKNOWN.
             */
            tests.add(new Test(gl4, "kueken7_la8_unorm.dds"));
            
            tests.add(new Test(gl4, "kueken7_r_ati1n_unorm.dds"));
            /**
             * Working althought I miss the ETC extension, "emulating compressed
             * format not supported in hardware with decompressed images".
             * https://en.wikipedia.org/wiki/Ericsson_Texture_Compression
             */
            tests.add(new Test(gl4, "kueken7_r_eac_snorm.ktx"));
            tests.add(new Test(gl4, "kueken7_r_eac_unorm.ktx"));
            
            tests.add(new Test(gl4, "kueken7_r5g6b5_unorm.dds"));
            tests.add(new Test(gl4, "kueken7_r8_snorm.dds"));
            tests.add(new Test(gl4, "kueken7_r8_unorm.dds"));
            tests.add(new Test(gl4, "kueken7_r16_unorm.dds"));
            tests.add(new Test(gl4, "kueken7_rg_ati2n_unorm.dds"));
            /**
             * Working althought I miss the ETC extension, "emulating compressed
             * format not supported in hardware with decompressed images".
             * https://en.wikipedia.org/wiki/Ericsson_Texture_Compression
             */
            tests.add(new Test(gl4, "kueken7_rg_eac_snorm.ktx"));            
            tests.add(new Test(gl4, "kueken7_rg_eac_unorm.ktx"));            
            /**
             * Working but not sure about the result.
             */
            tests.add(new Test(gl4, "kueken7_rg11b10_ufloat.dds"));
            tests.add(new Test(gl4, "kueken7_rg11b10_ufloat.ktx"));
            /**
             * Untested, I dont have AMD_compressed_ATC_texture.
             */
            tests.add(new Test(gl4, "kueken7_rgb_atc_unorm.dds"));
            
            tests.add(new Test(gl4, "kueken7_rgb_dxt1_srgb.dds"));
            /**
             * Wrong header, glInternalFormat should be:
             *
             * INTERNAL_SRGB_DXT1(0x8C4C)
             *
             * instead of:
             *
             * INTERNAL_RGB_DXT1(0x83F0).
             */
            tests.add(new Test(gl4, "kueken7_rgb_dxt1_srgb.ktx"));
            
            tests.add(new Test(gl4, "kueken7_rgb_dxt1_unorm.dds"));
            tests.add(new Test(gl4, "kueken7_rgb_dxt1_unorm.ktx"));
            tests.add(new Test(gl4, "kueken7_rgb_etc1_unorm.dds"));
            tests.add(new Test(gl4, "kueken7_rgb_etc1_unorm.ktx"));
            tests.add(new Test(gl4, "kueken7_rgb_etc2_srgb.dds"));
            /**
             * Working althought I miss the ETC extension, "emulating compressed
             * format not supported in hardware with decompressed images".
             * https://en.wikipedia.org/wiki/Ericsson_Texture_Compression
             */
            tests.add(new Test(gl4, "kueken7_rgb_etc2_srgb.ktx"));
            /**
             * Wrong header, header.format.fourCC is D3DFMT_DX10 but
             * header10.format is DXGI_FORMAT_UNKNOWN.
             */
            tests.add(new Test(gl4, "kueken7_rgb_etc2_unorm.dds"));
            /**
             * Untested, I dont have GL_IMG_texture_compression_pvrtc.
             */
            tests.add(new Test(gl4, "kueken7_rgb_pvrtc_2bpp_unorm.dds"));
            tests.add(new Test(gl4, "kueken7_rgb_pvrtc_2bpp_srgb.ktx"));
            tests.add(new Test(gl4, "kueken7_rgb_pvrtc_4bpp_unorm.dds"));
            tests.add(new Test(gl4, "kueken7_rgb_pvrtc_4bpp_srgb.ktx"));
            /**
             * Buffer problem.
             */
            tests.add(new Test(gl4, "kueken7_rgb_pvrtc2_2bpp_srgb.ktx"));
            tests.add(new Test(gl4, "kueken7_rgb_pvrtc2_4bpp_srgb.ktx"));
            
            tests.add(new Test(gl4, "kueken7_rgb8_srgb.dds"));
            tests.add(new Test(gl4, "kueken7_rgb8_srgb.ktx"));
            tests.add(new Test(gl4, "kueken7_rgb8_unorm.dds"));        
            tests.add(new Test(gl4, "kueken7_rgb8_unorm.ktx"));        
            tests.add(new Test(gl4, "kueken7_rgb9e5_ufloat.dds"));
            tests.add(new Test(gl4, "kueken7_rgb9e5_ufloat.ktx"));
            /**
             * Probabily working but format type enum unsupported by jogl.
             */
            tests.add(new Test(gl4, "kueken7_rgb10a2_unorm.dds"));
            tests.add(new Test(gl4, "kueken7_rgb10a2u.dds"));
            /**
             * Working althought I miss the ASTC extension, "emulating
             * compressed format not supported in hardware with decompressed
             * images". https://www.opengl.org/wiki/ASTC_Texture_Compression
             */
            tests.add(new Test(gl4, "kueken7_rgba_astc4x4_srgb.ktx"));
            /**
             * GL_INVALID_VALUE is generated if imageSize is not consistent with
             * the format, dimensions, and contents of the specified compressed
             * image data.
             */
            tests.add(new Test(gl4, "kueken7_rgba_astc8x5_srgb.ktx"));
            /**
             * Wrong header, header.format.fourCC is D3DFMT_DX10 but
             * header10.format is DXGI_FORMAT_UNKNOWN.
             */
            tests.add(new Test(gl4, "kueken7_rgba_astc8x8_unorm.dds"));
            /**
             * GL_INVALID_VALUE is generated if imageSize is not consistent with
             * the format, dimensions, and contents of the specified compressed
             * image data.
             */
            tests.add(new Test(gl4, "kueken7_rgba_astc12x12_srgb.ktx"));
            /**
             * I cant test, I dont have AMD_compressed_ATC_texture.
             */
            tests.add(new Test(gl4, "kueken7_rgba_atc_explicit_unorm.dds"));
            tests.add(new Test(gl4, "kueken7_rgba_atc_interpolate_unorm.dds"));
            
            tests.add(new Test(gl4, "kueken7_rgba_dxt5_srgb.dds"));
            /**
             * Wrong header, glInternalFormat should be:
             *
             * INTERNAL_SRGB_DXT5
             *
             * instead of:
             *
             * INTERNAL_RGB_DXT5
             */
            tests.add(new Test(gl4, "kueken7_rgba_dxt5_srgb.ktx"));
            
            tests.add(new Test(gl4, "kueken7_rgba_dxt5_unorm.dds"));
            tests.add(new Test(gl4, "kueken7_rgba_dxt5_unorm.ktx"));
            /**
             * Working althought I miss the ASTC extension, "emulating
             * compressed format not supported in hardware with decompressed
             * images". https://www.opengl.org/wiki/ASTC_Texture_Compression
             */
            tests.add(new Test(gl4, "kueken7_rgba_etc2_a1_srgb.ktx"));
            tests.add(new Test(gl4, "kueken7_rgba_etc2_srgb.ktx"));
            /**
             * Wrong header, header.format.fourCC is D3DFMT_DX10 but
             * header10.format is DXGI_FORMAT_UNKNOWN.
             */
            tests.add(new Test(gl4, "kueken7_rgba_pvrtc2_4bpp_unorm.dds"));

            tests.add(new Test(gl4, "kueken7_rgba8_snorm.dds"));
            tests.add(new Test(gl4, "kueken7_rgba8_srgb.dds"));
            tests.add(new Test(gl4, "kueken7_rgba8_srgb.ktx"));
            tests.add(new Test(gl4, "kueken7_rgba8_unorm.dds"));
            tests.add(new Test(gl4, "kueken7_rgba8_unorm.ktx"));
            tests.add(new Test(gl4, "kueken7_rgba16_sfloat.dds"));
            tests.add(new Test(gl4, "kueken7_rgba16_sfloat.ktx"));
            tests.add(new Test(gl4, "kueken8_rgba8_srgb.dds"));
            tests.add(new Test(gl4, "kueken8_rgba8_srgb.ktx"));

#### [JGLI 0.7.0.0](https://github.com/elect86/jgli/releases/tag/0.7.0.0) - 2015-10-09

- first true ported version 
- added support for DDS and KTX texture formats


