package com.problem.solving.string;

import com.problem.solving.BaseProblem;

import java.util.Scanner;
/**
 * https://practice.geeksforgeeks.org/problems/remove-vowels-from-string/0
 * Given a string, remove the vowels from the string and print the string without vowels.
 * @author rachita
 *
 */
public class RemoveVowel extends BaseProblem {

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter string");
		String  input= in.nextLine();
		in.close();
		
		removeVowels(input);
		
		
	}

	private void removeVowels(String input) {
		if(input==null)
			return;
		if(input.length()==0)
			return;
		
		char[] arr=input.toCharArray();			
		for(int i=0;i<arr.length;i++) {
			char z = arr[i];
	         if (z=='a' || z=='e' || z=='i' || z=='o' || z=='u') {
	        	 	arr=rotateLeft(arr,i);
	        	 	System.out.println(String.valueOf(z)+" "+String.valueOf(arr));
				
			}
		}
		System.out.println(String.valueOf(arr));
		
	}

	private char[] rotateLeft(char[] arr,int pos) {
		// TODO Auto-generated method stub
		for (int i=pos;i<=arr.length-1;i++) {
			if(i==arr.length-1) {
				arr[i]=' ';
			}else
			arr[i]=arr[i+1];
			
		}
		return arr;
		
	}

}
