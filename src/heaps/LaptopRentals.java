package heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LaptopRentals {


    public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
        times.sort(Comparator.comparing(a -> a.get(0)));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int maxLaptop = 0;

        for(int index = 0; index < times.size(); index++){
            int start = times.get(index).get(0);
            int end = times.get(index).get(1);

            while (!minHeap.isEmpty() && minHeap.peek()<= start){
                minHeap.poll();
            }
            minHeap.add(end);
            maxLaptop = Math.max(maxLaptop, minHeap.size());
        }
        return maxLaptop;
    }

//    public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
//        int maxEndTime = 0;
//
//        for(int i = 0; i < times.size(); i++){
//            maxEndTime = Math.max(times.get(i).get(1), maxEndTime);
//        }
//
//        int[] laptopRequires = new  int[maxEndTime+1];
//        for(int i = 0; i < times.size(); i++){
//            int start = times.get(i).get(0);
//            int end = times.get(i).get(1);
//
//            for(int j = start; j < end; j++){
//                laptopRequires[j] = laptopRequires[j]+1;
//            }
//        }
//
//        int minLaptop = 0;
//        for(int i = 0; i < laptopRequires.length; i++){
//            minLaptop = Math.max(minLaptop,laptopRequires[i]);
//        }
//        return minLaptop;
//    }
}
