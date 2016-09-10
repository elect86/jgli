/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gli;

import java.io.File;
import java.io.IOException;
import gli.detail.LoadDds;
import gli.detail.LoadKtx;

/**
 *
 * @author GBarbieri
 */
public class Load {

    // Load a texture (DDS, KTX) from file
    public static Texture load(String fileName) throws IOException {
        
        String extension = "";

        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i + 1);
        }
        
        File file = new File(Load.class.getResource(fileName).getFile());
        
        switch(extension) {
            
            case "dds":
                return LoadDds.loadDds(file);
                
            case "ktx":
                return LoadKtx.loadKtx(file);
        }

        return new Texture();
    }
}
