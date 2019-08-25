package com.problem.solving.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/min-cost-path-dp-6/
 */
public class MinCostPath {

    static int mat[][] = {{1, 2, 3},
            {4, 8, 2},
            {1, 5, 3}};
    int n = 3;

    public static void main(String asr[]) {
        MinCostPath problem = new MinCostPath();
        System.out.println(problem.minCost(2, 2));
    }


    private int minCost(int i, int j) {

        if (i < 0 || j < 0) {
            //not valid cell
            return Integer.MAX_VALUE;
        } else if (i == 0 && j == 0) {
            //orgin reached
            return mat[i][j];
        } else
            return mat[i][j] + min(minCost(i - 1, j),
                    minCost(i, j - 1), minCost(i - 1, j - 1));


    }

    static int min(int x, int y, int z) {
        if (x < y)
            return (x < z) ? x : z;
        else
            return (y < z) ? y : z;
    }

}
