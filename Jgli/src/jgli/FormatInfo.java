/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgli;

/**
 *
 * @author elect
 */
public class FormatInfo {

    public byte blockSize;
    public byte[] blockDimension;
    public byte component;
    public short flags;

    public FormatInfo(byte blockSize, byte[] blockDimension, byte component, short flags) {
        this.blockSize = blockSize;
        this.blockDimension = blockDimension;
        this.component = component;
        this.flags = flags;
    }
}
