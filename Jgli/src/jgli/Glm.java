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
                
        for(boolean b : vec) {
            if(!b) {
                return false;
            }
        }
        return true;
    }
}
