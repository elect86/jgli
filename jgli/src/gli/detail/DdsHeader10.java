/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gli.detail;

import java.nio.ByteBuffer;
import gli.dx.Dx;
import gli.detail.LoadDds.D3d10ResourceDimension;
import static gli.detail.LoadDds.DdsAlphaMode.DDS_ALPHA_MODE_UNKNOWN;

/**
 *
 * @author GBarbieri
 */
public class DdsHeader10 {

    public Dx.DxgiFormat format;
    public D3d10ResourceDimension resourceDimension;
    public int miscFlag;    // D3D10_RESOURCE_MISC_GENERATE_MIPS
    public int arraySize;
    public LoadDds.DdsAlphaMode alphaFlags; // Should be 0 whenever possible to avoid D3D utility library to fail
    public static final int sizeOf = 5 * Integer.BYTES;

    public DdsHeader10() {
        format = Dx.DxgiFormat.DXGI_FORMAT_UNKNOWN;
        resourceDimension = D3d10ResourceDimension.D3D10_RESOURCE_DIMENSION_UNKNOWN;
        miscFlag = 0;
        arraySize = 0;
        alphaFlags = DDS_ALPHA_MODE_UNKNOWN;
    }

    public DdsHeader10(ByteBuffer byteBuffer) {
        format = Dx.DxgiFormat.get(byteBuffer.getInt());
        resourceDimension = D3d10ResourceDimension.values()[byteBuffer.getInt()];
        miscFlag = byteBuffer.getInt();
        arraySize = byteBuffer.getInt();
        alphaFlags = LoadDds.DdsAlphaMode.get(byteBuffer.getInt());

        if (DdsHeader10.sizeOf != 20) {
            throw new Error("DDS DX10 Extended Header size mismatch");
        }
    }
}
