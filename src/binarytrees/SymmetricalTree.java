package binarytrees;

import binarytrees.ds.BinaryTree;

public class SymmetricalTree {
    public boolean symmetricalTree(BinaryTree tree) {
      if(tree==null) return true;
      return isMirror(tree.left, tree.right);
    }
    public boolean isMirror(BinaryTree left, BinaryTree right) {
        if(left==null && right==null) return true;
        if(left==null || right==null) return false;
        if(left.value != right.value) return false;
        return isMirror(left.left, right.right) &&  isMirror(left.right, right.left);
    }

}
