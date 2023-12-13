package main.com.bogdaniancu.speech.test;

import java.util.LinkedHashMap;
import java.util.Map;



class LRUCache extends LinkedHashMap<Integer, Integer> {



    private static final int DEFAULT_CAPACITY = 10;

    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public LRUCache() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }


    public int get(int key) {
        Integer result = super.get(key);
        if (result == null) {
            return -1;
        }
        return result;
    }

    public void put(int key, int value) {
        super.put(key, value);
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