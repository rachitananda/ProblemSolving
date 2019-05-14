package com.problem.solving.ds.list;

import java.util.HashSet;

public class LinkedList {
	Node start;

	// public LinkedList(NodeWithParentPtr start){
	// this.start= start;
	// this.start=null;
	// }

	/**
	 * O(n)
	 * 
	 * @param node
	 */
	public void insertAtEnd(Node node) {

		if (start == null) {
			node.next = null;
			start = node;
		} else {
			Node n = start;
			while (n.next != null) {
				n = n.next;
			}
			n.next = node;
			node.next = null;

		}

	}

	public void insertAtStart(Node node) {
		if (start == null) {
			start = node;
			return;
		}

		node.next = start;
		start = node;
	}

	public void insertAfterNode(Node node, int key) {
		if (start == null) {
			return;
		} else {
			Node n = start;
			while (n.next != null) {
				if (n.data == key) {
					node.next = n.next;
					n.next = node;
					break;
				}
				n = n.next;
			}

		}

		printList();

	}

	public void deleteNode(int key) {
		if (start == null) {
			return;
		}
		Node n = start;
		Node prev = start;
		while (n != null) {
			if (n.data == key) {
				prev.next = n.next;
				break;
			}
			prev = n;
			n = n.next;
		}
		printList();
	}

	public void deleteAtN(int position) {
		if (start == null) {
			return;
		}
		int ctr = 0;
		Node n = start;
		Node prev = start;
		while (n != null) {

			if (ctr == position) {
				prev.next = n.next;
				break;
			}
			ctr++;
			prev = n;
			n = n.next;

		}
		printList();
	}

	public void findLoop() {
		if (start == null) {
			return;
		}
		HashSet<Node> hs = new HashSet<Node>();
		Node n = start;
		while (n != null) {
			if (hs.contains(n)) {
				System.out.println("loop at " + n.data);
				break;
			}
			hs.add(n);
			n = n.next;
		}

	}

	public boolean checkIfLinkedListsIntersect(LinkedList otherList) {
		HashSet<Node> hs= new HashSet<Node>();
		Node n=start;
		while(n!=null){
			hs.add(n);
			n= n.next;
		}
		n= otherList.start;
		while(n!=null){
			if(hs.contains(n)){
				System.out.println("intersect at "+n.data);
				return true;
			}
			n=n.next;
		}
		
		return false;
	}

	public void printList() {
		if (start == null) {
			return;
		}
		System.out.println();
		Node n = start;
		while (n != null) {
			System.out.print(+n.data + " ");
			n = n.next;
		}
	}

}
