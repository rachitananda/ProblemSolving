package com.problem.solving.matrix;

import java.util.HashSet;

/*
https://www.geeksforgeeks.org/a-boolean-matrix-question/
Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 (or true) then make
all the cells of ith row and jth column as 1.
 */
public class BooleanMatrix {

    static int R = 3, C = 4;
    static int mat[][] =
            {{1, 0, 0, 1},
            {0, 0, 1, 0},
            {0, 0, 0, 0}};

    public static void main(String[] args) {
        getBooleanMatrix();
    }

    /*
       O(n^2+n^2)=O(2n^2)
     */
    static void getBooleanMatrix(){

        //Set to ensure no duplicate entries
        HashSet<Integer> rowIndexes = new HashSet<>();
        HashSet<Integer> colIndexes = new HashSet<>();

        for(int i =0;i<R;i++){
            for(int j=0;j< C;j++){
                if(mat[i][j]==1){
                    rowIndexes.add(i);
                    colIndexes.add(j);
                }
            }
        }

        for(int i =0;i<R;i++){
            for(int j=0;j< C;j++){
                if(rowIndexes.contains(i)|| colIndexes.contains(j)){
                    mat[i][j]=1;
                }
            }
        }
        print();

    }

    static void print(){

        System.out.println("Solution:");
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(" "+mat[i][j]+" ");
            }
            System.out.println();
        }
    }

}
