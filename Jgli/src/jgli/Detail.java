/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgli;

import java.nio.ByteBuffer;

/**
 *
 * @author elect
 */
public class Detail {

    /**
     * DDS caps2.
     */
    public static final int DDSCAPS2_CUBEMAP = 0x00000200;
    public static final int DDSCAPS2_CUBEMAP_POSITIVEX = 0x00000400;
    public static final int DDSCAPS2_CUBEMAP_NEGATIVEX = 0x00000800;
    public static final int DDSCAPS2_CUBEMAP_POSITIVEY = 0x00001000;
    public static final int DDSCAPS2_CUBEMAP_NEGATIVEY = 0x00002000;
    public static final int DDSCAPS2_CUBEMAP_POSITIVEZ = 0x00004000;
    public static final int DDSCAPS2_CUBEMAP_NEGATIVEZ = 0x00008000;
    public static final int DDSCAPS2_VOLUME = 0x00200000;

    public static final int DDSCAPS2_CUBEMAP_ALLFACES
            = DDSCAPS2_CUBEMAP_POSITIVEX | DDSCAPS2_CUBEMAP_NEGATIVEX | DDSCAPS2_CUBEMAP_POSITIVEY
            | DDSCAPS2_CUBEMAP_NEGATIVEY | DDSCAPS2_CUBEMAP_POSITIVEZ | DDSCAPS2_CUBEMAP_NEGATIVEZ;

    /**
     * DDS flags.
     */
    public static final int DDSD_CAPS = 0x00000001;
    public static final int DDSD_HEIGHT = 0x00000002;
    public static final int DDSD_WIDTH = 0x00000004;
    public static final int DDSD_PITCH = 0x00000008;
    public static final int DDSD_PIXELFORMAT = 0x00001000;
    public static final int DDSD_MIPMAPCOUNT = 0x00020000;
    public static final int DDSD_LINEARSIZE = 0x00080000;
    public static final int DDSD_DEPTH = 0x00800000;

    /**
     * DDS caps.
     */
    public static final int DDSCAPS_COMPLEX = 0x00000008;
    public static final int DDSCAPS_MIPMAP = 0x00400000;
    public static final int DDSCAPS_TEXTURE = 0x00001000;

    /**
     * D3D10 resource dimension.
     */
    public static final int D3D10_RESOURCE_DIMENSION_UNKNOWN = 0;
    public static final int D3D10_RESOURCE_DIMENSION_BUFFER = 1;
    public static final int D3D10_RESOURCE_DIMENSION_TEXTURE1D = 2;
    public static final int D3D10_RESOURCE_DIMENSION_TEXTURE2D = 3;
    public static final int D3D10_RESOURCE_DIMENSION_TEXTURE3D = 4;

    /**
     * D3D10 resource misc flag.
     */
    public static final int D3D10_RESOURCE_MISC_GENERATE_MIPS = 0x01;
    public static final int D3D10_RESOURCE_MISC_SHARED = 0x02;
    public static final int D3D10_RESOURCE_MISC_TEXTURECUBE = 0x04;
    public static final int D3D10_RESOURCE_MISC_SHARED_KEYEDMUTEX = 0x10;
    public static final int D3D10_RESOURCE_MISC_GDI_COMPATIBLE = 0x20;

    /**
     * DDS alpha mode.
     */
    public static final int DDS_ALPHA_MODE_UNKNOWN = 0x0;
    public static final int DDS_ALPHA_MODE_STRAIGHT = 0x1;
    public static final int DDS_ALPHA_MODE_PREMULTIPLIED = 0x2;
    public static final int DDS_ALPHA_MODE_OPAQUE = 0x3;
    public static final int DDS_ALPHA_MODE_CUSTOM = 0x4;

    /**
     * Cap.
     */
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

    public static class DdsHeader {

        public int magic;
        public int size;
        public int flags;
        public int height;
        public int width;
        public int pitch;
        public int depth;
        public int mipMapLevels;
        public int[] reserved1 = new int[11];
        public DdsPixelFormat format;
        public int surfaceFlags;
        public int cubemapFlags;
        public int[] reserved2 = new int[3];

        public static final int sizeOf = 4 * Byte.BYTES + 7 * Integer.BYTES + 11 * Integer.BYTES
                + DdsPixelFormat.sizeOf + 2 * Integer.BYTES + 3 * Integer.BYTES;

