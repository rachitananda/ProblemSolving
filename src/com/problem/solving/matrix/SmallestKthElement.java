package com.problem.solving.matrix;

import java.util.Scanner;

public class SmallestKthElement  {

    static int mat[][] = { {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50} };

    public static void  main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("For smallest Kth elemenr- Enter K: ");
        int k = in.nextInt();
        in.close();
    }
//TODO
//    static int findKthSmallest(int k, int r , int c) {
//        if(k >((r-1)*(c-1))) {
//            System.out.println("K should not be greater than total no of elements in the matrix");
//            return -1;
//        }
//        k = k-1;
//        if(k==0) {
//            //smallest element in sorted matrix;
//            return mat[0][0];
//        }
//        int ctr=0;
//        int i= 0,j=0;
//        int item= -1;
//        while(i<=r-1 && j<=c-1) {
//            if(
//        }
//
//        return item;
//    }
}

