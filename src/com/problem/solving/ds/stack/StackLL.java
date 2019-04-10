package com.problem.solving.ds.stack;

/**
 * Stack implementation with Linked List
 * 
 * @author rachita http://bigocheatsheet.com/ Pros: The linked list
 *         implementation of stack can grow and shrink according to the needs at
 *         runtime. Cons: Requires extra memory due to involvement of pointers.
 */
public class StackLL {

	static class StackNode {
		int data;
		StackNode next;

		StackNode(int data) {
			this.data = data;
		}
	}

	static StackNode top;

	public static void main(String[] args) {
		System.out.println("StackLL");
		push(1);
		push(2);
		push(3);
		pop();
		pop();

	}

	static void push(int x) {
		StackNode node = new StackNode(x);
		if (isEmpty()) {
			node.next = null;
			top = node;
		} else {
			StackNode temp = top;
			//node.next = temp;
			top = node;
			node.next=temp;
		}
		print();
	}
	
	static void pop(){
		if(!isEmpty()){
			top= top.next;
		}
		print();
	}
	static void print(){
		if(isEmpty()){
			return;
		}
		System.out.println();
		StackNode node= top;
		do{
			System.out.print(+node.data+" ");
			node=node.next;
		}while(node!=null);
	}
	static boolean isEmpty() {
		if (top == null) {
			return true;
		} else {
			return false;
		}
	}
}
