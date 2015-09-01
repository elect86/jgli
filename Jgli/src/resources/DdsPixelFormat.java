/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import resources.dx.D3dFormat;
import resources.dx.Ddpf;

/**
 *
 * @author elect
 */
public class DdsPixelFormat {

    public int size; // 32
    public Ddpf flags;
    public D3dFormat fourCC;
    public int bpp;
    public int[] Mask;
}
