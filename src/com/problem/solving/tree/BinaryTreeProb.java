package com.problem.solving.tree;

import com.problem.solving.Problem;

public class BinaryTreeProb implements Problem {
	private BinaryTree tree= new BinaryTree();
	private Node node2= new Node(2);
	private Node node3= new Node(3);
	private Node node4= new Node(4);
	@Override
	public void execute() {
		System.out.println(getClass().getSimpleName());

		createTree();

	}

	/**
	 *       tree
	      ----
	       1    <-- root
	     /   \
	    2     3  
	   /   
	  4
	 */
		private void createTree() {
		
			tree.root.right=node3;
			tree.root.left=node2;
			node2.left=node4;
			
		}
	
}