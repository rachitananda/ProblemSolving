package com.problem.solving.sorting;

import com.problem.solving.BaseProblem;
import com.problem.solving.Utils;

/**
 * @author rachita
 * https://www.geeksforgeeks.org/insertion-sort/
 * Insertion sort is a simple sorting algorithm that works the way we sort playing cards in our hands.
 * Time Complexity: O(n*2)
 * Auxiliary Space: O(1)
 */
public class InsertionSort extends BaseProblem {
    int[] arr = new int[]{8, 7, 11, 1, 0, 9, 38, 22};

    @Override
    public void execute() {
        System.out.println(getClass().getSimpleName());
        Utils.printArray(doInsertionSort(arr));
    }


    private void insertionSort() {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            System.out.println(" i = " + i);
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] < arr[j]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
                Utils.printArray(arr);
            }
        }
    }

    public static int[] doInsertionSort(int[] input) {
        Utils.printArray(input);
        int temp;
        for (int i = 1; i < input.length; i++) {
            for (int j = i; j > 0; j--) {
                if (input[j] < input[j - 1]) {
                    temp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = temp;
                }
            }
        }
        return input;
    }
}
