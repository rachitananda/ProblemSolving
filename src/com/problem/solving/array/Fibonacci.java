package com.problem.solving.array;

import java.util.Scanner;

public class Fibonacci {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = in.nextInt();
        in.close();

       // fib(n);
    }

    /**
     * TODO not workign with recursion
     * @param n
     * @return
     */
    private static int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n-1) + fib(n-2);

    }

    private void fibonacci(int n){
        int count = 3;
        int first = 0;
        int second = 1;
        int third=0;
        System.out.print(first+" ");
        System.out.print(second+" ");
        while(count<=n){
            third= first+second;
            System.out.print(third+" ");
            first=second;
            second=third;
            count++;

        }
    }

}
