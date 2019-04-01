package com.problem.solving.array;

import com.problem.solving.Utils;

//http://www.geeksforgeeks.org/array-rotation/
//rotate arrayos size n  by d places 
public class RotateArray {
	int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
	int n = 7, d = 2;

	public RotateArray() {

	}

	public void execute() {
		// printArray(arr);
		rotate3();
	}
/**
 * complexity O(n)
 */
	private void rotate() {
		int temp[] = new int[d];
		for (int i = d - 1; i >= 0; i--) {
			temp[i] = arr[i];

		}
//		System.out.println("temp");
//		Utils.printArray(temp);
		for (int j = d; j <= n - 1; j++) {
			arr[j - d] = arr[j];
		}
//		System.out.println("shift by d");
//		Utils.printArray(arr);

		int l = 0;
		for (int k = n - d; k <= n - 1; k++) {
			arr[k] = temp[l];
			l++;
		}
		System.out.println("output");
		Utils.printArray(arr);

	}
	
	/*
	 * without using temp array
	 *  complexity O(n*d)
	 */
	private void rotate1() {
		
		for (int j=1;j<=d;j++) {
			int first=arr[0];
			for (int i=1;i<=n-1;i++) {
				arr[i-1]=arr[i];
			}
			arr[n-1]=first;
//			System.out.println("interation");
//			Utils.printArray(arr);
		}
		System.out.println("output");
		Utils.printArray(arr);
	}
	
	
/**
 * O(n+d)
 */
	private void rotate3() {
		int n = arr.length;
		int temp[] = new int[d];
		int t = 0;
		for (int i = 0; i < n; i++) {
			if (i <= d - 1) {
				temp[t++] = arr[i];
			} else {
				arr[i - d] = arr[i];
			}
		}
		Utils.printArray(temp);
		t = 0;
		for (int j = n - d; j < n; j++) {
			arr[j] = temp[t++];
		}
		
		Utils.printArray(arr);
	}

}
