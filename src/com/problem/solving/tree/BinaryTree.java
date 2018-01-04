package com.problem.solving.tree;

import com.problem.solving.ProblemI;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
	Node root= new Node(1);

	
	public BinaryTree(){
		root=null;
	}
	public BinaryTree(int key){
		root=new Node(key);
	}


	/**
	 * O(n)
	 * L Root R
	 */
	public void inOrderTraversal(Node root) {

		if (root == null)
			return;
		inOrderTraversal(root.left);
		System.out.print(" " + root.data + " ");
		inOrderTraversal(root.right);

	}

	/**
	 * O(n)
	 * Root L R
	 */
	public void preOrderTraversal(Node root) {

		if (root == null)
			return;

		System.out.print(" " + root.data + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);

	}

	/**
	 * O(n)
	 * L R Root
	 */
	public void postOrderTraversal(Node root) {

		if (root == null)
			return;

		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(" " + root.data + " ");

	}

	/*
      O(n) complexity
     */
	public void levelOrderTraversal() {

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(this.root);
		while (!queue.isEmpty()) {

			Node node = queue.poll();
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);

			System.out.print(node.data + " ");


		}

	}
}
