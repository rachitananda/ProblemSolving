package com.problem.solving.sorting;

import com.problem.solving.BaseProblem;
import com.problem.solving.Utils;

/**
 * 
 * @author rachita
 * 			Time complexity - O(n2) worst case Space complexity - O(1) -
 *         does not take extra space
 *         Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping
 *          the adjacent elements if they are in wrong order.
 *          https://www.geeksforgeeks.org/bubble-sort/
 */
public class BubbleSort extends BaseProblem {

	int[] arr = new int[] { 1, 5, 6, 89, 12, 44 };

	@Override
	public void execute() {

//		 sort();
		sortrecursive(arr, arr.length);

	}
	
	private void bubbleSort() {
		int n = arr.length;
		//last element sorts itself
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i-1; j++) {
				if(arr[j+1]<arr[j]){
					int temp = arr[j];
					arr[j]= arr[j+1];
					arr[j+1]= temp;
					Utils.printArray(arr);
				}
			}
			System.out.println("after i = "+i);
			Utils.printArray(arr);
		}
	}

	private void sortrecursive(int[] arr, int n) {
		if (n == 1)
			return;
		for (int j = 0; j <= n - 2; j++) {
			if (arr[j + 1] < arr[j]) {
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;

			}
			Utils.printArray(arr);
			sortrecursive(arr, n - 1);
		}
		System.out.println("output");
		Utils.printArray(arr);

	}

}
