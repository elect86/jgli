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
    private int[] blockCount;
    private short[] blockDimensions;
    private int[] dimensions;
    private ByteBuffer data;

    public Storage() {
        layers = 0;
        faces = 0;
        levels = 0;
        blockSize = 0;
        blockCount = new int[]{0, 0, 0};
        blockDimensions = new short[]{0, 0, 0};
        dimensions = new int[]{0, 0, 0};
    }

    public Storage(Storage storage, jgli.Format format, int[] dimensions, int layers, int faces, int levels) {
        this(format, dimensions, layers, faces, levels);

//        for()
    }

    public Storage(jgli.Format format, int[] dimensions, int layers, int faces, int levels) {

        this.layers = layers;
        this.faces = faces;
        this.levels = levels;
        blockSize = format.blockSize();
        blockCount = Glm.max(Glm.divide(dimensions, format.blockDimensions()), new int[]{1, 1, 1});
        blockDimensions = format.blockDimensions();
        this.dimensions = dimensions;

        assert (layers >= 0);
        assert (faces >= 0);
        assert (levels >= 0);
        assert (Glm.all(Glm.greaterThan(dimensions, new byte[]{0, 0, 0})));

        data = ByteBuffer.allocateDirect(layerSize(0, faces - 1, 0, levels - 1) * layers);
    }

    public final int layerSize(int baseFace, int maxFace, int baseLevel, int maxLevel) {

        assert (baseFace >= 0 && maxFace < faces);
        assert (baseFace >= 0 && baseFace < faces);
        assert (maxLevel >= 0 && maxLevel < levels);
        assert (baseLevel >= 0 && baseLevel < levels);
        /**
         * The size of a layer is the sum of the size of each face. All the
         * faces have the same size.
         */
        return faceSize(baseLevel, maxLevel) * (maxFace - baseFace + 1);
    }

    private int faceSize(int baseLevel, int maxLevel) {

        assert (maxLevel >= 0 && maxLevel < levels);
        assert (baseLevel >= 0 && baseLevel < levels);
        assert (baseLevel <= maxLevel);

        int faceSize = 0;

        // The size of a face is the sum of the size of each level.
        for (int level = baseLevel; level <= maxLevel; level++) {
            faceSize += levelSize(level);
        }
        return faceSize;
    }

    public int levelSize(int level) {

        assert (level >= 0 && level < levels);

        return blockSize * Glm.compMul(blockCount(level));
    }

    public short[] blockDimensions() {
        return blockDimensions;
    }

    private int[] blockCount(int level) {
        assert (!empty());
        assert (level >= 0 && level < levels);

        return Glm.max(Glm.shiftRight(blockCount, level), new int[]{1, 1, 1});
    }

    public boolean empty() {
        return data == null;
    }

    public void setData(ByteBuffer data) {
        this.data = data;
        System.out.println("capacity " + data.capacity());
    }

    public int[] dimensions(int level) {
        assert (!empty());
        return Glm.max(Glm.shiftRight(dimensions, level), new int[]{1, 1, 1});
    }

    public ByteBuffer data(int layer, int face, int level) {
        int offset = offset(layer, face, level);
        int levelSize = levelSize(level);
        data.position(offset);
        data.limit(offset + levelSize);
        ByteBuffer result = data.slice();
        data.position(0);
        data.limit(data.capacity());
        return result;
    }

    public void setData(ByteBuffer data, int layer, int face, int level) {
        int offset = offset(layer, face, level);
        int levelSize = levelSize(level);
        for (int b = 0; b < levelSize; b++) {
            this.data.put(offset + b, data.get(b));
        }
    }

    public ByteBuffer data() {
        return data;
    }

    public int offset(int layer, int face, int level) {
        if (layer >= layers) {
            throw new Error("layer >= layers");
        }
        if (face >= faces) {
            throw new Error("face >= faces");
        }
        if (level >= levels) {
            throw new Error("level >= levels");
        }
        int layerSize = layerSize(0, faces - 1, 0, levels - 1);
        int faceSize = faceSize(0, levels - 1);
        int baseOffset = layerSize * layer + faceSize * face;

        for (int levelIndex = 0, levelCount = level; levelIndex < levelCount; levelIndex++) {
            baseOffset += levelSize(levelIndex);
        }
        return baseOffset;
    }

    public void clear() {
        for (int i = 0; i < data.capacity(); i++) {
            data.put((byte) 0);
        }
        data.rewind();
    }

    public void clear(byte[] texel) {

        int texelCount = data.capacity() / (texel.length * Byte.BYTES);

        for (int texelIndex = 0; texelIndex < texelCount; texelIndex++) {
            data.put(texel);
        }
        data.rewind();
    }

    public void clear(int layer, int face, int level, byte[] texel) {

        int offset = offset(layer, face, level);
        int size = levelSize(level);

        data.position(offset);
        {
            for (int i = 0; i < (size / texel.length); i++) {
                data.put(texel);
            }
        }
        data.position(0);
    }
}
