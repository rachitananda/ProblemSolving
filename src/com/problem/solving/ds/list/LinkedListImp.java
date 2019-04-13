package com.problem.solving.ds.list;

import com.problem.solving.BaseProblem;
/**
 * https://www.geeksforgeeks.org/linked-list-vs-array/
 * @author rachita
 *
 */
public class LinkedListImp extends BaseProblem {

	private Node head = new Node(1);
	private Node second = new Node(2);
	private LinkedList ll = new LinkedList();

	@Override
	public void execute() {
		// TODO Auto-generated method stub
//		head.next = second;
		/*System.out.println("LINKED LIST");
		printList();
		insertAtEnd(new Node(3));
		insertAtBegining(new Node(0));
		insertAfterN(new Node(9), 1);*/
		
		/*ll.insertAtEnd(new Node(1));
		ll.insertAtEnd(new Node(2));
		ll.insertAtEnd(new Node(3));
		ll.insertAtEnd(new Node(4));
		ll.insertAtStart(new Node(5));
		ll.printList();
		ll.insertAfterNode(new Node(6), 3);
		ll.deleteNode(2);
		ll.deleteAtN(3);*/
		
		createLoop();
		
		
	}
	//search
	//delete at key
	//delete at given position
	//find length of linked list
	//get Nth node
	//detect loop in a linked list

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

	private void createLoop(){
		LinkedList ll = new LinkedList();
		Node n5 = new Node(5);
		Node n2= new Node(2);
		ll.insertAtEnd(new Node(1));
		ll.insertAtEnd(n2);
		ll.insertAtEnd(new Node(3));
		ll.insertAtEnd(new Node(4));
		ll.insertAtEnd(n5);
		n5.next=n2;
		
		
		ll.findLoop();
		
	}
}
