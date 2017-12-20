package com.problem.solving.sorting;
import com.problem.solving.Problem;
import com.problem.solving.Utils;

public class InsertionSort implements Problem  {
	int[] arr = new int[] { 8, 7, 11, 1, 0, 9,38,22 };
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println(getClass().getSimpleName());
		Utils.printArray(doInsertionSort(arr));
	}
	 public static int[] doInsertionSort(int[] input){
        Utils.printArray(input);
	        int temp;
	        for (int i = 1; i < input.length; i++) {
	            for(int j = i ; j > 0 ; j--){
	                if(input[j] < input[j-1]){
	                    temp = input[j];
	                    input[j] = input[j-1];
	                    input[j-1] = temp;
	                }
	            }
	        }
	        return input;
	    }
}
