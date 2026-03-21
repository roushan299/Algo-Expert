package binarytrees;

import binarytrees.ds.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class FindSuccessor {

    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        if(node.right != null){
            return getLeftMostChild(node.right);
        }
        return getRightMostChild(node);
    }

    private BinaryTree getRightMostChild(BinaryTree node) {
        BinaryTree current = node;

        while(current.parent != null && current.parent.right == current){
            current = current.parent;
        }
        return current.parent;
    }

    private BinaryTree getLeftMostChild(BinaryTree node) {
        BinaryTree current = node;

        while (current.left != null){
            current = current.left;
        }
        return current;
    }


    public BinaryTree findSuccessorInorder(BinaryTree tree, BinaryTree node) {
        List<BinaryTree> nodeList = new ArrayList<>();
        getNodeList(tree, nodeList);

        for(int index = 0; index < nodeList.size(); index++) {
            if(nodeList.get(index).equals(node) && index < nodeList.size() - 1) {
                return nodeList.get(index+1);
            }
        }
        return null;
    }

    private void getNodeList(BinaryTree tree, List<BinaryTree> nodeList) {
        if(tree==null) return;
        getNodeList(tree.left, nodeList);
        nodeList.add(tree);
        getNodeList(tree.right, nodeList);
    }


}
