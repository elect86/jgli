/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.dx;

/**
 *
 * @author elect
 */
public class Ddpf {

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
}
