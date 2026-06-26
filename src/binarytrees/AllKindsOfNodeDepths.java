package binarytrees;

import binarytrees.ds.BinaryTree;

import java.util.HashMap;

public class AllKindsOfNodeDepths {

    public static class BinaryTreeInfo{
      public int numNodesInTree;
      public int sumOfDepths;
      public int sumOfAllDepths;

      public BinaryTreeInfo(int numNodesInTree, int sumOfDepths, int sumOfAllDepths) {
          this.numNodesInTree = numNodesInTree;
          this.sumOfDepths = sumOfDepths;
          this.sumOfAllDepths = sumOfAllDepths;
      }

    }

    public static int allKindsOfNodeDepths(BinaryTree root){
        return getTreeInfo(root).sumOfAllDepths;
    }

    private static BinaryTreeInfo getTreeInfo(BinaryTree root) {
        if(root == null) return new BinaryTreeInfo(0,0,0);

        BinaryTreeInfo leftTreeInfo = getTreeInfo(root.left);
        BinaryTreeInfo rightTreeInfo = getTreeInfo(root.right);

        int sumOfLeftDepth =  leftTreeInfo.sumOfDepths + leftTreeInfo.numNodesInTree;
        int sumOfRightDepth =  rightTreeInfo.sumOfDepths + rightTreeInfo.numNodesInTree;

        int numNodeInTree = leftTreeInfo.numNodesInTree + rightTreeInfo.numNodesInTree + 1;
        int sumOfDepths = sumOfLeftDepth + sumOfRightDepth;
        int sumOfAllDepths = sumOfDepths + leftTreeInfo.sumOfAllDepths + rightTreeInfo.sumOfAllDepths;

        return new BinaryTreeInfo(numNodeInTree, sumOfDepths, sumOfAllDepths);
    }

//    public static int getNodeDepth(BinaryTree root, int depth) {
//        if(root == null) return 0;
//        int leftDepth = getNodeDepth(root.left, depth + 1);
//        int rightDepth = getNodeDepth(root.right, depth + 1);
//        return leftDepth + rightDepth + depth;
//    }
//
//
//    public static int allKindsOfNodeDepths(BinaryTree root) {
//        HashMap<BinaryTree, Integer> nodeCounts = new HashMap<>();
//        HashMap<BinaryTree, Integer> nodeDepths = new HashMap<>();
//
//        addNodeCounts(root, nodeCounts);
//        addNodeDepths(root, nodeDepths, nodeCounts);
//        return sumAllNodesDepths(root, nodeDepths);
//    }
//
//    private static void addNodeCounts(BinaryTree root, HashMap<BinaryTree, Integer> nodeCounts) {
//        nodeCounts.put(root, 1);
//
//        if(root.left != null){
//            addNodeCounts(root.left, nodeCounts);
//            nodeCounts.put(root, nodeCounts.get(root.left) + nodeCounts.get(root));
//        }
//
//        if(root.right != null){
//            addNodeCounts(root.right, nodeCounts);
//            nodeCounts.put(root, nodeCounts.get(root.right) + nodeCounts.get(root));
//        }
//    }
//    private static void addNodeDepths(BinaryTree root, HashMap<BinaryTree, Integer> nodeDepths, HashMap<BinaryTree, Integer> nodeCounts) {
//        nodeDepths.put(root, 0);
//
//        if(root.left != null){
//            addNodeDepths(root.left, nodeDepths, nodeCounts);
//            int totalDepth = nodeDepths.get(root.left) + nodeCounts.get(root.left) + nodeDepths.get(root);
//            nodeDepths.put(root, totalDepth);
//        }
//
//        if(root.right != null){
//            addNodeDepths(root.right, nodeDepths, nodeCounts);
//            int totalDepth = nodeDepths.get(root.right) + nodeCounts.get(root.right) + nodeDepths.get(root);
//            nodeDepths.put(root, totalDepth);
//        }
//    }
//
//    private static int sumAllNodesDepths(BinaryTree root, HashMap<BinaryTree, Integer> nodeDepths) {
//        if(root == null) return 0;
//        int sumOfLeftNodeDepth = sumAllNodesDepths(root.left, nodeDepths);
//        int sumOfRightNodeDepth = sumAllNodesDepths(root.right, nodeDepths);
//        int rootDepth = nodeDepths.get(root);
//        return sumOfLeftNodeDepth + sumOfRightNodeDepth + rootDepth;
//    }
//
//    public static int allKindsOfNodeDepths(BinaryTree root) {
//        int sumOfAllNodeDepths = 0;
//
//        Stack<BinaryTree> stack = new Stack<>();
//        stack.push(root);
//
//        while (!stack.isEmpty()) {
//            BinaryTree current = stack.pop();
//            if (current == null) continue;
//            sumOfAllNodeDepths += getNodeDepth(current, 0);
//            stack.push(current.left);
//            stack.push(current.right);
//        }
//        return sumOfAllNodeDepths;
//    }

//    public static int allKindsOfNodeDepths(BinaryTree root) {
//        if (root == null) return 0;
//        int leftDepthSum = allKindsOfNodeDepths(root.left);
//        int rightDepthSum = allKindsOfNodeDepths(root.right);
//        int rootNodeDepth = getNodeDepth(root, 0);
//        return leftDepthSum + rightDepthSum + rootNodeDepth;
//    }
//


}
