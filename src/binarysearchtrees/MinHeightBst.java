package binarysearchtrees;

import java.util.List;

public class MinHeightBst {

    public static BST minHeightBst(List<Integer> array) {
        BST bst = constructMinHeightBST(array, 0, array.size()-1);
        return bst;
    }

    private static BST constructMinHeightBST(List<Integer> array, int start, int end) {
        if(start > end) return null;

        int mid = (start + end)/2;
        int valueToAdd = array.get(mid);
        BST  bst = new BST(valueToAdd);
        bst.left = constructMinHeightBST(array, start, mid-1);
        bst.right =constructMinHeightBST(array, mid+1, end);
        return bst;
    }


    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}
