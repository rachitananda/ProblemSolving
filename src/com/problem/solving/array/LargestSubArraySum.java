package com.problem.solving.array;

import java.util.Scanner;

import com.problem.solving.BaseProblem;

/**
 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray 
 * Kadane algo
 * @author rachita
 */
public class LargestSubArraySum extends BaseProblem {

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t= in.nextInt();
		int output[] = new int[t];
		for(int j=0;j<t;j++){
		int n = in.nextInt();
		int arr[]= new int[n];
		for(int i=0; i<n;i++){
		    
		     arr[i]=in.nextInt();
		}
	    	output[j]=maxSubArraySum(arr,n);
		
	    }
	    in.close();
	    for(int k=0;k<t;k++){
	        System.out.println(output[k]);
	    }
	}

	static int maxSubArraySum(int a[], int size) 
    { 
    int max_so_far = a[0]; 
    int curr_max = a[0]; 
  
    for (int i = 1; i < size; i++) 
    { 
           curr_max = Math.max(a[i], curr_max+a[i]); 
        max_so_far = Math.max(max_so_far, curr_max); 
    } 
    return max_so_far; 
    } 
}
