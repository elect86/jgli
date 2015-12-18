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
public class Texture2D extends Texture {

    // Create a texture2D view with an existing storage.
    public Texture2D(Texture texture) {
        super(texture, jgli.Target.TARGET_2D, texture.format());
    }

    public Texture2D(Format format, int[] dimensions) {
        super(Target.TARGET_2D, format, new int[]{dimensions[0], dimensions[1], 1}, 1, 1, Util.levels(dimensions));
    }

    public Texture2D(Texture texture, Format format, int baseLayer, int maxLayer, int baseFace, int maxFace,
            int baseLevel, int maxLevel) {
        super(texture, Target.TARGET_2D, format, baseLayer, maxLayer, baseFace, maxFace, baseLevel, maxLevel);
    }

//    @Override
//    public final int[] dimensions() {
//        return dimensions(0);
//    }
//
//    @Override
//    public int[] dimensions(int level) {
//        
//        int[] result = super.dimensions(level);
//        
//        return new int[]{result[0], result[1]};
//    }
//    public Image level(int level) {
//
//        if (!(level < levels())) {
//            throw new Error("!(level < levels())");
//        }
//
//        return new Image(storage, format(), baseLayer(), baseFace(), baseLevel() + level);
//    }
}
