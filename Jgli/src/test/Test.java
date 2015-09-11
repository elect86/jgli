/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.jogamp.common.util.IOUtil;
import com.jogamp.newt.Display;
import com.jogamp.newt.NewtFactory;
import com.jogamp.newt.Screen;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GL;
import static com.jogamp.opengl.GL.GL_INVALID_ENUM;
import static com.jogamp.opengl.GL.GL_INVALID_FRAMEBUFFER_OPERATION;
import static com.jogamp.opengl.GL.GL_INVALID_OPERATION;
import static com.jogamp.opengl.GL.GL_INVALID_VALUE;
import static com.jogamp.opengl.GL.GL_NO_ERROR;
import static com.jogamp.opengl.GL.GL_OUT_OF_MEMORY;
import static com.jogamp.opengl.GL2ES2.GL_FRAGMENT_SHADER;
import static com.jogamp.opengl.GL2ES2.GL_VERTEX_SHADER;
import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.math.FloatUtil;
import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.GLBuffers;
import com.jogamp.opengl.util.glsl.ShaderCode;
import com.jogamp.opengl.util.glsl.ShaderProgram;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import jgli.Jgli;
import jgli.Texture;

/**
 *
 * @author elect
 */
public class Test implements GLEventListener, KeyListener {

    public static GLWindow glWindow;
    public static Animator animator;

    public static void main(String[] args) {

        Display display = NewtFactory.createDisplay(null);
        Screen screen = NewtFactory.createScreen(display, 0);
        GLProfile glProfile = GLProfile.get(GLProfile.GL4);
        GLCapabilities glCapabilities = new GLCapabilities(glProfile);
        glWindow = GLWindow.create(screen, glCapabilities);

        glWindow.setSize(1024, 768);
        glWindow.setPosition(50, 50);
        glWindow.setUndecorated(false);
        glWindow.setAlwaysOnTop(false);
        glWindow.setFullscreen(false);
        glWindow.setPointerVisible(true);
        glWindow.confinePointer(false);
        glWindow.setVisible(true);

        Test test = new Test();
        glWindow.addGLEventListener(test);
        glWindow.addKeyListener(test);

        animator = new Animator(glWindow);
        animator.start();
    }

    private int[] objects = new int[Semantic.Object.SIZE];
    // Position interleaved with colors (to be normalized).
    private float[] vertexData = new float[]{
        +0.25f, +0.25f, 0.75f, 1.0f, 1.0f,
        +0.25f, -0.25f, 0.75f, 1.0f, 0.0f,
        -0.25f, -0.25f, 0.75f, 0.0f, 0.0f,
        -0.25f, +0.25f, 0.75f, 0.0f, 1.0f};
    private short[] indexData = new short[]{
        0, 1, 2,
        0, 2, 3
    };
    private int program, modelToClipMatrixUL, texture0;
    private final String SHADERS_ROOT = "src/test/shaders";

    public Test() {
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        System.out.println("init");

        GL4 gl4 = drawable.getGL().getGL4();

        initVbo(gl4);

        initIbo(gl4);

        initVao(gl4);

        initProgram(gl4);

        initTexture(gl4);
    }

    private void initVbo(GL4 gl4) {

        gl4.glGenBuffers(1, objects, Semantic.Object.VBO);
        gl4.glBindBuffer(GL4.GL_ARRAY_BUFFER, objects[Semantic.Object.VBO]);
        {
            FloatBuffer vertexBuffer = GLBuffers.newDirectFloatBuffer(vertexData);
            int size = vertexData.length * Float.BYTES;
            gl4.glBufferData(GL4.GL_ARRAY_BUFFER, size, vertexBuffer, GL4.GL_STATIC_DRAW);
        }
        gl4.glBindBuffer(GL4.GL_ARRAY_BUFFER, 0);

        checkError(gl4, "initVbo");
    }

    private void initIbo(GL4 gl4) {

        gl4.glGenBuffers(1, objects, Semantic.Object.IBO);
        gl4.glBindBuffer(GL4.GL_ELEMENT_ARRAY_BUFFER, objects[Semantic.Object.IBO]);
        {
            ShortBuffer indexBuffer = GLBuffers.newDirectShortBuffer(indexData);
            int size = indexData.length * Short.BYTES;
            gl4.glBufferData(GL4.GL_ELEMENT_ARRAY_BUFFER, size, indexBuffer, GL4.GL_STATIC_DRAW);
        }
        gl4.glBindBuffer(GL4.GL_ELEMENT_ARRAY_BUFFER, 0);

        checkError(gl4, "initIbo");
    }

