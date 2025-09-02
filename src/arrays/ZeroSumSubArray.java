package arrays;

import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubArray {
    public boolean zeroSumSubarray(int[] nums) {
        Set<Integer> prefixSums = new HashSet<>();
        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            if(isZeroSubarray(num, currentSum, prefixSums)){
                return true;
            }
        }
        return false;
    }
    private boolean isZeroSubarray(int num, int currentSum, Set<Integer> prefixSums) {
        return num == 0               // single element zero
                || currentSum == 0        // prefix sum zero
                || !prefixSums.add(currentSum); // repeated prefix sum
    }
}
