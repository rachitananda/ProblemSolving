package com.problem.solving.array;

import com.problem.solving.Problem;
import com.problem.solving.sorting.InsertionSort;

/**
 * @author rachita
 *         http://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 *         Given an array and a value, find if there is a triplet in array whose
 *         sum is equal to the given value. If there is such a triplet present
 *         in array, then print the triplet and return true. Else return false.
 *         For example, if the given array is {12, 3, 4, 1, 6, 9} and given sum
 *         is 24, then there is a triplet (12, 3 and 9) present in array whose
 *         sum is 24.
 */
public class FindTriplets implements Problem {

	int arr[] = new int[] { 12, 3, 4, 1, 6, 9 };

	@Override
	public void execute() {
		System.out.println(getClass().getSimpleName());

		findTriplets2(24);

	}

	/**
	 * Time Complexity: O(n^3)
	 * 
	 * @param targetSum
	 */
	private void findTriplets1(int targetSum) {

		for (int i = 0; i < arr.length - 2; i++) {
			int sum = i;

			for (int j = i + i; j < arr.length - 1; j++) {
				sum += j;
				if (sum < 24) {
					for (int k = j + 1; k < arr.length; k++) {
						sum += k;
						if (arr[i] + arr[j] + arr[k] == targetSum) {
							System.out.println("triplet " + arr[i] + " " + arr[j] + " " + arr[k]);
							break;
						}
					}
				}
			}
		}

	}
/**
 * O(n^2)
 * @param targetSum
 */
	private void findTriplets2(int targetSum) {
		int array[] = InsertionSort.doInsertionSort(arr);// use quick sort - as it is O nlogn
		for (int i = 0; i < arr.length - 2; i++) {
			int j = i + 1;
			int k = array.length - 1;
			while (j < k) {
				if (array[i] + array[j] + array[k] == targetSum) {
					System.out.println("triplet " + arr[i] + " " + arr[j] + " " + arr[k]);
					break;
				}else if (array[i] + array[j] + array[k] < targetSum)
                    j++;
                 
                else // A[i] + A[l] + A[r] > sum
                    k--;
			}

		}
	}

}
