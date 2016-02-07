/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgli.bin;

/**
 *
 * @author GBarbieri
 */
public enum Swizzle {

    SWIZZLE_RED,
    SWIZZLE_FIRST(SWIZZLE_RED), SWIZZLE_CHANNEL_FIRST(SWIZZLE_RED),
    SWIZZLE_GREEN,
    SWIZZLE_BLUE,
    SWIZZLE_ALPHA, SWIZZLE_CHANNEL_LAST(SWIZZLE_ALPHA),
    SWIZZLE_ZERO,
    SWIZZLE_ONE, SWIZZLE_LAST(SWIZZLE_ONE),
    SWIZZLE_COUNT(SWIZZLE_LAST.value - SWIZZLE_FIRST.value + 1);

    public final int value;

    private Swizzle() {
        value = Counter.nextValue;
        Counter.nextValue++;
    }

    private Swizzle(Swizzle swizzle) {
        value = swizzle.value;
    }

    private Swizzle(int value) {
        this.value = value;
    }

    public boolean isChannel() {
        return value >= SWIZZLE_CHANNEL_FIRST.value & value <= SWIZZLE_CHANNEL_LAST.value;
    }

    /**
     * Trick to get automatic incremental values.
     */
    private static class Counter {

        private static int nextValue = 0;
    }
}
