package binarytrees;

import binarytrees.ds.BinaryTree;

public class SplitBinaryTree {

    static class SplitValue{
        public int sum;
        public boolean isSplit;
        public SplitValue(int sum, boolean isSplit) {
            this.sum = sum;
            this.isSplit = isSplit;
        }
    }

    public int splitBinaryTree(BinaryTree tree) {
        int totalSum = getTreeSum(tree);

        if(totalSum%2 != 0) return 0;
        int target = totalSum/2;
        boolean canBeSplit = trySubTrees(tree, target, true).isSplit;
        return canBeSplit ? target : 0;
    }

    private SplitValue trySubTrees(BinaryTree tree, int target, boolean isRoot) {
        if(tree == null) return new SplitValue(0, false);

        SplitValue leftSplitValue = trySubTrees(tree.left, target, false);
        SplitValue rightSplitValue = trySubTrees(tree.right, target, false);

        int currentSum = tree.value + leftSplitValue.sum + rightSplitValue.sum;
        boolean foundSplit = leftSplitValue.isSplit ||
                rightSplitValue.isSplit ||
                (!isRoot && currentSum == target );
        return new SplitValue(currentSum, foundSplit);
    }

    private int getTreeSum(BinaryTree tree){
        if(tree == null) return 0;
        int leftTreeSum = getTreeSum(tree.left);
        int rightTreeSum = getTreeSum(tree.right);
        return tree.value + leftTreeSum + rightTreeSum;
    }
}
