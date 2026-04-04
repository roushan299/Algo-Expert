package binarytrees;

import binarytrees.ds.BinaryTree;


public class MaxPathSumQuestion {

    static class MaxPathSum{
        int maxSumBranch = 0;
        int maxSum = 0;

        public MaxPathSum(int maxSumBranch, int maxSum){
            this.maxSumBranch = maxSumBranch;
            this.maxSum = maxSum;
        }
    }


    public static int maxPathSum(BinaryTree tree) {
        return maxPathSumHelper(tree).maxSum;
    }

    public static MaxPathSum maxPathSumHelper(BinaryTree tree){
        if(tree == null){
            return new MaxPathSum(0, Integer.MIN_VALUE);
        }

        MaxPathSum maxPathSumLeft = maxPathSumHelper(tree.left);
        MaxPathSum maxPathSumRight = maxPathSumHelper(tree.right);

        int maxChildSumAsBranch = Math.max(maxPathSumLeft.maxSumBranch, maxPathSumRight.maxSumBranch);
        int value = tree.value;
        int maxSumAsBranch = Math.max(maxChildSumAsBranch+value, value);
        int maxSumAsRootNode = Math.max(maxPathSumLeft.maxSumBranch + maxPathSumRight.maxSumBranch + value, maxSumAsBranch);
        int maxPathSum = Math.max(maxSumAsRootNode, Math.max(maxPathSumLeft.maxSum, maxPathSumRight.maxSum));
        return new MaxPathSum(maxSumAsBranch, maxPathSum);
    }

}
