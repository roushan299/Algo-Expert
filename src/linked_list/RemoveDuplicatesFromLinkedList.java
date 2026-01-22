package linked_list;

import linked_list.ds.LinkedList;

public class RemoveDuplicatesFromLinkedList {

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
       if(linkedList == null) {
           return null;
       }
       LinkedList previous = linkedList;
       LinkedList current = linkedList.next;

       while(current != null) {

           if(isDuplicate(previous, current)){
               removeCurrent(previous, current);
               current = previous.next;
           }else {
               previous = moveForward(previous);
               current = moveForward(current);
           }
       }
       return linkedList;
    }

    private LinkedList moveForward(LinkedList node) {
        return node.next;
    }

    private void removeCurrent(LinkedList previous, LinkedList current) {
        previous.next = current.next;
    }

    private boolean isDuplicate(LinkedList previous, LinkedList current) {
        return previous.value == current.value;
    }


}
