package arrays;

import java.util.Arrays;

public class SmallestDifference {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int[] ans = new  int[2];
        int arrayOneIdx = 0;
        int arrayTwoIdx = 0;
        int smallestDifference = Integer.MAX_VALUE;
        while (arrayOneIdx < arrayOne.length && arrayTwoIdx < arrayTwo.length) {
            int smallDiff = Math.abs(arrayOne[arrayOneIdx] - arrayTwo[arrayTwoIdx]);
            if(smallDiff == 0){
                return new int[]{arrayOne[arrayOneIdx], arrayTwo[arrayTwoIdx]};
            }

            if (smallDiff < smallestDifference) {
                ans = new  int[] {arrayOne[arrayOneIdx],arrayTwo[arrayTwoIdx]};
                smallestDifference = smallDiff;
            }

            if(arrayOne[arrayOneIdx] > arrayTwo[arrayTwoIdx]) {
                arrayTwoIdx++;
            }else{
                arrayOneIdx++;
            }

        }
        return ans;
    }
}
