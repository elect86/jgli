/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gli;

import java.nio.ByteBuffer;

/**
 *
 * @author elect
 */
public class Image {

    private Storage storage;
    private gli.Format format;
    private int baseLevel;
    private ByteBuffer data;
    private int size;

    public Image(Storage storage, gli.Format format, int baseLayer, int baseFace, int baseLevel) {

        this.storage = storage;
        this.format = format;
        this.baseLevel = baseLevel;
        this.data = computeData(baseLayer, baseFace, baseLevel);
        size = computeSize(baseLevel);
    }

    public ByteBuffer data() {
        
        if (empty()) {
            throw new Error("empty");
        }

        return storage.data();
    }

    private ByteBuffer computeData(int baseLayer, int baseFace, int baseLevel) {

        return storage.data(baseLayer, baseFace, baseLevel);
    }

    private int computeSize(int level) {
        return storage.levelSize(level);
    }

    public int[] dimensions() {

        if (empty()) {
            throw new Error("empty");
        }

        return storage.dimensions(baseLevel);
    }

    public final boolean empty() {
        return storage.empty();
    }
}
