package binarysearchtrees;

import binarysearchtrees.ds.BST;

public class FindClosestValueInBST {
    public static int findClosestValueInBst(BST tree, int target) {
        return findClosestValueInBstHelper(tree, target, tree.value);
    }

    private static int findClosestValueInBstHelper(BST tree, int target, int closest) {
        if(tree == null){
            return closest;
        }

        if(Math.abs(target - tree.value) < Math.abs(target - closest)){
            closest = tree.value;
        }

        if(target < tree.value){
            return findClosestValueInBstHelper(tree.left, target, closest);
        } else if (target > tree.value) {
            return findClosestValueInBstHelper(tree.right, target, closest);
        }else {
            return closest;
        }
    }


}
