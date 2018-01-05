package com.problem.solving.string;

import com.problem.solving.BaseProblem;

import java.util.Scanner;

/**
 * Given two strings S1 and S2 as input, the task is to merge them
 * alternatively.
 * 
 * @author rachita
 *
 */
public class MergeStringAlternate extends BaseProblem {

	@Override
	public void execute() {
		// TODO Auto-generated method stub
//		String str1 = "text", str2 = "byeeeeee";
		System.out.println(getClass().getSimpleName());
		Scanner in = new Scanner(System.in);
		System.out.println("enter str1");
		String str1=in.nextLine();
		System.out.println("enter str2");
		String str2=in.nextLine();
		in.close();
		mergeAlternateStrings(str1,str2);

	}

	private void mergeAlternateStrings(String str1, String str2) {
		char[] strArr1 = str1.toCharArray();
		char[] strArr2 = str2.toCharArray();
		int n1 = strArr1.length;
		int n2 = strArr2.length;
		char arr[] = new char[n1 + n2];
		int i = 0, k = 0;
		int j = 0;

		while (i < n1 || j < n2) {
			if (i < n1 && j < n2) {
				arr[k++] = strArr1[i++];
				arr[k++] = strArr2[j++];
			}else if ( j == n2 && i<n1) {
				arr[k++] = strArr1[i++];
			}else if ( i == n1 && j<n2) {
				arr[k++] = strArr2[j++];
			}

		}
		System.out.println(String.valueOf(arr));
	}

}
