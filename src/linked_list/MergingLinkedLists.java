package linked_list;

import linked_list.ds.LinkedList;

import java.util.HashSet;

public class MergingLinkedLists {

    public LinkedList mergingLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList currentNodeOne = linkedListOne;
        LinkedList currentNodeTwo = linkedListTwo;

        while(currentNodeOne != currentNodeTwo){

            if(currentNodeOne == null){
                currentNodeOne = linkedListOne;
            }else{
                currentNodeOne = currentNodeOne.next;
            }

            if(currentNodeTwo == null){
                currentNodeTwo = linkedListTwo;
            }else {
                currentNodeTwo = currentNodeTwo.next;
            }
        }
        return currentNodeOne;
    }
}
