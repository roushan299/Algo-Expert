package arrays;

public class LongestSubarrayWithSum {

    public int[] longestSubarrayWithSum(int[] array, int targetSum) {
        int[] range = new int[0];
        int longestSubArray = 0;
        int left = 0;
        int sum = 0;

        for(int right = 0; right < array.length; right++){
            sum += array[right];

            while (sum > targetSum && left <= right){
                sum -= array[left];
                left++;
            }
            int currentRangeLength = right - left + 1;
            if(sum == targetSum && currentRangeLength > longestSubArray){
                longestSubArray = currentRangeLength;
                range = new int[]{left, right};
            }
        }
        return range;
    }
}
