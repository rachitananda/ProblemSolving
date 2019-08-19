package com.problem.solving.ds.tree.advanced;

import com.problem.solving.Utils;

/**
 * https://www.geeksforgeeks.org/segment-tree-set-1-range-minimum-query/
 */
public class RangeMinQuery {


    static int arr[] = {1, 3, 5, 7, 9, 11};
    static int n = arr.length;


    int st[];

    public static void main(String args[]) {

         RangeMinQuery  rmq= new RangeMinQuery(arr, n);

        System.out.println("MIN 1:5 =" + rmq.RMQ(1,5,n));
// Update: set arr[1] = 10 and update corresponding segment
        // tree nodes
//        rmq.updateValue(arr, n, 1, 10);
//
//        // Find sum after the value is updated
//        System.out.println("Updated MIN of values in given range = " +
//                rmq.RMQ(1, 5, n));

    }


    /**
     * Constructor to construct segment tree from given array. This
     * constructor  allocates memory for segment tree and calls
     * buildST() to  fill the allocated memory
     */

    RangeMinQuery(int input[], int n) {

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
        // right subtrees and store the MIN of values in this node
        int mid = getMid(begin, end);

        st[current] = minVal(buildST(arr, begin, mid, 2 * current + 1),

                buildST(arr, mid + 1, end, 2 * current + 2));

        return st[current];

    }

    private int getMid(int begin, int end) {
        //standard way  mid= (b+e)/2
        //this has edge case problems with large ints
        //https://www.geeksforgeeks.org/start-end-start2-preferrable-method-calculating-middle-array-start-end2/
        return begin + (end - begin) / 2;
    }

    int RMQ(int queryStart, int queryEnd, int n) {

        if (queryStart < 0 || queryEnd > n - 1 || queryStart > queryEnd) {
            System.out.println("invalid input");
            return -1;
        }

        return getRMQ(0, n - 1, queryStart, queryEnd, 0);
    }

    private int getRMQ(int begin, int end, int queryStart, int queryEnd, int current) {


        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (queryStart <= begin && queryEnd >= end)
            return st[current];

        // If segment of this node is outside the given range
        if (end < queryStart || begin > queryEnd)
            return Integer.MAX_VALUE;


        int mid = getMid(begin, end);
        System.out.println("sum mid: " + mid);

        return minVal(getRMQ(begin, mid, queryStart, queryEnd, 2 * current + 1) ,
                getRMQ(mid + 1, end, queryStart, queryEnd, 2 * current + 2));


    }

    int minVal(int x, int y) {
        return (x < y) ? x : y;
    }


}


