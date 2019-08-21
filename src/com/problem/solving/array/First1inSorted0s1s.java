package com.problem.solving.array;

/**
 * https://www.geeksforgeeks.org/find-index-first-1-sorted-array-0s-1s/
 */
public class First1inSorted0s1s {


    public static void main(String[] args) {
        int arr[] = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
        int n = arr.length;
        First1inSorted0s1s problem = new First1inSorted0s1s();
        System.out.println(problem.indexOfFirstOne(arr, n));
        System.out.println(problem.indexOfFirstOneOptimised(arr, n));

    }

    /**
     * O(logn) - optimised with mid
     *
     * @param arr
     * @param n
     * @return
     */
    public int indexOfFirstOneOptimised(int arr[], int n) {
        // traverse the array from left to right
        int begin = 0;
        int end = n - 1;
        int mid=0;
        while (begin <= end) {
            mid = (begin + end) / 2;

            if(arr[mid]<1){
                begin= mid+1;
            }else{
                //=1
                if(arr[mid-1]==0){
                    //found
                    return mid;
                }
                //keep looking
                end= mid-1;
            }

        }
        return mid;
    }


    /**
     * O(n) - brute force
     *
     * @param arr
     * @param n
     * @return
     */
    public int indexOfFirstOne(int arr[], int n) {
        // traverse the array from left to right
        for (int i = 0; i < n; i++)

            // if true, then return i
            if (arr[i] == 1)
                return i;

        // 1's are not present in the array
        return -1;
    }

}


