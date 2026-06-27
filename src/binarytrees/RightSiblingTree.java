package binarytrees;

import binarytrees.ds.BinaryTree;

public class RightSiblingTree {

    public static BinaryTree rightSiblingTree(BinaryTree root) {
        mutate(root, null, false);
        return root;
    }

    private static void mutate(BinaryTree root, BinaryTree parent, boolean isLeftChild) {
        if(root == null)  return;

        BinaryTree leftChild =  root.left;
        BinaryTree rightChild = root.right;

        mutate(leftChild, root, true);

        if(parent == null){
            root.right = null;
        }else if(isLeftChild){
            root.right = parent.right;
        }else{
            if(parent.right == null){
                root.right = null;
            }else {
                root.right = parent.right.left;
            }
        }

        mutate(rightChild, root, false);
    }

}
