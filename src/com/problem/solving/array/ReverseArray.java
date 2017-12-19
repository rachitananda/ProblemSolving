package com.problem.solving.array;

import com.problem.solving.Problem;
import com.problem.solving.Utils;

public class ReverseArray implements Problem {
	int[] arr = { 1, 2, 3 ,4};

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("ReverseArray");
		reverse1();
	}

	private void reverse() {
		// TODO Auto-generated method stub
		if(arr==null){
			return;
		}
		int n=arr.length;
		boolean isEven=false;
		if(n%2==0) {
			isEven=true;
		}
		int mid=n/2;
		for (int i=0;i<mid;i++) {
			int temp=arr[i];
			arr[i]=arr[n-1-i];
			arr[n-1-i]=temp;
		}
		if(isEven) {
			int temp=arr[mid];
			arr[mid]=arr[mid+1];
			arr[mid+1]=temp;
			
		}
		
		System.out.println("output");
		Utils.printArray(arr);
		


	}
	
	private void reverse1() {
		int end=arr.length-1;
		int start=0;
		int mid=arr.length/2;
		while (start < mid ) {
			swap(start,end);
			start++;
			end--;
		}
		System.out.println("output");
		Utils.printArray(arr);
	}
	
	private void swap(int m, int n) {
		int temp=arr[n];
		arr[n]=arr[m];
		arr[m]=temp;
		
	}

}
