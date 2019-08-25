package com.problem.solving;

public class Utils {

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    public static void printMatrix(int[][] arr, int n) {
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(" " + arr[i][j]);

            }
        }
    }


    public static void printMatrix(boolean[][] arr, int n) {
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(" " + arr[i][j]);

            }
        }
    }

    public static <T > T[][] printMatrix(T[][] arr, int n) {
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(" " + arr[i][j]);

            }
        }
        return arr;
    }

}
