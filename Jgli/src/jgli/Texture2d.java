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
public class Texture2d extends Texture {

    // Create a texture2D view with an existing storage.
    public Texture2d(Texture texture) {

        super(texture, jgli.Target.TARGET_2D, texture.format());
    }

    public Image level(int level) {

        if (!(level < levels())) {
            throw new Error("!(level < levels())");
        }

        return new Image(storage, format(), baseLayer(), baseFace(), baseLevel() + level);
    }
}
