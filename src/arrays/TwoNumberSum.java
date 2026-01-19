package arrays;

import java.util.HashMap;
import java.util.HashSet;

public class TwoNumberSum {

    public static int[] twoNumberSum(int[] array, int targetSum) {
        HashSet<Integer> set = new HashSet<>();

        for(int num: array){
            int complement = targetSum - num;
            if(set.contains(complement)){
                return new int[]{num, complement};
            }else {
                set.add(num);
            }
        }
        return new  int[0];
    }
}
