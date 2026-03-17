package linked_list;

import linked_list.ds.LinkedList;

public class SumOfLinkedLists {

    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList dummyHead = new LinkedList(0);
        LinkedList current = dummyHead;

        int carry = 0;

        while (!isEnd(linkedListOne) || !isEnd(linkedListTwo) || carry != 0) {
            int valueOne = getValue(linkedListOne);
            int valueTwo = getValue(linkedListTwo);

            int sum = valueOne + valueTwo + carry;
            int digit = getDigit(sum);
            carry = getCarry(sum);

            current = appendNode(current, digit);
            linkedListOne = moveNext(linkedListOne);
            linkedListTwo = moveNext(linkedListTwo);

        }
        return dummyHead.next;
    }

    private LinkedList moveNext(LinkedList node) {
        return node == null ? null : node.next;
    }

    private int getValue(LinkedList node) {
        return node == null ? 0 : node.value;
    }

    private int getDigit(int sum) {
        return sum % 10;
    }

    private int getCarry(int sum) {
        return sum / 10;
    }

    private LinkedList appendNode(LinkedList node, int value) {
        node.next = new LinkedList(value);
        return node.next;
    }

    private boolean isEnd(LinkedList node){
        return node == null;
    }
}
