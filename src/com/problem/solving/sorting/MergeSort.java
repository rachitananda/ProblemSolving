package com.problem.solving.sorting;

import com.problem.solving.BaseProblem;
import com.problem.solving.Utils;

/**
 * https://www.geeksforgeeks.org/merge-sort/
 * 
 * @author rachita
 * Divide n conquer
 * Auxiliary Space: O(n)
 * Time Complexity :O(nlogn)
 */
public class MergeSort extends BaseProblem {

	int arr[] = { 38, 27, 43, 3, 9, 82, 10 };
//	int arr[] = { 3, 82 ,9};

	@Override
	public void execute() {
		mergeSort(arr, 0, arr.length - 1);
		Utils.printArray(arr);
	}

	private void mergeSort(int arr[], int l, int r) {

		if (l < r) {

			int m = (l + r) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);
			merge(arr, l, m, r);
			Utils.printArray(arr);

		}
		// return arr;

	}

	/**
	 * / Merges two subarrays of arr[]. // First subarray is arr[l..m] // Second
	 * subarray is arr[m+1..r]
	 *
	 */
	private void merge(int[] arr, int l, int m, int r) {

		int n1, n2;

		n1 = m - l + 1;
		// n2= r-(m-1)+1 one gets cancelled
		n2 = r - m;
		int L[] = new int[n1];
		int R[] = new int[n2];
		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		int i = 0, j = 0;
		// Initial index of merged subarry array 
		int k = l;
		while (i < n1 && j < n2) {

			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;

			} else {
				arr[k] = R[j];
				j++;

			}
			k++;
		}
		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

        /* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}

	}
}
