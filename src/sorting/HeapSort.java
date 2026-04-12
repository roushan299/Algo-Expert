package sorting;

public class HeapSort {

    public static int[] heapSort(int[] array) {
        buildMaxHeap(array);

        for(int endIdx = array.length-1;endIdx > 0;endIdx--){
            swap(0, endIdx, array);
            siftDown(0, endIdx-1, array);
        }
        return array;
    }

    private static void siftDown(int currentIdx, int endIdx, int[] heap) {
        int leftChildIdx = getLeftChildIndex(currentIdx);

        while(leftChildIdx <= endIdx){

            int rightChildIdx = getRightChildIndex(currentIdx) <= endIdx ? getRightChildIndex(currentIdx) : -1;
            int idxToSwap = leftChildIdx;
            if(rightChildIdx > -1 && heap[rightChildIdx] > heap[leftChildIdx]){
                idxToSwap = rightChildIdx;
            }

            if(heap[idxToSwap] > heap[currentIdx]){
                swap(currentIdx, idxToSwap, heap);
                currentIdx = idxToSwap;
                leftChildIdx = getLeftChildIndex(currentIdx);
            }else {
                return;
            }
        }

    }

    private static void buildMaxHeap(int[] array) {
        int firstParentIdx = getParentIndex(array.length-1);

        for (int currentIdx = firstParentIdx+1; currentIdx >= 0; currentIdx--){
            siftDown(currentIdx, array.length-1, array);
        }
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int getParentIndex(int index) {
        return (index - 1)/2;
    }

    private static int getLeftChildIndex(int index){
        return index*2 + 1;
    }

    private static int getRightChildIndex(int index){
        return index*2 + 2;
    }


}
