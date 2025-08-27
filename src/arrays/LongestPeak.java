package arrays;

public class LongestPeak {
    public static int longestPeak(int[] array) {
       int longestPeak = 0;
       int idx = 1;

       while (idx < array.length-1) {
           boolean isPeak = array[idx - 1] < array[idx] && array[idx] > array[idx + 1];
           if(!isPeak){
               idx++;
               continue;
           }
           int leftIdx = idx - 1;
           while(leftIdx >= 0 && array[leftIdx] < array[leftIdx+1]){
               leftIdx--;
           }
          int rightIdx = idx + 1;
           while (rightIdx < array.length && array[rightIdx] < array[rightIdx-1]){
               rightIdx++;
           }
           int currentPeakLength  = rightIdx - leftIdx - 1;
           longestPeak = Math.max(currentPeakLength, longestPeak);
           idx = rightIdx;
       }
        return longestPeak;
    }
}
