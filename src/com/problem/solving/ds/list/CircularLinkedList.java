package com.problem.solving.ds.list;

import com.problem.solving.BaseProblem;

import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/circular-linked-list/
 */
public class CircularLinkedList extends BaseProblem {
	Node head = null;

	@Override
	public void execute() {
		Scanner in = new Scanner(System.in);
		int t= in.nextInt();
		for (int i=0;i<t;i++) {
			int size=in.nextInt();
			//get linkedlist
			for(int j=0; j<size;j++) {
				appendNode(new Node(in.nextInt()));
			}
			traverse(head);
			//element to be inserted
			insertInSortedList(head, new Node(in.nextInt()));
			
			traverse(head);
			
		}
		
		in.close();
		

	}

	private void traverse(Node node) {
		if (head == null)
			return;
		System.out.print(head.data+" ");
		while(node.next!=head) {
			node=node.next;
			System.out.print(node.data+" ");
		}

	}

	private void appendNode(Node node) {
		if (node == null)
			return;

		if (head == null) {
			head=node;
			head.next = head;
		}
		Node n= head;
		while(n.next!=head) {
			n=n.next;
		}
		//last item found
		n.next=node;
		node.next=head;
	
	}
	/**
	 * https://practice.geeksforgeeks.org/problems/sorted-insert-for-circular-linked-list/1
	 * Given a sorted circular linked list, insert a newnode so that it remains a sorted circular linked list.
	 */
	private void insertInSortedList(Node head,Node node){
		
		Node n= head;
		boolean isInserted = false;
		while(n.next!=head) {
			
			if(node.data>n.data && node.data < n.next.data) {
				//insert here in between
				node.next=n.next;
				n.next=node;
				isInserted=true;
				break;
			}
			n=n.next;
		   
		}
		//appends at last - largest element
		if(!isInserted) {
		n.next=node;
		node.next=head;
		}	
		
		
	}

}
