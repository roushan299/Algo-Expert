package sorting;

public class SelectionSort {
    public static int[] selectionSort(int[] array) {
        int currentIndex = 0;

        while (currentIndex < array.length-1) {
            int smallestIndex = currentIndex;

            for(int i = currentIndex+1; i < array.length; i++) {
                if(array[i] < array[smallestIndex]) {
                    smallestIndex = i;
                }
            }
            swap(array, currentIndex, smallestIndex);
            currentIndex ++;
        }
        return array;
    }
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