        public static final int offsetMagic = 0;
        public static final int offsetSize = offsetMagic + 4 * Byte.BYTES;
        public static final int offsetFlags = offsetSize + Integer.BYTES;
        public static final int offsetHeight = offsetFlags + Integer.BYTES;
        public static final int offsetWidth = offsetHeight + Integer.BYTES;
        public static final int offsetPitch = offsetWidth + Integer.BYTES;
        public static final int offsetDepth = offsetPitch + Integer.BYTES;
        public static final int offsetMipMapLevels = offsetDepth + Integer.BYTES;
        public static final int offsetReserved1 = offsetMipMapLevels + Integer.BYTES;
        public static final int offsetFormat = offsetReserved1 + 11 * Integer.BYTES;
        public static final int offsetSurfaceFlags = offsetFormat + DdsPixelFormat.sizeOf;
        public static final int offsetCubemapFlags = offsetSurfaceFlags + Integer.BYTES;
        public static final int offsetReserved2 = offsetCubemapFlags + Integer.BYTES;

        public DdsHeader(ByteBuffer byteBuffer) {

            magic = byteBuffer.getInt();
            size = byteBuffer.getInt();
            flags = byteBuffer.getInt();
            height = byteBuffer.getInt();
            width = byteBuffer.getInt();
            pitch = byteBuffer.getInt();
            depth = byteBuffer.getInt();
            mipMapLevels = byteBuffer.getInt();
            for (int i = 0; i < reserved1.length; i++) {
                reserved1[i] = byteBuffer.getInt();
            }
            format = new DdsPixelFormat(byteBuffer);
            surfaceFlags = byteBuffer.getInt();
            cubemapFlags = byteBuffer.getInt();
            for (int i = 0; i < reserved2.length; i++) {
                reserved2[i] = byteBuffer.getInt();
            }
        }
    }

    public static class DdsHeader10 {

        public int format;
        public int resourceDimension;
        public int miscFlag;    // D3D10_RESOURCE_MISC_GENERATE_MIPS
        public int arraySize;
        public int reserved;
        public static final int sizeOf = 5 * Integer.BYTES;

        public DdsHeader10(ByteBuffer byteBuffer) {
            format = byteBuffer.getInt();
            resourceDimension = byteBuffer.getInt();
            miscFlag = byteBuffer.getInt();
            arraySize = byteBuffer.getInt();
            reserved = byteBuffer.getInt();
        }
    }

    public static class DdsPixelFormat {

        public int size;
        public int flags;
        public int fourCC;
        public int bpp;
        public int[] mask = new int[4];

        public static final int sizeOf = (4 + 4) * Integer.BYTES;

        public DdsPixelFormat(ByteBuffer byteBuffer) {

            size = byteBuffer.getInt();
            flags = byteBuffer.getInt();
            fourCC = byteBuffer.getInt();
            bpp = byteBuffer.getInt();
            for (int i = 0; i < mask.length; i++) {
                mask[i] = byteBuffer.getInt();
            }
        }
    }

