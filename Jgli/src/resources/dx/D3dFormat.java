/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.dx;

/**
 * https://msdn.microsoft.com/en-us/library/windows/desktop/bb172558%28v=vs.85%29.aspx
 * http://gli.g-truc.net/0.6.0/api/a00001.html
 * https://github.com/g-truc/gli/blob/master/gli/dx.hpp
 *
 * @author elect
 */
public class D3dFormat {

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
}
