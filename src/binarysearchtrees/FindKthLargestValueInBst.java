package binarysearchtrees;


import binarysearchtrees.ds.BST;

import java.util.ArrayList;
import java.util.List;

public class FindKthLargestValueInBst {

    static class Counter{
        int count = 0;
        int result = -1;
        
    }

    public int findKthLargestValueInBst(BST tree, int k) {
        Counter counter = new Counter();
        traverse(tree, k, counter);
        return counter.result;
    }

    private void traverse(BST tree, int k, Counter counter) {
        if(tree == null || counter.count >= k)return ;

        traverse(tree.right, k, counter);
        counter.count++;

        if(counter.count == k){
            counter.result = tree.value;
            return;
        }
        traverse(tree.left, k, counter);
    }


//    public int findKthLargestValueInBst(BST tree, int k) {
//        List<Integer> list = new ArrayList<>();
//        getInorder(tree, list);
//        int step =list.get(list.size()-k);
//        return step;
//    }
//
//    private void getInorder(BST tree, List<Integer> list) {
//        if(tree == null) return;
//        getInorder(tree.left, list);
//        list.add(tree.value);
//        getInorder(tree.right, list);
//    }







}
