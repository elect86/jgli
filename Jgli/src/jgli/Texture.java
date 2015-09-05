/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgli;

import java.nio.ByteBuffer;

/**
 *
 * @author gbarbieri
 */
public class Texture {

    public ByteBuffer data;
    public int format;
    public int target;
    public int baseLayer;
    public int maxLayer;
    public int baseFace;
    public int maxFace;
    public int baseLevel;
    public int maxLevel;

    /**
     * Create an empty texture instance
     */
    public Texture(int target, int format, int[] dimensions, int layers, int faces, int levels) {
        
        data = ByteBuffer.allocateDirect(faces)
    }
}
