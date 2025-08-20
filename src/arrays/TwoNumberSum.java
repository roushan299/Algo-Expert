package arrays;

import java.util.HashSet;

public class TwoNumberSum {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        int[] arr = new int[0];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
            if(set.contains(targetSum - array[i])){
                arr = new int[]{array[i], targetSum - array[i]};
            }
        }
        return arr;
    }
}
