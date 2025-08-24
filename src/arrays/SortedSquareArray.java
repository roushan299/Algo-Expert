package arrays;

public class SortedSquareArray {
    public int[] sortedSquaredArray(int[] array) {
        // Write your code here.
        int[] sortedSquareArray = new int[array.length];
        int smallestValueIdx = 0;
        int largestValueIdx = array.length-1;

        for(int idx = array.length-1; idx >=0; idx--){
            int smallerValue = array[smallestValueIdx];
            int largerValue = array[largestValueIdx];
            if(Math.abs(smallerValue) > Math.abs(largerValue)){
                sortedSquareArray[idx] = smallerValue*smallerValue;
                smallestValueIdx ++;
            }else {
                sortedSquareArray[idx] = largerValue*largerValue;
                largestValueIdx --;
            }
        }
        return sortedSquareArray;
    }
}
