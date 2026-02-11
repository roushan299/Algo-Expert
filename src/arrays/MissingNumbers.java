package arrays;

import java.util.Arrays;

public class MissingNumbers {
    public int[] missingNumbers(int[] nums) {
        int n = getTotalCount(nums);
        int sumDiff = getSumDiff(nums, n);
        int midPoint = getMidPoint(sumDiff);
        int smallerMissingNum = getSmallMissingNum(nums, midPoint);
        int largerMissingNum = sumDiff - smallerMissingNum;
        return new int[]{smallerMissingNum,largerMissingNum};
    }

    private int getSmallMissingNum(int[] nums, int midPoint) {
        int expectedMidPointSum = 0;
        int actualMidPointSum = midPoint*(midPoint+1)/2;
        for (int num : nums) {
            if(num <= midPoint) {
                expectedMidPointSum += num;
            }
        }
        return actualMidPointSum - expectedMidPointSum;
    }

    private int getMidPoint(int sumDiff) {
        return sumDiff / 2;
    }

    private int getSumDiff(int[] nums, int n) {
        return getExpectedSum(n) - getActualSum(nums);
    }

    private int getActualSum(int[] nums) {
        return Arrays.stream(nums).sum();
    }

    private int getExpectedSum(int n) {
        return n * (n + 1) / 2;
    }

    private int getTotalCount(int[] nums) {
        return nums.length+2;
    }

    private int calculateSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
