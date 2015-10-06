/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgli;

import java.nio.ByteBuffer;
import static jgli.Target.*;

/**
 *
 * @author gbarbieri
 */
public class Texture {

    protected jgli.Format format;
    protected jgli.Target target;
    protected int baseLayer;
    protected int maxLayer;
    protected int baseFace;
    protected int maxFace;
    protected int baseLevel;
    protected int maxLevel;
    protected Storage storage;
    protected int size;

    public Texture() {

    }

    /**
     * Create an empty texture instance.
     *
     * @param target
     * @param format
     * @param dimensions
     * @param layers
     * @param faces
     * @param levels
     */
    public Texture(jgli.Target target, jgli.Format format, int[] dimensions, int layers, int faces, int levels) {

        this.format = format;
        this.target = target;
        this.baseLayer = 0;
        this.maxLayer = layers - 1;
        this.baseFace = 0;
        this.maxFace = faces - 1;
        this.baseLevel = 0;
        this.maxLevel = levels - 1;

        if (!(target != TARGET_CUBE || (target == TARGET_CUBE && dimensions[0] == dimensions[1]))) {
            throw new Error("!(target != TARGET_CUBE || (target == TARGET_CUBE && dimensions[0] == dimensions[1]))");
        }
        if (!(target != TARGET_CUBE_ARRAY || (target == TARGET_CUBE_ARRAY && dimensions[0] == dimensions[1]))) {
            throw new Error("!(target != TARGET_CUBE_ARRAY || (target == TARGET_CUBE_ARRAY && dimensions[0] == dimensions[1]))");
        }

        storage = new Storage(format, dimensions, layers, faces, levels);

        buildCache();
    }

    public Texture(Texture texture, jgli.Target target, jgli.Format format) {

        storage = texture.storage;
        this.target = target;
        this.format = format;
        baseLayer = texture.baseLayer();
        maxLayer = texture.maxLayer();
        baseFace = texture.baseFace();
        maxFace = texture.maxFace();
        baseLevel = texture.baseLevel();
        maxLevel = texture.maxLevel();

        if (empty()) {
            return;
        }

        boolean error = false;

        if (!(target != TARGET_1D || (target == TARGET_1D && layers() == 1 && faces() == 1 && dimensions()[1] == 1 && dimensions()[2] == 1))) {
            error = true;
        }
        if (!(target != TARGET_1D_ARRAY || (target == TARGET_1D_ARRAY && layers() >= 1 && faces() == 1 && dimensions()[1] == 1 && dimensions()[2] == 1))) {
            error = true;
        }
        if (!(target != TARGET_2D || (target == TARGET_2D && layers() == 1 && faces() == 1 && dimensions()[1] >= 1 && dimensions()[2] == 1))) {
            error = true;
        }
        if (!(target != TARGET_2D_ARRAY || (target == TARGET_2D_ARRAY && layers() >= 1 && faces() == 1 && dimensions()[1] >= 1 && dimensions()[2] == 1))) {
            error = true;
        }
        if (!(target != TARGET_3D || (target == TARGET_3D && layers() == 1 && faces() == 1 && dimensions()[1] >= 1 && dimensions()[2] >= 1))) {
            error = true;
        }
        if (!(target != TARGET_CUBE || (target == TARGET_CUBE && layers() == 1 && faces() >= 1 && dimensions()[1] >= 1 && dimensions()[2] == 1))) {
            error = true;
        }
        if (!(target != TARGET_CUBE_ARRAY || (target == TARGET_CUBE_ARRAY && layers() >= 1 && faces() >= 1 && dimensions()[1] >= 1 && dimensions()[2] == 1))) {
            error = true;
        }
        if (error) {
            throw new Error("wrong parameters");
        }
        
        buildCache();
    }

    private void buildCache() {
        size = storage.layerSize(baseFace(), maxFace(), baseLevel(), maxLevel()) * layers();
    }

    public int size(int level) {
        if (storage.empty()) {
            throw new Error("no data!");
        }
        if (!(level >= baseLevel && level <= maxLevel)) {
            throw new Error("level >= baseLevel && level <= maxLevel");
        }

        return storage.levelSize(level);
    }

    public final boolean empty() {
        return storage.empty();
    }

    public final int[] dimensions() {
        return dimensions(0);
    }

    public int[] dimensions(int level) {
        return storage.dimensions(baseLevel + level);
    }

    public ByteBuffer data(int layer, int face, int level) {
        return storage.data(layer, face, level);
    }

    public void setData(ByteBuffer data) {
//        for (int i = 0; i < data.capacity(); i++) {
//            System.out.println("data[" + i + "] " + (data.get(i) & 0xff));
////            System.out.println("data[" + i + "] " + data.get(i));
//        }

        storage.setData(data);
    }

    public int baseLayer() {
        return baseLayer;
    }

    public int maxLayer() {
        return maxLayer;
    }

    public final int layers() {
        return maxLayer - baseLayer + 1;
    }

    public int baseFace() {
        return baseFace;
    }

    public int maxFace() {
        return maxFace;
    }

    public final int faces() {
        return maxFace - baseFace + 1;
    }

    public int baseLevel() {
        return baseLevel;
    }

    public int maxLevel() {
        return maxLevel;
    }

    public int levels() {
        return maxLevel - baseLevel + 1;
    }

    public jgli.Format format() {
        return format;
    }

    public jgli.Target target() {
        return target;
    }
    
    public int size() {
        if(empty()) {
            throw new Error("empty");
        }
        return size;
    }
}
