package com.problem.solving.dynamicconnectivity;

/**
 * eager approach
 * @author rachita
 * https://www.coursera.org/learn/algorithms-part1/lecture/ZgecU/quick-union
 */
public class QuickFind {
	
	private int array[];
	
	public QuickFind(int n){
		
		array = new int[n];
		for(int i=0;i<n;i++){
			array[i] = i;
		}
		
	}
	
	private boolean connected(int p, int q){	
		return array[p]==array[q];	
	}

	private void union(int p, int q){
		int pId=array[p];
		int qId=array[q];
		
	for (int i=0;i<array.length;i++){
		if(array[i]==pId){
			array[i]=qId;
		}
	}
		
	}
}
