package main.com.bogdaniancu.speech;


import java.util.*;

public class LRUCache{

    class Node {
        int key;
        int value;
        Node pre;
        Node post;

        public Node() {}

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            pre = null;
            post = null;
        }
    }
    
    private Map<Integer, Node> cache;
    private int capacity;
    private Node head;
    private Node tail;

    private void addNode(Node node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    private void removeNode(Node node) {
        node.pre.post = node.post;
        node.post.pre = node.pre;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private Node popTail() {
        Node res = tail.pre;
        removeNode(res);
        return res;
    }

    public LRUCache(int capacity) {
//        this.count = 0;
        this.capacity = capacity;
        this.cache = new HashMap<>();

        head = new Node();
        head.pre = null;

        tail = new Node();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = cache.get(key);

        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node == null) {
            Node newNode = new Node(key, value);

            cache.put(key, newNode);
            addNode(newNode);


            if (cache.size() > capacity) {
                Node tailNode = popTail();
                cache.remove(tailNode.key);
            }

        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

    }
}
