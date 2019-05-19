package com.problem.solving.matrix;

import com.problem.solving.BaseProblem;

import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
 *
 * @author rachita
 */

public class FindElementMatrix extends BaseProblem {
    static int i, j;
    int mat[][] = {{10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}};

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

        in.close();
//        findElement1(arr, r, c, item);
        //recursive
        i = 0;
        j = c - 1;
        System.out.println("found :" + findElementR(arr, r, c, item));


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

    private boolean findElementR(int[][] arr, int r, int c, int item) {


        if (i == r - 1 && j == 0) {
            //not found
            return false;
        }
        if (item < arr[i][j] && j > 0) {
            j--;
        } else if (item > arr[i][j] && i < r - 1) { //>
            i++;
        } else if (item == arr[i][j]) {
            return true;
        } else {
            return false;
        }
        return findElementR(arr, r, c, item);

    }


}
