/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgli.bin;

import jgli.Gl;

/**
 *
 * @author elect
 */
public class FormatInfo {

    public byte blockSize;
    public int[] blockDimensions;
    public byte component;
    public Gl.Swizzle[] swizzles;
    public short flags;

    public FormatInfo(byte blockSize, byte[] blockDimension, byte component, Gl.Swizzle[] swizzles, short flags) {
        this(blockSize, new int[]{blockDimension[0], blockDimension[1], blockDimension[2]}, component, swizzles, flags);
    }

    public FormatInfo(byte blockSize, int blockDimension, byte component, Gl.Swizzle[] swizzles, short flags) {
        this(blockSize, new int[]{blockDimension, blockDimension, blockDimension}, component, swizzles, flags);
    }

    public FormatInfo(byte blockSize, int[] blockDimension, byte component, Gl.Swizzle[] swizzles, short flags) {
        this.blockSize = blockSize;
        this.blockDimensions = blockDimension;
        this.component = component;
        this.swizzles = swizzles;
        this.flags = flags;
    }
}
