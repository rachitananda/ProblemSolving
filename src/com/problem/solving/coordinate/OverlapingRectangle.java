package com.problem.solving.coordinate;

import java.util.Scanner;

import com.problem.solving.BaseProblem;
/**
 * https://practice.geeksforgeeks.org/problems/overlapping-rectangles/0
 * Given two rectangles, find if the given two rectangles overlap or not. A rectangle is denoted by 
 * providing the x and y co-ordinates of two points the left top corner and the right bottom
 *  corner of the rectangle.
 * @author rachita
 *
 */
public class OverlapingRectangle extends BaseProblem{

	@Override
	public void execute() {
		Scanner in = new Scanner(System.in);
		int t=in.nextInt();
		int i=0;
		while(i<t){
		//coordinates for 1st rect
		int x1=in.nextInt();
		int y1=in.nextInt();
		int a1=in.nextInt();;
		int b1=in.nextInt();
		
		//coordinates for 2nd rect
		int x2=in.nextInt();
		int y2=in.nextInt();
		int a2=in.nextInt();
		int b2=in.nextInt();
		
		System.out.println(isIntersecting(x1,y1,a1,b1,x2,y2,a2,b2));
		
		i++;
		}
		
	}
	
	private  int isIntersecting(int x1, int y1, 
	int a1, int b1,int x2, int y2, int a2, int b2){
	    //check for invalid input
	   // if(x1>a1 || x2>a2){
	   //     return 0;
	   // }
	    
	   int result =1;
	   if(x2>a1 || x1>a2){
	       result=0;
	   } 
	   if(b2>y1|| b1>y2){
	       result=0;
	   }
	   return result;
	}

}
