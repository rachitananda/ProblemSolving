package com.problem.solving.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 * Problem : W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights
 * of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it
 * (0-1 property).
 * 1) Optimal Substructure:
 * To consider all subsets of items, there can be two cases for every item: (1) the item is included in the optimal subset, (2) not included in the optimal set.
 * Therefore, the maximum value that can be obtained from n items is max of following two values.
 * 1) Maximum value obtained by n-1 items and W weight (excluding nth item).
 * 2) Value of nth item plus maximum value obtained by n-1 items and W minus weight of the nth item (including nth item).
 * <p>
 * If weight of nth item is greater than W, then the nth item cannot be included and case 1 is the only possibility.
 */

public class Knapsack {

    public static void main(String[] args) {

        Knapsack knapsack = new Knapsack();

        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;

        int maxValue = knapsack.knapsack(val.length, W, wt, val);

        System.out.println("Max Val knapsack : " + maxValue);
        System.out.println("Max Val knapsack DP : " + knapsack.knapsackDP(val.length,W,wt,val));

    }

    /**
     * recursive + has overlapping sub problems
     * Brute force
     * computes for each subproblem
     * O(2^n) - EXPONENTIAL
     *
     * @param n   total items
     * @param W   knapsack capacity weight
     * @param wt  weight[]
     * @param val value[]
     * @return max value the bag can hold while filling to full wt capacity
     */
    private int knapsack(int n, int W, int wt[], int val[]) {

        if (n == 0 || W == 0) {
            return 0;
        }
        // If weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (wt[n - 1] > W) {
            return knapsack(n - 1, W, wt, val);
        }

        //exclude the this item
        int case1 = knapsack(n - 1, W, wt, val);

        //include this item
        int case2 = val[n - 1] + knapsack(n - 1, W - wt[n - 1], wt, val);

        // Return the maximum of two cases:
        // (1) nth item included
        // (2) not included
        return Math.max(case1, case2);

    }


    /**
     * O(n*W)
     * DP
     */
    private int knapsackDP(int n, int W, int wt[], int val[]) {

        int[][] solution = new int[n + 1][W + 1];


        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {

                if (i == 0 || w == 0) {
                    solution[i][W] = 0;
                }

               else if (wt[i - 1] <= w) {
                    //exclude the this item
                    int case1 = solution[i - 1][w];
                    //include this item
                    int case2 = val[i - 1] + solution[i - 1][w - wt[i - 1]];
                    solution[i][w] = Math.max(case1, case2);
                } else {
                    // If weight of the nth item is more than Knapsack capacity W, then
                    // this item cannot be included in the optimal solution
                    solution[i][w] = solution[i - 1][W];
                }

            }
        }

        //print solution matrix
        System.out.println("Solution matrix: ");
        for(int i = 0;i<n+1;i++ ){
            for(int j=0;j<W+1;j++){
                System.out.print(solution[i][j]+" ");
            }
            System.out.println();
        }

        return solution[n][W];
    }


}
