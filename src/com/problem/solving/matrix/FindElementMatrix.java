package com.problem.solving.matrix;

import com.problem.solving.BaseProblem;

import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
 *
 * @author rachita
 */

public class FindElementMatrix extends BaseProblem {

    @Override
    public void execute() {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter T Test case counr ");
        int t = in.nextInt();
        System.out.println("Enter row  and column size ");
        int r = in.nextInt();
//		System.out.println("Enter column count ");
        int c = in.nextInt();
        int[][] arr = new int[r][c];
        System.out.println("Enter matrix of size rxc ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println("Enter element to find ");
        int item = in.nextInt();
        findElement1(arr, r, c, item);

        in.close();

    }

    /*
        O(n^2)
     */
    private void findElement(int[][] arr, int r, int c, int item) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == item) {
                    System.out.println("found at (" + i + "," + j + ")");
                    return;
                }
            }

        }

    }

    /*
     * O(n+m)
     */
    private void findElement1(int[][] arr, int r, int c, int item) {
        int i = 0, j = c - 1;
        while (i < r && j >= 0) {

            if (arr[i][j] == item) {
                System.out.println("found at (" + i + "," + j + ")");
                break;
            } else if (item < arr[i][j]) {
                j--;
            } else if (item > arr[i][j]) {
                i++;
            }

        }

    }
}
