package linked_list;

import linked_list.ds.LinkedList;

public class ZipLinkedList {

    public LinkedList zipLinkedList(LinkedList linkedList) {
        if(isNull(linkedList) || isNull(linkedList.next)) return linkedList;
        LinkedList firstHalfHead = linkedList;
        LinkedList secondHalfHead = splitLinkedList(linkedList);
        LinkedList reversedSecondHalfHead = reverseLinkedList(secondHalfHead);
        return interWeaveLinkedList(firstHalfHead, reversedSecondHalfHead);
    }

    private LinkedList splitLinkedList(LinkedList linkedList) {
        LinkedList slow = linkedList;
        LinkedList fast = linkedList;

        while (!isNull(fast) && !isNull(fast.next)) {
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkedList secondHalfHead = slow.next;
        slow.next = null;
        return secondHalfHead;
    }

    private LinkedList reverseLinkedList(LinkedList head) {
        if(isNull(head) || isNull(head.next)) return head;
        LinkedList reversedHead = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return reversedHead;
    }
    private LinkedList interWeaveLinkedList(LinkedList head, LinkedList reversedHead) {
        LinkedList linkedList1Iterator = head;
        LinkedList linkedList2Iterator = reversedHead;

        while (!isNull(linkedList2Iterator)){
            LinkedList linkedList1IteratorNext = linkedList1Iterator.next;
            LinkedList linkedList2IteratorNext = linkedList2Iterator.next;

            linkedList1Iterator.next = linkedList2Iterator;
            linkedList2Iterator.next = linkedList1IteratorNext;

            linkedList1Iterator = linkedList1IteratorNext;
            linkedList2Iterator = linkedList2IteratorNext;
        }
        return head;
    }

    private boolean isNull(LinkedList head) {
        return head == null;
    }


}
