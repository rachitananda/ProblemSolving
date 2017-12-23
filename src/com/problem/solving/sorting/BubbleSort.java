package com.problem.solving.sorting;

import com.problem.solving.ProblemI;
import com.problem.solving.Utils;

/**
 * 
 * @author rachita Time complexity - O(n2) worst case Space complexity - O(1) -
 *         does not take extra space
 */
public class BubbleSort implements ProblemI {

	int[] arr = new int[] { 1, 5, 6, 89, 12, 44 };

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("BubbleSort");
//		 sort();
		sortrecursive(arr, arr.length);

	}

	private void sort() {
		int n = arr.length;
		for (int i = 0; i <= n - 1; i++) {
			for (int j = 0; j <= n - 2 - i; j++) {
				if (arr[j + 1] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

				}
				Utils.printArray(arr);
			}
		}
		System.out.println("output");
		Utils.printArray(arr);

	}

	private void sortrecursive(int[] arr, int n) {
		if (n == 1)
			return;
		for (int j = 0; j <= n - 2; j++) {
			// for (int j = 0; j <= n - 1 - i; j++) {
			if (arr[j + 1] < arr[j]) {
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;

			}
			Utils.printArray(arr);
			// }
			sortrecursive(arr, n - 1);
		}
		System.out.println("output");
		Utils.printArray(arr);

	}

}
