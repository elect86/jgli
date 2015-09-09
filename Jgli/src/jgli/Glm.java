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
public class Glm {

    public static boolean[] equal(int[] vec0, int[] vec1) {

        if (vec0.length != vec1.length) {
            throw new Error("Length of vectors differs!");
        }

        boolean[] result = new boolean[vec0.length];

        for (int component = 0; component < vec0.length; component++) {
            result[component] = vec0[component] == vec1[component];
        }
        return result;
    }

    public static boolean all(boolean[] vec) {

        for (boolean b : vec) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public static int[] divide(int[] vec0, int[] vec1) {

        if (vec0.length != vec1.length) {
            throw new Error("Length of vectors differs!");
        }

        int[] result = new int[vec0.length];

        for (int component = 0; component < vec0.length; component++) {
            result[component] = vec0[component] / vec1[component];
        }
        return result;
    }
    
    public static int[] max(int[] vec0, int[] vec1) {
        if (vec0.length != vec1.length) {
            throw new Error("Length of vectors differs!");
        }

        int[] result = new int[vec0.length];

        for (int component = 0; component < vec0.length; component++) {
            result[component] = Math.max(vec0[component], vec1[component]);
        }
        return result;
    }

    public static byte[] maxB(byte[] vec0, byte[] vec1) {

        if (vec0.length != vec1.length) {
            throw new Error("Length of vectors differs!");
        }

        byte[] result = new byte[vec0.length];

        for (int component = 0; component < vec0.length; component++) {
            result[component] = vec0[component] > vec1[component] ? vec0[component] : vec1[component];
        }
        return result;
    }
    
    public static int[] maxI(byte[] vec0, byte[] vec1) {

        if (vec0.length != vec1.length) {
            throw new Error("Length of vectors differs!");
        }

        int[] result = new int[vec0.length];

        for (int component = 0; component < vec0.length; component++) {
            result[component] = vec0[component] > vec1[component] ? vec0[component] : vec1[component];
        }
        return result;
    }

    public static boolean[] greaterThan(int[] vec0, byte[] vec1) {

        if (vec0.length != vec1.length) {
            throw new Error("Length of vectors differs!");
        }

        boolean[] result = new boolean[vec0.length];

        for (int component = 0; component < vec0.length; component++) {
            result[component] = vec0[component] > vec1[component];
        }
        return result;
    }

    public static int compMul(int[] vec) {

        int result = 1;

        for (int i = 0; i < vec.length; i++) {
            result *= vec[i];
        }
        return result;
    }

    public static int[] shiftRight(int[] vec, int shift) {
        
        int[] result = new int[vec.length];
        for (int i = 0; i < vec.length; i++) {
            result[i] = vec[i] >> shift;
        }
        return result;
    }
}