    private void initVao(GL4 gl4) {
        /**
         * Let's create the VAO and save in it all the attributes properties.
         */
        gl4.glGenVertexArrays(1, objects, Semantic.Object.VAO);
        gl4.glBindVertexArray(objects[Semantic.Object.VAO]);
        {
            /**
             * Ibo is part of the VAO, so we need to bind it and leave it bound.
             */
            gl4.glBindBuffer(GL4.GL_ELEMENT_ARRAY_BUFFER, objects[Semantic.Object.IBO]);
            {
                /**
                 * VBO is not part of VAO, we need it to bind it only when we
                 * call glEnableVertexAttribArray and glVertexAttribPointer, so
                 * that VAO knows which VBO the attributes refer to, then we can
                 * unbind it.
                 */
                gl4.glBindBuffer(GL4.GL_ARRAY_BUFFER, objects[Semantic.Object.VBO]);
                {
                    int stride = (3 + 2) * Float.BYTES;
                    /**
                     * We draw in 2D on the xy plane, so we need just two
                     * coordinates for the position, it will be padded to vec4
                     * as (x, y, 0, 1) in the vertex shader.
                     */
                    gl4.glEnableVertexAttribArray(Semantic.Attr.POSITION);
                    gl4.glVertexAttribPointer(Semantic.Attr.POSITION, 3, GL4.GL_FLOAT,
                            false, stride, 0 * Float.BYTES);
                    /**
                     * Color needs three coordinates. We show the usage of
                     * normalization, where signed value get normalized [-1, 1]
                     * like in this case. unsigned will get normalized in the
                     * [0, 1] instead, but take in account java use always
                     * signed, althought you can trick it. Vec3 color will be
                     * padded to (x, y, z, 1) in the fragment shader.
                     */
                    gl4.glEnableVertexAttribArray(Semantic.Attr.TEXCOORD);
                    gl4.glVertexAttribPointer(Semantic.Attr.TEXCOORD, 2, GL4.GL_FLOAT,
                            false, stride, 3 * Float.BYTES);
                }
                gl4.glBindBuffer(GL4.GL_ARRAY_BUFFER, 0);
            }
        }
        gl4.glBindVertexArray(0);

        checkError(gl4, "initVao");
    }

    private void initProgram(GL4 gl4) {
        ShaderCode vertShader = ShaderCode.create(gl4, GL_VERTEX_SHADER, this.getClass(),
                SHADERS_ROOT, null, "vs", "glsl", null, true);
        ShaderCode fragShader = ShaderCode.create(gl4, GL_FRAGMENT_SHADER, this.getClass(),
                SHADERS_ROOT, null, "fs", "glsl", null, true);

        ShaderProgram shaderProgram = new ShaderProgram();
        shaderProgram.add(vertShader);
        shaderProgram.add(fragShader);

        shaderProgram.init(gl4);

        program = shaderProgram.program();

        /**
         * These links don't go into effect until you link the program. If you
         * want to change index, you need to link the program again.
         */
        gl4.glBindAttribLocation(program, Semantic.Attr.POSITION, "position");
        gl4.glBindAttribLocation(program, Semantic.Attr.TEXCOORD, "inUV");
        gl4.glBindFragDataLocation(program, Semantic.Frag.COLOR, "outputColor");

        shaderProgram.link(gl4, System.out);
        /**
         * Take in account that JOGL offers a GLUniformData class, here we don't
         * use it, but take a look to it since it may be interesting for you.
         */
//        modelToClipMatrixUL = gl4.glGetUniformLocation(program, "modelToClipMatrix");

        checkError(gl4, "initProgram");
    }

    private void initTexture(GL4 gl4) {

        jgli.Gl gl = new jgli.Gl();

        try {
            Texture texture = Jgli.loadDds("/test/data/kueken7_rgba8_unorm.dds");

            gl4.glGenTextures(1, objects, Semantic.Object.TEXTURE);

            jgli.Gl.Format glFormat = gl.translate(texture.format);

            jgli.Gl.Target glTarget = gl.translate(texture.target);

            for (int level = 0; level < texture.maxLevel; level++) {
                
                
            }

        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        System.out.println("dispose");

        GL4 gl4 = drawable.getGL().getGL4();

        gl4.glDeleteProgram(program);
        /**
         * Clean VAO first in order to minimize problems. If you delete IBO
         * first, VAO will still have the IBO id, this may lead to crashes.
         */
        gl4.glDeleteVertexArrays(1, objects, objects[Semantic.Object.VAO]);

        gl4.glDeleteBuffers(1, objects, Semantic.Object.VBO);

        gl4.glDeleteBuffers(1, objects, Semantic.Object.IBO);

        System.exit(0);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
//        System.out.println("display");

        GL4 gl4 = drawable.getGL().getGL4();

        gl4.glClearColor(0f, .33f, 0.66f, 1f);
        gl4.glClearDepthf(1f);
        gl4.glClear(GL4.GL_COLOR_BUFFER_BIT | GL4.GL_DEPTH_BUFFER_BIT);

        gl4.glUseProgram(program);
        {
            gl4.glBindVertexArray(objects[Semantic.Object.VAO]);
            {
                gl4.glDrawElements(GL4.GL_TRIANGLES, indexData.length, GL4.GL_UNSIGNED_SHORT, 0);
            }
            gl4.glBindVertexArray(0);
        }
        gl4.glUseProgram(0);

        checkError(gl4, "display");
    }

    protected boolean checkError(GL gl, String title) {

        int error = gl.glGetError();
        if (error != GL_NO_ERROR) {
            String errorString;
            switch (error) {
                case GL_INVALID_ENUM:
                    errorString = "GL_INVALID_ENUM";
                    break;
                case GL_INVALID_VALUE:
                    errorString = "GL_INVALID_VALUE";
                    break;
                case GL_INVALID_OPERATION:
                    errorString = "GL_INVALID_OPERATION";
                    break;
                case GL_INVALID_FRAMEBUFFER_OPERATION:
                    errorString = "GL_INVALID_FRAMEBUFFER_OPERATION";
                    break;
                case GL_OUT_OF_MEMORY:
                    errorString = "GL_OUT_OF_MEMORY";
                    break;
                default:
                    errorString = "UNKNOWN";
                    break;
            }
            System.out.println("OpenGL Error(" + errorString + "): " + title);
            throw new Error();
        }
        return error == GL_NO_ERROR;
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        System.out.println("reshape");
        GL4 gl4 = drawable.getGL().getGL4();
        /**
         * Just the glViewport for this sample, normally here you update your
         * projection matrix.
         */
        gl4.glViewport(x, y, width, height);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            Test.animator.stop();
            Test.glWindow.destroy();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
