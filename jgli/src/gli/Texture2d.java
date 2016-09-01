/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gli;

/**
 *
 * @author GBarbieri
 */
public class Texture2d extends Texture {

    // Create a texture2D view with an existing storage.
    public Texture2d(Texture texture) {
        super(texture, gli.Target.TARGET_2D, texture.format());
    }

    public Texture2d(Format format, int[] dimensions) {
        super(Target.TARGET_2D, format, new int[]{dimensions[0], dimensions[1], 1}, 1, 1, Util.levels(dimensions));
    }

    public Texture2d(Texture texture, Format format, int baseLayer, int maxLayer, int baseFace, int maxFace,
            int baseLevel, int maxLevel) {
        super(texture, Target.TARGET_2D, format, baseLayer, maxLayer, baseFace, maxFace, baseLevel, maxLevel);
    }
}