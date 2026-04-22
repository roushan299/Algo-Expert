package binarysearchtrees;

import binarytrees.ds.BinaryTree;

public class SumBsts {

    static class TreeInfo {
        boolean isBSt;
        int minValue;
        int maxValue;
        int bstSum;
        int bstSize;
        int totalSum;

        public TreeInfo(boolean isBSt, int minValue, int maxValue, int bstSum, int bstSize, int totalSum) {
            this.isBSt = isBSt;
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.bstSum = bstSum;
            this.bstSize = bstSize;
            this.totalSum = totalSum;
        }
    }

    public int sumBsts(BinaryTree tree) {
        TreeInfo bstInfo = getTreeInfo(tree);
        return bstInfo.totalSum;
    }

    private TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 0, 0);
        }

        TreeInfo left = getTreeInfo(tree.left);
        TreeInfo right = getTreeInfo(tree.right);

        boolean satisfiesBstProps =
                tree.value > left.maxValue && tree.value <= right.minValue;

        boolean isBst = satisfiesBstProps && left.isBSt && right.isBSt;

        int minValue = Math.min(tree.value, Math.min(left.minValue, right.minValue));
        int maxValue = Math.max(tree.value, Math.max(left.maxValue, right.maxValue));

        int bstSum = 0;
        int bstSize = 0;
        int totalSum = left.totalSum + right.totalSum;

        if (isBst) {
            bstSum = left.bstSum + right.bstSum + tree.value;
            bstSize = left.bstSize + right.bstSize + 1;

            if (bstSize >= 3) {
                totalSum = bstSum;
            }
        }

        return new TreeInfo(isBst, minValue, maxValue, bstSum, bstSize, totalSum);
    }
}
