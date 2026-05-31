package linked_list;


import javax.swing.*;
import java.util.HashMap;

public class LRUCacheQuestion {

    static class LRUCache {

        int maxSize;
        private final HashMap<String, Node> cache;

        private Node head;
        private Node tail;

        public LRUCache(int maxSize) {
            this.maxSize = Math.max(1, maxSize);
            this.cache = new HashMap<>();
        }

        public void insertKeyValuePair(String key, int value) {

            // key already exists
            if(cache.containsKey(key)) {
                Node node = cache.get(key);
                node.value = value;
                moveToHead(node);
                return;
            }

            // check size of cache
            if(cache.size() == maxSize) evictLeastRecentlyUsed();

            Node node = new Node(key, value);
            cache.put(key, node);
            addToHead(node);
        }

        public LRUResult getValueFromKey(String key) {
            // key is not found
            if(!cache.containsKey(key)) {
                return new LRUResult(false, 0);
            }

            Node node = cache.get(key);
            moveToHead(node);
            return new LRUResult(true, node.value);
        }

        public String getMostRecentKey() {
            return  head == null ? null : head.key;
        }

        private void evictLeastRecentlyUsed(){
            // no value exists
            if(tail == null) return;

            cache.remove(tail.key);

            // if max cache size is 1
            if(head == tail){
                head = null;
                tail = null;
                return;
            }

            tail = tail.prev;
            tail.next = null;
        }

        private void addToHead(Node node) {
            node.prev = null;

            // if no node exists
            if(head == null){
                head = node;
                tail = node;
                return;
            }

            // if at least one node exists
            node.next = head;
            head.prev = node;
            head = node;
        }


        private void moveToHead(Node node) {
            // node is head
            if(node == head) return;

            removeNode(node);
            addToHead(node);
        }

        private void removeNode(Node node) {
            // node is head
            if(node == head){
                head = head.next;

                if(head != null){
                    head.prev = null;
                }
            }else if(node == tail){
                // head is tail
                tail = tail.prev;

                if(tail != null){
                    tail.next = null;
                }
            }else {
                // removing from middle
                node.prev.next  = node.next;
                node.next.prev = node.prev;
            }

            node.prev = null;
            node.next = null;
        }
    }




    private static class Node{
        String key;
        int value;

        Node prev;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }

}
