package com.problem.solving.ds.tree;

import com.problem.solving.BaseProblem;

public class BinarySearchTreeImp extends BaseProblem {

	private BinarySearchTree tree = new BinarySearchTree();

	@Override
	public void execute() {

		// tree.insertBST(key, root);//
		tree.insert(50); 
        tree.insert(30); 
        tree.insert(20); 
        tree.insert(40); 
        tree.insert(70); 
        tree.insert(60); 
        tree.insert(80); 
		tree.inOrderTraversal(tree.root);
		tree.search(20);
		tree.search(23);
		tree.search(70);
		tree.search(90);
	}

}
