package arrays;

import java.util.Arrays;

public class SweetAndSavory {
    public int[] sweetAndSavory(int[] dishes, int target) {
        if(dishes == null || dishes.length == 0){
            return new int[2];
        }

        Arrays.sort(dishes);


        if(!hasSweetAndSavory(dishes)){
            return new int[2];
        }

        return twoPointerSearch(dishes, target);
    }

    private boolean hasSweetAndSavory(int[] dishes){
        return dishes[0] < 0 && dishes[dishes.length-1] > 0;
    }

    private int[] twoPointerSearch(int[] dishes, int target){
        int[] answer = new int[2];
        int left = 0;
        int right = dishes.length - 1;
        int bestSum = Integer.MIN_VALUE;
        while(left < right && dishes[left] < 0 && dishes[right] > 0){
            int currentSum = dishes[left] + dishes[right];
            if(currentSum > target){
                right--;
            }else {
                if(currentSum >bestSum){
                    bestSum = currentSum;
                    answer[0] = dishes[left];
                    answer[1] = dishes[right];
                }
                left++;
            }
        }
        return answer;
    }
}
