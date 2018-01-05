package com.problem.solving.list;

import com.problem.solving.BaseProblem;

public class LinkedList extends BaseProblem {

	private Node head = new Node(1);
	private Node second = new Node(2);

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		head.next = second;
		System.out.println("LINKED LIST");
		printList();
		insertAtEnd(new Node(3));
		insertAtBegining(new Node(0));
		insertAfterN(new Node(9), 1);
	}

	private void insertAfterN(Node node, int n) {
		int ctr = 0;
		Node itr = head;

		while (itr.next != null) {
			ctr++;
			itr = itr.next;
			if (ctr == n) {
				Node temp = itr.next;
				itr.next = node;
				node.next = temp;
				break;
			}

		}
		printList();

	}

	private void insertAtBegining(Node node) {

		node.next = head;
		head = node;
		printList();

	}

	private void insertAtEnd(Node node) {
		Node n = head;

		while (n.next != null) {
			n = n.next;
		}
		// n is last
		n.next = node;
		printList();

	}

	private void printList() {
		// TODO Auto-generated method stub
		Node node = head;

		System.out.print(node.data + " ");
		while (node.next != null) {

			node = node.next;
			System.out.print(node.data + " ");
		}
		System.out.println();

	}

}
