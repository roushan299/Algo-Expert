package linkedList;


import linkedList.impl.LinkedList;

public class MiddleNode {
    public LinkedList middleNode(LinkedList linkedList) {
        LinkedList fast = linkedList;
        LinkedList slow = linkedList;

        while (fast != null && slow != null && slow.next != null){
            fast = fast.next;
            slow = slow.next.next;
        }
        return fast;
    }
}
