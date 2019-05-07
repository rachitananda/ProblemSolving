package com.problem.solving.sorting;

import com.problem.solving.BaseProblem;
import com.problem.solving.Utils;

/**
 * @author rachita
 * QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around
 * the picked pivot. There are many different versions of quickSort that pick pivot in different ways.
 Always pick first element as pivot.
 Always pick last element as pivot (implemented below)
 Pick a random element as pivot.
 Pick median as pivot.
 https://www.geeksforgeeks.org/quick-sort/
 https://www.youtube.com/watch?v=SLauY6PpjW4
 Worst O(n^2),Avg O(nLogn) , Best(nLogN)
 Space O(1)
 for arrays quicksort preferred over merge as no extra space taken
 For linked list mergesort preferred  over quicksort, as LL are not contigious in memory & insert & delet are O(1) each for LL
 */
public class QuickSort extends BaseProblem {
    int arr[] = {10, 80, 30, 90, 40, 50, 70};

    @Override
    public void execute() {
        quickSort(arr);
    }

    private void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        Utils.printArray(arr);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            System.out.println("return");
            return;
        }

        //take random pivot
        int pivot = arr[(left + right) / 2];
        int partition = partition(arr, left, right, pivot);
        System.out.println("Partition :" + partition + " pivot: " + pivot);
        Utils.printArray(arr);
        quickSort(arr, left, partition - 1);
        quickSort(arr, partition, right);


    }

    private int partition(int[] arr, int left, int right, int pivot) {

        while (left <= right) {
            while (arr[left] < pivot) {
                //keep incrementing untill all the left items are in order
                //i.e less than pivot
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            if(left<=right) {
                swap(arr, right, left);
                left++;
                right--;
            }

        }
        return left;
    }

    private void swap(int[] arr, int right, int left) {
        int temp = arr[right];
        arr[right] = arr[left];
        arr[left] = temp;
    }


}
