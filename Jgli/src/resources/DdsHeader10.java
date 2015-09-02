/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import resources.dx.DxgiFormat;
import resources.DdsResources;
import static resources.DdsResources.D3D10_RESOURCE_DIMENSION_UNKNOWN;


/**
 *
 * @author elect
 */
public class DdsHeader10 {
    
    public int format;
    public int resourceDimension;
    public int miscFlag;    // D3D10_RESOURCE_MISC_GENERATE_MIPS
    public int arraySize;
    public int reserved;

    public DdsHeader10() {
        format = DxgiFormat.DXGI_FORMAT_UNKNOWN;
        resourceDimension = D3D10_RESOURCE_DIMENSION_UNKNOWN;
        miscFlag = 0;
        arraySize = 0;
        reserved = 0;
    }
    
    
}
