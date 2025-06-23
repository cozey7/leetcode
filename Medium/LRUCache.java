// 146. LRU Cache - 05.25.2025
import java.util.*;

class Node {
    int key;
    int value;
    Node next;
    Node prev;

    public Node() {
        this.next = null;
        this.prev = null;
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    int capacity;
    int size;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        Node d = map.get(key);
        if(d == null) {
            //print();
            return -1;
        } else {
            moveToHead(d);
            //print();
            return d.value;
        }
        
    }
    
    public void put(int key, int value) {
        this.size++;
        Node d = map.get(key);
        if(d == null) {     // new entry
            Node newNode = new Node(key, value);
            addToHead(newNode);
            map.put(key, newNode);

        } else {        // key exists
            map.remove(key);
            d.value = value;
            moveToHead(d);
            this.size--;
            map.put(key, d);
        }

        if(this.size > this.capacity) {
            map.remove(popFromTail().key);
            this.size--;
        }

        //print();
    }

    private void addToHead(Node d) {
        d.next = this.head.next;
        d.prev = this.head;

        this.head.next.prev = d;
        this.head.next = d;
    }

    private Node popFromTail() {
        Node popped = this.tail.prev;
        removeNode(popped);
        return popped;
    }

    private void removeNode(Node d) {
        d.prev.next = d.next;
        d.next.prev = d.prev;
    }

    private void moveToHead(Node d) {
        this.removeNode(d);
        this.addToHead(d);
    }

    // private void print() {
    //     for(Node i = this.head.next; i != this.tail; i = i.next) {
    //         System.out.print("[" + i.key + "," + i.value + "], ");
    //     }
    //     System.out.print("size=" + this.size);
    //     System.out.println();
    // }



}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */