package sorting;

import java.util.ArrayList;
import java.util.Collections;

public class RadixSort {

    public ArrayList<Integer> radixSort(ArrayList<Integer> array) {
        if(array == null || array.size() < 2) return array;
        int maxNumber = getMaxDigit(array);

        for(int exp = 1; maxNumber/ exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
        return array;
    }

    private void countingSort(ArrayList<Integer> array, int digit) {
        ArrayList<Integer> sorted = new ArrayList<>(Collections.nCopies(array.size(), 0));
        int[] countArray = new  int[10];

        for(int num: array){
            int countIndex =  (num / digit) % 10;
            countArray[countIndex] += 1;
        }

        for(int index = 1; index < countArray.length; index++ ){
            countArray[index] += countArray[index-1];
        }

        for(int index = array.size()-1; index >= 0; index--){
            int num = array.get(index);
            int countIndex =  (num / digit) % 10;

            sorted.set(countArray[countIndex] - 1, num);
            countArray[countIndex] -= 1;
        }

        for(int index = 0; index < sorted.size(); index++){
            array.set(index, sorted.get(index));
        }
    }

    private int getMaxDigit(ArrayList<Integer> array) {
        int maxDigit = 0;
        for(int value : array) maxDigit = Math.max(value, maxDigit);
        return maxDigit;
    }

}
