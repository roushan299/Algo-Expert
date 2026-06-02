package linked_list;

import linked_list.ds.LinkedList;

public class LinkedListPalindrome {

    static class LinkedListInfo{
        public boolean outerNodesAreEqual;
        public LinkedList leftNodeToCompare;

        public LinkedListInfo(boolean outerNodesEqual, LinkedList leftNodeToCompare){
            this.outerNodesAreEqual = outerNodesEqual;
            this.leftNodeToCompare = leftNodeToCompare;
        }
    }

//    public boolean linkedListPalindrome(LinkedList head) {
//        LinkedListInfo isPalindromeResults = isPalindrome(head, head);
//        return isPalindromeResults.outerNodesAreEqual;
//    }
//
//
//    private LinkedListInfo isPalindrome(LinkedList leftNode, LinkedList rightNode){
//
//        if(rightNode == null){
//            return new LinkedListInfo(true, leftNode);
//        }
//
//        LinkedListInfo recursiveCallResults = isPalindrome(leftNode, rightNode.next);
//        LinkedList leftNodeToCompare = recursiveCallResults.leftNodeToCompare;
//        boolean outerNodesAreEqual = recursiveCallResults.outerNodesAreEqual;
//
//        boolean recursiveCallResultIsEqual = outerNodesAreEqual && leftNodeToCompare.value == rightNode.value;
//        LinkedList nextNodeToCompare = leftNodeToCompare.next;
//        return new  LinkedListInfo(recursiveCallResultIsEqual, nextNodeToCompare);
//    }


    public boolean linkedListPalindrome(LinkedList head) {
        LinkedList middleNode = getMiddleNode(head);
        LinkedList reversedSecondHalfNode = reverseLinkedList(middleNode);
        LinkedList firstHalfNode = head;

        while (reversedSecondHalfNode != null) {
            if(reversedSecondHalfNode.value != firstHalfNode.value) {
                return false;
            }
            reversedSecondHalfNode = reversedSecondHalfNode.next;
            firstHalfNode = firstHalfNode.next;
        }
        return true;
    }

    private LinkedList reverseLinkedList(LinkedList node){
        if(node == null || node.next == null) return node;
        LinkedList reversedNode = reverseLinkedList(node.next);
        node.next.next = node;
        node.next = null;
        return reversedNode;
    }

    private LinkedList getMiddleNode(LinkedList head) {
        LinkedList fast = head;
        LinkedList slow = head;

        while (fast !=  null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


}
