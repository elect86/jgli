/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

/**
 *
 * @author elect
 */
public class DdsHeader {

    public byte[] magic; // 4
    public int size;
    public int flags;
    public int height;
    public int width;
    public int pitch;
    public int depth;
    public int mipMapLevels;
    public int[] reserved1; // 11
    DdsPixelFormat format;
    public int surfaceFlags;
    public int cubemapFlags;
    public int[] reserved2; // 3

    public static final int sizeOf = 4 * Byte.BYTES + 7 * Integer.BYTES + 11 * Integer.BYTES
            + DdsPixelFormat.sizeOf + 2 * Integer.BYTES + 3 * Integer.BYTES;

    public static class Offset {

        public static final int magic = 0;
        public static final int size = magic + 4 * Byte.BYTES;
        public static final int flags = size + Integer.BYTES;
        public static final int height = flags + Integer.BYTES;
        public static final int width = height + Integer.BYTES;
        public static final int pitch = width + Integer.BYTES;
        public static final int depth = pitch + Integer.BYTES;
        public static final int mipMapLevels = depth + Integer.BYTES;
        public static final int reserved1 = mipMapLevels + Integer.BYTES;
        public static final int format = reserved1 + 11 * Integer.BYTES;
        public static final int surfaceFlags = format + DdsPixelFormat.sizeOf;
        public static final int cubemapFlags = surfaceFlags + Integer.BYTES;
        public static final int reserved2 = cubemapFlags + Integer.BYTES;
    }

}
