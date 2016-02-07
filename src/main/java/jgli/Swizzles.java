/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgli;

/**
 *
 * @author GBarbieri
 */
public class Swizzles {

    public Swizzle r;
    public Swizzle g;
    public Swizzle b;
    public Swizzle a;

    public Swizzles(Swizzle swizzle) {
        r = swizzle;
        g = swizzle;
        b = swizzle;
        a = swizzle;
    }

    public Swizzles(Swizzle r, Swizzle g, Swizzle b, Swizzle a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }
    
    public Swizzle[] toArray() {
        return new Swizzle[]{r, g, b, a};
    }

    public enum Swizzle {
        // Represent the source of a channel
        SWIZZLE_RED(0),
        SWIZZLE_FIRST(SWIZZLE_RED),
        SWIZZLE_CHANNEL_FIRST(SWIZZLE_RED),
        SWIZZLE_GREEN(1),
        SWIZZLE_BLUE(2),
        SWIZZLE_ALPHA(3),
        SWIZZLE_CHANNEL_LAST(SWIZZLE_ALPHA),
        SWIZZLE_ZERO(4),
        SWIZZLE_ONE(5),
        SWIZZLE_LAST(SWIZZLE_ONE),
        SWIZZLE_COUNT(SWIZZLE_LAST.value - SWIZZLE_FIRST.value + 1);

        public final byte value;

        private Swizzle(int value) {
            this.value = (byte) value;
        }

        private Swizzle(Swizzle swizzle) {
            value = swizzle.value;
        }
        // Determine whether the Swizzle value represent a channel
        public boolean isChannel() {
            return value >= SWIZZLE_CHANNEL_FIRST.value && value <= SWIZZLE_CHANNEL_LAST.value;
        }
    }
}
