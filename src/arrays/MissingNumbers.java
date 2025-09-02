package arrays;

public class MissingNumbers {
    public int[] missingNumbers(int[] nums) {
      int n = nums.length;
      int totalCount = n+2;

      int expectedSum = totalCount*(totalCount+1)/2;
      int actualSum = arraySum(nums);

      int missingSum = expectedSum-actualSum;
      int pivot = missingSum/2;

      int leftActualSum = 0;
      int rightActualSum = 0;
      for(int num : nums) {
        if(num <= pivot) {
            leftActualSum += num;
        }else{
            rightActualSum += num;
        }
      }

      int leftExpectedSum = sumRange(1, pivot);
      int rightExpectedSum = sumRange(pivot+1, totalCount);

      return new int[]{leftExpectedSum-leftActualSum, rightExpectedSum-rightActualSum};
    }

    private int sumRange(int start, int end) {
        return (end * (end+1)/2) - ((start - 1) * start/2);
    }

    private int arraySum(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        return sum;
    }
}
