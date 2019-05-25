package com.problem.solving.matrix;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rachita
 * https://www.geeksforgeeks.org/kth-smallest-element-in-a-row-wise-and-column-wise-sorted-2d-array-set-1/
 * K’th Smallest Element in  2D sorted Array Matrix
 * 1) Build a min heap of elements from first row. A heap entry also stores row number and column number.
 * 2) Do following k times.
 * …a) Get minimum element (or root) from min heap.
 * …b) Find row number and column number of the minimum element.
 * …c) Replace root with the next element from same column (if no next element in column ,replace with INT_MAX) and min-heapify the root.
 * 3) Return the last extracted root.
 * <p>
 * Time Complexity: The above solution involves following steps.
 * 1) Build a min heap which takes O(n) time
 * 2) Heapify k times which takes O(kLogn) time.
 * Therefore, overall time complexity is O(n + kLogn) time.
 */
public class SmallestKthElement {

    static int mat[][] = {{10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}};

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int colCount = 4;
        int rowCount = 4;
        System.out.println("For smallest Kth element- Enter K: ");
        int k = in.nextInt();
        in.close();
        MinHeapImp minHeap = new MinHeapImp(rowCount, colCount, mat);
        //add 1st row to min heap
        for (int j = 0; j < colCount; j++) {
            minHeap.add(new MatrixNode(mat[0][j], 0, j));
            minHeap.print();
        }
        for (int i =1;i<=k;i++) {
            System.out.println("smallest "+i+"th element:"+minHeap.extractMinRoot());
            minHeap.print();
        }

    }

    static class MatrixNode {
        int key;
        int row;
        int col;

        MatrixNode(int key, int row, int col) {
            this.row = row;
            this.col = col;
            this.key = key;
        }
    }

    static class MinHeapImp {
        MatrixNode items[];
        int capacity;
        int size;
        int rowCount, colCount;
        int mat[][];

        MinHeapImp(int rowCount, int colCount, int[][] matrix) {
            this.capacity = colCount;
            items = new MatrixNode[capacity];
            this.colCount = colCount;
            this.rowCount = rowCount;
            this.mat = matrix;
            size = 0;
        }

        public void setMatrix(int mat[][]) {
            this.mat = mat;
        }

        private boolean hasParent(int index) {
            return index == 0 ? false : true;
        }

        private int getParentIndex(int index) {
            return (int) Math.ceil((index - 1) / 2.0);
        }

        private int getLeftChildIndex(int index) {
            return (2 * index + 1);
        }

        private int getRightChildIndex(int index) {
            return (2 * index + 2);
        }

        private boolean hasLeftChild(int index) {
            return getLeftChildIndex(index) < size ? true : false;
        }

        private boolean hasRightChild(int index) {
            return getRightChildIndex(index) < size ? true : false;
        }

        private boolean isEmpty() {
            return size == 0 ? true : false;
        }

        private void ensureCapacity() {
            if (size == capacity) {
                capacity = 2 * capacity;
                items = Arrays.copyOf(items, capacity);
            }
        }

        public void swap(int index1, int index2) {
            MatrixNode temp = items[index1];
            items[index1] = items[index2];
            items[index2] = temp;
        }

        public void add(MatrixNode node) {
            if (isEmpty()) {
                items[size] = node;
                size++;
                return;
            }

            ensureCapacity();
            items[size] = node;
            size++;
            heapifyUp(size - 1);
        }

        private boolean heapifyUp(int index) {

            if (!hasParent(index)) {
                //root
                return false;
            } else {//has parent
                if (items[getParentIndex(index)].key > items[index].key) {
                    swap(getParentIndex(index), index);
                    return heapifyUp(getParentIndex(index));
                } else {
                    return false;
                }
            }

        }

        private void print() {
            System.out.println("HEAP BUILD:");
            for (int i = 0; i < size; i++) {
                System.out.print(items[i].key + " ");
            }
        }

        /**
         * POll
         * Extract Root
         * Replace root with the next element from same column (if no next element in column ,replace with INT_MAX)
         * and min-heapify the root.
         */
        public int extractMinRoot() {
            MatrixNode min = items[0];
            int col = items[0].col;
            if (col == colCount - 1) {
                //no more item in this col- this is last item of this col
                items[0] = new MatrixNode(Integer.MAX_VALUE, 0, 0);
            } else {
                int key = mat[min.row + 1][min.col];
                items[0] = new MatrixNode(key, min.row + 1, min.col);
            }
            heapifyDown(0);

            return min.key;
        }

        private boolean heapifyDown(int index) {
            if (index == size - 1) {
                return false;
            }

            if (!hasLeftChild(index)) {
                return false;
            } else {
                //has left child
                int smallestChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && items[getRightChildIndex(index)].key < items[smallestChildIndex].key) {
                    smallestChildIndex = getRightChildIndex(index);
                }
                if (items[index].key > items[smallestChildIndex].key) {
                    swap(index, smallestChildIndex);
                   return heapifyDown(smallestChildIndex);
                } else {
                    return false;
                }

            }

        }

    }

}

