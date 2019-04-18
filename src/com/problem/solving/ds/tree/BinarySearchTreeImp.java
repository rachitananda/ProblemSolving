package com.problem.solving.ds.tree;

import com.problem.solving.BaseProblem;

public class BinarySearchTreeImp extends BaseProblem {

	private BinarySearchTree tree = new BinarySearchTree();

	@Override
	public void execute() {
		
		
		/* Let us create following BST 
        50 
     /     \ 
    30      70 
   /  \    /  \ 
  20   40  60   80 */

		
		tree.insert(50); 
        tree.insert(30); 
        tree.insert(20); 
        tree.insert(40); 
        tree.insert(70); 
        tree.insert(60); 
        tree.insert(80); 
        System.out.println("\nHeight of Tree "+tree.getDepth());
		tree.inOrderTraversal(tree.root);
		tree.search(20);
		tree.search(23);
		tree.search(70);
		tree.search(90);
		
		System.out.println("\nDelete 20");
		tree.delete(20);
		System.out.println("Inorder traversal of the modified tree");
		tree.inOrderTraversal(tree.root);

		System.out.println("\nDelete 30");
		tree.delete(30);
		System.out.println("Inorder traversal of the modified tree");
		tree.inOrderTraversal(tree.root);

		System.out.println("\nDelete 50");
		tree.delete(50);
		System.out.println("Inorder traversal of the modified tree");
		tree.inOrderTraversal(tree.root);
		
		
	}

}
