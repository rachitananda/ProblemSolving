package com.problem.solving.string;

import java.util.Scanner;

/**
 * @author rachita
 * https://www.geeksforgeeks.org/reverse-words-given-string-java/
 */
public class ReverseWordsInString {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter Sentence :");

        String string = in.nextLine();
        in.close();
        String[] words = string.split("\\s");
        StringBuffer sb = new StringBuffer();

        //reverse charters of each word
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            int j = 0, k = chars.length - 1;
            while (j < k) {
                char temp = chars[j];
                chars[j] = chars[k];
                chars[k] = temp;
                j++;
                k--;
            }
            sb.append(new String(chars)+" ");

        }
        System.out.println("Reversed:"+sb.toString());
        sb.delete(0, sb.length());
        for (int i = words.length-1; i >=0; i--) {
            sb.append(words[i]+" ");
        }
        System.out.println("Reversed:"+sb.toString());



    }
}
