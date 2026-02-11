package binarytrees;

import binarytrees.ds.BinaryTree;

public class NodeDepths {
    public static int nodeDepths(BinaryTree root) {
        return calculateNodeDepths(root, 0);
    }

    private static int calculateNodeDepths(BinaryTree root, int depth) {
        if (root == null) return 0;
        int leftDepth = calculateNodeDepths(root.left, depth + 1);
        int rightDepth = calculateNodeDepths(root.right, depth + 1);
        return depth + leftDepth + rightDepth;
    }
}
