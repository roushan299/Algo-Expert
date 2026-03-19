package linked_list;

import linked_list.ds.Node;


public  class DoublyLinkedList {

    public Node head;
    public Node tail;

    private boolean isSingleNode(Node node){
        return node == head && node == tail;
    }

    private void connect(Node left, Node right){
        if(left != null) left.next = right;
        if(right != null) right.prev = left;
    }

    public void setHead(Node node) {
        if(head == null){
            head = tail = node;
            return;
        }
        insertBefore(head, node);
    }

    public void setTail(Node node) {
        if(tail == null){
            setHead(node);
            return;
        }
        insertAfter(tail, node);
    }

    public void insertBefore(Node node, Node nodeToInsert) {
        if(isSingleNode(nodeToInsert))  return;

        remove(nodeToInsert);

        Node prev = node.prev;
        connect(prev, nodeToInsert);
        connect(nodeToInsert, node);

        if(node == head) head = nodeToInsert;

    }

    public void insertAfter(Node node, Node nodeToInsert) {
        if(isSingleNode(nodeToInsert))  return;
        remove(nodeToInsert);
        Node next = node.next;
        connect(node, nodeToInsert);
        connect(nodeToInsert, next);
        if(node == tail) tail = nodeToInsert;
    }

    public void insertAtPosition(int position, Node nodeToInsert) {
        if(position == 1){
            setHead(nodeToInsert);
            return;
        }

        Node current = head;
        int index = 1;

        while(current != null && index < position){
            current = current.next;
            index++;
        }

        if(current == null){
            setTail(nodeToInsert);
        }else {
            insertBefore(current, nodeToInsert);
        }
    }

    public void removeNodesWithValue(int value) {
        Node current = head;
        while(current != null){
            Node next = current.next;
            if(value == current.value){
                remove(current);
            }
            current = next;
        }
    }


    public void remove(Node node) {
        if(node == null) return;

        if(node == head) head = head.next;
        if(node == tail) tail = tail.prev;

        connect(node.prev, node.next);
        node.next = null;
        node.prev = null;
    }

    public boolean containsNodeWithValue(int value) {
        Node current = head;

        while(current != null){
            if(value == current.value) return true;
            current = current.next;
        }
        return false;
    }
}
