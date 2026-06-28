package binarytrees;

import binarytrees.ds.BinaryTree;

import java.util.*;

public class FindNodesDistanceK {


    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        ArrayList<Integer> nodeDistanceK = new ArrayList<>();
        findNodesDistanceK(tree, target, k, nodeDistanceK);
        return nodeDistanceK;
    }

    public int findNodesDistanceK(BinaryTree node, int target, int k, ArrayList<Integer> nodeDistanceK) {
        if(node == null) return -1;

        if(node.value == target){
            addSubTreeNodeAtDistanceK(node, 0, k, nodeDistanceK);
            return 1;
        }

        int leftDistance = findNodesDistanceK(node.left, target, k, nodeDistanceK);
        int rightDistance = findNodesDistanceK(node.right, target, k, nodeDistanceK);

        if(leftDistance == k || rightDistance == k){
            nodeDistanceK.add(node.value);
        }

        if(leftDistance != -1){
            addSubTreeNodeAtDistanceK(node.right, leftDistance+1, k, nodeDistanceK);
            return leftDistance+1;
        }

        if(rightDistance != -1){
            addSubTreeNodeAtDistanceK(node.left, rightDistance+1, k, nodeDistanceK);
            return rightDistance+1;
        }
        return -1;
    }

    private void addSubTreeNodeAtDistanceK(BinaryTree node, int distance, int k, ArrayList<Integer> nodeDistanceK) {
        if(node == null) return;

        if(distance == k){
            nodeDistanceK.add(node.value);
        }else {
            addSubTreeNodeAtDistanceK(node.left, distance+1, k, nodeDistanceK);
            addSubTreeNodeAtDistanceK(node.right, distance+1, k, nodeDistanceK);
        }
    }

//    public class BinaryTreeInfo{
//        public BinaryTree tree;
//        public int distance;
//
//        public BinaryTreeInfo(BinaryTree tree, int distance){
//            this.tree = tree;
//            this.distance = distance;
//        }
//    }
//
//
//    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
//        HashMap<Integer, BinaryTree> nodeToParents = new  HashMap<>();
//        populateNodesToParent(tree, nodeToParents, null);
//
//        BinaryTree targetNode = getNodeFromValue(target, tree);
//        return breadthFirstSearchForNodesDistanceK(targetNode, nodeToParents, k);
//    }
//
//    private ArrayList<Integer> breadthFirstSearchForNodesDistanceK(BinaryTree targetNode, HashMap<Integer, BinaryTree> nodeToParents, int k) {
//        ArrayList<Integer> nodeValueList = new ArrayList<>();
//        if(targetNode == null) return nodeValueList;
//
//        Queue<BinaryTreeInfo> queue = new LinkedList<>();
//        queue.add(new BinaryTreeInfo(targetNode, 0));
//
//        HashSet<Integer> seen = new  HashSet<>();
//        seen.add(targetNode.value);
//
//        while (!queue.isEmpty()) {
//            BinaryTreeInfo currentTreeInfo = queue.poll();
//            BinaryTree node =  currentTreeInfo.tree;
//            int distance = currentTreeInfo.distance;
//
//            if(distance == k){
//                nodeValueList.add(node.value);
//            }
//
//            // left child
//            if(node.left != null && !seen.contains(node.left.value)){
//                seen.add(node.left.value);
//                queue.add(new BinaryTreeInfo(node.left, distance+1));
//            }
//
//            // right child
//            if(node.right != null && !seen.contains(node.right.value)){
//                seen.add(node.right.value);
//                queue.add(new BinaryTreeInfo(node.right, distance+1));
//            }
//
//            // parent
//            BinaryTree parent = nodeToParents.get(node.value);
//            if(parent != null && !seen.contains(parent.value)){
//                seen.add(parent.value);
//                queue.add(new BinaryTreeInfo(parent, distance+1));
//            }
//        }
//
//        return nodeValueList;
//    }
//
//    private BinaryTree getNodeFromValue(int target, BinaryTree tree) {
//        if (tree == null) return null;
//
//        if (tree.value == target) return tree;
//        BinaryTree left = getNodeFromValue(target, tree.left);
//        if(left != null) return left;
//        return getNodeFromValue(target, tree.right);
//    }
//
//    private void populateNodesToParent(BinaryTree tree, HashMap<Integer, BinaryTree> nodeToParents, BinaryTree parent) {
//        if(tree == null) return;
//
//        nodeToParents.put(tree.value, parent);
//        populateNodesToParent(tree.left, nodeToParents, tree);
//        populateNodesToParent(tree.right, nodeToParents, tree);
//    }


}
