package arrays;

import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubarray {
    public boolean zeroSumSubarray(int[] nums) {
       if(nums == null || nums.length == 0) return false;

       int currentSum = 0;
       Set<Integer> set = new HashSet<>();

       for(int num : nums){
           currentSum += num;

           if(currentSum == 0 || num == 0 || set.contains(currentSum)){
               return true;
           }
           set.add(currentSum);
       }
       return false;
    }

}
