package com.problem.solving.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/maximum-length-subsequence-difference-adjacent-elements-either-0-1/
 * https://www.geeksforgeeks.org/maximum-length-subsequence-difference-adjacent-elements-either-0-1-set-2/
 * @author rachita
 * Given an array of n integers. The problem is to find maximum length of the subsequence
 * with difference between adjacent elements as either 0 or 1.
 */
public class SubsequenceAdjacentElementDiff {
    static int  arr[] = {2, 5, 6, 3, 7, 6, 5, 8};
    static int  arr1[] = {-2, -1, 5, -1, 4, 0, 3};

    public static void main(String[] args){
        System.out.println(maxSubSequenceLength(arr));
        System.out.println(maxSubSequenceLength(arr1));
    }

    static int maxSubSequenceLength(int[] arr){
        int ctr=0;
        int prev= arr[0];
        for(int i=1;i<arr.length;i++){
            if(prev==arr[i]){
                ctr++;
                prev= arr[i];
            }else if(Math.abs(prev- arr[i])==1){
                ctr++;
                prev= arr[i];
            }
            if(ctr==0){
                prev= arr[i];
            }


        }

        return ++ctr;
    }

}
