package arrays;

import java.util.HashMap;

public class LargestRange {

    public static int[] largestRange(int[] array) {
        HashMap<Integer, Boolean> hashTable = new HashMap<>();

        for(int num : array){
            hashTable.put(num, true);
        }
        int[] range = new int[]{0, 0};
        int longestLength = 0;

        for(int num : array){
            if(!hashTable.get(num)) continue;

            int left = findLeftBoundary(num, hashTable);
            int right = findRightBoundary(num, hashTable);
            int currentLength = right - left+1;

             if(currentLength > longestLength){
                 longestLength = currentLength;
                 range[0] = left;
                 range[1] = right;
             }
        }
        return range;
    }

    private  static int findLeftBoundary(int num, HashMap<Integer, Boolean> hashTable){
        int leftValue = num;

        while(hashTable.containsKey(leftValue)){
            hashTable.put(leftValue, false);
            leftValue--;
        }
        return leftValue+1;
    }

    private static int findRightBoundary(int num, HashMap<Integer, Boolean> hashTable){
        int rightValue = num;
        while(hashTable.containsKey(rightValue)){
            hashTable.put(rightValue, false);
            rightValue++;
        }
        return rightValue-1;
    }

}
