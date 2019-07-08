package com.problem.solving.dynamicprogramming;

import java.util.Scanner;

/*
https://www.geeksforgeeks.org/minimum-insertions-to-form-a-palindrome-dp-28/
 */
public class MinInsertionsToFormPalindrome {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        in.close();
        char[] chars = string.toCharArray();
        int minInsertion = minInsertionCount(chars, 0, chars.length - 1);
        System.out.print("Min insertions needed :"+minInsertion);

    }


    static int minInsertionCount(char[] chars, int low, int high) {


        if (low > high || low > chars.length - 1 || high < 0 || high > chars.length - 1) {
            return 0;
        }

        if(low>high){
            //recusrion on ab
            //it was only 2 character string and we tried recursion on it
            return 1;
        }

        if(low== high){
            return 0;
        }

        if (chars[low] == chars[high]) {
            return minInsertionCount(chars, low + 1, high - 1);
        } else {
            //ab
            return 1 + Math.min(minInsertionCount(chars, low, high - 1),minInsertionCount(chars, low+1, high));
        }


    }
}
