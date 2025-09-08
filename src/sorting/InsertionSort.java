package sorting;

public class InsertionSort {
    public static int[] insertionSort(int[] array) {

        for(int i = 1; i < array.length; i++){
            for(int j = i; j >= 1; j--){
                if(array[j-1] > array[j]){
                    swap(array, j-1, j);
                }
            }
        }
        return array;

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
