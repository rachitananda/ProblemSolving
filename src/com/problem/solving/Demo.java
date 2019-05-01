package com.problem.solving;

public class Demo {

	//static int[] arr = { 64, 25, 12, 22, 11 };
		static	int[] arr = new int[] { 8, 7, 11, 1, 0, 9,38,22 };
	public static void main(String[] args) {

		insertionSort();

	}
	
	static void insertionSort(){
		int n = arr.length;
		for (int i = 1;i<n;i++){
			System.out.println(" i = "+i);
			int pos =i;
			for (int j=i-1;j>=0;j--){
				if(arr[pos] < arr[j]){
					//swap
					
					int temp = arr[j];
					arr[j]= arr[pos];
					arr[pos]=temp;
					pos=j;
				}
				
				Utils.printArray(arr);
			}
		}
	}

	static void bubbleSort() {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i-1; j++) {
				if(arr[j+1]<arr[j]){
					int temp = arr[j];
					arr[j]= arr[j+1];
					arr[j+1]= temp;
					Utils.printArray(arr);
				}
			}
			System.out.println("after i = "+i);
			Utils.printArray(arr);
		}
	}

	static void selectionSort() {
		int n = arr.length;
		for (int i = 0; i < n - 2; i++) {
			int min = arr[i];
			int pos = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < min) {
					min = arr[j];
					pos = j;
				}
			}
			// swap
			int temp = arr[i];
			arr[i] = min;
			arr[pos] = temp;

			Utils.printArray(arr);

		}
	}

}
