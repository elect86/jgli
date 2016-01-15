/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgli;

/**
 *
 * @author GBarbieri
 */
public class Texture2dArray extends Texture {

    // Create a texture2D view with an existing storage.
    public Texture2dArray(Texture texture) {
        super(texture, jgli.Target.TARGET_2D_ARRAY, texture.format());
    }

    public Texture2dArray(Format format, int[] dimensions, int layers, int levels) {
        super(Target.TARGET_2D_ARRAY, format, new int[]{dimensions[0], dimensions[1], 1}, layers, 1, levels);
    }

//    public Texture2dArray(Texture texture, Format format, int baseLayer, int maxLayer, int baseFace, int maxFace,
//            int baseLevel, int maxLevel) {
//        super(texture, Target.TARGET_2D, format, baseLayer, maxLayer, baseFace, maxFace, baseLevel, maxLevel);
//    }
}
