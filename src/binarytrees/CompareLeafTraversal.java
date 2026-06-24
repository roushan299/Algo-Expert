package binarytrees;

import binarytrees.ds.BinaryTree;
import java.util.ArrayList;
import java.util.Stack;

public class CompareLeafTraversal {


    public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
        BinaryTree[] tree1Head = new  BinaryTree[1];
        BinaryTree[] tree1Tail = new  BinaryTree[1];

        BinaryTree[] tree2Head = new  BinaryTree[1];
        BinaryTree[] tree2Tail = new  BinaryTree[1];

        connectLeafNodes(tree1, tree1Head, tree1Tail);
        connectLeafNodes(tree2, tree2Head, tree2Tail);

        BinaryTree current1 = tree1Head[0];
        BinaryTree current2 = tree2Head[0];

        while (current1 != null && current2 != null) {

            if(current1.value != current2.value) return false;
            current1 = current1.right;
            current2 = current2.right;
        }

        return current1 == null && current2 == null;
    }

    private void connectLeafNodes(BinaryTree currentNode, BinaryTree[] head, BinaryTree[] tail) {
        if(currentNode == null) return;

        // leaf node found
        if(isLeafNode(currentNode)){

            if(head[0] == null){
                head[0] = currentNode;
            }else {
                tail[0].right = currentNode;
            }
            tail[0] = currentNode;
            return;
        }
        connectLeafNodes(currentNode.left, head, tail);
        connectLeafNodes(currentNode.right, head, tail);
    }


    private boolean isLeafNode(BinaryTree node){
        return node.left == null && node.right == null;
    }

//    public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
//        Stack<BinaryTree> tree1TraversalStack = getTreeTraversalStack(tree1);
//        Stack<BinaryTree> tree2TraversalStack = getTreeTraversalStack(tree2);
//
//        while (!tree1TraversalStack.isEmpty() && !tree2TraversalStack.isEmpty()) {
//            BinaryTree tree1Leaf = getNextLeafNode(tree1TraversalStack);
//            BinaryTree tree2Leaf = getNextLeafNode(tree2TraversalStack);
//
//            if(tree1Leaf.value != tree2Leaf.value) return false;
//        }
//        return tree1TraversalStack.isEmpty() && tree2TraversalStack.isEmpty();
//    }
//
//    private BinaryTree getNextLeafNode(Stack<BinaryTree> treeTraversalStack) {
//        BinaryTree currentNode = treeTraversalStack.pop();
//
//        while (!isLeafNode(currentNode)){
//            if(currentNode.right != null) treeTraversalStack.push(currentNode.right);
//            if(currentNode.left != null) treeTraversalStack.push(currentNode.left);
//            currentNode = treeTraversalStack.pop();
//        }
//        return currentNode;
//    }
//
//    private boolean isLeafNode(BinaryTree node) {
//        return node.left == null && node.right == null;
//    }
//
//    private Stack<BinaryTree> getTreeTraversalStack(BinaryTree tree) {
//        Stack<BinaryTree> stack = new Stack<>();
//        stack.push(tree);
//        return stack;
//    }


//    public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
//        ArrayList<Integer> list1 = new ArrayList<>();
//        ArrayList<Integer> list2 = new ArrayList<>();
//        getLeafNodeValue(tree1, list1);
//        getLeafNodeValue(tree2, list2);
//        return compareList(list1, list2);
//    }
//
//    private boolean compareList(ArrayList<Integer> list1, ArrayList<Integer> list2) {
//        boolean flag;
//        flag = list1.size() == list2.size();
//
//        for(int i = 0; i < list1.size(); i++){
//            if(!list1.get(i).equals(list2.get(i))){
//                flag = false;
//                break;
//            }
//        }
//        return flag;
//    }
//
//    private void getLeafNodeValue(BinaryTree tree, ArrayList<Integer> list) {
//        if(tree==null) return;
//        if(tree.left == null && tree.right == null) list.add(tree.value);
//        getLeafNodeValue(tree.left, list);
//        getLeafNodeValue(tree.right, list);
//    }
}
