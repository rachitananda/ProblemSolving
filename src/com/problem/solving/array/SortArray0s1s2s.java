package com.problem.solving.array;

import com.problem.solving.BaseProblem;

import java.util.Scanner;
/**
 * https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 * https://www.geeksforgeeks.org/how-to-get-rid-of-java-tle-problem/
 * @author rachita
 *
 */
public class SortArray0s1s2s extends BaseProblem {
	
	@Override
	public void execute() {

		Scanner in = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		System.out.println("Enter T:");
		int t= in.nextInt();
		for(int i = 0; i<t; i++){
			System.out.println("Enter N:");
		    int n= in.nextInt();
		    int arr[] = new int[n];
			System.out.println("Enter Array:");
		    for(int j=0;j<n ;j++ ){
		       arr[j]=in.nextInt();
		    }
			in.close();
		    arr=sort(arr);
		    //append to output
			System.out.println("Output :");
		   for(int k =0;k<n;k++){
		       sb.append(arr[k]+" ");
		   }
		    sb.append("\n");
		}

		System.out.print(sb);
	}
	
	
	
		static int[] sort(int arr[]){
		    
		    int lo=0;
		    int hi=arr.length-1;
		    int mid=0;
		    int temp;
		    while(mid<=hi){
		        switch(arr[mid]){
		            case 0: temp= arr[lo];
		                 arr[lo] = arr[mid];
		                 arr[mid]= temp;
		                 lo++;
		                 mid++;
		                break;
		            case 1:
		                mid++;
		                break;
		           case 2: temp= arr[hi];
		                 arr[hi] = arr[mid];
		                 arr[mid]= temp;    
		                 hi--;
		               break;
		        }
		    }
		    
		    return arr;
		}
	

}
