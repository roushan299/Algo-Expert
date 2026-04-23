package binarysearchtrees;

import binarysearchtrees.ds.BST;

import java.util.Stack;

public class RepairBst {


    private BST repairBst(BST tree) {
        BST nodeOne = null;
        BST nodeTwo = null;
        BST previousNode = null;

        Stack<BST> stack = new Stack<>();
        BST currentNode = tree;
        while (currentNode != null || !stack.isEmpty()) {

            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = stack.pop();

            if(previousNode != null && previousNode.value > currentNode.value) {
                if(nodeOne == null) {
                    nodeOne = previousNode;
                }
                nodeTwo = currentNode;
            }
            previousNode = currentNode;
            currentNode = currentNode.right;
        }

        if(nodeOne != null && nodeTwo != null) {
            int temp = nodeOne.value;
            nodeOne.value = nodeTwo.value;
            nodeTwo.value = temp;
        }

        return tree;
    }

//    BST nodeOne = null;
//    BST nodeTwo = null;
//    BST previousNode = null;
//
//    public BST repairBst(BST tree) {
//        inOrderTraversal(tree);
//
//        if(nodeOne != null && nodeTwo != null) {
//            int temp = nodeOne.value;
//            nodeOne.value = nodeTwo.value;
//            nodeTwo.value = temp;
//        }
//        return tree;
//    }
//
//    private void inOrderTraversal(BST tree) {
//        if(tree == null) return;
//        inOrderTraversal(tree.left);
//
//        if(previousNode != null && previousNode.value > tree.value) {
//            if(nodeOne == null){
//                nodeOne = previousNode;
//            }
//            nodeTwo = tree;
//        }
//        previousNode = tree;
//        inOrderTraversal(tree.right);
//    }

}
