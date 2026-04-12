package heaps;

import java.util.PriorityQueue;

public class ContinuousMedian {

    static class ContinuousMedianHandler {
        double median = 0;
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        public void insert(int number) {
            // insert
            if(minHeap.isEmpty() || number <= maxHeap.peek()){
                maxHeap.add(number);
            }else {
                minHeap.add(number);
            }
            reBalanceHeap();
            updateMedian();
        }

        private void reBalanceHeap(){
            if(maxHeap.size() > minHeap.size()+1){
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }

        private void updateMedian() {
            if(minHeap.size() == maxHeap.size()){
                median = (minHeap.peek() + maxHeap.peek())/ 2.0;
            }else {
                median = maxHeap.peek();
            }
        }

        public double getMedian() {
            return median;
        }
    }


}
