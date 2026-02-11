package binarytrees;

import binarytrees.ds.BinaryTree;

public class EvaluateExpressionTree {
    public int evaluateExpressionTree(BinaryTree tree) {
        if(tree==null) return 0;

        if(isLeafNode(tree)) return tree.value;
        int leftVal = evaluateExpressionTree(tree.left);
        int rightVal = evaluateExpressionTree(tree.right);
        return evaluate(tree.value, leftVal, rightVal);
    }

    private int evaluate(int expression, int value1, int value2) {

        switch (expression) {
            case -1: return value1 + value2;
            case -2: return value1 - value2;
            case -3: return value1 / value2;
            case -4: return value1 * value2;
            default: throw new IllegalArgumentException("Illegal expression");
        }
    }

    private boolean isLeafNode(BinaryTree tree) {
        return tree.left == null && tree.right == null;
    }

}
