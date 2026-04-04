package dynamicPrograming;

import java.util.Arrays;

public class MinNumberOfJumps {

    public static int minNumberOfJumps(int[] array) {
        if (array.length == 1) return 0;

        int maxReach = array[0];
        int steps = array[0];
        int jumps = 0;

        for (int i = 1; i < array.length-1; i++) {
            maxReach = Math.max(maxReach, array[i]+i);
            steps -= 1;

            if(steps==0){
                jumps += 1;
                steps = maxReach-i;
            }
        }
        return jumps+1;
    }

//    public static int minNumberOfJumps(int[] array) {
//        int[] minJumps = new  int[array.length];
//        Arrays.fill(minJumps, Integer.MAX_VALUE);
//        minJumps[0] = 0;
//
//        for(int i = 1; i < array.length; i++){
//            for(int j = 0; j < i; j++){
//                if(array[j] + j >= i){
//                    minJumps[i] = Math.min(minJumps[i], minJumps[j] + 1);
//                }
//            }
//        }
//        return minJumps[minJumps.length - 1];
//    }
}
