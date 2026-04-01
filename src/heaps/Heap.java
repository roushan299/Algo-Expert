package heaps;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    static class MinHeap{

        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array){
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
           int firstParentIdx = getParentIndex(array.size()-1);
           for(int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx-- ){
               siftDown(currentIdx, array.size()-1, array);
           }
           return array;
        }

        public void siftDown(int currentIndex, int endIndex, List<Integer> heap){
           int leftChildIndex = getLeftChildIndex(currentIndex);

           while (leftChildIndex <= endIndex){
               int rightChildIndex = getRightChildIndex(currentIndex) <=  endIndex ? getRightChildIndex(currentIndex) : -1;
               int indexToSwap = leftChildIndex;
               if(rightChildIndex != -1 && heap.get(rightChildIndex) <  heap.get(leftChildIndex)){
                   indexToSwap = rightChildIndex;
               }

               if(heap.get(indexToSwap) < heap.get(currentIndex)){
                   swap(heap, currentIndex, indexToSwap);
                   currentIndex = indexToSwap;
                   leftChildIndex = getLeftChildIndex(indexToSwap);
               }else {
                   break;
               }
           }
        }

        public void siftUp(int currentIndex, int endIndex, List<Integer> heap){
            int parentIndex = getParentIndex(currentIndex);

            while (currentIndex > 0 && heap.get(parentIndex) > heap.get(currentIndex)){
                swap(heap, currentIndex, parentIndex);
                currentIndex = parentIndex;
                parentIndex = getParentIndex(currentIndex);
            }
        }

        private void siftUp(int currentIndex, List<Integer> heap){
            siftUp(currentIndex, 0, heap);
        }

        public int peek(){
            return heap.size() == 0 ? -1 : heap.get(0);
        }

        public int remove(){
          swap(heap, 0, heap.size()-1);
          int value =  heap.remove(heap.size()-1);
          siftDown(0, heap.size()-1, heap);
          return value;
        }

        public void insert(int value){
            heap.add(value);
            int currentIndex = heap.size()-1;
            siftUp(currentIndex, heap);
        }

        private int getLeftChildIndex(int index){
            return index * 2 + 1;
        }
        private int getRightChildIndex(int index){
            return getLeftChildIndex(index) + 1;
        }

        private int getParentIndex(int index){
            return (index - 1) / 2;
        }

        private void swap(List<Integer> array, int index1, int index2){
            int temp = array.get(index1);
            array.set(index1, array.get(index2));
            array.set(index2, temp);
        }


    }
}
