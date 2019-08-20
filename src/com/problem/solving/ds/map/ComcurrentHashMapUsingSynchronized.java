package com.problem.solving.ds.map;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://www.geeksforgeeks.org/concurrenthashmap-in-java/
 * https://codereview.stackexchange.com/questions/96686/concurrenthashmap-implementation
 * https://www.careercup.com/question?id=5813643672289280
 * USING SYNCHRONIZE BLOCK LOCKS
 * In ConcurrentHashMap, the Object is divided into number of segments according to the concurrency level.
 * Default concurrency-level of ConcurrentHashMap is 16.
 * In ConcurrentHashMap, at a time any number of threads can perform retrieval operation but for updation in object,
 * thread must lock the particular segment in which thread want to operate.This type of locking mechanism is known as
 * Segment locking or bucket locking.Hence at a time 16 updation operations can be performed by threads.
 * null insertion is not possible in ConcurrentHashMap as key or value.
 */
public class ComcurrentHashMapUsingSynchronized<K, V> extends CustomHashMap {


    private Object locks[];

    public ComcurrentHashMapUsingSynchronized(int capacity) {
        super(capacity);
        locks = new Lock[capacity];
        for (int i = 0; i < capacity; i++) {
            locks[i] = new ReentrantLock();
        }
    }

    public ComcurrentHashMapUsingSynchronized() {
        super();
        locks = new Lock[super.capacity];
        for (int i = 0; i < super.capacity; i++) {
            locks[i] = new ReentrantLock();
        }
    }

    @Override
    public boolean put(Object key, Object value) {
        boolean flag;
        int targetBucketIndex = super.getBucketHashIndex(key);
        synchronized (locks[targetBucketIndex]) {//block
            flag = super.put(key, value);
            locks[targetBucketIndex].notifyAll(); //notify all waiting threads and release the lock
        }
        return flag;
    }


    public static void main(String[] args) {
        CustomConcurrentHashMapUsingLocks<Integer, Integer> map = new CustomConcurrentHashMapUsingLocks<>(12);

        map.printMap();
        map.put(1, 11);
        map.put(2, 12);
        map.put(3, 13);
        System.out.println("GET key 1:" + map.get(1));
        System.out.println("GET key 3:" + map.get(3));
        System.out.println("SIZE:" + map.getSize());

        map.put(10, 110);
        map.printMap();
        map.put(20, 120);
        map.printMap();
        map.put(30, 130);
        System.out.println("SIZE:" + map.getSize());
        map.printMap();

        System.out.println("GET key 1:" + map.get(1));
        System.out.println("GET key 3:" + map.get(3));
        System.out.println("GET key 10:" + map.get(10));
        System.out.println("GET key 30:" + map.get(30));

        System.out.println("GET DELETED 30:" + map.remove(30));
        map.printMap();

    }

}

