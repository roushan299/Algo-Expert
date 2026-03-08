package sorting;

public class SelectionSort {

    public static int[] selectionSort(int[] array) {
        int currentIdx = 0;


        while (currentIdx < array.length-1) {
            int smallestIdx = currentIdx;

            for(int i=currentIdx+1; i<array.length; i++){
                if(array[i] < array[smallestIdx]){
                    smallestIdx = i;
                }
            }
            swap(array, currentIdx, smallestIdx);
            currentIdx++;
        }
        return array;
    }

    private  static void swap(int[] array, int i, int j) {
        int  temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
