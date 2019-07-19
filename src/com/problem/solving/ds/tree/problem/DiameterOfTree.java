package com.problem.solving.ds.tree.problem;

import com.problem.solving.ds.tree.BinaryTree;
import com.problem.solving.ds.tree.Node;

/**
 * https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 * https://www.geeksforgeeks.org/diameter-tree-using-dfs/  TODO
 */
public class DiameterOfTree {

    private static BinaryTree tree = new BinaryTree(1);
    int maxDiameter = 0;

    public static void main(String[] args) {
        DiameterOfTree diameter = new DiameterOfTree();
        diameter.createTree2();
        System.out.println(" Diameter  :" + diameter.getMaxDiameter(tree.root));

     //   System.out.println(" Diameter Optimised Solution :" + diameter.diameterOptimised()); TODO not working


    }


    /*
                         1
                    /         \
                   2           3
                /    \          \
                4    5           6
                   / \            \
                  7   4            9
                                   / \
                                  10  11
                                   \
                                    12
      */


    private void createTree() {

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
        Node n12 = new Node(12);

        n5.right = n8;
        n5.left = n7;
        n2.right = n5;
        n2.left = n4;

        n10.right = n12;
        n9.right = n11;
        n9.left = n10;

        n6.right = n9;

        n3.right = n6;

        tree.root.right = n3;
        tree.root.left = n2;

        tree.levelOrderTraversal();

    }

  /*
                           1
                        /     \
                      2         3
                    /   \
                   4    5
                  / \    \
                 6  7     8
                   /     / \
                  9     10  11
                  \         /
                  12       13

   */

    private void createTree2() {

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
        Node n12 = new Node(12);
        Node n13 = new Node(13);


        n9.right = n12;
        n7.left = n9;
        n4.right = n7;
        n4.left = n6;
        n2.left = n4;

        n11.left = n13;
        n8.right = n11;
        n8.left = n10;
        n5.right = n8;
        n2.right = n5;


        tree.root.right = n3;
        tree.root.left = n2;

        tree.levelOrderTraversal();

    }


    /**
     * recursively make each node as root and check lhs rhs max diamter
     * Time Complexity: O(n^2)
     *
     * @param root
     * @return returns the max diameter for tree with
     */
    private int getMaxDiameter(Node root) {


        if (root == null) {
            return maxDiameter;
        }

        maxDiameter = Math.max(getTreeDiameter(root), maxDiameter);

        if (root.left != null) {
            getMaxDiameter(root.left);
        }

        if (root.right != null) {
            getMaxDiameter(root.right);
        }

        return maxDiameter;
    }

    /**
     * get diameter with node as root of subtree
     *
     * @param root
     * @return diameter
     */
    private int getTreeDiameter(Node root) {
/* Return max of following three
          1) Diameter of left subtree
         2) Diameter of right subtree
         3) Height of left subtree + height of right subtree + 1 */
        int depthRhs = tree.getHeight(root.right);
        int depthLhs = tree.getHeight(root.left);

        return (depthRhs + depthLhs) + 1;

    }

    private int diameterOptimised()
    {
        if (tree.root == null)
            return 0;

        // This will store the final answer
        A a = new A();
   //     int diameter=0;
        int height_of_tree = getHeightOptimised(tree.root, a);
        return a.ans;
    }

    /**
     *O(n)
     */
    public int getHeightOptimised(Node root, A maxDiameter){

        if(root== null){
            return 0;
        }
        int maxRhs=1,maxLhs=1;
        if(root.right!=null)
            maxRhs+=getHeightOptimised(root.right,maxDiameter);

        if(root.left!=null)
            maxLhs += getHeightOptimised(root.left,maxDiameter);

        maxDiameter.ans =Math.max(maxDiameter.ans, maxLhs+maxRhs+1);

        //System.out.println("height"+Math.max(maxRhs, maxLhs));
        return Math.max(maxRhs, maxLhs)+1;
    }

    static class A
    {
        int ans = Integer.MIN_VALUE;
    }
}
