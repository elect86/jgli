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
public class TextureCube extends Texture {

    public TextureCube(Format format, int[] dimensions, int levels) {
        super(Target.TARGET_CUBE, format, new int[]{dimensions[0], dimensions[1], 1}, 1, 6, levels);
    }

    public void clearFace(int face, byte[] texel) {
        for (int level = baseLevel; level < levels(); level++) {
            clear(0, face, level, texel);
        }
    }

    public Texture2D_ face(int face) {
        return new Texture2D_(this, format, baseLayer, maxLayer, baseFace + face, baseFace + face, baseLevel, maxLevel);
    }
}
