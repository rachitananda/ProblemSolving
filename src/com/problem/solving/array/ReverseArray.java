package com.problem.solving.array;

import com.problem.solving.BaseProblem;
import com.problem.solving.Utils;

public class ReverseArray extends BaseProblem {
	int[] arr = { 1, 2, 3 ,4,5};

	@Override
	public void execute() {

		reverse3();
	}

	private void reverse3(){
		int j = arr.length-1;
		int i = 0;
		while(i<j){
			swap(i,j);
			i++;
			j--;
		}
		Utils.printArray(arr);
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
	
	
	
	private void reverse2(){
		
		for(int i=0;i<arr.length;i++){
			int temp =arr[i];
			if(i==arr.length-1){
				arr[i]=temp;
				break;
			}
			arr[i]=arr[i+1];
		
		}
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
