package com.problem.solving.ds.stack;

/**
 * Stack with Arrays Pros: Easy to implement. Memory is saved as pointers are
 * not involved. Cons: It is not dynamic. It doesn’t grow and shrink depending
 * on needs at runtime.
 * https://www.geeksforgeeks.org/stack-data-structure-introduction-program/
 * push(), pop(), isEmpty() and peek() all take O(1) time.
 * Search(), access() O(n)
 * @author rachita LIFO
 */
public class Stack {

	static int top = -1;
	final static int MAX = 10;
	static int arr[] = new int[10];

	public static void main(String[] args) {

		System.out.println("push : 1 x , pop : 0");

		push(2);
		push(5);
		push(8);
		push(11);
		pop();
		pop();
		peek();

		// Scanner in = new Scanner(System.in);
		// int operation = in.nextInt();
		// switch (operation) {
		// case 1:
		// int x = in.nextInt();
		// push(x);
		// break;
		// case 2:
		// pop();
		// break;
		// default:
		// break;
		// }

		// in.close();

	}

	static boolean isEmpty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}

	static void push(int x) {
		if (top < MAX) {
			arr[++top] = x;
		}
		printArray();
	}

	static int pop() {
		if (!isEmpty()) {
			top--;
		}
		printArray();
		return -1;
	}

	static void printArray() {
		for (int i = 0; i <= top; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
	}

	static void peek() {
		if (!isEmpty()) {
			System.out.println(arr[top]);
		}
	}

}
