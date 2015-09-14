/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.textures;

import com.jogamp.opengl.GL4;
import com.jogamp.opengl.math.FloatUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import jgli.Texture;
import jgli.detail.LoadDds;
import test.Main;
import test.Semantic;

/**
 *
 * @author elect
 */
public class Test {

    private String name;
    private final String data = "/test/data/";
    private Texture texture;
    private int[] objects = new int[Semantic.Object.SIZE];
    private jgli.Gl.Format glFormat;
    private jgli.Gl.Target glTarget;

    public Test(GL4 gl4, String name) {

        this.name = name;

        try {
            initTexture(gl4);
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

        initSampler(gl4);
    }

    private void initTexture(GL4 gl4) throws IOException {

        jgli.Gl gl = new jgli.Gl();

        texture = LoadDds.loadDds(data + name);

        gl4.glGenTextures(1, objects, Semantic.Object.TEXTURE);

        glFormat = gl.translate(texture.format);

        glTarget = gl.translate(texture.target);

        printInfo();

        gl4.glBindTexture(glTarget.value, objects[Semantic.Object.TEXTURE]);
        {
            for (int layer = 0; layer < texture.layers(); layer++) {

                for (int face = 0; face < texture.faces(); face++) {

                    for (int level = 0; level < texture.levels(); level++) {

                        switch (texture.target) {

                            case TARGET_1D:

                                if (texture.format.isCompressed()) {

                                    gl4.glCompressedTexImage1D(glTarget.value, level,
                                            glFormat.internal.value, texture.dimensions(level)[0],
                                            0, texture.size(level), texture.data(layer, face, level));

                                } else {

//                                    System.out.println("level: " + level + ", dimensions ("
//                                            + texture.dimensions(level)[0] + ", "
//                                            + texture.dimensions(level)[1] + "), "
//                                            + "capacity: " + texture.data(layer, face, level).capacity());
                                    gl4.glTexImage1D(glTarget.value, level, glFormat.internal.value,
                                            texture.dimensions(level)[0], 0, glFormat.external.value,
                                            glFormat.type.value, texture.data(layer, face, level));
                                }
                                break;

                            case TARGET_1D_ARRAY:
                            case TARGET_2D:
                            case TARGET_CUBE:

                                if (texture.format.isCompressed()) {

                                    gl4.glCompressedTexImage2D(glTarget.value, level,
                                            glFormat.internal.value, texture.dimensions(level)[0],
                                            texture.dimensions(level)[1], 0, texture.size(level),
                                            texture.data(layer, face, level));

                                } else {

//                                    System.out.println("level: " + level + ", dimensions (" + texture.dimensions(level)[0]
//                                            + ", " + texture.dimensions(level)[1] + "), "
//                                            + "capacity: " + texture.data(layer, face, level).capacity());
                                    gl4.glTexImage2D(glTarget.value, level, glFormat.internal.value,
                                            texture.dimensions(level)[0], texture.dimensions(level)[1],
                                            0, glFormat.external.value, glFormat.type.value,
                                            texture.data(layer, face, level));
                                }
                                break;

                            case TARGET_2D_ARRAY:
                            case TARGET_3D:
                            case TARGET_CUBE_ARRAY:

                                if (texture.format.isCompressed()) {

                                    gl4.glCompressedTexImage3D(glTarget.value, level,
                                            glFormat.internal.value, texture.dimensions(level)[0],
                                            texture.dimensions(level)[1], texture.dimensions(level)[2],
                                            0, texture.size(level),
                                            texture.data(layer, face, level));

                                } else {

//                                    System.out.println("level: " + level + ", dimensions ("
//                                            + texture.dimensions(level)[0] + ", "
//                                            + texture.dimensions(level)[1] + ", "
//                                            + texture.dimensions(level)[2] + "), "
//                                            + "capacity: " + texture.data(layer, face, level).capacity());
                                    gl4.glTexImage3D(glTarget.value, level, glFormat.internal.value,
                                            texture.dimensions(level)[0], texture.dimensions(level)[1],
                                            texture.dimensions(level)[2], 0, glFormat.external.value,
                                            glFormat.type.value, texture.data(layer, face, level));
//                                    gl4.glTexImage3D(glTarget.value, level, glFormat.internal.value,
//                                            texture.dimensions(level)[0], texture.dimensions(level)[1],
//                                            texture.dimensions(level)[2], 0, glFormat.external.value,
//                                            glFormat.type.value, level == 7 ? ByteBuffer.allocateDirect(6)
//                                                    : texture.data(layer, face, level));
                                }
                                break;

                            default:
                                throw new Error("Invalid target");
                        }
                    }
                }
            }
            gl4.glTexParameteri(glTarget.value, GL4.GL_TEXTURE_BASE_LEVEL, 0);
            gl4.glTexParameteri(glTarget.value, GL4.GL_TEXTURE_MAX_LEVEL, texture.maxLevel());

            int[] swizzle = new int[glFormat.swizzle.length];
            for (int i = 0; i < swizzle.length; i++) {
                swizzle[i] = glFormat.swizzle[i].value;
            }
            gl4.glTexParameterIiv(glTarget.value, GL4.GL_TEXTURE_SWIZZLE_RGBA, swizzle, 0);
        }
        gl4.glBindTexture(glTarget.value, 0);
    }

    private void printInfo() {
        System.out.println(name + ", " + glTarget.name()
                + ", storage: [" + texture.maxLayer() + ", " + texture.maxFace() + ", " + texture.maxLevel() + "]"
                + ", " + glFormat.internal.name()
                + ", level 0 (" + texture.dimensions(0)[0] + ", " + texture.dimensions(0)[1] + ")"
                + ", " + glFormat.external.name()
                + ", " + glFormat.type.name()
                + ", (" + glFormat.swizzle[0].name() + ", " + glFormat.swizzle[1].name()
                + ", " + glFormat.swizzle[2].name() + ", " + glFormat.swizzle[3].name() + ")");
    }

    private void initSampler(GL4 gl4) {

        gl4.glGenSamplers(1, objects, Semantic.Object.SAMPLER);
        gl4.glSamplerParameteri(objects[Semantic.Object.SAMPLER], GL4.GL_TEXTURE_MAG_FILTER, GL4.GL_NEAREST);
        gl4.glSamplerParameteri(objects[Semantic.Object.SAMPLER], GL4.GL_TEXTURE_MIN_FILTER, GL4.GL_NEAREST_MIPMAP_NEAREST);
        gl4.glSamplerParameteri(objects[Semantic.Object.SAMPLER], GL4.GL_TEXTURE_WRAP_S, GL4.GL_CLAMP_TO_EDGE);
        gl4.glSamplerParameteri(objects[Semantic.Object.SAMPLER], GL4.GL_TEXTURE_WRAP_T, GL4.GL_CLAMP_TO_EDGE);
    }

    public void render(GL4 gl4) {

        gl4.glActiveTexture(GL4.GL_TEXTURE0 + 0);
        gl4.glBindTexture(glTarget.value, objects[Semantic.Object.TEXTURE]);
        {
            int[] offset = new int[]{10, 10};

            for (int layer = 0; layer < texture.layers(); layer++) {

                for (int face = 0; face < texture.faces(); face++) {

                    for (int level = 0; level < texture.levels(); level++) {

                        float[] a = FloatUtil.makeOrtho(new float[16], 0, true, 0,
                                Main.glWindow.getWidth(), 0, Main.glWindow.getHeight(), -1f, 1f);
                        float[] b = FloatUtil.makeTranslation(new float[16], true,
                                offset[0], offset[1], 0);
                        float[] c = FloatUtil.makeScale(new float[16], true,
                                texture.dimensions(level)[0], texture.dimensions(level)[1], 1);

                        FloatUtil.multMatrix(a, b);
                        FloatUtil.multMatrix(a, c);

                        gl4.glUniformMatrix4fv(Main.modelToClipMatrixUL, 1, false, a, 0);

                        gl4.glUniform1f(Main.lodUL, (float) level);

                        gl4.glDrawElements(GL4.GL_TRIANGLES, Main.indexData.length, GL4.GL_UNSIGNED_SHORT, 0);

                        offset[0] += texture.dimensions(level)[0];
                        offset[1] += texture.dimensions(level)[1];
                    }
                }
                offset[0] = 100 + (texture.dimensions(0)[0] + 100) * layer;
                offset[1] = 100;
            }
        }
        gl4.glBindTexture(glTarget.value, 0);
    }

    public String getName() {
        return name;
    }
}
