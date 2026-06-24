package binarytrees;

import binarytrees.ds.BinaryTree;

public class FlattenBinaryTree {

    public static class BinaryTreeInfo{
        BinaryTree leftMost;
        BinaryTree rightMost;

        public BinaryTreeInfo(BinaryTree leftMost, BinaryTree rightMost) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
        }
    }

    public static BinaryTree flattenBinaryTree(BinaryTree binaryTree){
        BinaryTreeInfo treeInfo  = flattenTree(binaryTree);
        return  treeInfo.leftMost;
    }

    private static BinaryTreeInfo flattenTree(BinaryTree node) {
        BinaryTree leftMost  = null;
        BinaryTree rightMost  = null;

        if(node.left == null){
            leftMost = node;
        }else {
            BinaryTreeInfo leftInfo = flattenTree(node.left);
            connectNodes(leftInfo.rightMost, node);
            leftMost = leftInfo.leftMost;
        }

        if(node.right == null){
            rightMost = node;
        }else {
            BinaryTreeInfo rightInfo = flattenTree(node.right);
            connectNodes(node, rightInfo.leftMost);
            rightMost = rightInfo.rightMost;
        }

        return new BinaryTreeInfo(leftMost, rightMost);
    }

    private static void connectNodes(BinaryTree left, BinaryTree right) {
        left.right = right;
        right.left = left;
    }


//    public static BinaryTree flattenBinaryTree(BinaryTree root) {
//        ArrayList<BinaryTree> inOrderValues = new ArrayList<>();
//        getInOrderValue(root, inOrderValues);
//        BinaryTree flattenTreeNode = getFlattenTree(inOrderValues);
//        return flattenTreeNode;
//    }
//
//    private static BinaryTree getFlattenTree(ArrayList<BinaryTree> inOrderValues) {
//        if(inOrderValues.size() == 0) return null;
//
//        for(int index = 0; index < inOrderValues.size()-1; index++){
//            BinaryTree leftNode =  inOrderValues.get(index);
//            BinaryTree rightNode = inOrderValues.get(index+1);
//            leftNode.right = rightNode;
//            rightNode.left = leftNode;
//        }
//        return inOrderValues.get(0);
//    }
//
//    private static void getInOrderValue(BinaryTree root, ArrayList<BinaryTree> inOrderValues) {
//        if(root == null) return;
//        getInOrderValue(root.left, inOrderValues);
//        inOrderValues.add(root);
//        getInOrderValue(root.right, inOrderValues);
//    }


}
