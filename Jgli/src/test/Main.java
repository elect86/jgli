/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.jogamp.newt.Display;
import com.jogamp.newt.NewtFactory;
import com.jogamp.newt.Screen;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GL;
import static com.jogamp.opengl.GL2ES2.*;
import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.GLBuffers;
import com.jogamp.opengl.util.glsl.ShaderCode;
import com.jogamp.opengl.util.glsl.ShaderProgram;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import jgli.Texture;
import test.textures.*;

/**
 *
 * @author elect
 */
public class Main implements GLEventListener, KeyListener {

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

        Main test = new Main();
        glWindow.addGLEventListener(test);
        glWindow.addKeyListener(test);

        animator = new Animator(glWindow);
        animator.start();
    }

    private int[] objects = new int[Semantic.Object.SIZE];
    private float[] vertexData = new float[]{
        +1f, +1f, 0.75f, 1.0f, 0.0f,
        +1f, +0f, 0.75f, 1.0f, 1.0f,
        +0f, +0f, 0.75f, 0.0f, 1.0f,
        +0f, +1f, 0.75f, 0.0f, 0.0f};
    public static short[] indexData = new short[]{
        0, 1, 2,
        0, 2, 3
    };
    public static int program, modelToClipMatrixUL, texture0UL, lodUL, currentTest = -1;
    private Texture texture;
    private final String SHADERS_ROOT = "src/test/shaders";
    private ArrayList<Test> tests = new ArrayList<>();
    private long start;

    public Main() {
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        System.out.println("init");

        GL4 gl4 = drawable.getGL().getGL4();

        initVbo(gl4);

        initIbo(gl4);

        initVao(gl4);

        initProgram(gl4);

        tests.add(new Test(gl4, "kueken7_a8_unorm.dds"));
        tests.add(new Test(gl4, "kueken7_bgra8_srgb.dds"));
        tests.add(new Test(gl4, "kueken7_rgba8_unorm.dds"));
        

        start = System.nanoTime();
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

        gl4.glGenVertexArrays(1, objects, Semantic.Object.VAO);
        gl4.glBindVertexArray(objects[Semantic.Object.VAO]);
        {
            gl4.glBindBuffer(GL4.GL_ELEMENT_ARRAY_BUFFER, objects[Semantic.Object.IBO]);
            {
                gl4.glBindBuffer(GL4.GL_ARRAY_BUFFER, objects[Semantic.Object.VBO]);
                {
                    int stride = (3 + 2) * Float.BYTES;

                    gl4.glEnableVertexAttribArray(Semantic.Attr.POSITION);
                    gl4.glVertexAttribPointer(Semantic.Attr.POSITION, 3, GL4.GL_FLOAT,
                            false, stride, 0 * Float.BYTES);

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

        gl4.glBindAttribLocation(program, Semantic.Attr.POSITION, "position");
        gl4.glBindAttribLocation(program, Semantic.Attr.TEXCOORD, "inUV");
        gl4.glBindFragDataLocation(program, Semantic.Frag.COLOR, "outputColor");

        shaderProgram.link(gl4, System.out);

        modelToClipMatrixUL = gl4.glGetUniformLocation(program, "modelToClipMatrix");
        texture0UL = gl4.glGetUniformLocation(program, "texture0");
        lodUL = gl4.glGetUniformLocation(program, "lod");

        gl4.glUseProgram(program);
        {
            gl4.glUniform1i(texture0UL, 0);
        }
        gl4.glUseProgram(0);

        checkError(gl4, "initProgram");
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        System.out.println("dispose");

        GL4 gl4 = drawable.getGL().getGL4();

        gl4.glDeleteProgram(program);

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
                gl4.glBindSampler(0, objects[Semantic.Object.SAMPLER]);
                {
                    int seconds = (int) ((System.nanoTime() - start) / 1_000_000_000);
//                    System.out.println("test " + ((int) seconds / 3));
                    int newTest = (seconds / 3) % tests.size();
                    if (currentTest != newTest) {
                        System.out.println("" + tests.get(newTest).getName());
                        currentTest = newTest;
                    }
                    tests.get(currentTest).render(gl4);
                }
                gl4.glBindSampler(0, 0);
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

        gl4.glViewport(x, y, width, height);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            Main.animator.stop();
            Main.glWindow.destroy();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
