package com.problem.solving.matrix;

import com.problem.solving.Utils;

/**
 * https://www.geeksforgeeks.org/rotate-matrix-90-degree-without-using-extra-space-set-2/
 * Given a square matrix, turn it by 90 degrees in anti-clockwise direction without using any extra space.
 */
public class Rotate90Matrix {


    int matrix[][] = {{1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    int mat[][] = {{1, 2, 3, 4},
            {5, 5, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
    };

    int n = 3;
    int m = 4;

    public static void main(String[] args) {

        Rotate90Matrix problem = new Rotate90Matrix();
//        problem.rotate90AntiClockwise(problem.matrix, problem.n);
//        problem.rotate90AntiClockwise(problem.mat, problem.m);
        problem.rotate90Clockwise(problem.matrix, problem.n);

    }


    /**
     * https://www.geeksforgeeks.org/rotate-matrix-90-degree-without-using-extra-space-set-2/
     *
     * @param arr
     * @param n
     */
    private void rotate90AntiClockwise(int arr[][], int n) {
        Utils.printMatrix(arr, n);

        arr = transpose(arr, n);
        Utils.printMatrix(arr, n);

        arr = reverseColumn(arr, n);
        Utils.printMatrix(arr, n);
    }

    /**
     * https://www.geeksforgeeks.org/rotate-a-matrix-by-90-degree-in-clockwise-direction-without-using-any-extra-space/
     *
     * @param arr
     * @param n
     */
    private void rotate90Clockwise(int arr[][], int n) {
        Utils.printMatrix(arr, n);

        arr = transpose(arr, n);
        Utils.printMatrix(arr, n);

        arr = reverseColumnClockwise(arr, n);
        Utils.printMatrix(arr, n);
    }

    /**
     * https://www.geeksforgeeks.org/program-to-find-transpose-of-a-matrix/
     *
     * @param arr
     * @param n
     * @return
     */
    private int[][] transpose(int arr[][], int n) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[0].length; j++) {
                int temp = arr[j][i];
                arr[j][i] = arr[i][j];
                arr[i][j] = temp;
            }
        }
        return arr;
    }

    private int[][] reverseColumn(int arr[][], int n) {

        for (int i = 0; i < n; i++) {//row
            int k = arr[0].length - 1;
            for (int j = 0; j < k; j++) {//col
                int temp = arr[j][i];
                arr[j][i] = arr[k][i];
                arr[k][i] = temp;
                k--;
            }
        }
        return arr;
    }


    private int[][] reverseColumnClockwise(int arr[][], int n) {

        for (int i = 0; i < n; i++) {//row
            int k = arr[0].length - 1;
            for (int j = 0; j < k; j++) {//col
                int temp = arr[i][j];
                arr[i][j] = arr[i][k];
                arr[i][k] = temp;
                k--;
            }
        }
        return arr;
    }


}
