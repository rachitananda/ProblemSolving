package com.problem.solving.dynamicprogramming;

import com.problem.solving.Utils;

/**
 * https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 * https://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
 */
public class LongestPalindromeSubstring {

    // Driver program to test above functions
    public static void main(String[] args) {

        String str = "forgeeksskeegfor";
        String str1 = "anitinhel";
        String str2 = "gabbaf";
        System.out.println("DP Length is: " +
                longestPalSubstrDP(str2));
        System.out.println(" Length is: " +
                longestPalinSubstring(str1));
    }


    static void printSubStr(String str, int low, int high) {
        System.out.println(str.substring(low, high + 1));
    }

    // This function prints the longest palindrome substring
    // of str[].
    // It also returns the length of the longest palindrome
    //
    /*
     https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
     O(n^2) EXTRA SPACE NEEDED DP
     */
    static int longestPalSubstrDP(String str) {
        int n = str.length();   // get length of input string

        // table[i][j] will be false if substring str[i..j]
        // is not palindrome.
        // Else table[i][j] will be true
        int table[][] = new int[n][n];

        // All substrings of length 1 are palindromes
        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = 1;//true;

        // check for sub-string of length 2.
        int start = 0;
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = 1;//true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for lengths greater than 2. k is length
        // of substring
        for (int k = 3; k <= n; k++) {

            // Fix the starting index
            //length of substring pallin = n - (k-1)= n -k+1
            for (int i = 0; i < n - k + 1; i++) {
                // Get the ending index of substring from
                // starting index i and length k
                int j = i + (k - 1);

                // checking for sub-string from ith index to
                // jth index iff str.charAt(i+1) to
                // str.charAt(j-1) is a palindrome
                if (table[i + 1][j - 1] == 1 && str.charAt(i) ==
                        str.charAt(j)) {
                    table[i][j] = 1;//true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        System.out.print("Longest palindrome substring is; ");
        printSubStr(str, start, start + maxLength - 1);

        Utils.printMatrix(table, n);

        return maxLength; // return length of LPS
    }


    /**
     * https://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
     * O(n^2) NO EXTRA SPACE NEEDED
     * @param str
     * @return
     */
    public static int longestPalinSubstring(String str) {
        int maxLength = 1;
        int start = 0;
        int n = str.length();

        for (int i = 1; i < n; i++) {
            // case 1 pallin length is EVEN - aa
            int low = i - 1;
            int high = i;

            while (low >= 0 && high < n && str.charAt(low) == str.charAt(high)) {
                // pallin match - expand on left and right by 1 in size
                int pallinLength = high - low + 1;// high - (low - 1)
                if (pallinLength > maxLength) {
                    maxLength = pallinLength;
                    start = low;
                }
                low--;
                high++;
            }//even while

            // case 1 pallin length is ODD - aa
            low = i - 1;
            high = i + 1;

            while (low >= 0 && high < n && str.charAt(low) == str.charAt(high)) {
                // pallin match - expand on left and right by 1 in size
                int pallinLength = high - low + 1;// high - (low - 1)
                if (pallinLength > maxLength) {
                    maxLength = pallinLength;
                    start = low;
                }
                low--;
                high++;
//                }
            }//odd while
        }
        printSubStr(str, start, start + maxLength - 1);
        return maxLength;

    }
}
