package dynamicPrograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxSumIncreasingSubsequence {

    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        int[] sums = new int[array.length];
        int[] sequence = new  int[array.length];
        Arrays.fill(sequence, -1);
        copyValue(sums, array);
        int maxSumIdx = 0;


        for(int i = 0; i < array.length; i++){
            int currentNum = array[i];

            for(int j = 0; j <= i; j++){
                int otherNum = array[j];

                if(otherNum < currentNum && sums[j] + currentNum >= sums[i]){
                        sums[i] = sums[j] + currentNum;
                        sequence[i] = j;
                }

            }

            if(sums[i] > sums[maxSumIdx]){
                maxSumIdx = i;
            }
        }
        List<Integer> maxSums = new ArrayList<>();
        maxSums.add(sums[maxSumIdx]);
        List<Integer> sequenceList = buildSequence(sequence, maxSumIdx, array);
        return new ArrayList<List<Integer>>() {
            {
                add(maxSums);// Example max sum
                add(sequenceList); // Example max sequence
            }
        };
    }

    private static List<Integer> buildSequence(int[] sequence,int currentIdx, int[] array) {
        List<Integer> sequenceList = new ArrayList<>();

        while(currentIdx != -1){
            sequenceList.add(array[currentIdx]);
            currentIdx = sequence[currentIdx];
        }
        Collections.reverse(sequenceList);
        return sequenceList;
    }

    private static void copyValue(int[] sums, int[] arr){
        for(int i = 0; i < arr.length; i++){
            sums[i] = arr[i];
        }
    }
}
