package binarytrees;

import binarytrees.ds.BinaryTree;

public class InvertBinaryTree {
    public static void invertBinaryTree(BinaryTree tree) {
        if(tree == null) return;
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
        swapNode(tree);
    }

    private static void swapNode(BinaryTree tree) {
        BinaryTree temp = tree.right;
        tree.right = tree.left;
        tree.left = temp;
    }

}
