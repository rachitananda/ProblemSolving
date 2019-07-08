package com.problem.solving.ds.list;

import java.util.HashMap;

/**
 * https://www.geeksforgeeks.org/lru-cache-implementation/
 * https://java2blog.com/lru-cache-implementation-java/
 * Design a Least recently used cache implementation in java. It should have below properties.
 * Bounded size: It should have bounded size to take care of memory limits.
 * Fast access: As we are designing cache, we should be able to fetch or update entries faster.O(1)
 * Evict least recently used entry: Cache should evict least recently used entry if capacity is reached
 * Solution
 * As we need to do lookup in O(1) time then HashMap is obvious choice but we need to take care of least recently used entry as well.
 * We need to find a data structure which can remove/add in O(1) time if we already know the node. We can use a double linked list for this purpose because it provides removal/addition in O(1) time if already know about the node.
 * HashMap will make get operation in O(1) time and Doube linked list will make removal/addition in O(1) time.
 * Insert at HEAD and DELETE FROM TAIL
 * GET entry (should be moved to head(most used on top))
 * PUT - if capacity reaches delete tail node(least recently used)
 */
public class LRUCache {

    class Node {
        int data;
        int hashKey;
        Node prev;
        Node next;

        public Node(int hashKey, int data) {
            this.data = data;
            this.hashKey = hashKey;
        }
    }

    int capacity;
    Node head = null;
    Node tail = null;
    HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(4);

        cache.put(1, 100);
        cache.put(1, 100);
        cache.put(10, 99);
        cache.put(15, 98);
        cache.put(10, 97);
        cache.put(12, 96);
        cache.put(18, 95);
        cache.put(1, 94);

        System.out.println(cache.get(1));
        System.out.println(cache.get(10));
        System.out.println(cache.get(15));


    }

    /**
     * Insert at head - if exits delete old entry add node at head
     * O(1)
     *
     * @param hashKey
     * @param data
     */

    private void put(int hashKey, int data) {

        if (map.containsKey(hashKey)) {
            //update
            //delete old
            Node node = map.get(hashKey);
            delete(node);
            node.data=data;
            //set new as head
            setHead(node);

        } else {
            //add new key entry
            Node node = new Node(hashKey, data);
            //check capacity
            if(map.size()>=capacity){
                //delete tail - least recently used/oldest
                map.remove(tail.hashKey);
                delete(tail);
            }
            map.put(hashKey,node);
            setHead(node);
        }

    }

    /**
     * move the get entry to head (as its recently used)
     *
     * @param hashKey
     * @return data
     */
    private int get(int hashKey) {

        if (map.containsKey(hashKey)) {
            Node node = map.get(hashKey);
            delete(node);
            setHead(node);
            return node.data;

        } else {
            return -1;
        }

    }

    private void delete(Node node) {
        if (node.prev != null) {
            //middle node
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            //middle node
            node.next.prev = node.prev;
        } else {
            tail = tail.prev;
        }

    }

    private void setHead(Node node) {

        node.next = head;
        node.prev = null;

        if (head != null)
            head.prev = node;

        head = node;

        if (tail == null) {
            tail = head;
        }

    }
}

