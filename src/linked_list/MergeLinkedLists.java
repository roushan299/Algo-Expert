package linked_list;

import linked_list.ds.LinkedList;

public class MergeLinkedLists {


    private static boolean isNUll(LinkedList head) {
        return head == null;
    }

    public static LinkedList mergeLinkedLists( LinkedList headOne, LinkedList headTwo) {
        if(isNUll(headOne)) return headTwo;
        if(isNUll(headTwo)) return headOne;

        if(headOne.value <= headTwo.value) {
            headOne.next = mergeLinkedLists(headOne.next, headTwo);
            return headOne;
        }else {
            headTwo.next = mergeLinkedLists(headOne, headTwo.next);
            return headTwo;
        }
    }




    /* in place time complexity o(max (m, n)) and space complexity (1)
    public static LinkedList mergeLinkedLists( LinkedList headOne, LinkedList headTwo) {
            if(isNUll(headOne)) return headTwo;
            if(isNUll(headTwo)) return headOne;

            if(headOne.value > headTwo.value) {
                LinkedList temp = headOne;
                headOne = headTwo;
                headTwo = temp;
            }

            LinkedList head = headOne;

            while (!isNUll(head) && !isNUll(headTwo)) {
                LinkedList prev = null;

                while (!isNUll(headOne) && headOne.value <= headTwo.value) {
                    prev = headOne;
                    headOne = headOne.next;
                }
                prev.next = headTwo;

                LinkedList temp = headOne;
                headOne = headTwo;
                headTwo = temp;
            }
            return head;
    }
     */


   /*
     Iterative way time complexity o(max(m, n)) and space complexity o(m+n)
   public static LinkedList mergeLinkedLists( LinkedList headOne, LinkedList headTwo) {
        LinkedList head = new LinkedList(-1);
        LinkedList tail = head;

        while (headOne != null && headTwo != null) {
            if(headOne.value <= headTwo.value) {
               tail.next = headOne;
               headOne = headOne.next;
            }else{
                tail.next = headTwo;
                headTwo = headTwo.next;
            }
            tail = tail.next;
        }

        if(headOne != null) {
            tail.next = headOne;
        }else {
            tail.next = headTwo;
        }
        return head.next;
    }

    */
}
