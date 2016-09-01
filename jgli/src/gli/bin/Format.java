/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gli.bin;

import static gli.Format.FORMAT_COUNT;
import static gli.Format.FORMAT_INVALID;
import static gli.Gl.Swizzle.*;
import gli.Gl;

/**
 *
 * @author GBarbieri
 */
public class Format {

    

    private static final Format instance = new Format();

//    private Format() {
//        if (table.length != FORMAT_COUNT.value) {
//            throw new Error("GLI error: format descriptor list doesn't match number of supported formats");
//        }
//    }
//
//    public static FormatInfo getFormatInfo(jgli.Format format) {
//        if (format == FORMAT_INVALID) {
//            throw new Error("Format invalid");
//        }
//        return table[format.value - jgli.Format.FORMAT_FIRST.value];
//    }
//
//    public static final int bitsPerPixel(int format) {
//
//        FormatInfo info = table[format];
//
//        return info.blockSize * 8 / (info.blockDimensions[0] * info.blockDimensions[1] * info.blockDimensions[2]);
//    }
//
//    public static final boolean isCompressed(jgli.Format format) {
//        return (getFormatInfo(format).flags & CAP_COMPRESSED_BIT) != 0;
//    }
}
