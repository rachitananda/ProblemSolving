package com.problem.solving.ds.tree;

import com.problem.solving.BaseProblem;

public class BinaryTreeProb extends BaseProblem {
    private BinaryTree tree = new BinaryTree();
    private Node node1 = new Node(2);
    private Node node2 = new Node(2);
    private Node node3 = new Node(3);
    private Node node4 = new Node(4);

    @Override
    public void execute() {
        System.out.println(getClass().getSimpleName());

        createTree();
        System.out.println("Height of Tree " + tree.getDepth());

    }

    /**
     * //	 *       tree
     * //	      ----
     * //	       1    <-- root
     * //	     /   \
     * //	    2     3
     * //	   /
     * //	  4
     */
    private void createTree() {
        tree.root = node1;
        tree.root.right = node3;
        tree.root.left = node2;
        node2.left = node4;
    }

}
