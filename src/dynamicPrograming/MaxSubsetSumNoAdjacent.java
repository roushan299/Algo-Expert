package dynamicPrograming;

public class MaxSubsetSumNoAdjacent {
    public static int maxSubsetSumNoAdjacent(int[] array) {
       if(array == null || array.length == 0) return 0;
       if(array.length == 1) return array[0];
       int[] subSetSums = new int[array.length];
       subSetSums[0] = array[0];
       subSetSums[1] = Math.max(array[0], array[1]);
       for(int i = 2; i < array.length; i++){
           subSetSums[i] = Math.max(subSetSums[i-1], subSetSums[i-2] + array[i]);
       }
       return subSetSums[array.length-1];
    }
}
