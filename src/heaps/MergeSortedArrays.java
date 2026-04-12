package heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedArrays {

    static class Node{
        int value;
        int arrayIndex;
        int elementIndex;

        Node(int value, int arrayIndex, int elementIndex){
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }

    }

    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        List<Integer> sortedArray = new ArrayList<>();
        if(arrays == null || arrays.size() == 0) return sortedArray;

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));

        // first push element of each array
        for(int index = 0; index < arrays.size(); index++){
            List<Integer> array = arrays.get(index);

            if(arrays == null && arrays.size() == 0) continue;

            Node node = new Node(array.get(0), index, 0);
            minHeap.add(node);
        }

        // poll and enter lower value in sorted result array and
        // add next value from same array from which we get lower value
        while (!minHeap.isEmpty()){
            Node currentNode = minHeap.poll();
            sortedArray.add(currentNode.value);
            int nextIndex = currentNode.elementIndex + 1;

            List<Integer> array = arrays.get(currentNode.arrayIndex);

            if(nextIndex < array.size()){
                Node node = new  Node(array.get(nextIndex), currentNode.arrayIndex, nextIndex);
                minHeap.add(node);
            }
        }
        return sortedArray;
    }





















//    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
//        if(arrays.isEmpty()) return new ArrayList<>();
//        if(arrays.size() < 2) return arrays.get(0);
//        List<Integer> mergedSortedArray = mergeSortedArrays(arrays.get(0), arrays.get(1));
//
//        for(int i=2; i<arrays.size(); i++){
//            List<Integer> currentSortedArray =  mergeSortedArrays(arrays.get(i), mergedSortedArray);
//            mergedSortedArray = currentSortedArray;
//        }
//        return mergedSortedArray;
//    }
//
//    private static List<Integer> mergeSortedArrays(List<Integer> sortedList1, List<Integer> sortedList2) {
//        int index1 = 0;
//        int index2 = 0;
//        List<Integer> mergedSortedArray = new ArrayList<>();
//        while (index1 < sortedList1.size() && index2 < sortedList2.size()) {
//            if(sortedList1.get(index1) <= sortedList2.get(index2)){
//                mergedSortedArray.add(sortedList1.get(index1));
//                index1++;
//            }else {
//                mergedSortedArray.add(sortedList2.get(index2));
//                index2++;
//            }
//        }
//        addRestValueToSortedArray(index1, sortedList1, mergedSortedArray);
//        addRestValueToSortedArray(index2, sortedList2, mergedSortedArray);
//        return mergedSortedArray;
//
//    }
//
//    private static void addRestValueToSortedArray(int index, List<Integer> sortedList, List<Integer> mergedSortedArray) {
//        while (index < sortedList.size()) {
//            mergedSortedArray.add(sortedList.get(index));
//            index++;
//        }
//    }

}
