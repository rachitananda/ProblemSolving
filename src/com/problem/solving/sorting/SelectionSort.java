package com.problem.solving.sorting;

import com.problem.solving.BaseProblem;
import com.problem.solving.Utils;

/**
 * https://www.geeksforgeeks.org/selection-sort/
 * 
 * @author rachita Time complexity - O(n2) worst case 
 * 		   Space complexity - O(1) -does not take extra space 
 * 		   The selection sort algorithm sorts an array
 *         by repeatedly finding the minimum element (considering ascending
 *         order) from unsorted part and putting it at the beginning. The
 *         algorithm maintains two subarrays in a given array. 1) The subarray
 *         which is already sorted. 2) Remaining subarray which is unsorted. In
 *         every iteration of selection sort, the minimum element (considering
 *         ascending order) from the unsorted subarray is picked and moved to
 *         the sorted subarray.
 */
public class SelectionSort extends BaseProblem {

	int[] arr = new int[] { 8, 7, 11, 1, 0, 9, 38, 22 };

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		selectionSort();
	}

	private void selectionSort() {
		int n = arr.length;
		for (int i = 0; i < n - 2; i++) {
			int min = arr[i];
			int pos = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < min) {
					min = arr[j];
					pos = j;
				}
			}
			// swap
			int temp = arr[i];
			arr[i] = min;
			arr[pos] = temp;

			Utils.printArray(arr);

		}
	}
	
	

}
