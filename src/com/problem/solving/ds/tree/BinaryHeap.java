package com.problem.solving.ds.tree;

import java.util.Arrays;

/**
 * @author rachita
 * https://www.geeksforgeeks.org/binary-heap/
 * https://www.hackerrank.com/topics/heaps
 * https://www.youtube.com/watch?v=t0Cq6tVNRBA
 * A Binary Heap is a Binary Tree with following properties.
 * 1) It�s a COMPLETE TREE (All levels are completely filled except possibly the last level and the last level
 * has all keys as left as possible). This property of Binary Heap makes them suitable to be stored in an array.
 * 2) A Binary Heap is either Min Heap or Max Heap. In a Min Binary Heap, the key at root must be minimum among
 * all keys present in Binary Heap. The same property must be recursively true for all nodes in Binary Tree.
 * Max Binary Heap is similar to MinHeap.
 * 3) The traversal method use to achieve Array representation is Level Order
 * 4) binary heap is typically represented as an array.
 * 5)The root element will be at Arr[0].
 * Arr[(i-1)/2] 	Returns the parent node
 * Arr[(2*i)+1] 	Returns the left child node
 * Arr[(2*i)+2] 	Returns the right child node
 * **Applications of Heaps:***
 * 1) Heap Sort: Heap Sort uses Binary Heap to sort an array in O(nLogn) time.
 * 2) Priority Queue: Priority queues can be efficiently implemented using Binary Heap because it supports insert(), delete() and extractmax(), decreaseKey() operations in O(logn) time. Binomoial Heap and Fibonacci Heap are variations of Binary Heap. These variations perform union also efficiently.
 * 3) graph Algorithms: The priority queues are especially used in graph Algorithms like Dijkstra�s Shortest Path and Prim�s Minimum Spanning Tree.
 * 4) Many problems can be efficiently solved using Heaps. See following for example.
 * a) K�th Largest Element in an array.
 * b) Sort an almost sorted array/
 * c) Merge K Sorted Arrays.
 */
abstract public class BinaryHeap {

    protected int capacity;
    public int size;
    protected int items[];

    public BinaryHeap(){
        capacity=10;
        items = new int[capacity];
    }

    public BinaryHeap(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
    }

    public int getParentIndex(int index) {
        //ceil to fix round down of 0.5 to 0 when index is 2
        return (int) Math.ceil((index - 1) / 2.0);
    }

    public int getLeftChildIndex(int index) {
        return (2 * index) + 1;
    }

    public int getRightChildIndex(int index) {
        return (2 * index) + 2;
    }

    /**
     * @param index The index of the element you are checking.
     * @return true if the calculated parent index exists within array bounds
     * false otherwise.
     **/
    public boolean hasParent(int index) {
        return index > 0 ? true : false;
    }

    /**
     * @param index The index of the element you are checking.
     * @return true if the Heap contains enough elements to fill the right child index,
     * false otherwise.
     **/
    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size ? true : false;
    }

    public boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size ? true : false;
    }

    public int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    public int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    public int parent(int index){
        return items[getParentIndex(index)];
    }

    /**
     * Doubles underlying array if capacity is reached.
     **/
    public void ensureCapacity() {
        if (size == capacity) {
            capacity=capacity * 2;
            items = Arrays.copyOf(items, capacity );
        }
    }

    public void swap(int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public boolean isEmpty() {
        if (size == 0) {
            System.out.println("IsEMPTY TRUE");
            return true;
        }
        return false;
    }

    /**
     * @return The value at the top of the Heap.
     **/
    public int peek() {
        if (!isEmpty()) {
            return items[0];
        } else {
            return -1;
        }
    }

    /**
     * Extracts/removes root element from Heap.
     * //Extracr MIN/MAX/ROOt
     *  O(Logn)
     **/
    public int pollExtractRoot() {
        if (isEmpty())
            return -1;

        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDownAfterExtractRoot();
        return item;
    }

    /**
     * @param item The value to be inserted into the Heap.
     *  O(Logn)
     **/
    public void add(int item) {
        // Resize underlying array if it's not large enough for insertion
        ensureCapacity();
        // Insert value at the next open location in heap
        items[size] = item;
        size++;
        // Correct order property
        heapifyUpAfterAddInHeap();
    }

    /**
     * Swap values down the Heap.
     * 0(logn)
     **/
    abstract public  void heapifyDownAfterExtractRoot();

    /**
     * Swap values up the Heap.
     **/
    abstract public void heapifyUpAfterAddInHeap();

    public  void print(){
        System.out.println("HEAP created");
        for (int i = 0; i < size; i++) {
            System.out.print(" "+items[i]);

        }
    }
    public void printTillCapacity(){
        System.out.println("HEAP created");
        for (int i = 0; i < capacity; i++) {
            System.out.print(" "+items[i]);

        }
    }

}
