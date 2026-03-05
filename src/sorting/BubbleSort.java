package sorting;

public class BubbleSort {

    public static int[] bubbleSort(int[] array) {
        int size = array.length-1;
        while (size > 0){
            for(int i = 0; i < size; i++){
                if(array[i] > array[i+1]){
                    swapValue(array, i);
                }
            }
            size--;
        }
        return array;
    }

    private static void swapValue(int[] array, int i) {
        int temp = array[i];
        array[i] = array[i+1];
        array[i+1] = temp;
    }
}
