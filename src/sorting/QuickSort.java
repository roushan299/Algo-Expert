package sorting;

public class QuickSort {

    public static int[] quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
        return array;
    }

    private static void quickSortHelper(int[] array, int startIdx, int endIdx) {
        if(startIdx >= endIdx) return;

        int pivotIdx = startIdx;
        int leftIdx = startIdx + 1;
        int rightIdx = endIdx;

        while (leftIdx <= rightIdx) {

            if(array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {
                swap(array, leftIdx, rightIdx);
            }

            if (array[leftIdx] <= array[pivotIdx]) {
                leftIdx++;
            }

            if(array[rightIdx] >= array[pivotIdx]) {
                rightIdx--;
            }
        }
        swap(array, pivotIdx, rightIdx);
        boolean leftSubArrayIsSmaller = rightIdx - 1 - startIdx < endIdx- (rightIdx + 1);

        if(leftSubArrayIsSmaller) {
            quickSortHelper(array, startIdx, rightIdx - 1);
            quickSortHelper(array, rightIdx + 1, endIdx);
        }else {
            quickSortHelper(array, rightIdx+1, endIdx);
            quickSortHelper(array, startIdx, rightIdx-1);
        }
    }

    private static void swap(int[] array, int leftIdx, int rightIdx) {
        int temp = array[leftIdx];
        array[leftIdx] = array[rightIdx];
        array[rightIdx] = temp;
    }
}
