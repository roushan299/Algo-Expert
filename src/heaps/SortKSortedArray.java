package heaps;

import java.util.PriorityQueue;

public class SortKSortedArray {
    public int[] sortKSortedArray(int[] array, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] sortedArray = new int[array.length];

        for(int i=0; i< Math.min(k+1, array.length); i++){
            pq.add(array[i]);
        }

        int nextIndexToInsert = 0;

        for(int idx=k+1; idx<array.length; idx++){
            int minElement = pq.remove();
            array[nextIndexToInsert] = minElement;
            nextIndexToInsert++;

            int currentElement = array[idx];
            pq.add(currentElement);
        }

        while(!pq.isEmpty()){
            array[nextIndexToInsert] = pq.remove();
            nextIndexToInsert++;
        }

        return array;
    }
}
