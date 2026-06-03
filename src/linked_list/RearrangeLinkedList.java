package linked_list;

import linked_list.ds.LinkedList;

public class RearrangeLinkedList {

    public static class LinkedListInfo{
        LinkedList head;
        LinkedList tail;

        public LinkedListInfo(LinkedList head, LinkedList tail){
            this.head = head;
            this.tail = tail;
        }
    }

    public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
        LinkedListInfo smallListInfo = new LinkedListInfo(null, null);
        LinkedListInfo equalListInfo = new LinkedListInfo(null, null);
        LinkedListInfo greaterListInfo = new  LinkedListInfo(null, null);

        LinkedList node = head;

        while (node != null) {

            if(node.value < k){
                // construct smaller
                growLinkedList(smallListInfo, node);
            }else if(node.value > k){
                // construct greater
                growLinkedList(greaterListInfo, node);
            }else {
                // construct equal
                growLinkedList(equalListInfo, node);
            }
            LinkedList prevNode = node;
            node = node.next;
            prevNode.next = null;
        }
        LinkedListInfo firstLinkedListInfo = connectLinkedList(smallListInfo, equalListInfo);
        LinkedListInfo finalLinkedListInfo = connectLinkedList(firstLinkedListInfo, greaterListInfo);
        return finalLinkedListInfo.head;
    }

    private static void growLinkedList(LinkedListInfo linkedListInfo, LinkedList node) {
        LinkedList newHead = linkedListInfo.head;
        LinkedList newTail = node;

        if(newHead == null){
            newHead = node;
        }

        if(linkedListInfo.tail != null){
            linkedListInfo.tail.next = node;
        }
        linkedListInfo.head = newHead;
        linkedListInfo.tail = newTail;
    }


    private static LinkedListInfo connectLinkedList(LinkedListInfo firstLinkedListInfo, LinkedListInfo secondLinkedListInfo) {
        LinkedList newHead = firstLinkedListInfo.head == null ? secondLinkedListInfo.head : firstLinkedListInfo.head;
        LinkedList newTail = secondLinkedListInfo.tail == null ? firstLinkedListInfo.tail : secondLinkedListInfo.tail;

        if(firstLinkedListInfo.tail != null){
            firstLinkedListInfo.tail.next = secondLinkedListInfo.head;
        }

        return new LinkedListInfo(newHead, newTail);
    }

}
