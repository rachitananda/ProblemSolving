package com.problem.solving.dynamicprogramming;

/**
 * @author rachita
 * https://www.geeksforgeeks.org/maximum-sum-rectangle-in-a-2d-matrix-dp-27/
 */
public class LargestSubMatrixSum {
    static int mat[][] = new int[][]{
            {1, 2, -1, -4, -20},
            {-8, -3, 4, 2, 1},
            {3, 8, 10, 1, 3},
            {-4, -1, 1, 7, -6}
    };
    static int row = 4, column = 5;
//TODO

    public static void main(String[] args) {

        System.out.println("MAx sum " + maxSumMatrixBruteForce());

    }

    /*
    O(n^4) TODO NOT WORKING
     */
    public static int maxSumMatrixBruteForce() {
        int maxSum = 0;
        for (int i = 0; i < row; i++) {

            for (int j = 0; j < column; j++) {


                int sum = 0;
                //sum each matrix ixj
                for (int r = i; r < row; r++) {
                    for (int c = j; c <column; c++) {
                        sum += mat[r][c];
                    }
                }

                System.out.println("Sum for matrix " + i + "x" + j + " : " + sum);
                maxSum = Math.max(maxSum, sum);
            }

        }

        return maxSum;
    }

}
