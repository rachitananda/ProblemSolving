package com.problem.solving.tree;

import com.problem.solving.BaseProblem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS /Level order tree traversal
 * https://www.geeksforgeeks.org/level-order-tree-traversal/
 */
public class TreeTraversal extends BaseProblem {

    @Override
    public void execute() {
        createTree();
    }

    /**
     * //     *               1
     * //     *            /   \
     * //     *           2     3
     * //     *         /   \  /  \
     * //     *        4    5  6   7
     * output
     * level order/BFS : 1234567
     */
    private void createTree() {
        BinaryTree tree = new BinaryTree(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        tree.root.left = n2;
        tree.root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        System.out.print("levelOrderTraversal ");
        tree.levelOrderTraversal();
        System.out.println();
        System.out.print("InOrderTraversal");
        tree.inOrderTraversal(tree.root);
        System.out.println();
        System.out.print("PreOrderTraversal");
        tree.preOrderTraversal(tree.root);
        System.out.println();
        System.out.print("PostOrderTraversal");
        tree.postOrderTraversal(tree.root);

    }

}
