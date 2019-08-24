package com.problem.solving.ds.tree.advanced;

import com.problem.solving.Utils;

/**
 * https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/tutorial/
 * https://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
 * <p>
 * Segment Tree is used in cases where there are multiple range queries on array and modifications of elements
 * of the same array. For example, finding the sum of all the elements in an array from indices  to , or
 * finding the minimum (famously known as Range Minumum Query problem) of all the elements in an array
 * from indices  to .
 * <p>
 * Representation of Segment trees
 * 1. Leaf Nodes are the elements of the input array.
 * 2. Each internal node represents some merging of the leaf nodes. The merging may be different for different
 * problems. For this problem, merging is sum of leaves under a node.
 * <p>
 * An array representation of tree is used to represent Segment Trees. For each node at index i,
 * the left child is at index 2*i+1, right child at 2*i+2 and the parent is at i-1/2.
 * <p>
 * Height of the segment tree will be height=log2(n). Since the tree is represented using array and relation between parent and
 * child indexes must be maintained, size of memory allocated for segment tree will be  2* (2^height) =1
 */
public class SegmentTree {

    static int arr[] = {1, 3, 5, 7, 9, 11};
    static int n = arr.length;


    int st[];

    public static void main(String args[]) {

        SegmentTree segmentTree = new SegmentTree(arr, n);

        System.out.println("Sum 1:3 =" + segmentTree.getSum(1, 3, n));
        // Update: set arr[1] = 10 and update corresponding segment
        // tree nodes
        segmentTree.updateValue(arr, n, 1, 10);

        // Find sum after the value is updated
        System.out.println("Updated sum of values in given range = " +
                segmentTree.getSum(1, 3, n));

    }


    /**
     * Constructor to construct segment tree from given array. This
     * constructor  allocates memory for segment tree and calls
     * buildST() to  fill the allocated memory
     */

    SegmentTree(int input[], int n) {

        // Allocate memory for segment tree

        //Height of segment tree
        int heightOfST = (int) (Math.ceil(Math.log(n) / Math.log(2)));//log2(n)= log10(n)/log10(2)

        //Maximum size of segment tree
        int maxSize = 2 * (int) Math.pow(2, heightOfST) - 1;

        st = new int[maxSize];

        buildST(arr, 0, n - 1, 0);
        Utils.printArray(st);
    }

    /*
     A recursive function that constructs Segment Tree for array[begin..end].
     current is index of current node in segment tree st
     O(n)
     */
    private int buildST(int arr[], int begin, int end, int current) {

        if (begin == end) {
            //leaf node
            st[current] = arr[begin];
            return st[current];
        }
        //not a leave node
// If there are more than one elements, then recur for left and
        // right subtrees and store the sum of values in this node
        int mid = getMid(begin, end);

        st[current] = buildST(arr, begin, mid, 2 * current + 1) +

                buildST(arr, mid + 1, end, 2 * current + 2);

        return st[current];

    }

    private int getMid(int begin, int end) {
        //standard way  mid= (b+e)/2
        //this has edge case problems with large ints
        //https://www.geeksforgeeks.org/start-end-start2-preferrable-method-calculating-middle-array-start-end2/
        return begin + (end - begin) / 2;
    }

    int getSum(int queryStart, int queryEnd, int n) {

        if (queryStart < 0 || queryEnd > n - 1 || queryStart > queryEnd) {
            System.out.println("invalid input");
            return -1;
        }

        return getRangeSum(0, n - 1, queryStart, queryEnd, 0);
    }

    private int getRangeSum(int begin, int end, int queryStart, int queryEnd, int current) {


        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (queryStart <= begin && queryEnd >= end)
            return st[current];

        // If segment of this node is outside the given range
        if (end < queryStart || begin > queryEnd)
            return 0;


        int mid = getMid(begin, end);
        System.out.println("sum mid: " + mid);

        return getRangeSum(begin, mid, queryStart, queryEnd, 2 * current + 1) +
                getRangeSum(mid + 1, end, queryStart, queryEnd, 2 * current + 2);


    }

    // The function to update a value in input array and segment tree.
    // It uses updateValueUtil() to update the value in segment tree
    void updateValue(int arr[], int n, int i, int new_val) {
        // Check for erroneous input index
        if (i < 0 || i > n - 1) {
            System.out.println("Invalid Input");
            return;
        }

        // Get the difference between new value and old value
        int diff = new_val - arr[i];

        // Update the value in array
        arr[i] = new_val;

        // Update the values of nodes in segment tree
        updateValueUtil(0, n - 1, i, diff, 0);
    }

    /* A recursive function to update the nodes which have the given
       index in their range. The following are parameters
        st, si, ss and se are same as getSumUtil()
        i    --> index of the element to be updated. This index is in
                 input array.
       diff --> Value to be added to all nodes which have i in range */
    void updateValueUtil(int begin, int end, int i, int diff, int current) {
        // Base Case: If the input index lies outside the range of
        // this segment
        if (i < begin || i > end)
            return;

        // If the input index is in range of this node, then update the
        // value of the node and its children
        st[current] = st[current] + diff;
        if (end != begin) {
            int mid = getMid(begin, end);
            updateValueUtil(begin, mid, i, diff, 2 * current + 1);
            updateValueUtil(mid + 1, end, i, diff, 2 * current + 2);
        }
    }

}
