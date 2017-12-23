package com.problem.solving.matrix;

import java.util.Scanner;

import com.problem.solving.BaseProblem;

/**
 * https://www.geeksforgeeks.org/given-n-x-n-square-matrix-find-sum-sub-squares-size-k-x-k/
 * 
 * @author rachita
 *
 */
public class SubMatrixSum extends BaseProblem {

	@Override
	public void execute() {

		int n = 3, k = 2;
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		//TODO issues with logic
//		for (int i = 0; i <=(n-k); i++) {
//			for (int j = 0; j <= n-k; j++) {
//				//sub matrix
//				int sum=0;
//				System.out.println("i ,j "+ i+ ", ");
//				for (int a = i; a < k; a++) {
//					for (int b = j; b < k; b++) {
//						sum+=arr[a][b];
//
//					}
//				}
//				System.out.println(sum);
//
//			}
//		}
	}
}
