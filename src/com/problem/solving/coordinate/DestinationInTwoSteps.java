package com.problem.solving.coordinate;

import java.util.Scanner;

/**
 * @author rachita
 * https://www.geeksforgeeks.org/check-destination-reachable-source-two-movements-allowed/
 * <p>
 * Check if a destination is reachable from source with two movements allowed
 * Given coordinates of a source point (x1, y1) determine if it is possible to reach the destination point (x2, y2). From any point (x, y) there only two types of valid movements:
 * (x, x + y) and (x + y, y). Return a boolean true if it is possible else return false.
 * Note: All coordinates are positive.
 */
public class DestinationInTwoSteps {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Src x,y :");
        int x1= in.nextInt();
        int y1 = in.nextInt();
        System.out.println("Enter Dest x,y:");
        int x2= in.nextInt();
        int y2= in.nextInt();
        System.out.println("IsReachable:"+isReachable(x1,y1,x2,y2));
    }

    /**
     *
     * recursively calculate all possible outvcomes of 2 VIA points following (x, x + y) OR (x + y, y).
     * @return boolean if reachable in via 2 points which follow EITHER Of the 2 equation
     * (x, x + y) OR (x + y, y).
     */
    public static boolean isReachable(int x1, int y1, int x2, int y2){
        //src = dest , destination reached
        if(x1==x2 && y1==y2){
            return true;
        }
        //stop checking as all coordinates are +ve
        if(x1>x2 || y1>y2){
            return false;
        }

        return(isReachable(x1,x1+y1,x2,y2)|| isReachable(x1+y1,y1,x2,y2));

    }

}
