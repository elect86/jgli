/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgli.dx;

/**
 *
 * @author GBarbieri
 */
public class DxgiFormat {

    public enum Dds {

        DXGI_FORMAT_UNKNOWN(0),
        DXGI_FORMAT_R32G32B32A32_TYPELESS(1),
        DXGI_FORMAT_R32G32B32A32_FLOAT(2),
        DXGI_FORMAT_R32G32B32A32_UINT(3),
        DXGI_FORMAT_R32G32B32A32_SINT(4),
        DXGI_FORMAT_R32G32B32_TYPELESS(5),
        DXGI_FORMAT_R32G32B32_FLOAT(6),
        DXGI_FORMAT_R32G32B32_UINT(7),
        DXGI_FORMAT_R32G32B32_SINT(8),
        DXGI_FORMAT_R16G16B16A16_TYPELESS(9),
        DXGI_FORMAT_R16G16B16A16_FLOAT(10),
        DXGI_FORMAT_R16G16B16A16_UNORM(11),
        DXGI_FORMAT_R16G16B16A16_UINT(12),
        DXGI_FORMAT_R16G16B16A16_SNORM(13),
        DXGI_FORMAT_R16G16B16A16_SINT(14),
        DXGI_FORMAT_R32G32_TYPELESS(15),
        DXGI_FORMAT_R32G32_FLOAT(16),
        DXGI_FORMAT_R32G32_UINT(17),
        DXGI_FORMAT_R32G32_SINT(18),
        DXGI_FORMAT_R32G8X24_TYPELESS(19),
        DXGI_FORMAT_D32_FLOAT_S8X24_UINT(20),
        DXGI_FORMAT_R32_FLOAT_X8X24_TYPELESS(21),
        DXGI_FORMAT_X32_TYPELESS_G8X24_UINT(22),
        DXGI_FORMAT_R10G10B10A2_TYPELESS(23),
        DXGI_FORMAT_R10G10B10A2_UNORM(24),
        DXGI_FORMAT_R10G10B10A2_UINT(25),
        DXGI_FORMAT_R11G11B10_FLOAT(26),
        DXGI_FORMAT_R8G8B8A8_TYPELESS(27),
        DXGI_FORMAT_R8G8B8A8_UNORM(28),
        DXGI_FORMAT_R8G8B8A8_UNORM_SRGB(29),
        DXGI_FORMAT_R8G8B8A8_UINT(30),
        DXGI_FORMAT_R8G8B8A8_SNORM(31),
        DXGI_FORMAT_R8G8B8A8_SINT(32),
        DXGI_FORMAT_R16G16_TYPELESS(33),
        DXGI_FORMAT_R16G16_FLOAT(34),
        DXGI_FORMAT_R16G16_UNORM(35),
        DXGI_FORMAT_R16G16_UINT(36),
        DXGI_FORMAT_R16G16_SNORM(37),
        DXGI_FORMAT_R16G16_SINT(38),
        DXGI_FORMAT_R32_TYPELESS(39),
        DXGI_FORMAT_D32_FLOAT(40),
        DXGI_FORMAT_R32_FLOAT(41),
        DXGI_FORMAT_R32_UINT(42),
        DXGI_FORMAT_R32_SINT(43),
        DXGI_FORMAT_R24G8_TYPELESS(44),
        DXGI_FORMAT_D24_UNORM_S8_UINT(45),
        DXGI_FORMAT_R24_UNORM_X8_TYPELESS(46),
        DXGI_FORMAT_X24_TYPELESS_G8_UINT(47),
        DXGI_FORMAT_R8G8_TYPELESS(48),
        DXGI_FORMAT_R8G8_UNORM(49),
        DXGI_FORMAT_R8G8_UINT(50),
        DXGI_FORMAT_R8G8_SNORM(51),
        DXGI_FORMAT_R8G8_SINT(52),
        DXGI_FORMAT_R16_TYPELESS(53),
        DXGI_FORMAT_R16_FLOAT(54),
        DXGI_FORMAT_D16_UNORM(55),
        DXGI_FORMAT_R16_UNORM(56),
        DXGI_FORMAT_R16_UINT(57),
        DXGI_FORMAT_R16_SNORM(58),
        DXGI_FORMAT_R16_SINT(59),
        DXGI_FORMAT_R8_TYPELESS(60),
        DXGI_FORMAT_R8_UNORM(61),
        DXGI_FORMAT_R8_UINT(62),
        DXGI_FORMAT_R8_SNORM(63),
        DXGI_FORMAT_R8_SINT(64),
        DXGI_FORMAT_A8_UNORM(65),
        DXGI_FORMAT_R1_UNORM(66),
        DXGI_FORMAT_R9G9B9E5_SHAREDEXP(67),
        DXGI_FORMAT_R8G8_B8G8_UNORM(68),
        DXGI_FORMAT_G8R8_G8B8_UNORM(69),
        DXGI_FORMAT_BC1_TYPELESS(70),
        DXGI_FORMAT_BC1_UNORM(71),
        DXGI_FORMAT_BC1_UNORM_SRGB(72),
        DXGI_FORMAT_BC2_TYPELESS(73),
        DXGI_FORMAT_BC2_UNORM(74),
        DXGI_FORMAT_BC2_UNORM_SRGB(75),
        DXGI_FORMAT_BC3_TYPELESS(76),
        DXGI_FORMAT_BC3_UNORM(77),
        DXGI_FORMAT_BC3_UNORM_SRGB(78),
        DXGI_FORMAT_BC4_TYPELESS(79),
        DXGI_FORMAT_BC4_UNORM(80),
        DXGI_FORMAT_BC4_SNORM(81),
        DXGI_FORMAT_BC5_TYPELESS(82),
        DXGI_FORMAT_BC5_UNORM(83),
        DXGI_FORMAT_BC5_SNORM(84),
        DXGI_FORMAT_B5G6R5_UNORM(85),
        DXGI_FORMAT_B5G5R5A1_UNORM(86),
        DXGI_FORMAT_B8G8R8A8_UNORM(87),
        DXGI_FORMAT_B8G8R8X8_UNORM(88),
        DXGI_FORMAT_R10G10B10_XR_BIAS_A2_UNORM(89),
        DXGI_FORMAT_B8G8R8A8_TYPELESS(90),
        DXGI_FORMAT_B8G8R8A8_UNORM_SRGB(91),
        DXGI_FORMAT_B8G8R8X8_TYPELESS(92),
        DXGI_FORMAT_B8G8R8X8_UNORM_SRGB(93),
        DXGI_FORMAT_BC6H_TYPELESS(94),
        DXGI_FORMAT_BC6H_UF16(95),
        DXGI_FORMAT_BC6H_SF16(96),
        DXGI_FORMAT_BC7_TYPELESS(97),
        DXGI_FORMAT_BC7_UNORM(98),
        DXGI_FORMAT_BC7_UNORM_SRGB(99),
        DXGI_FORMAT_AYUV(100),
        DXGI_FORMAT_Y410(101),
        DXGI_FORMAT_Y416(102),
        DXGI_FORMAT_NV12(103),
        DXGI_FORMAT_P010(104),
        DXGI_FORMAT_P016(105),
        DXGI_FORMAT_420_OPAQUE(106),
        DXGI_FORMAT_YUY2(107),
        DXGI_FORMAT_Y210(108),
        DXGI_FORMAT_Y216(109),
        DXGI_FORMAT_NV11(110),
        DXGI_FORMAT_AI44(111),
        DXGI_FORMAT_IA44(112),
        DXGI_FORMAT_P8(113),
        DXGI_FORMAT_A8P8(114),
        DXGI_FORMAT_B4G4R4A4_UNORM(115),
        //
        DXGI_FORMAT_P208(130),
        DXGI_FORMAT_V208(131),
        DXGI_FORMAT_V408(132),
        DXGI_FORMAT_ASTC_4X4_TYPELESS(133),
        DXGI_FORMAT_ASTC_4X4_UNORM(134),
        DXGI_FORMAT_ASTC_4X4_UNORM_SRGB(135),
        DXGI_FORMAT_ASTC_5X4_TYPELESS(137),
        DXGI_FORMAT_ASTC_5X4_UNORM(138),
        DXGI_FORMAT_ASTC_5X4_UNORM_SRGB(139),
        DXGI_FORMAT_ASTC_5X5_TYPELESS(141),
        DXGI_FORMAT_ASTC_5X5_UNORM(142),
        DXGI_FORMAT_ASTC_5X5_UNORM_SRGB(143),
        DXGI_FORMAT_ASTC_6X5_TYPELESS(145),
        DXGI_FORMAT_ASTC_6X5_UNORM(146),
        DXGI_FORMAT_ASTC_6X5_UNORM_SRGB(147),
        DXGI_FORMAT_ASTC_6X6_TYPELESS(149),
        DXGI_FORMAT_ASTC_6X6_UNORM(150),
        DXGI_FORMAT_ASTC_6X6_UNORM_SRGB(151),
        DXGI_FORMAT_ASTC_8X5_TYPELESS(153),
        DXGI_FORMAT_ASTC_8X5_UNORM(154),
        DXGI_FORMAT_ASTC_8X5_UNORM_SRGB(155),
        DXGI_FORMAT_ASTC_8X6_TYPELESS(157),
        DXGI_FORMAT_ASTC_8X6_UNORM(158),
        DXGI_FORMAT_ASTC_8X6_UNORM_SRGB(159),
        DXGI_FORMAT_ASTC_8X8_TYPELESS(161),
        DXGI_FORMAT_ASTC_8X8_UNORM(162),
        DXGI_FORMAT_ASTC_8X8_UNORM_SRGB(163),
        DXGI_FORMAT_ASTC_10X5_TYPELESS(165),
        DXGI_FORMAT_ASTC_10X5_UNORM(166),
        DXGI_FORMAT_ASTC_10X5_UNORM_SRGB(167),
        DXGI_FORMAT_ASTC_10X6_TYPELESS(169),
        DXGI_FORMAT_ASTC_10X6_UNORM(170),
        DXGI_FORMAT_ASTC_10X6_UNORM_SRGB(171),
        DXGI_FORMAT_ASTC_10X8_TYPELESS(173),
        DXGI_FORMAT_ASTC_10X8_UNORM(174),
        DXGI_FORMAT_ASTC_10X8_UNORM_SRGB(175),
        DXGI_FORMAT_ASTC_10X10_TYPELESS(177),
        DXGI_FORMAT_ASTC_10X10_UNORM(178),
        DXGI_FORMAT_ASTC_10X10_UNORM_SRGB(179),
        DXGI_FORMAT_ASTC_12X10_TYPELESS(181),
        DXGI_FORMAT_ASTC_12X10_UNORM(182),
        DXGI_FORMAT_ASTC_12X10_UNORM_SRGB(183),
        DXGI_FORMAT_ASTC_12X12_TYPELESS(185),
        DXGI_FORMAT_ASTC_12X12_UNORM(186),
        DXGI_FORMAT_ASTC_12X12_UNORM_SRGB(187),
        //        
        DXGI_FORMAT_FORCE_UINT(0xffffffff);

