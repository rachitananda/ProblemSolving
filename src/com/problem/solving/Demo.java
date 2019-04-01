package com.problem.solving;

public class Demo extends BaseProblem {
	int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
	int n = 7, d = 2;

	@Override
	public void execute() {
		// TODO Auto-generated method stub
rotate3();
	}

	private void rotate3() {
		int n = arr.length;
		int temp[] = new int[d];
		int t = 0;
		for (int i = 0; i < n; i++) {
			if (i <= d - 1) {
				temp[t++] = arr[i];
			} else {
				arr[i - d] = arr[i];
			}
		}
		Utils.printArray(temp);
		t = 0;
		for (int j = n - d; j < n; j++) {
			arr[j] = temp[t++];
		}
		
		Utils.printArray(arr);
	}

}