    private static final FormatInfo[] table = new FormatInfo[]{
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

        // Unsigned integer formats
        new FormatInfo((byte) 1, new byte[]{1, 1, 1}, (byte) 1, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R8_UINT,
        new FormatInfo((byte) 2, new byte[]{1, 1, 1}, (byte) 2, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RG8_UINT,
        new FormatInfo((byte) 3, new byte[]{1, 1, 1}, (byte) 3, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB8_UINT,
        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 4, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA8_UINT,

        new FormatInfo((byte) 2, new byte[]{1, 1, 1}, (byte) 1, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R16_UINT,
        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 2, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RG16_UINT,
        new FormatInfo((byte) 6, new byte[]{1, 1, 1}, (byte) 3, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB16_UINT,
        new FormatInfo((byte) 8, new byte[]{1, 1, 1}, (byte) 4, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA16_UINT,

        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 1, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R32_UINT,
        new FormatInfo((byte) 8, new byte[]{1, 1, 1}, (byte) 2, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RG32_UINT,
        new FormatInfo((byte) 12, new byte[]{1, 1, 1}, (byte) 3, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB32_UINT,
        new FormatInfo((byte) 16, new byte[]{1, 1, 1}, (byte) 4, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA32_UINT,

        // Signed integer formats
        new FormatInfo((byte) 1, new byte[]{1, 1, 1}, (byte) 1, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT)), //FORMAT_R8_SINT,
        new FormatInfo((byte) 2, new byte[]{1, 1, 1}, (byte) 2, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT)), //FORMAT_RG8_SINT,
        new FormatInfo((byte) 3, new byte[]{1, 1, 1}, (byte) 3, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT)), //FORMAT_RGB8_SINT,
        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 4, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT)), //FORMAT_RGBA8_SINT,

        new FormatInfo((byte) 2, new byte[]{1, 1, 1}, (byte) 1, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT)), //FORMAT_R16_SINT,
        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 2, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT)), //FORMAT_RG16_SINT,
        new FormatInfo((byte) 6, new byte[]{1, 1, 1}, (byte) 3, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT)), //FORMAT_RGB16_SINT,
        new FormatInfo((byte) 8, new byte[]{1, 1, 1}, (byte) 4, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT)), //FORMAT_RGBA16_SINT,

        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 1, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT)), //FORMAT_R32_SINT,
        new FormatInfo((byte) 8, new byte[]{1, 1, 1}, (byte) 2, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT)), //FORMAT_RG32_SINT,
        new FormatInfo((byte) 12, new byte[]{1, 1, 1}, (byte) 3, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT)), //FORMAT_RGB32_SINT,
        new FormatInfo((byte) 16, new byte[]{1, 1, 1}, (byte) 4, (short) (CAP_INTEGER_BIT | CAP_SIGNED_BIT)), //FORMAT_RGBA32_SINT,

        // Floating formats
        new FormatInfo((byte) 2, new byte[]{1, 1, 1}, (byte) 1, (short) (CAP_FLOAT_BIT | CAP_SIGNED_BIT)), //FORMAT_R16_SFLOAT,
        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 2, (short) (CAP_FLOAT_BIT | CAP_SIGNED_BIT)), //FORMAT_RG16_SFLOAT,
        new FormatInfo((byte) 6, new byte[]{1, 1, 1}, (byte) 3, (short) (CAP_FLOAT_BIT | CAP_SIGNED_BIT)), //FORMAT_RGB16_SFLOAT,
        new FormatInfo((byte) 8, new byte[]{1, 1, 1}, (byte) 4, (short) (CAP_FLOAT_BIT | CAP_SIGNED_BIT)), //FORMAT_RGBA16_SFLOAT,

        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 1, (short) (CAP_FLOAT_BIT | CAP_SIGNED_BIT)), //FORMAT_R32_SFLOAT,
        new FormatInfo((byte) 8, new byte[]{1, 1, 1}, (byte) 2, (short) (CAP_FLOAT_BIT | CAP_SIGNED_BIT)), //FORMAT_RG32_SFLOAT,
        new FormatInfo((byte) 12, new byte[]{1, 1, 1}, (byte) 3, (short) (CAP_FLOAT_BIT | CAP_SIGNED_BIT)), //FORMAT_RGB32_SFLOAT,
        new FormatInfo((byte) 16, new byte[]{1, 1, 1}, (byte) 4, (short) (CAP_FLOAT_BIT | CAP_SIGNED_BIT)), //FORMAT_RGBA32_SFLOAT,

        // sRGB formats
        new FormatInfo((byte) 3, new byte[]{1, 1, 1}, (byte) 3, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_COLORSPACE_SRGB_BIT)), //FORMAT_R8_SRGB,
        new FormatInfo((byte) 3, new byte[]{1, 1, 1}, (byte) 3, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_COLORSPACE_SRGB_BIT)), //FORMAT_RG8_SRGB,
        new FormatInfo((byte) 3, new byte[]{1, 1, 1}, (byte) 3, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_COLORSPACE_SRGB_BIT)), //FORMAT_RGB8_SRGB,
        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 4, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_COLORSPACE_SRGB_BIT)), //FORMAT_RGBA8_SRGB,

        // Packed formats
        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 4, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_PACKED_BIT)), //FORMAT_RGB10A2_UNORM,
        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 4, (short) (CAP_INTEGER_BIT | CAP_UNSIGNED_BIT | CAP_PACKED_BIT)), //FORMAT_RGB10A2_UINT,
        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 3, (short) (CAP_PACKED_BIT | CAP_FLOAT_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB9E5_UFLOAT,
        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 3, (short) (CAP_PACKED_BIT | CAP_FLOAT_BIT | CAP_SIGNED_BIT)), //FORMAT_RG11B10_UFLOAT,
        new FormatInfo((byte) 1, new byte[]{1, 1, 1}, (byte) 3, (short) (CAP_PACKED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RG3B2_UNORM,
        new FormatInfo((byte) 2, new byte[]{1, 1, 1}, (byte) 3, (short) (CAP_PACKED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R5G6B5_UNORM,
        new FormatInfo((byte) 2, new byte[]{1, 1, 1}, (byte) 4, (short) (CAP_PACKED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB5A1_UNORM,
        new FormatInfo((byte) 2, new byte[]{1, 1, 1}, (byte) 4, (short) (CAP_PACKED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA4_UNORM,

        // Swizzle formats
        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 3, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGRX8_UNORM,
        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 4, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_SWIZZLE_BIT)), //FORMAT_BGRA8_UNORM,
        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 3, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_SWIZZLE_BIT | CAP_COLORSPACE_SRGB_BIT)), //FORMAT_BGRX8_SRGB,
        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 4, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_SWIZZLE_BIT | CAP_COLORSPACE_SRGB_BIT)), //FORMAT_BGRA8_SRGB,

        // Luminance Alpha formats
        new FormatInfo((byte) 1, new byte[]{1, 1, 1}, (byte) 1, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_LUMINANCE_ALPHA_BIT)), //FORMAT_L8_UNORM,
        new FormatInfo((byte) 1, new byte[]{1, 1, 1}, (byte) 1, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_LUMINANCE_ALPHA_BIT)), //FORMAT_A8_UNORM,
        new FormatInfo((byte) 2, new byte[]{1, 1, 1}, (byte) 2, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_LUMINANCE_ALPHA_BIT)), //FORMAT_LA8_UNORM,
        new FormatInfo((byte) 2, new byte[]{1, 1, 1}, (byte) 1, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_LUMINANCE_ALPHA_BIT)), //FORMAT_L16_UNORM,
        new FormatInfo((byte) 2, new byte[]{1, 1, 1}, (byte) 1, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_LUMINANCE_ALPHA_BIT)), //FORMAT_A16_UNORM,
        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 2, (short) (CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT | CAP_LUMINANCE_ALPHA_BIT)), //FORMAT_LA16_UNORM,

        // Depth formats
        new FormatInfo((byte) 2, new byte[]{1, 1, 1}, (byte) 1, (short) (CAP_DEPTH_BIT | CAP_INTEGER_BIT)), //FORMAT_D16_UNORM,
        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 1, (short) (CAP_DEPTH_BIT | CAP_INTEGER_BIT)), //FORMAT_D24_UNORM,
        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 2, (short) (CAP_DEPTH_BIT | CAP_STENCIL_BIT)), //FORMAT_D24S8_UNORM,
        new FormatInfo((byte) 4, new byte[]{1, 1, 1}, (byte) 1, (short) (CAP_DEPTH_BIT | CAP_FLOAT_BIT)), //FORMAT_D32_UFLOAT,
        new FormatInfo((byte) 8, new byte[]{1, 1, 1}, (byte) 2, (short) (CAP_DEPTH_BIT | CAP_STENCIL_BIT | CAP_FLOAT_BIT)), //FORMAT_D32_UFLOAT_S8_UNORM,

        /// Compressed formats
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_DXT1_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_DXT1_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_DXT3_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_DXT5_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 1, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R_ATI1N_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 1, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_R_ATI1N_SNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 2, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RG_ATI2N_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 2, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_RG_ATI2N_SNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_FLOAT_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_BP_UFLOAT,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_FLOAT_BIT | CAP_SIGNED_BIT)), //FORMAT_RGB_BP_SFLOAT,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_BP_UNORM,
        new FormatInfo((byte) 32, new byte[]{8, 8, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_PVRTC1_8X8_UNORM,
        new FormatInfo((byte) 32, new byte[]{16, 8, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_PVRTC1_16X8_UNORM,
        new FormatInfo((byte) 32, new byte[]{8, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_PVRTC1_8X8_UNORM,
        new FormatInfo((byte) 32, new byte[]{16, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_PVRTC1_16X8_UNORM,
        new FormatInfo((byte) 32, new byte[]{8, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_PVRTC2_8X8_UNORM,
        new FormatInfo((byte) 32, new byte[]{16, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_PVRTC2_16X8_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_ATC_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ATC_EXPLICIT_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ATC_INTERPOLATED_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_ETC_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_ETC2_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ETC2_PUNCHTHROUGH_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ETC2_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 1, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R11_EAC_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 1, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_R11_EAC_SNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 2, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RG11_EAC_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 2, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_RG11_EAC_SNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_4X4_UNORM,
        new FormatInfo((byte) 16, new byte[]{5, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_5X4_UNORM,
        new FormatInfo((byte) 16, new byte[]{5, 5, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_5X5_UNORM,
        new FormatInfo((byte) 16, new byte[]{6, 5, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_6X5_UNORM,
        new FormatInfo((byte) 16, new byte[]{6, 6, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_6X6_UNORM,
        new FormatInfo((byte) 16, new byte[]{8, 5, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_8X5_UNORM,
        new FormatInfo((byte) 16, new byte[]{8, 6, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_8X6_UNORM,
        new FormatInfo((byte) 16, new byte[]{8, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_8X8_UNORM,
        new FormatInfo((byte) 16, new byte[]{10, 5, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_10X5_UNORM,
        new FormatInfo((byte) 16, new byte[]{10, 6, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_10X6_UNORM,
        new FormatInfo((byte) 16, new byte[]{10, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_10X8_UNORM,
        new FormatInfo((byte) 16, new byte[]{10, 10, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_10X10_UNORM,
        new FormatInfo((byte) 16, new byte[]{12, 10, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_12X10_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ATC_EXPLICIT_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ATC_INTERPOLATED_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_ETC_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_ETC2_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ETC2_PUNCHTHROUGH_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ETC2_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 1, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_R11_EAC_UNORM,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 1, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_R11_EAC_SNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 2, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RG11_EAC_UNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 2, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_SIGNED_BIT)), //FORMAT_RG11_EAC_SNORM,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_4X4_UNORM,
        new FormatInfo((byte) 16, new byte[]{5, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_5X4_UNORM,
        new FormatInfo((byte) 16, new byte[]{5, 5, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_5X5_UNORM,
        new FormatInfo((byte) 16, new byte[]{6, 5, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_6X5_UNORM,
        new FormatInfo((byte) 16, new byte[]{6, 6, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_6X6_UNORM,
        new FormatInfo((byte) 16, new byte[]{8, 5, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_8X5_UNORM,
        new FormatInfo((byte) 16, new byte[]{8, 6, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_8X6_UNORM,
        new FormatInfo((byte) 16, new byte[]{8, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_8X8_UNORM,
        new FormatInfo((byte) 16, new byte[]{10, 5, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_10X5_UNORM,
        new FormatInfo((byte) 16, new byte[]{10, 6, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_10X6_UNORM,
        new FormatInfo((byte) 16, new byte[]{10, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_10X8_UNORM,
        new FormatInfo((byte) 16, new byte[]{10, 10, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_10X10_UNORM,
        new FormatInfo((byte) 16, new byte[]{12, 10, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_12X10_UNORM,
        new FormatInfo((byte) 16, new byte[]{12, 12, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC_12X12_UNORM,

        // Compressed sRGB formats
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_DXT1_SRGB,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_DXT1_SRGB,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_DXT3_SRGB,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_DXT5_SRGB,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_BP_SRGB,
        new FormatInfo((byte) 32, new byte[]{8, 8, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_PVRTC1_8X8_SRGB,
        new FormatInfo((byte) 32, new byte[]{16, 8, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_PVRTC1_16X8_SRGB,
        new FormatInfo((byte) 32, new byte[]{8, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_PVRTC1_8X8_SRGB,
        new FormatInfo((byte) 32, new byte[]{16, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_PVRTC1_16X8_SRGB,
        new FormatInfo((byte) 32, new byte[]{8, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_PVRTC2_8X8_SRGB,
        new FormatInfo((byte) 32, new byte[]{16, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_PVRTC2_16X8_SRGB,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 3, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGB_ETC2_SRGB,
        new FormatInfo((byte) 8, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ETC2_PUNCHTHROUGH_SRGB,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ETC2_SRGB,
        new FormatInfo((byte) 16, new byte[]{4, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC4X4_SRGB,
        new FormatInfo((byte) 16, new byte[]{5, 4, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC5X4_SRGB,
        new FormatInfo((byte) 16, new byte[]{5, 5, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC5X5_SRGB,
        new FormatInfo((byte) 16, new byte[]{6, 5, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC6X5_SRGB,
        new FormatInfo((byte) 16, new byte[]{6, 6, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC6X6_SRGB,
        new FormatInfo((byte) 16, new byte[]{8, 5, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC8X5_SRGB,
        new FormatInfo((byte) 16, new byte[]{8, 6, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC8X6_SRGB,
        new FormatInfo((byte) 16, new byte[]{8, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC8X8_SRGB,
        new FormatInfo((byte) 16, new byte[]{10, 5, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC10X5_SRGB,
        new FormatInfo((byte) 16, new byte[]{10, 6, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC10X6_SRGB,
        new FormatInfo((byte) 16, new byte[]{10, 8, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC10X8_SRGB,
        new FormatInfo((byte) 16, new byte[]{10, 10, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC10X10_SRGB,
        new FormatInfo((byte) 16, new byte[]{12, 10, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC12X10_SRGB,
        new FormatInfo((byte) 16, new byte[]{12, 12, 1}, (byte) 4, (short) (CAP_COMPRESSED_BIT | CAP_COLORSPACE_SRGB_BIT | CAP_NORMALIZED_BIT | CAP_UNSIGNED_BIT)), //FORMAT_RGBA_ASTC12X12_SRGB,
    };
    
    public static FormatInfo get_format_info(int format) {
        return table[format];
    }

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
