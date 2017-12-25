package com.problem.solving.string;

import com.problem.solving.BaseProblem;

/**
 * Given two strings s and t. The task is to find maximum length of some prefix
 * of the string S which occur in string t as subsequence. Example : digger
 * biggerdiagram Prefix "dig" of s is longest subsequence in t.
 * 
 * @author rachita
 *
 */
public class PrefixAsSubsequence extends BaseProblem {

	@Override
	public void execute() {
//		 String s="digger";
//		 String t="biggerdiagram";

		String s = "geeksforgeeks";
		String t = "agbcedfeitk";
		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();
		int  count = 0;
		char item = sArr[count];
		for (int j = 0; j < tArr.length; j++) {
			if (sArr[count] == tArr[j]) {
				
				if (count< sArr.length - 1) {
					count++;
				} else {
					break;
				}
			}
		}
		System.out.println(count);

	}

}
