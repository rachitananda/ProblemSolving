package com.problem.solving.ds.tree.problem;

import com.problem.solving.BaseProblem;
import com.problem.solving.ds.tree.BinaryTree;
import com.problem.solving.ds.tree.Node;

/*
https://www.geeksforgeeks.org/foldable-binary-trees/
 */
public class FoldableBinaryTree extends BaseProblem {
    BinaryTree tree = new BinaryTree(10);
    BinaryTree tree2 = new BinaryTree(100);


    @Override
    public void execute() {

        createTree();

        System.out.println("IsFoldable:  " + isFoldable(tree2));

    }

    //BETTER SOLUTION ON WEBSITE
    private boolean isFoldable(BinaryTree tree) {
        if (tree.root.left == null || tree.root.right == null) {
            //root should have both child nodes
            return false;
        }
        return checkChildNodes(tree.root.left, tree.root.right);
    }

    private boolean checkChildNodes(Node left, Node right) {
        if (left == null && right == null) {
            return true;
        }

        if ((left.right != null && right.left != null) ||
                (left.left == null && right.right == null) ||
                (left.right == null && right.left == null) ||
                (left.left != null && right.right != null)) {
            //check mirror condition
            return (checkChildNodes(left.left, right.right) && checkChildNodes(left.right, right.left));
        } else {
            return false;
        }
    }

    private void createTree() {
        Node n7 = new Node(7);
        Node n9 = new Node(9);
        Node n11 = new Node(11);
        Node n15 = new Node(15);
        n15.left = n11;
        n7.right = n9;
        tree.root.left = n7;
        tree.root.right = n15;
        tree.levelOrderTraversal();

        System.out.println("Tree 2");
        Node n70 = new Node(70);
        Node n90 = new Node(90);
        Node n150 = new Node(150);
        Node n110 = new Node(11);
        n70.left = n90;
        n150.left = n11;
        tree2.root.left = n70;
        tree2.root.right = n150;
        tree2.levelOrderTraversal();
    }
}
