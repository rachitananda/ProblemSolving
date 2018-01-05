package com.problem.solving.array;
/**
 *
 * @author rachita
 *
 */

import com.problem.solving.BaseProblem;

import java.util.Scanner;

public class MisingNoInArray extends BaseProblem{
	
	int testcaseCount ;

	@Override
	public void execute() {

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
