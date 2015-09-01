/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgli;

/**
 *
 * @author elect
 */
public class Target {

    public static final int TARGET_1D = 0;
    public static final int TARGET_FIRST = TARGET_1D;
    public static final int TARGET_1D_ARRAY = 1;
    public static final int TARGET_2D = 2;
    public static final int TARGET_2D_ARRAY = 3;
    public static final int TARGET_3D = 4;
    public static final int TARGET_CUBE = 5;
    public static final int TARGET_CUBE_ARRAY = 6;
    public static final int TARGET_LAST = TARGET_CUBE_ARRAY;

    public static final int TARGET_COUNT = TARGET_LAST - TARGET_FIRST + 1;
    public static final int TARGET_INVALID = -1;

    /**
     * Check whether a target is a 1D target.
     *
     * @param target
     * @return
     */
    public static boolean isTarget1d(int target) {
        return target == TARGET_1D || target == TARGET_1D_ARRAY;
    }

    /**
     * Check whether a target is an array target.
     *
     * @param target
     * @return
     */
    public static boolean isTargetArray(int target) {
        return target == TARGET_1D_ARRAY || target == TARGET_2D_ARRAY || target == TARGET_CUBE_ARRAY;
    }

    /**
     * Check whether a target is a cube map target.
     * @param target
     * @return 
     */
    public static boolean isTargetCube(int target) {
        return target == TARGET_CUBE || target == TARGET_CUBE_ARRAY;
    }
}
