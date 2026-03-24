package binarysearchtrees;

import binarysearchtrees.ds.BST;
import java.util.ArrayList;

public class ReconstructBst {

    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        return reconstructBst(preOrderTraversalValues, new int[]{0}, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private BST reconstructBst(ArrayList<Integer> preOrderTraversalValues, int[] index, int lowerBound, int upperBound) {
        if(index[0] >= preOrderTraversalValues.size()) return null;

        int rootValue = preOrderTraversalValues.get(index[0]);
        if(lowerBound > rootValue || upperBound <= rootValue) return null;

        index[0]++;
        BST root =  new BST(rootValue);

        root.left = reconstructBst(preOrderTraversalValues, index, lowerBound, rootValue);
        root.right = reconstructBst(preOrderTraversalValues, index, rootValue, upperBound);
        return root;
    }


//    time = o(n^2) and space = o(h)
//    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
//        return reconstructBst(preOrderTraversalValues, 0, preOrderTraversalValues.size() - 1);
//    }
//
//    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues, int start, int end) {
//        if(start > end) return null;
//
//        int rootValue = preOrderTraversalValues.get(start);
//        BST root = new BST(rootValue);
//        int leftStart =  start+1;
//        int rightEnd = end;
//
//        int mid = leftStart;
//
//        while (mid <= rightEnd && rootValue > preOrderTraversalValues.get(mid)) {
//            mid++;
//        }
//        int rightStart = mid;
//        int leftEnd = mid-1;
//        root.left = reconstructBst(preOrderTraversalValues, leftStart, leftEnd);
//        root.right = reconstructBst(preOrderTraversalValues, rightStart, rightEnd);
//        return root;
//    }
}
