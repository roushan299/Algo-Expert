package binarytrees;

import binarytrees.ds.BinaryTree;
import java.util.function.Function;

public class IterativeInOrderTraversal {


    public static void iterativeInOrderTraversal(BinaryTree tree, Function<BinaryTree, Void> callback) {
        BinaryTree previousNode = null;
        BinaryTree currentNode = tree;

        while (currentNode != null) {
            BinaryTree nextNode  = null;
            if(previousNode == null || previousNode == currentNode.parent){
                if(currentNode.left != null){
                    nextNode = currentNode.left;
                }else {
                    callback.apply(currentNode);
                    nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;
                }
            }else if (previousNode == currentNode.left){
                callback.apply(currentNode);
                nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;
            }else {
                nextNode = currentNode.parent;
            }

            previousNode = currentNode;
            currentNode = nextNode;
        }
    }

}
