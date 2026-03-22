package binarytrees;

import binarytrees.ds.BinaryTree;

public class MergeBinaryTrees {


    public BinaryTree mergeBinaryTrees(BinaryTree tree1, BinaryTree tree2) {
        if(tree1 == null) return tree2;
        if(tree2 == null) return tree1;
        tree1.value = tree1.value + tree2.value;
        tree1.left = mergeBinaryTrees(tree1.left, tree2.left);
        tree1.right = mergeBinaryTrees(tree1.right, tree2.right);
        return tree1;
    }

    /**

    public BinaryTree mergeBinaryTrees(BinaryTree tree1, BinaryTree tree2) {
        if(tree1 == null) return tree2;
        if(tree2 == null) return tree1;

        BinaryTree leftMergedTree = mergeBinaryTrees(tree1.left, tree2.left);
        BinaryTree rightMergedTree = mergeBinaryTrees(tree1.right, tree2.right);
        int rootValue = getValue(tree1) + getValue(tree2);
        BinaryTree root = new BinaryTree(rootValue);
        root.left = leftMergedTree;
        root.right = rightMergedTree;
        return root;
    }


    private int getValue(BinaryTree tree) {
        return tree == null ? 0 : tree.value;
    }
     */
}
