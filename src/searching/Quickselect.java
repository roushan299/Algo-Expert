package searching;

public class Quickselect {

    public static int quickselect(int[] array, int k) {
        int position = k-1;
        return quickSelectHelper(array, 0, array.length-1, position);
    }
    private static int quickSelectHelper(int[] array, int startIdx, int endIdx, int position) {

        while (true){

            if(startIdx > endIdx){
                return -1;
            }

            int pivotIdx = startIdx;
            int leftIdx = startIdx+1;
            int rightIdx = endIdx;

            while(leftIdx <= rightIdx){

                if(array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]){
                    swap(array, leftIdx, rightIdx);
                }

                if(array[leftIdx] <=  array[pivotIdx]){
                    leftIdx++;
                }

                if(array[rightIdx] >=  array[pivotIdx]){
                    rightIdx--;
                }
            }
            swap(array, pivotIdx, rightIdx);

            if(rightIdx == position) return array[rightIdx];
            else if(rightIdx < position) startIdx = rightIdx + 1;
            else endIdx = rightIdx-1;
        }
    }

    private static void swap(int[] array, int leftIdx, int rightIdx) {
        int  temp = array[leftIdx];
        array[leftIdx] = array[rightIdx];
        array[rightIdx] = temp;
    }
}
