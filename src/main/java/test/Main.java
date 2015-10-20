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
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import jgli.Texture;

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
    public static int modelToClipMatrixUL, lodUL, samplerUL, layerUL;
    public int program, currentTest = -1;
    private Texture texture;
    private final String SHADERS_ROOT = "/shaders";
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

        gl4.glEnable(GL4.GL_DEBUG_OUTPUT);

        int[] alignment = new int[1];
        gl4.glGetIntegerv(GL4.GL_UNPACK_ALIGNMENT, alignment, 0);
//        System.out.println("alignment: " + alignment[0]);
        gl4.glPixelStorei(GL4.GL_UNPACK_ALIGNMENT, 1);
        {
            /**
             * To test.
             */
//            tests.add(new Test(gl4, "array_r8_unorm.dds"));
//            tests.add(new Test(gl4, "array_r8_unorm.ktx"));
//            
//            tests.add(new Test(gl4, "cube_rgba8_unorm.dds"));
//            tests.add(new Test(gl4, "cube_rgba8_unorm.ktx"));
//            tests.add(new Test(gl4, "kueken7_a8_unorm.dds"));
//            tests.add(new Test(gl4, "kueken7_bgra8_srgb.dds"));
//            tests.add(new Test(gl4, "kueken7_bgra8_unorm.dds"));
            /**
             * Bug, getting FORMAT_RGB8_SRGB instead that FORMAT_BGRX8_SRGB.
             * This will lead to a wrong exstimated texture size.
             */
//            tests.add(new Test(gl4, "kueken7_bgrx8_srgb.dds"));
//            
//            tests.add(new Test(gl4, "kueken7_bgrx8_unorm.dds"));
//            tests.add(new Test(gl4, "kueken7_l8_unorm.dds"));
            /**
             * Wrong header, header.format.fourCC is D3DFMT_DX10 but
             * header10.format is DXGI_FORMAT_UNKNOWN.
             */
//            tests.add(new Test(gl4, "kueken7_la8_unorm.dds"));
//            
//            tests.add(new Test(gl4, "kueken7_r_ati1n_unorm.dds"));
            /**
             * Working althought I miss the ETC extension, "emulating compressed
             * format not supported in hardware with decompressed images".
             * https://en.wikipedia.org/wiki/Ericsson_Texture_Compression
             */
//            tests.add(new Test(gl4, "kueken7_r_eac_snorm.ktx"));
//            tests.add(new Test(gl4, "kueken7_r_eac_unorm.ktx"));
//            
//            tests.add(new Test(gl4, "kueken7_r5g6b5_unorm.dds"));
//            tests.add(new Test(gl4, "kueken7_r8_snorm.dds"));
//            tests.add(new Test(gl4, "kueken7_r8_unorm.dds"));
//            tests.add(new Test(gl4, "kueken7_r16_unorm.dds"));
//            tests.add(new Test(gl4, "kueken7_rg_ati2n_unorm.dds"));
            /**
             * Working althought I miss the ETC extension, "emulating compressed
             * format not supported in hardware with decompressed images".
             * https://en.wikipedia.org/wiki/Ericsson_Texture_Compression
             */
//            tests.add(new Test(gl4, "kueken7_rg_eac_snorm.ktx"));            
//            tests.add(new Test(gl4, "kueken7_rg_eac_unorm.ktx"));            
            /**
             * Working but not sure about the result.
             */
//            tests.add(new Test(gl4, "kueken7_rg11b10_ufloat.dds"));
//            tests.add(new Test(gl4, "kueken7_rg11b10_ufloat.ktx"));
            /**
             * Untested, I dont have AMD_compressed_ATC_texture.
             */
//            tests.add(new Test(gl4, "kueken7_rgb_atc_unorm.dds"));
//            
//            tests.add(new Test(gl4, "kueken7_rgb_dxt1_srgb.dds"));
            /**
             * Wrong header, glInternalFormat should be:
             *
             * INTERNAL_SRGB_DXT1(0x8C4C)
             *
             * instead of:
             *
             * INTERNAL_RGB_DXT1(0x83F0).
             */
//            tests.add(new Test(gl4, "kueken7_rgb_dxt1_srgb.ktx"));
//            
//            tests.add(new Test(gl4, "kueken7_rgb_dxt1_unorm.dds"));
//            tests.add(new Test(gl4, "kueken7_rgb_dxt1_unorm.ktx"));
//            tests.add(new Test(gl4, "kueken7_rgb_etc1_unorm.dds"));
//            tests.add(new Test(gl4, "kueken7_rgb_etc1_unorm.ktx"));
//            tests.add(new Test(gl4, "kueken7_rgb_etc2_srgb.dds"));
            /**
             * Working althought I miss the ETC extension, "emulating compressed
             * format not supported in hardware with decompressed images".
             * https://en.wikipedia.org/wiki/Ericsson_Texture_Compression
             */
//            tests.add(new Test(gl4, "kueken7_rgb_etc2_srgb.ktx"));
            /**
             * Wrong header, header.format.fourCC is D3DFMT_DX10 but
             * header10.format is DXGI_FORMAT_UNKNOWN.
             */
//            tests.add(new Test(gl4, "kueken7_rgb_etc2_unorm.dds"));
            /**
             * Untested, I dont have GL_IMG_texture_compression_pvrtc.
             */
//            tests.add(new Test(gl4, "kueken7_rgb_pvrtc_2bpp_unorm.dds"));
//            tests.add(new Test(gl4, "kueken7_rgb_pvrtc_2bpp_srgb.ktx"));
//            tests.add(new Test(gl4, "kueken7_rgb_pvrtc_4bpp_unorm.dds"));
//            tests.add(new Test(gl4, "kueken7_rgb_pvrtc_4bpp_srgb.ktx"));
            /**
             * Buffer problem. 
             * 
             * Update: Replace them with the new ones!
             */
//            tests.add(new Test(gl4, "kueken7_rgba_pvrtc2_2bpp_srgb.ktx"));
//            tests.add(new Test(gl4, "kueken7_rgba_pvrtc2_4bpp_srgb.ktx"));
//            
            tests.add(new Test(gl4, "kueken7_rgb8_srgb.dds"));
//            tests.add(new Test(gl4, "kueken7_rgb8_srgb.ktx"));
//            tests.add(new Test(gl4, "kueken7_rgb8_unorm.dds"));        
//            tests.add(new Test(gl4, "kueken7_rgb8_unorm.ktx"));        
//            tests.add(new Test(gl4, "kueken7_rgb9e5_ufloat.dds"));
//            tests.add(new Test(gl4, "kueken7_rgb9e5_ufloat.ktx"));
            /**
             * Probabily working but format type enum unsupported by jogl.
             */
//            tests.add(new Test(gl4, "kueken7_rgb10a2_unorm.dds"));
//            tests.add(new Test(gl4, "kueken7_rgb10a2u.dds"));
            /**
             * Working althought I miss the ASTC extension, "emulating
             * compressed format not supported in hardware with decompressed
             * images". https://www.opengl.org/wiki/ASTC_Texture_Compression
             */
//            tests.add(new Test(gl4, "kueken7_rgba_astc4x4_srgb.ktx"));
            /**
             * GL_INVALID_VALUE is generated if imageSize is not consistent with
             * the format, dimensions, and contents of the specified compressed
             * image data.
             */
//            tests.add(new Test(gl4, "kueken7_rgba_astc8x5_srgb.ktx"));
            /**
             * Wrong header, header.format.fourCC is D3DFMT_DX10 but
             * header10.format is DXGI_FORMAT_UNKNOWN.
             */
//            tests.add(new Test(gl4, "kueken7_rgba_astc8x8_unorm.dds"));
            /**
             * GL_INVALID_VALUE is generated if imageSize is not consistent with
             * the format, dimensions, and contents of the specified compressed
             * image data.
             */
//            tests.add(new Test(gl4, "kueken7_rgba_astc12x12_srgb.ktx"));
            /**
             * I cant test, I dont have AMD_compressed_ATC_texture.
             */
//            tests.add(new Test(gl4, "kueken7_rgba_atc_explicit_unorm.dds"));
//            tests.add(new Test(gl4, "kueken7_rgba_atc_interpolate_unorm.dds"));
//            
//            tests.add(new Test(gl4, "kueken7_rgba_dxt5_srgb.dds"));
            /**
             * Wrong header, glInternalFormat should be:
             *
             * INTERNAL_SRGB_DXT5
             *
             * instead of:
             *
             * INTERNAL_RGB_DXT5
             */
//            tests.add(new Test(gl4, "kueken7_rgba_dxt5_srgb.ktx"));
//            
//            tests.add(new Test(gl4, "kueken7_rgba_dxt5_unorm.dds"));
//            tests.add(new Test(gl4, "kueken7_rgba_dxt5_unorm.ktx"));
            /**
             * Working althought I miss the ASTC extension, "emulating
             * compressed format not supported in hardware with decompressed
             * images". https://www.opengl.org/wiki/ASTC_Texture_Compression
             */
//            tests.add(new Test(gl4, "kueken7_rgba_etc2_a1_srgb.ktx"));
//            tests.add(new Test(gl4, "kueken7_rgba_etc2_srgb.ktx"));
            /**
             * Wrong header, header.format.fourCC is D3DFMT_DX10 but
             * header10.format is DXGI_FORMAT_UNKNOWN.
             */
//            tests.add(new Test(gl4, "kueken7_rgba_pvrtc2_4bpp_unorm.dds"));
//            
//        tests.add(new Test(gl4, "kueken7_rgba8_snorm.dds"));
//        tests.add(new Test(gl4, "kueken7_rgba8_srgb.dds"));
//        tests.add(new Test(gl4, "kueken7_rgba8_srgb.ktx"));
//        tests.add(new Test(gl4, "kueken7_rgba8_unorm.dds"));
//        tests.add(new Test(gl4, "kueken7_rgba8_unorm.ktx"));
//        tests.add(new Test(gl4, "kueken7_rgba16_sfloat.dds"));        
//        tests.add(new Test(gl4, "kueken7_rgba16_sfloat.ktx"));        
//        tests.add(new Test(gl4, "kueken8_rgba8_srgb.dds"));
//        tests.add(new Test(gl4, "kueken8_rgba8_srgb.ktx"));
        }
        gl4.glPixelStorei(GL4.GL_UNPACK_ALIGNMENT, alignment[0]);

        start = System.nanoTime();

        checkError(gl4, "init");
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
        lodUL = gl4.glGetUniformLocation(program, "lod");
        samplerUL = gl4.glGetUniformLocation(program, "sampler");
        layerUL = gl4.glGetUniformLocation(program, "layer");

        int texture0UL = gl4.glGetUniformLocation(program, "texture0");

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

    public static boolean checkError(GL gl, String title) {

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
