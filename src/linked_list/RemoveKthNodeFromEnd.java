package linked_list;

import linked_list.ds.LinkedList;

public class RemoveKthNodeFromEnd {
    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        LinkedList second = moveKStepsAhead(head, k);

        if(second == null){
            removeHead(head);
            return;
        }

        LinkedList first = moveBothPointers(head, second);
        deleteNode(first);
    }

    private static void deleteNode(LinkedList node) {
        node.next = node.next.next;
    }

    private static LinkedList moveBothPointers(LinkedList first, LinkedList second) {

        while (second.next != null){
            second = second.next;
            first = first.next;
        }
        return first;
    }

    private static void removeHead(LinkedList head) {
        head.value = head.next.value;
        head.next = head.next.next;
    }

    private static LinkedList moveKStepsAhead(LinkedList head, int k) {
        int counter = 1;
        LinkedList current = head;

        while(counter <= k && current != null){
            current = current.next;
            counter++;
        }
        return current;
    }

}
