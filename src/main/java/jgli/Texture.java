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

    protected Format format;
    protected Target target;
    protected Swizzles swizzles;
    protected int baseLayer;
    protected int maxLayer;
    protected int baseFace;
    protected int maxFace;
    protected int baseLevel;
    protected int maxLevel;
    protected Storage storage;
    protected int size;

    /**
     * Create an empty texture instance.
     */
    public Texture() {
        storage = new Storage();
        target = Target.TARGET_INVALID;
        format = Format.FORMAT_INVALID;
        baseLayer = maxLayer = 0;
        baseFace = maxFace = 0;
        baseLevel = maxLevel = 0;
        swizzles = new Swizzles(Swizzles.Swizzle.SWIZZLE_ZERO);
    }

    public Texture(
            Target target,
            Format format,
            int[] dimensions,
            int layers,
            int faces,
            int levels) {

        this(target, format, dimensions, layers, faces, levels, new Swizzles(Swizzles.Swizzle.SWIZZLE_RED,
                Swizzles.Swizzle.SWIZZLE_GREEN, Swizzles.Swizzle.SWIZZLE_BLUE, Swizzles.Swizzle.SWIZZLE_ALPHA));
    }

    public Texture(
            Target target,
            Format format,
            int[] dimensions,
            int layers,
            int faces,
            int levels,
            Swizzles swizzles) {

        this.format = format;
        this.target = target;
        this.baseLayer = 0;
        this.maxLayer = layers - 1;
        this.baseFace = 0;
        this.maxFace = faces - 1;
        this.baseLevel = 0;
        this.maxLevel = levels - 1;
        this.swizzles = swizzles;

        if (!(target != TARGET_CUBE || (target == TARGET_CUBE && dimensions[0] == dimensions[1]))) {
            throw new Error("!(target != TARGET_CUBE || (target == TARGET_CUBE && dimensions[0] == dimensions[1]))");
        }
        if (!(target != TARGET_CUBE_ARRAY || (target == TARGET_CUBE_ARRAY && dimensions[0] == dimensions[1]))) {
            throw new Error("!(target != TARGET_CUBE_ARRAY || (target == TARGET_CUBE_ARRAY && dimensions[0] == dimensions[1]))");
        }

        storage = new Storage(format, dimensions, layers, faces, levels);

        buildCache();
    }

    public Texture(
            Texture texture,
            Target target,
            Format format,
            int baseLayer, int maxLayer,
            int baseFace, int maxFace,
            int baseLevel, int maxLevel) {

        this(texture, target, format, baseLayer, maxLayer, baseFace, maxFace, baseLevel, maxLevel,
                new Swizzles(Swizzles.Swizzle.SWIZZLE_RED, Swizzles.Swizzle.SWIZZLE_GREEN,
                        Swizzles.Swizzle.SWIZZLE_BLUE, Swizzles.Swizzle.SWIZZLE_ALPHA));
    }

    public Texture(
            Texture texture,
            Target target,
            Format format,
            int baseLayer, int maxLayer,
            int baseFace, int maxFace,
            int baseLevel, int maxLevel,
            Swizzles swizzles) {

        /**
         * @TODO, fix storage
         */
        storage = texture.storage;
        this.target = target;
        this.format = format;
        this.baseLayer = baseLayer;
        this.maxLayer = maxLayer;
        this.baseFace = baseFace;
        this.maxFace = maxFace;
        this.baseLevel = baseLevel;
        this.maxLevel = maxLevel;
        this.swizzles = swizzles;

        assert (format.blockSize() == texture.format().blockSize());
        assert (target != TARGET_1D || (target == TARGET_1D && layers() == 1 && faces() == 1 && dimensions()[1] == 1 && dimensions()[2] == 1));
        assert (target != TARGET_1D_ARRAY || (target == TARGET_1D_ARRAY && layers() >= 1 && faces() == 1 && dimensions()[1] == 1 && dimensions()[2] == 1));
        assert (target != TARGET_2D || (target == TARGET_2D && layers() == 1 && faces() == 1 && dimensions()[1] >= 1 && dimensions()[2] == 1));
        assert (target != TARGET_2D_ARRAY || (target == TARGET_2D_ARRAY && layers() >= 1 && faces() == 1 && dimensions()[1] >= 1 && dimensions()[2] == 1));
        assert (target != TARGET_3D || (target == TARGET_3D && layers() == 1 && faces() == 1 && dimensions()[1] >= 1 && dimensions()[2] >= 1));
        assert (target != TARGET_CUBE || (target == TARGET_CUBE && layers() == 1 && faces() >= 1 && dimensions()[1] >= 1 && dimensions()[2] == 1));
        assert (target != TARGET_CUBE_ARRAY || (target == TARGET_CUBE_ARRAY && layers() >= 1 && faces() >= 1 && dimensions()[1] >= 1 && dimensions()[2] == 1));
    }

    public Texture(
            Texture texture,
            Target target,
            Format format) {

        this(texture, target, format, new Swizzles(Swizzles.Swizzle.SWIZZLE_RED, Swizzles.Swizzle.SWIZZLE_GREEN,
                Swizzles.Swizzle.SWIZZLE_BLUE, Swizzles.Swizzle.SWIZZLE_ALPHA));
    }

    public Texture(
            Texture texture,
            Target target,
            Format format,
            Swizzles swizzles) {

        storage = texture.storage;
        this.target = target;
        this.format = format;
        baseLayer = texture.baseLayer();
        maxLayer = texture.maxLayer();
        baseFace = texture.baseFace();
        maxFace = texture.maxFace();
        baseLevel = texture.baseLevel();
        maxLevel = texture.maxLevel();
        this.swizzles = swizzles;

        if (empty()) {
            return;
        }

        boolean error = false;

        assert (target != TARGET_1D || (target == TARGET_1D && layers() == 1 && faces() == 1 && dimensions()[1] == 1 && dimensions()[2] == 1));
        assert (target != TARGET_1D_ARRAY || (target == TARGET_1D_ARRAY && layers() >= 1 && faces() == 1 && dimensions()[1] == 1 && dimensions()[2] == 1));
        assert (target != TARGET_2D || (target == TARGET_2D && layers() == 1 && faces() == 1 && dimensions()[1] >= 1 && dimensions()[2] == 1));
        assert (target != TARGET_2D_ARRAY || (target == TARGET_2D_ARRAY && layers() >= 1 && faces() == 1 && dimensions()[1] >= 1 && dimensions()[2] == 1));
        assert (target != TARGET_3D || (target == TARGET_3D && layers() == 1 && faces() == 1 && dimensions()[1] >= 1 && dimensions()[2] >= 1));
        assert (target != TARGET_CUBE || (target == TARGET_CUBE && layers() == 1 && faces() >= 1 && dimensions()[1] >= 1 && dimensions()[2] == 1));
        assert (target != TARGET_CUBE_ARRAY || (target == TARGET_CUBE_ARRAY && layers() >= 1 && faces() >= 1 && dimensions()[1] >= 1 && dimensions()[2] == 1));

        if (error) {
            throw new Error("wrong parameters");
        }

        buildCache();
    }

    public void clear() {
        
        assert (!empty());
        
        storage.clear();
    }

    public void clear(byte[] texel) {
        
        assert (!empty());
        assert (format.blockSize() == (texel.length * Byte.BYTES));

        storage.clear(texel);
    }

    public void clear(int layer, int face, int level, byte[] texel) {
        storage.clear(layer, face, level, texel);
    }

    private void buildCache() {
        size = storage.layerSize(baseFace(), maxFace(), baseLevel(), maxLevel()) * layers();
    }

    public int size(int level) {

        if (empty()) {
            throw new Error("empty");
        }
        if (!(level >= 0 && level <= levels())) {
            throw new Error("level >= baseLevel && level <= maxLevel");
        }
        return storage.levelSize(baseLevel + level);
    }

    public final boolean empty() {
        return storage.empty();
    }

    public int[] dimensions() {
        return dimensions(0);
    }

    public int[] dimensions(int level) {
        if (empty()) {
            throw new Error("empty");
        }
        int[] srcDimensions = storage.dimensions(baseLevel() + level);
        int[] dstDimensions = new int[3];
        for (int i = 0; i < 3; i++) {
            dstDimensions[i] = srcDimensions[i] * format().blockDimensions()[i] / storage.blockDimensions()[i];
        }
        return Glm.max(dstDimensions, new int[]{1, 1, 1});
    }

    public ByteBuffer data() {
        return storage.data();
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

    public void setData(ByteBuffer data, int layer, int face, int level) {
        storage.setData(data, layer, face, level);
    }

    public int baseLayer() {
        return baseLayer;
    }

    public int maxLayer() {
        return maxLayer;
    }

    public final int layers() {
        if (empty()) {
            return 0;
        }
        return maxLayer - baseLayer + 1;
    }

    public int baseFace() {
        return baseFace;
    }

    public int maxFace() {
        return maxFace;
    }

    public final int faces() {
        if (empty()) {
            return 0;
        }
        return maxFace - baseFace + 1;
    }

    public int baseLevel() {
        return baseLevel;
    }

    public int maxLevel() {
        return maxLevel;
    }

    public int levels() {
        if (empty()) {
            return 0;
        }
        return maxLevel - baseLevel + 1;
    }

    public Format format() {
        return format;
    }

    public Swizzles swizzles() {
        Swizzles formatSwizzles = format.getFormatInfo().swizzles;
        Swizzles customSwizzles = swizzles;

        return new Swizzles(
                customSwizzles.r.isChannel() ? formatSwizzles.toArray()[customSwizzles.r.value] : customSwizzles.r,
                customSwizzles.g.isChannel() ? formatSwizzles.toArray()[customSwizzles.g.value] : customSwizzles.g,
                customSwizzles.b.isChannel() ? formatSwizzles.toArray()[customSwizzles.b.value] : customSwizzles.b,
                customSwizzles.a.isChannel() ? formatSwizzles.toArray()[customSwizzles.a.value] : customSwizzles.a);
    }

    public Target target() {
        return target;
    }

    public int size() {
        if (empty()) {
            throw new Error("empty");
        }
        return size;
    }
}
