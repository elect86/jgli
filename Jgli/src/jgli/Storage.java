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
public class Storage {

    private int layers;
    private int faces;
    private int levels;
    private int blockSize;
    private byte[] blockCount;
    private int[] dimensions;
    private ByteBuffer data;

    public Storage(int format, int[] dimensions, int layers, int faces, int levels) {

        this.layers = layers;
        this.faces = faces;
        this.levels = levels;
        blockSize = Jgli.block_size(format);
        blockCount = Glm.maxB(Glm.divide(dimensions, Jgli.block_dimension(format)), new byte[]{1, 1, 1});
        this.dimensions = dimensions;

        if (layers <= 0) {
            throw new Error("layers <= 0!");
        }
        if (faces <= 0) {
            throw new Error("faces <= 0!");
        }
        if (levels <= 0) {
            throw new Error("levels <= 0!");
        }
        if (!Glm.all(Glm.greaterThan(dimensions, new byte[]{0, 0, 0}))) {
            throw new Error("Not all dimensions > 0!");
        }

//        data = ByteBuffer.allocateDirect(faces)
        
    }

    public int layer_size(int baseFace, int maxFace, int baseLevel, int maxLevel) {

        if (maxFace >= faces) {
            throw new Error("maxFace >= faces!");
        }
        if (maxLevel >= levels) {
            throw new Error("maxLevel >= levels!");
        }
        /**
         * The size of a layer is the sum of the size of each face. All the
         * faces have the same size.
         */
        return face_size(baseLevel, maxLevel) * (maxFace - baseFace + 1);
    }

    private int face_size(int baseLevel, int maxLevel) {

        if (maxLevel >= levels) {
            throw new Error("maxLevel >= levels!");
        }

        int faceSize = 0;

        // The size of a face is the sum of the size of each level.
        for (int level = baseLevel; level <= maxLevel; level++) {
            faceSize += level_size(level);
        }
        return faceSize;
    }
    
    private int level_size(int level) {
        
        if(level >= levels) {
            throw new Error("level >= levels!");
        }
        
        return blockSize * Glm.compMul(block_count(level));
    }
    
    private int[] block_count(int level) {
        
        if(!(level < levels)) {
            throw new Error("!(level < levels)");
        }
        
        return Glm.maxI(Glm.shiftRight(blockCount, level), new byte[]{1, 1, 1});
    }
}
