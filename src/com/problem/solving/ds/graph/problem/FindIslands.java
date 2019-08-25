package com.problem.solving.ds.graph.problem;

/**
 * https://www.geeksforgeeks.org/find-number-of-islands/
 * https://www.youtube.com/watch?v=CGMNePwovA0
 */
public class FindIslands {

    static int mat[][] = new int[][]{{1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}};
    static int n = 5;

    boolean visited[][] = new boolean[n][n];

    public static void main(String[] args) {
        FindIslands problem = new FindIslands();
        System.out.println("Cluster count : " + problem.getIslandCount(mat, n, n));

    }

    /**
     * O(rowCount*colCount)
     *
     * @param mat
     * @param rowCount
     * @param colCount
     * @return
     */
    private int getIslandCount(int[][] mat, int rowCount, int colCount) {
        visited = new boolean[rowCount][colCount];
        int clusterCount = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (isValidCell(i, j, rowCount, colCount)) {
                    DFS(mat, i, j, rowCount, colCount);
                    clusterCount++;
                }
            }
        }


        return clusterCount;
    }

    private void DFS(int mat[][], int i, int j, int rowCount, int colCount) {

        //check 8 adjacent cells
        int[] rowAdjIndex = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] colAdjIndex = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
        int k = 8;

        visited[i][j] = true;

        //for each adjacent cell
        for (int m = 0; m < k; m++) {
            int row = i + rowAdjIndex[m];
            int col = j + colAdjIndex[m];
            if (isValidCell(row, col, rowCount, colCount)) {
                //the DFS loop will break when no unvisted cell with value=1 is found
                //i.e cluster is complete
                DFS(mat, row, col, rowCount, colCount);
            }
        }


    }

    private boolean isValidCell(int i, int j, int rowCount, int colCount) {

        //shoul be a vaild cell in bounds of mat
        //should not be visited already
        //should not be 0
        if (i < 0 || j < 0 || i > rowCount-1 || j > colCount-1 || visited[i][j] || mat[i][j] == 0)

            return false;
        else
            return true;// value =1 and unvisited
    }


}
