package com.problem.solving.array;
/**
 * https://practice.geeksforgeeks.org/problems/perfect-array/0
 * @author rachita
 *
 */

import java.util.Scanner;

import com.problem.solving.ProblemI;

public class PerfectArray implements ProblemI{
	
	int testcaseCount ;

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter test case count N: ");
		int testcaseCount = reader.nextInt(); // Scans the next token of the input as an int.
		//once finished
		
		for(int i=0;i<testcaseCount;i++) {
			// for each test case get  aar size n arr
			System.out.println("Enter input size N: ");
			int n= reader.nextInt();
			int arr[] =new int[n];
			for(int j=0;j<n;j++) {
				System.out.println("enter  "+j);
				 arr[j]=reader.nextInt();
			}
		
			System.out.println("Missing no "+findMissingNumber(arr));
		}
		reader.close();
		
		
		
	}

	private int findMissingNumber(int[] arr) {
		// TODO Auto-generated method stub
		for(int i=0;i<arr.length;i++) {
			if(arr[i]+1 !=arr[i+1]) {	
				
				return arr[i]+1;
			}

			
		}
		
		return -1;
	}
	
	
	


}
