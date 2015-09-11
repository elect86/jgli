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
public enum Target {

    TARGET_1D,
    TARGET_FIRST(TARGET_1D),
    TARGET_1D_ARRAY,
    TARGET_2D,
    TARGET_2D_ARRAY,
    TARGET_3D,
    TARGET_CUBE,
    TARGET_CUBE_ARRAY,
    TARGET_LAST(TARGET_CUBE_ARRAY),
    TARGET_COUNT(TARGET_LAST.value - TARGET_FIRST.value + 1),
    TARGET_INVALID(-1);

    public final int value;

    private Target(int value) {
        this.value = value;
    }

    private Target() {
        this.value = Counter.nextValue;
        Counter.nextValue++;
    }

    private Target(Target target) {
        value = target.value;
    }

    /**
     * Trick to get automatic incremental values.
     */
    private static class Counter {

        private static int nextValue = 0;
    }

    /**
     * Check whether a target is a 1D target.
     *
     * @return
     */
    public boolean isTarget1d() {
        return value == TARGET_1D.value || value == TARGET_1D_ARRAY.value;
    }

    /**
     * Check whether a target is an array target.
     *
     * @return
     */
    public boolean isTargetArray() {
        return value == TARGET_1D_ARRAY.value || value == TARGET_2D_ARRAY.value || value == TARGET_CUBE_ARRAY.value;
    }

    /**
     * Check whether a target is a cube map target.
     *
     * @return
     */
    public boolean isTargetCube() {
        return value == TARGET_CUBE.value || value == TARGET_CUBE_ARRAY.value;
    }
}
