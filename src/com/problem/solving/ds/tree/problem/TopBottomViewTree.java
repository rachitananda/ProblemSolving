package com.problem.solving.ds.tree.problem;

import com.problem.solving.ds.tree.BinaryTree;
import com.problem.solving.ds.tree.Node;

/**
 * https://www.geeksforgeeks.org/print-nodes-in-top-view-of-binary-tree-set-2/
 */
public class TopBottomViewTree {

    TreeVerticalOrder verticalOrder = new TreeVerticalOrder();

    BinaryTree tree;

    public static void main(String args[]) {

        TopBottomViewTree problem = new TopBottomViewTree();

        problem.createTree();
        problem.verticalOrder.verticalLevelOrder(problem.tree.root);
        problem.verticalOrder.bottomViewTree(problem.tree.root);
    }

    /*
                           1
                          / \
                         2   3
                          \
                           4
                            \
                             5
                              \
                               6

        */
    private void createTree(){
        tree = new BinaryTree();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        tree.root = n1;
        n1.left = n2;
        n1.right = n3;


        n2.right = n4;
        n4.right= n5;
        n5.right= n6;
        tree.levelOrderTraversal();

    }
}
