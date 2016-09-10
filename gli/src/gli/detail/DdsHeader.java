/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gli.detail;

import java.nio.ByteBuffer;

/**
 *
 * @author GBarbieri
 */
public class DdsHeader {

    public int magic;
    public int size;
    public int flags;
    public int height;
    public int width;
    public int pitch;
    public int depth;
    public int mipMapLevels;
    public int[] reserved1 = new int[11];
    public DdsPixelFormat format;
    public int surfaceFlags;
    public int cubemapFlags;
    public int[] reserved2 = new int[3];

    public static final int sizeOf = 4 * Byte.BYTES + 7 * Integer.BYTES + 11 * Integer.BYTES
            + DdsPixelFormat.sizeOf + 2 * Integer.BYTES + 3 * Integer.BYTES;

    public static final int offsetMagic = 0;
    public static final int offsetSize = offsetMagic + 4 * Byte.BYTES;
    public static final int offsetFlags = offsetSize + Integer.BYTES;
    public static final int offsetHeight = offsetFlags + Integer.BYTES;
    public static final int offsetWidth = offsetHeight + Integer.BYTES;
    public static final int offsetPitch = offsetWidth + Integer.BYTES;
    public static final int offsetDepth = offsetPitch + Integer.BYTES;
    public static final int offsetMipMapLevels = offsetDepth + Integer.BYTES;
    public static final int offsetReserved1 = offsetMipMapLevels + Integer.BYTES;
    public static final int offsetFormat = offsetReserved1 + 11 * Integer.BYTES;
    public static final int offsetSurfaceFlags = offsetFormat + DdsPixelFormat.sizeOf;
    public static final int offsetCubemapFlags = offsetSurfaceFlags + Integer.BYTES;
    public static final int offsetReserved2 = offsetCubemapFlags + Integer.BYTES;

    public DdsHeader(ByteBuffer byteBuffer) {

        magic = byteBuffer.getInt();
        size = byteBuffer.getInt();
        flags = byteBuffer.getInt();
        height = byteBuffer.getInt();
        width = byteBuffer.getInt();
        pitch = byteBuffer.getInt();
        depth = byteBuffer.getInt();
        mipMapLevels = byteBuffer.getInt();
        for (int i = 0; i < reserved1.length; i++) {
            reserved1[i] = byteBuffer.getInt();
        }
        format = new DdsPixelFormat(byteBuffer);
        surfaceFlags = byteBuffer.getInt();
        cubemapFlags = byteBuffer.getInt();
        for (int i = 0; i < reserved2.length; i++) {
            reserved2[i] = byteBuffer.getInt();
        }

        /**
         * G-truc has 124 as he doesnt count the initial word 'magic'.
         */
        if (DdsHeader.sizeOf != 128) {
            throw new Error("DDS Header size mismatch");
        }
    }
}
