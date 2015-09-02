/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

/**
 *
 * @author elect
 */
public class DdsResources {

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
     * DDS resources.
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
}
