package com.problem.solving.factorial;

import java.util.Scanner;

import com.problem.solving.ProblemI;

/**
 * https://practice.geeksforgeeks.org/problems/find-all-factorial-numbers-less-than-or-equal-to-n/0
 * A number N is called a factorial number if it is the factorial of a positive
 * integer. For example, the first few factorial numbers are 1, 2, 6, 24, 120, …
 * Given a number N, the task is to print all factorial numbers smaller than or
 * equal to N.
 * 
 * @author rachita
 */

public class Factorial implements ProblemI {
	int t;

	@Override
	public void execute() {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		System.out.println("Enter Test cases T :");
		t = in.nextInt();
		for (int i = 0; i < t; i++) {
			System.out.println("Enter N for  Test cases " + i);
			int n = in.nextInt();
			System.out.println("Factorial nos smaller than"+n );
			factorialLimit(n);
		}

		in.close();
	}

	private char[] factorialLimit(int limit) {
		for (int i=1;i<=limit;i++) {
			if(factorial(i)>limit) {
				break;
			}
			System.out.print(factorial(i)+" ");
		}
		return null;
	}
	
	private int factorial(int n) {
		int factorial=1;
		for (int i=n;i>=1;i--) {
			factorial=factorial*i;
		}
		
		return factorial;
		
		
	}

}
