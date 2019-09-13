package com.problem.solving.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/min-cost-path-dp-6/
 * Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost
 * path to reach (m, n) from (0, 0). Each cell of the matrix represents a cost to traverse through that cell.
 * Total cost of a path to reach (m, n) is sum of all the costs on that path (including both source and destination).
 * You can only traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell (i, j),
 * cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed. You may assume that all costs are positive integers.
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