        public final int value;

        private Dds() {
            value = Counter.nextValue;
            Counter.nextValue++;
        }

        private Dds(int value) {
            this.value = value;
            Counter.nextValue = value++;
        }

        private Dds(Dds dxgiFormat) {
            value = dxgiFormat.value;
        }

        public static Dds get(int value) {
            for (Dds dds : values()) {
                if (dds.value == value) {
                    return dds;
                }
            }
            return DXGI_FORMAT_UNKNOWN;
        }

        /**
         * Trick to get automatic incremental values.
         */
        private static class Counter {

            private static int nextValue = 0;
        }
    }

    public enum Gli {

        DXGI_FORMAT_R64_UINT_GLI(1),
        DXGI_FORMAT_R64_SINT_GLI,
        DXGI_FORMAT_R64_FLOAT_GLI,
        DXGI_FORMAT_R64G64_UINT_GLI,
        DXGI_FORMAT_R64G64_SINT_GLI,
        DXGI_FORMAT_R64G64_FLOAT_GLI,
        DXGI_FORMAT_R64G64B64_UINT_GLI,
        DXGI_FORMAT_R64G64B64_SINT_GLI,
        DXGI_FORMAT_R64G64B64_FLOAT_GLI,
        DXGI_FORMAT_R64G64B64A64_UINT_GLI,
        DXGI_FORMAT_R64G64B64A64_SINT_GLI,
        DXGI_FORMAT_R64G64B64A64_FLOAT_GLI,
        //			
        DXGI_FORMAT_RG4_UNORM_GLI,
        DXGI_FORMAT_RGBA4_UNORM_GLI,
        DXGI_FORMAT_R5G6B5_UNORM_GLI,
        DXGI_FORMAT_R5G5B5A1_UNORM_GLI,
        DXGI_FORMAT_A1B5G5R5_UNORM_GLI,
        //			
        DXGI_FORMAT_R8_SRGB_GLI,
        DXGI_FORMAT_R8_USCALED_GLI,
        DXGI_FORMAT_R8_SSCALED_GLI,
        //			
        DXGI_FORMAT_R8G8_SRGB_GLI,
        DXGI_FORMAT_R8G8_USCALED_GLI,
        DXGI_FORMAT_R8G8_SSCALED_GLI,
        //			
        DXGI_FORMAT_R8G8B8_UNORM_GLI,
        DXGI_FORMAT_R8G8B8_SNORM_GLI,
        DXGI_FORMAT_R8G8B8_USCALED_GLI,
        DXGI_FORMAT_R8G8B8_SSCALED_GLI,
        DXGI_FORMAT_R8G8B8_UINT_GLI,
        DXGI_FORMAT_R8G8B8_SINT_GLI,
        DXGI_FORMAT_R8G8B8_SRGB_GLI,
        //			
        DXGI_FORMAT_B8G8R8_UNORM_GLI,
        DXGI_FORMAT_B8G8R8_SNORM_GLI,
        DXGI_FORMAT_B8G8R8_USCALED_GLI,
        DXGI_FORMAT_B8G8R8_SSCALED_GLI,
        DXGI_FORMAT_B8G8R8_UINT_GLI,
        DXGI_FORMAT_B8G8R8_SINT_GLI,
        DXGI_FORMAT_B8G8R8_SRGB_GLI,
        //			
        DXGI_FORMAT_R8G8B8A8_USCALED_GLI,
        DXGI_FORMAT_R8G8B8A8_SSCALED_GLI,
        //			
        DXGI_FORMAT_B8G8R8A8_SNORM_GLI,
        DXGI_FORMAT_B8G8R8A8_USCALED_GLI,
        DXGI_FORMAT_B8G8R8A8_SSCALED_GLI,
        DXGI_FORMAT_B8G8R8A8_UINT_GLI,
        DXGI_FORMAT_B8G8R8A8_SINT_GLI,
        //			
        DXGI_FORMAT_R8G8B8A8_PACK_UNORM_GLI,
        DXGI_FORMAT_R8G8B8A8_PACK_SNORM_GLI,
        DXGI_FORMAT_R8G8B8A8_PACK_USCALED_GLI,
        DXGI_FORMAT_R8G8B8A8_PACK_SSCALED_GLI,
        DXGI_FORMAT_R8G8B8A8_PACK_UINT_GLI,
        DXGI_FORMAT_R8G8B8A8_PACK_SINT_GLI,
        DXGI_FORMAT_R8G8B8A8_PACK_SRGB_GLI,
        //			
        DXGI_FORMAT_R10G10B10A2_SNORM_GLI,
        DXGI_FORMAT_R10G10B10A2_USCALED_GLI,
        DXGI_FORMAT_R10G10B10A2_SSCALED_GLI,
        DXGI_FORMAT_R10G10B10A2_SINT_GLI,
        //			
        DXGI_FORMAT_B10G10R10A2_UNORM_GLI,
        DXGI_FORMAT_B10G10R10A2_SNORM_GLI,
        DXGI_FORMAT_B10G10R10A2_USCALED_GLI,
        DXGI_FORMAT_B10G10R10A2_SSCALED_GLI,
        DXGI_FORMAT_B10G10R10A2_UINT_GLI,
        DXGI_FORMAT_B10G10R10A2_SINT_GLI,
        //			
        DXGI_FORMAT_R16_USCALED_GLI,
        DXGI_FORMAT_R16_SSCALED_GLI,
        DXGI_FORMAT_R16G16_USCALED_GLI,
        DXGI_FORMAT_R16G16_SSCALED_GLI,
        //			
        DXGI_FORMAT_R16G16B16_UNORM_GLI,
        DXGI_FORMAT_R16G16B16_SNORM_GLI,
        DXGI_FORMAT_R16G16B16_USCALED_GLI,
        DXGI_FORMAT_R16G16B16_SSCALED_GLI,
        DXGI_FORMAT_R16G16B16_UINT_GLI,
        DXGI_FORMAT_R16G16B16_SINT_GLI,
        DXGI_FORMAT_R16G16B16_FLOAT_GLI,
        //			
        DXGI_FORMAT_R16G16B16A16_USCALED_GLI,
        DXGI_FORMAT_R16G16B16A16_SSCALED_GLI,
        //			
        DXGI_FORMAT_S8_UINT_GLI,
        DXGI_FORMAT_D16_UNORM_S8_UINT_GLI,
        DXGI_FORMAT_D24_UNORM_GLI,
        //			
        DXGI_FORMAT_L8_UNORM_GLI,
        DXGI_FORMAT_A8_UNORM_GLI,
        DXGI_FORMAT_LA8_UNORM_GLI,
        DXGI_FORMAT_L16_UNORM_GLI,
        DXGI_FORMAT_A16_UNORM_GLI,
        DXGI_FORMAT_LA16_UNORM_GLI,
        //			
        DXGI_FORMAT_R3G3B2_UNORM_GLI,
        //			
        DXGI_FORMAT_BC1_RGB_UNORM_GLI,
        DXGI_FORMAT_BC1_RGB_SRGB_GLI,
        DXGI_FORMAT_RGB_ETC2_UNORM_GLI,
        DXGI_FORMAT_RGB_ETC2_SRGB_GLI,
        DXGI_FORMAT_RGBA_ETC2_A1_UNORM_GLI,
        DXGI_FORMAT_RGBA_ETC2_A1_SRGB_GLI,
        DXGI_FORMAT_RGBA_ETC2_UNORM_GLI,
        DXGI_FORMAT_RGBA_ETC2_SRGB_GLI,
        DXGI_FORMAT_R11_EAC_UNORM_GLI,
        DXGI_FORMAT_R11_EAC_SNORM_GLI,
        DXGI_FORMAT_RG11_EAC_UNORM_GLI,
        DXGI_FORMAT_RG11_EAC_SNORM_GLI,
        //			
        DXGI_FORMAT_RGB_PVRTC1_8X8_UNORM_GLI,
        DXGI_FORMAT_RGB_PVRTC1_8X8_SRGB_GLI,
        DXGI_FORMAT_RGB_PVRTC1_16X8_UNORM_GLI,
        DXGI_FORMAT_RGB_PVRTC1_16X8_SRGB_GLI,
        DXGI_FORMAT_RGBA_PVRTC1_8X8_UNORM_GLI,
        DXGI_FORMAT_RGBA_PVRTC1_8X8_SRGB_GLI,
        DXGI_FORMAT_RGBA_PVRTC1_16X8_UNORM_GLI,
        DXGI_FORMAT_RGBA_PVRTC1_16X8_SRGB_GLI,
        DXGI_FORMAT_RGBA_PVRTC2_8X8_UNORM_GLI,
        DXGI_FORMAT_RGBA_PVRTC2_8X8_SRGB_GLI,
        DXGI_FORMAT_RGBA_PVRTC2_16X8_UNORM_GLI,
        DXGI_FORMAT_RGBA_PVRTC2_16X8_SRGB_GLI,
        //			
        DXGI_FORMAT_RGB_ETC_UNORM_GLI,
        DXGI_FORMAT_RGB_ATC_UNORM_GLI,
        DXGI_FORMAT_RGBA_ATCA_UNORM_GLI,
        DXGI_FORMAT_RGBA_ATCI_UNORM_GLI;

        public final int value;

        private Gli() {
            value = Counter.nextValue;
            Counter.nextValue++;
        }

        private Gli(int value) {
            this.value = value;
            Counter.nextValue = value++;
        }

        private Gli(Dds dxgiFormat) {
            value = dxgiFormat.value;
        }

        public static Gli get(int value) {
            for (Gli gli : values()) {
                if (gli.value == value) {
                    return gli;
                }
            }
            return DXGI_FORMAT_R64_UINT_GLI;
        }

        /**
         * Trick to get automatic incremental values.
         */
        private static class Counter {

            private static int nextValue = 0;
        }
    }
}
