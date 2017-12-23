package com.problem.solving.array;

import java.util.HashMap;
import java.util.Scanner;

import com.problem.solving.ProblemI;

/**
 * https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum/0
 * Given an array of integers, and an integer  ‘K’ , 
 * find the count of pairs of elements in the array whose sum is equal to 'K'
 * @author rachita
 *
 */
public class PairsWithGivenSum implements ProblemI{

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println(getClass().getSimpleName());
		
		Scanner in =new Scanner(System.in);
		System.out.println("Enter T test cases count");
		int T= in.nextInt();
		for (int i=0;i<T;i++) {
		System.out.println("Testcase "+i+" : Enter 2 space separated integers N and K denoting the size of array and the sum respectively");
		int n= in.nextInt();
		int k=in.nextInt();
		int arr[]=new int[n];
		System.out.println("Enter array of size "+n);
		for(int j=0;j<n;j++){
			arr[j]=in.nextInt();
		}
		System.out.println("count "+countPairsWithSum1(arr,k));
		
		
		}
		in.close();
		
	}
/**
 * O(n^2)
 * @param arr
 * @param k
 * @return count for pairs with sum K
 */
	private int countPairsWithSum(int[] arr, int k) {
		// TODO Auto-generated method stub
		int count=0;
		for(int i=0;i<arr.length;i++) {
			
			for(int j=i+1;j<arr.length;j++) {
				
				if(arr[i]+arr[j]==k) {
					count++;
				}
			}
			
		}
		return count;
	}
	/**
	 * O(n^2)
	 * @param arr
	 * @param k
	 * @return
	 */
	private int countPairsWithSum1(int[] arr, int k) {
		int count=0;
		HashMap<Integer, Integer> hmap= new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			int sumPair=k-arr[i];
			if(hmap.containsValue(arr[i])) {
				count++;
			}else {
			hmap.put(arr[i], k-arr[i]);
			}
			
		}
		return count;}
}
