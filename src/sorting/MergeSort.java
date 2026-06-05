package sorting;

public class MergeSort {

    public static int[] mergeSort(int[] array) {
        if(array == null || array.length <= 1) return array;

        int[] auxiliary = array.clone();
        mergeSort(array, auxiliary, 0, array.length-1);
        return array;
    }

    private static void mergeSort(int[] array, int[] auxiliary, int start, int end) {
        if(start >= end) return;

        int mid = start + (end - start)/2;

        mergeSort(array, auxiliary, start, mid);
        mergeSort(array, auxiliary, mid+1, end);

        // if already sorted return
        if(array[mid] <= array[mid+1]) return;

        merge(array, auxiliary, start, mid, end);
    }

    private static void merge(int[] array, int[] auxiliary, int start, int mid, int end) {
        System.arraycopy(array, start, auxiliary, start, end - start + 1);

        int left = start;
        int right = mid + 1;
        int current = start;

        while (left <= mid && right <= end) {
            if (auxiliary[left] <= auxiliary[right]) {
                array[current] = auxiliary[left];
                left++;
            }else {
                array[current] = auxiliary[right];
                right++;
            }
            current++;
        }

        while (left <= mid) {
            array[current] = auxiliary[left];
            current++;
            left++;
        }
    }

}
