package com.problem.solving.dynamicprogramming;

import com.problem.solving.BaseProblem;

/*
https://www.geeksforgeeks.org/find-the-longest-path-in-a-matrix-with-given-constraints/
DP
 */
public class LongestPathMatrix extends BaseProblem {

    int mat[][] = {{1, 2, 9},
            {5, 3, 8},
            {4, 6, 7}};

    int n = 3;



    @Override
    public void execute() {

        getLongestPath();

    }


    /*
     O(n^2)
     */
    private void getLongestPath() {

        int result = 1;
        int[][] lookup = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                lookup[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                //solution not computed for cell
                if (lookup[i][j] == -1) {
                    getLongestPathFromCell(i, j, lookup);
                }

                int val=lookup[i][j];
                result = Math.max(result, val);
            }
        }
        System.out.println("Longest Path : " + result);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" "+lookup[i][j]+" ");
            }
            System.out.println();
        }

    }

    private int getLongestPathFromCell(int i, int j, int[][] lookup) {


        if (i<0 || i>=n || j<0 || j>=n)
            return 0;

        //problem is solved
        if (lookup[i][j] != -1) {
            return lookup[i][j];
        }

        // Since all numbers are unique and in range from 1 to n*n,
        // there is atmost one possible direction from any cell
        //down
        if (j < n - 1 && (mat[i][j] + 1) == mat[i][j + 1]) {
            return lookup[i][j] = 1 + getLongestPathFromCell(i, j + 1, lookup);
        }
        //up
        if (j > 0 && (mat[i][j] + 1) == mat[i][j - 1]) {
            return lookup[i][j] = 1 + getLongestPathFromCell(i, j + 1, lookup);
        }
        //right
        if (i < n - 1 && (mat[i][j] + 1) == mat[i + 1][j]) {
            return lookup[i][j] = 1 + getLongestPathFromCell(i + 1, j, lookup);
        }
        //left
        if (i > 0 && (mat[i][j] + 1) == mat[i - 1][j]) {
            return lookup[i][j] = 1 + getLongestPathFromCell(i - 1, j, lookup);
        }


        return lookup[i][j] = 1;
    }


}
