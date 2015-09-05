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
public class Storage {
    
    private int layers;
    private int faces;
    private int levels;
    private int blockSize;
    private int blockCount;
    private int[] dimensions;
    
    public Storage (int format, int[] dimensions, int layers, int faces, int levels) {
        
        this.layers = layers;
        this.faces = faces;
        this.levels = levels;
        
    }
}
