/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgli;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

/**
 *
 * @author gbarbieri
 */
public class LoadDds {

    public static Texture loadDds(String filename) throws IOException {
        return loadDds(new File(filename));
    }

    public static Texture loadDds(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();

        return loadDds(fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, (int) file.length()));
    }

    public static Texture loadDds(ByteBuffer byteBuffer) throws IOException {

        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }
}
