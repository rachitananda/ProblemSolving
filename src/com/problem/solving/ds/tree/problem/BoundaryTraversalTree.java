package com.problem.solving.ds.tree.problem;

import com.problem.solving.BaseProblem;
import com.problem.solving.ds.tree.BinaryTree;
import com.problem.solving.ds.tree.Node;

/*
https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
 */
public class BoundaryTraversalTree extends BaseProblem {

    BinaryTree tree = new BinaryTree(20);


    @Override
    public void execute() {
        createTree();
        System.out.println("Boundary Traversal:");
        leftTraversal(tree.root);
        boundaryTraversal(tree.root);
        rightTraversal(tree.root);


    }


    private void leftTraversal(Node root) {
        if (root == null) {
            return;
        }
        if(root.left!=null || root.right!=null) {
            //ignore boundary/leaf nodes
            System.out.print(root.data + " ");
        }

        if (root.left != null) {
            leftTraversal(root.left);

        }
    }

    private void rightTraversal(Node root) {
        if (root == null) {
            return;
        }

        if (root.right != null) {
            rightTraversal(root.right);

        }
        if(tree.root!=root && (root.left!=null || root.right!=null)) {
            //dont print root mnode & leaf nodes
            System.out.print(root.data + " ");
        }
    }


    private void boundaryTraversal(Node root) {

        if (root == null) {
            return;
        }
        if ((root.left == null && root.right == null)) {
            System.out.print(root.data + " ");
        }

        if (root.left != null) {
            boundaryTraversal(root.left);

        }

        //print right node only if its leaf node
        if (root.right != null) {

            boundaryTraversal(root.right);
        }
    }

    private void createTree() {
        Node n22 = new Node(22);
        Node n25 = new Node(25);
        n22.right = n25;

        Node n12 = new Node(12);
        Node n10 = new Node(10);
        Node n14 = new Node(14);
        n12.right = n14;
        n12.left = n10;

        Node n4 = new Node(4);
        Node n8 = new Node(8);

        n8.right = n12;
        n8.left = n4;

        tree.root.left = n8;
        tree.root.right = n22;

        System.out.println("--Tree created--");
        tree.levelOrderTraversal();

    }
}
