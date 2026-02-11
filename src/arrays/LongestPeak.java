package arrays;

public class LongestPeak {

    public static int longestPeak(int[] array) {
       int longestPeakLength = 0;
       int index = 1;

       while (index < array.length-1) {
           if(!isPeak(array, index)){
               index++;
               continue;
           }

           int left = index-2;
           while(left >= 0 && array[left] < array[left+1]){
               left--;
           }
           int right = index+2;
           while(right < array.length && array[right]<array[right-1]){
               right++;
           }
           int currentPeakLength = right - left - 1;
           longestPeakLength = Math.max(currentPeakLength, longestPeakLength);
           index = right;
       }
       return longestPeakLength;
    }

    private static boolean isPeak(int[] array, int index) {
        return array[index - 1] < array[index] && array[index] > array[index+1];
    }
}
