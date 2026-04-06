package linked_list;

import linked_list.ds.LinkedList;

public class FindLoop {

    public static LinkedList findLoop(LinkedList head) {

        LinkedList slow = head;
        LinkedList fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow) break;
        }

       if(fast == null || fast.next == null) return null;
        slow = head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }


}
