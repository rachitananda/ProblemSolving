package com.problem.solving.numbersytem;

import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/count-set-bits-in-an-integer/
 * 
 * @author rachita
 * 
 */
public class CountSetBits {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int output[] = new int[t];
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			output[i] = countSetBitsRecursive(n);
		}

		for (int j = 0; j < t; j++) {
			System.out.println(output[j]);
		}
		in.close();
	}

	/**
	 * not a good approach
	 * 
	 * @param n
	 * @return
	 */
	static int countSetBits1(int n) {
		int ctr = 0;
		while (n > 0) {

			int rem = n % 2;
			if (rem > 0) {
				ctr++;
			}
			n = n / 2;
		}
		return ctr;
	}

	/**
	 * using bit wise operator
	 * 
	 * @param n
	 * @return
	 */
	static int countSetBits(int n) {
		int ctr = 0;
		while (n > 0) {
			// will check if last bit is 0 or 1
			ctr += n & 1;// 110 &
							// 001
							// = 000
			n = n >> 1;// eliminate the counted bit by right shirt 110>>1 = 11
						// or 011
		}
		return ctr;
	}

	static int count = 0;

	// static int countSetBitsRecursive(int n){
	//
	// if(n==0){
	// return count;
	// }
	//
	// count+=n & 1;// 110 &
	// // 001
	// //= 000
	// n= n>>1;// eliminate the counted bit by right shift 110>>1 = 11 or 011
	//
	// count= countSetBitsRecursive(n);
	// }

	public static int countSetBitsRecursive(int n) {
		int x;
		// base case
		if (n == 0) {
			System.out.println("bestcase 0");
			return 0;
		}

		else {
			x = (n & 1) + countSetBits(n >> 1);
			System.out.println("x" + x);
			return x;
		}
	}

}
