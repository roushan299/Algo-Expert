package linked_list;

import linked_list.ds.LinkedList;


public class MiddleNode {
    public LinkedList middleNode(LinkedList linkedList) {
       if(isEmpty(linkedList)){
           return linkedList;
       }
       LinkedList slow = linkedList;
       LinkedList fast = linkedList;

       while(canAdvanceFast(fast)){
           slow = advanceOne(slow);
           fast = advanceTwo(fast);
       }
       return slow;
    }

    private LinkedList advanceTwo(LinkedList node) {
        return node.next.next;
    }

    private LinkedList advanceOne(LinkedList node) {
        return  node.next;
    }

    private boolean canAdvanceFast(LinkedList node) {
        return node != null && node.next != null;
    }

    public boolean isEmpty(LinkedList linkedList){
        return linkedList == null;
    }
}
