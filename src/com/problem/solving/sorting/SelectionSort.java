package com.problem.solving.sorting;

import com.problem.solving.ProblemI;
import com.problem.solving.Utils;

/**
 * 
 * @author rachita
 * Time complexity - O(n2) worst case
 * Space complexity - O(1)  - does not take extra space
 */
public class SelectionSort implements ProblemI {
	public SelectionSort(){
		System.out.println("SelectionSort");
	}
	int[] arr = new int[] { 8, 7, 11, 1, 0, 9,38,22 };


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		sort();
	}

	

	private void sort() {
		int n = arr.length;
		// last element will be sorted on their own
		for (int i = 0; i <= n - 2; i++) {
			int minPos = i;
			for (int j = i + 1; j <= n - 1; j++) {
				if (arr[j] < arr[minPos]) {
//					minPos = j;
					// swap
					int temp = arr[minPos];
					arr[minPos] = arr[j];
					arr[j] = temp;
//					Utils.printArray(arr);
				}
				
			}  
		}
		System.out.println("output");
		Utils.printArray(arr);
	}


}
