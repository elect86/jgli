/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgli.detail;

/**
 *
 * @author elect
 */
public class FormatInfo {

    public byte blockSize;
    public int[] blockDimensions;
    public byte component;
    public short flags;

    public FormatInfo(byte blockSize, int[] blockDimension, byte component, short flags) {
        this.blockSize = blockSize;
        this.blockDimensions = blockDimension;
        this.component = component;
        this.flags = flags;
    }
}
