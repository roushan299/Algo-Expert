package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Arrays.sort(array);
        List<Integer[]> result = new ArrayList<>();
        for(int idx = 0;idx<array.length-2;idx++){
            int leftIdx = idx+1;
            int rightIdx = array.length-1;
            while(leftIdx<rightIdx){
                int sum = array[idx] + array[leftIdx] + array[rightIdx];
                if(sum == targetSum){
                    result.add(new Integer[]{array[idx], array[leftIdx], array[rightIdx]});
                    leftIdx++;
                    rightIdx--;
                }else if(sum > targetSum){
                    rightIdx--;
                }else {
                    leftIdx++;
                }
            }
        }
        return result;
    }
}
