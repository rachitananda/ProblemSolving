package com.problem.solving.ds.tree.problem;

import com.problem.solving.ds.tree.BinaryTree;
import com.problem.solving.ds.tree.Node;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
 * //TODO recursive method
 */
public class SpiralTraversalTree {
    BinaryTree tree = new BinaryTree();

    public static void main(String args[]) {

        SpiralTraversalTree problem = new SpiralTraversalTree();
        problem.createTree();
        problem.spiralTraversal(problem.tree);

    }

    /*

                        1
                     /     \
                   2         3
                 /  \       /  \
                7    6     5    4
              /  \        / \
              8   9      10  11



      */


    private void createTree() {

        tree = new BinaryTree();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);

        tree.root = n1;
        n1.left = n2;
        n1.right = n3;

        n2.left = n7;
        n2.right = n6;

        n3.left = n5;
        n3.right = n4;


        n7.left = n8;
        n7.right = n9;

        n5.left = n10;
        n5.right = n11;

    }

    private void spiralTraversal(BinaryTree tree) {
        if (tree.root == null) {
            return;
        }
        System.out.print("----- Level Order Spiral Traversal--- ");
        boolean isReverse = true;//for root node
        //when isRevere= true add to stack as S0 child RL
        //else add to stack as S1 child LR

        Stack<Node> s0 = new Stack<>();// push LR , reverse=true
        Stack<Node> s1 = new Stack<>();// push RL reverse=false


        s0.push(tree.root);

        //until both stacks are empty
        while (!s0.isEmpty() || !s1.isEmpty()) {

            while (!s0.isEmpty()) {
                //reverse order  RL
                Node node = s0.pop();
                System.out.print(" " + node.data);
                if (node.right != null) {
                    s1.push(node.right);
                }
                if (node.left != null) {
                    s1.push(node.left);
                }
            }

            while (!s1.isEmpty()) {
                //correct  order  LR
                Node node = s1.pop();
                System.out.print(" " + node.data);
                if (node.left != null) {
                    s0.push(node.left);
                }
                if (node.right != null) {
                    s0.push(node.right);
                }
            }
        }
    }


}
