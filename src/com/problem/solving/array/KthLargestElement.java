package com.problem.solving.array;

import java.util.Arrays;

/**
 * @author rachita
 * https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
 * K’th Smallest Element in Unsorted Array
 * Solutions:
 * 1.Sort -  O(nlogn) with heap/merge sort (best sorting complexity)
 * 2. Min Heap - extractMax() 0(logn) - best scenario-
 * simple optomization is to create a Min Heap of the given n elements and call extractMin() k times.
 * Time complexity of this solution is O(n + kLogn).Time complexity of this solution is O(n + kLogn).
 */
public class KthLargestElement {

    //    static int items[] = {7, 10, 4, 3, 20, 15};
    static int k = 3;

    public static void main(String[] args) {

        MaxHeap heap = new MaxHeap();
        heap.add(7);
        heap.print();
        heap.add(10);
        heap.print();
        heap.add(4);
        heap.print();
        heap.add(3);
        heap.print();
        heap.add(20);
        heap.print();
        heap.add(15);
        heap.print();

        for(int i =1;i<=k-1;i++) {
          heap.extractMax();
          System.out.println("Extract MAX K"+i);
            heap.print();
        }
        System.out.println("kth largest:"+heap.getMaxPeek());


    }

    static class MaxHeap {
        int items[];
        int capacity = 10;
        int size;

        MaxHeap() {
            capacity = 10;
            size = 0;
            items = new int[capacity];
        }

        private void ensureCapacity() {
            if (size == capacity) {
                capacity = capacity * 2;
                items = Arrays.copyOf(items, capacity);
            }
        }

        private boolean isEmpty() {
            return (size == 0) ? true : false;
        }

        private boolean hasParent(int index) {
            return (index == 0 ? false : true);
        }

        private boolean hasRight(int index) {
            return (getRightIndex(index) < size ? true : false);
        }

        private boolean hasLeft(int index) {
            return (getLeftIndex(index) < size ? true : false);
        }

        private int getParentIndex(int i) {
            //ceil to ensure round down is not done
            return (int) Math.ceil((i - 1) / 2.0);
        }

        private int getRightIndex(int i) {
            return (2 * i + 1);
        }

        private int getLeftIndex(int i) {
            return (2 * i + 2);
        }

        private int getMaxPeek() {
            return (!isEmpty() ? items[0] : -1);
        }

        private void swap(int x, int y) {
            int temp = items[x];
            items[x] = items[y];
            items[y] = temp;
        }

        private void add(int item) {

            ensureCapacity();
            items[size] = item;
            size++;
            heapifyUp();//O(logn)

        }

        private void heapifyUp() {
            int index = size - 1;
            while (hasParent(index) && items[getParentIndex(index)] < items[index]) {
                //parent does not comply to max heap property
                swap(getParentIndex(index), index);
                index = getParentIndex(index);

            }
        }

        private void extractMax() {
            //nt max = arr[0];
            items[0] = items[size - 1];
            size--;
            heapifyDown();
        }

        private void heapifyDown() {
            int index = 0;
            while (hasLeft(index)) {
                int largestChildIndex = getLeftIndex(index);
                if (hasRight(getRightIndex(index)) && items[getRightIndex(index)] > items[largestChildIndex]) {
                    largestChildIndex = getRightIndex(index);
                }
                if (items[index] > items[largestChildIndex]) {
                    break;
                } else {
                    swap(largestChildIndex, index);
                }
                index = largestChildIndex;

            }

        }


        private void print() {
            System.out.println();
            for(int i=0;i<size;i++) {
                System.out.print(items[i]+" ");
            }
        }

    }

}
