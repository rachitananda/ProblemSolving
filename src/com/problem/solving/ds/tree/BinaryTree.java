package com.problem.solving.ds.tree;


import java.util.LinkedList;
import java.util.Queue;

/** https://www.geeksforgeeks.org/binary-tree-data-structure/
 * @author rachita
 *Why Trees?
1. One reason to use trees might be because you want to store information that naturally forms a hierarchy.
 For example, the file system on a computer: 
 2. Trees (with some ordering e.g., BST) provide moderate access/search (quicker than Linked List and slower than arrays).
3. Trees provide moderate insertion/deletion (quicker than Arrays and slower than Unordered Linked Lists).
4. Like Linked Lists and unlike Arrays, Trees don�t have an upper limit on number of nodes as nodes are linked using pointers.
Main applications of trees include:
1. Manipulate hierarchical data.
2. Make information easy to search (see tree traversal).
3. Manipulate sorted lists of data.
4. As a workflow for compositing digital images for visual effects.
5. Router algorithms
6. Form of a multi-stage decision-making (see business chess).

Binary Tree: A tree whose elements have at most 2 children is called a binary tree. 
Since each element in a binary tree can have only 2 children, we typically name them the left and right child. 
 */
public class BinaryTree {
	
	public Node root= new Node(1);

	
	public BinaryTree(){
		root=null;
	}
	public BinaryTree(int key){
		root=new Node(key);
	}


	/**
	 * https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
	 * O(n)
	 * L Root R
	 * DFS
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
	 * DFS
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
	 * DFS
	 */
	public void postOrderTraversal(Node root) {

		if (root == null)
			return;

		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(" " + root.data + " ");

	}

	/*
	 * https://www.geeksforgeeks.org/level-order-tree-traversal/
      O(n) complexity
      BFS
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
	
	
	public int getDepth(){
		return getHeight(root);
	}
	
	/**
	 *O(n) 
	 *https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
	 * @param root
	 * @return
	 */
	public int getHeight(Node root){
		
		if(root== null){
			return 0;
		}
		int maxRhs=1,maxLhs=1;
		if(root.right!=null)
		maxRhs+=getHeight(root.right);
		
		if(root.left!=null)
		maxLhs += getHeight(root.left);

		//System.out.println("height"+Math.max(maxRhs, maxLhs));
		return Math.max(maxRhs, maxLhs);
	}



	
}
