package linked_list;

import linked_list.ds.LinkedList;

public class ReverseLinkedList {
    public static LinkedList reverseLinkedList(LinkedList head) {
        if(head == null || head.next == null) return head;

        LinkedList reversedLinkedListHead = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return reversedLinkedListHead;
    }
}
