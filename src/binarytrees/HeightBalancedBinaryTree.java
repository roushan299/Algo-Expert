package binarytrees;

import binarytrees.ds.BinaryTree;

public class HeightBalancedBinaryTree {

    static class Balance{
        public int height;
        public boolean isBalanced;
        public Balance(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
     return checkBalance(tree).isBalanced;
    }

    private Balance checkBalance(BinaryTree tree) {
        if(tree == null) return baseCase();
        Balance left = checkBalance(tree.left);
        Balance right = checkBalance(tree.right);

        int height = computeHeight(left, right);
        boolean isBalanced = isNodeBalanced(left, right);
        return new Balance(height, isBalanced);
    }

    private boolean isNodeBalanced(Balance left, Balance right) {
        return  left.isBalanced &&
                right.isBalanced &&
                Math.abs(left.height - right.height) <= 1;
    }

    private int computeHeight(Balance left, Balance right) {
        return Math.max(left.height, right.height)+1;
    }

    private Balance baseCase() {
        return new Balance(0, true);
    }
}
