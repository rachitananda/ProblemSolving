package com.problem.solving.backtracking;

/*
@author rachita

 https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/
 */
public class RatInMaze {

    static int n = 4;


    static int[][] maze = {
            {1, 1, 1, 1},
            {1, 0, 1, 1},
            {0, 1, 1, 1},
            {1, 1, 1, 1}
    };

    public static void main(String[] args) {

        int solution[][] = new int[n][n];

        solveMaze(maze, 0, 0, solution);

        printSolution(solution);

    }

    private static void printSolution(int[][] solution) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();

        }
    }


    static boolean solveMaze(int[][] maze, int x, int y, int[][] sol) {
        //destination reached
        if (x == n - 1 && y == n - 1) {
            sol[x][y] = 1;
            return true;
        }

        //check if its a valid coordinate to check the path ahead

        if (isValidCoordinate(maze, x, y)) {
            sol[x][y] = 1;

            //move in right/x direction  & check if destination reached
            if (solveMaze(maze, x + 1, y, sol)) {
                return true;
            }

            //move in down/y direction  & check if destination reached
            if (solveMaze(maze, x, y + 1, sol)) {
                return true;
            }

            //BACKTRACK no path found till destination from (x,y)
            sol[x][y] = 0;

        }

        return false;
    }


    static boolean isValidCoordinate(int[][] maze, int x, int y) {
        return (x >= 0 && y >= 0 && x < n && y < n && maze[x][y] == 1);
    }

}


