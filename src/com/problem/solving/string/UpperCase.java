package com.problem.solving.string;

import java.util.Scanner;

import com.problem.solving.ProblemI;

/**
 * https://practice.geeksforgeeks.org/problems/upper-case-conversion/0 Given a
 * string , write a program to title case every first letter of words in string.
 * 
 * @author rachita
 *
 */
public class UpperCase implements ProblemI {

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("enter tescase count");
		int t = in.nextInt();
		in.nextLine();//skip newline
		
		for (int i = 0; i < t; i++) {
			String input = in.nextLine();
			System.out.println("enter string");
			

			toUppercase(input);
		}
		in.close();

	}

	private void toUppercase(String str) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder(str);

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				sb.setCharAt(i + 1, Character.toUpperCase(str.charAt(i + 1)));
			}

		}
		sb.setCharAt(0, Character.toUpperCase(str.charAt(0)));
		System.out.println(sb.toString());
	}

}
