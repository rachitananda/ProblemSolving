package com.problem.solving.matrix;

/**
 * https://www.geeksforgeeks.org/find-the-row-with-maximum-number-1s/
 * Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s.
 */
public class FindRowWithMax1s {

    int mat[][] = {{0, 0, 0, 1},
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 0, 0, 0}};

    int n = 4;


    public static void main(String[] args) {

        FindRowWithMax1s problem = new FindRowWithMax1s();
        System.out.println("Row with max :" + problem.rowWithMax1s(problem.mat, problem.n));

    }

    /**
     * O(m+n)
     *
     * @param mat
     * @param n
     * @return
     */
    private int rowWithMax1s(int[][] mat, int n) {

        int i = 0;
        int j = 0;
        int max = -1;

        while (i < n) {
            if (mat[i][j] == 0) {
                if (j == n - 1) {
                    //last item in row
                    //move to next row
                    j = 0;
                    i++;
                } else {
                    //go right in same row
                    j++;
                }
            } else {
                //mat[i][j]==1
                //check next row if it has more 1s
                max = i;
                if (j == 0) {
                    //found row with all 1s
                    break;
                }
                //since sorted row , look for a 1s in row below
                // before current j where 1 is found
                j--;
                i++;
            }
        }
        return max;
    }
}
