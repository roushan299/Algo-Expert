package linkedList;

import linkedList.impl.LinkedList;

public class RemoveDuplicates {
    public LinkedList removeDuplicatesFromLinkedList( LinkedList linkedList) {
       LinkedList temp = linkedList;

       while ( temp != null && temp.next != null){
           if(temp.value == temp.next.value){
               temp.next = temp.next.next;
           }else {
               temp = temp.next;
           }
       }
       return linkedList;
    }
}
