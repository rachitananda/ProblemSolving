package com.problem.solving.search;

import com.problem.solving.BaseProblem;


import java.util.Arrays;


/**
 * O(logn)
 *
 * @author rachita
 */
public class   BinarySearch extends BaseProblem {
    //works on sorted array
    int arr[] = new int[]{1, 3, 6, 9, 11, 23, 55};

    @Override
    public void execute() {
        System.out.println(getClass().getSimpleName());
        Arrays.sort(arr);
        search(6);

    }

    private void search(int item) {

        int begin = 0, end = arr.length;
        int mid = (begin + end) / 2;

        while (begin <= end) {
            if (item == arr[mid]) {
                System.out.println("found at " + mid);
                return;
            }
            if (item < arr[mid]) {
                end = mid - 1;
                mid = (begin + end) / 2;
            } else {
                begin = mid + 1;
                mid = (begin + end) / 2;
            }


        }

    }

}
