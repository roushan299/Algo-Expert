package linked_list;

import linked_list.ds.LinkedList;

public class NodeSwap {


    public LinkedList nodeSwap(LinkedList head) {
        if(head == null || head.next == null) return head;

        LinkedList dummyHead = new LinkedList(-1);
        dummyHead.next = head;

        LinkedList prev = dummyHead;

        while (prev.next != null && prev.next.next != null) {

            // move to the nodes
            LinkedList first = prev.next;
            LinkedList second = prev.next.next;

            // swaping
            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first;
        }

        return dummyHead.next;
    }

//    public LinkedList nodeSwap(LinkedList head) {
//        if(head == null || head.next == null) return head;
//
//        LinkedList first = head;
//        LinkedList second = head.next;
//
//        head.next = nodeSwap(head.next.next);
//        second.next = first;
//        return second;
//    }


}
