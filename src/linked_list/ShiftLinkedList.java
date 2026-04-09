package linked_list;

import linked_list.ds.LinkedList;

public class ShiftLinkedList {

    static class Result{
        int length;
        LinkedList tail;

        Result(int length, LinkedList tail){
            this.length = length;
            this.tail = tail;
        }
    }

    public static LinkedList shiftLinkedList(LinkedList head, int k) {

        Result result = getLengthAndTailNode(head);
        LinkedList listTail = result.tail;
        int offSet = Math.abs(k) % result.length;

        if(offSet == 0) return head;
        int newTailPosition = k > 0 ? result.length - offSet : offSet;

        LinkedList newTail = head;

        for(int i=1;i<newTailPosition;i++){
            newTail = newTail.next;
        }

        LinkedList newHead = newTail.next;
        newTail.next = null;
        listTail.next = head;
        return newHead;
    }

    private static Result getLengthAndTailNode(LinkedList head) {
        int length = 0;
        LinkedList tail = null;
        LinkedList temp = head;
        while (!isNull(temp)) {
            length++;
            tail = temp;
            temp = temp.next;
        }
        return new  Result(length, tail);
    }

    private static boolean isNull(LinkedList head) {
        return head == null;
    }
}
