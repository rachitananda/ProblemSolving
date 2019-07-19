package com.problem.solving.ds.tree.problem;

import com.problem.solving.ds.tree.BinaryTree;
import com.problem.solving.ds.tree.Node;

/**
 * https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
 */
public class CheckBST {

    BinaryTree tree = new BinaryTree();

    public static void main(String[] args){

        CheckBST checkBST = new CheckBST();

        checkBST.createTree1();
        checkBST.checkBST();

    }

    /*
                 4
                / \
               2   5
              /  \
             1    3
     */
    private void createTree1(){
        tree.root= new Node(4);
        Node n2 =  new Node(2);
        Node n3 =  new Node(3);
        Node n1 =  new Node(1);
        Node n5 =  new Node(5);

       n2.right=n3;
       n2.left=n1;

       tree.root.right=n5;
       tree.root.left=n2;

       tree.levelOrderTraversal();
    }

    /*
                     3
                    / \
                   2   5
                  /  \
                 1    4
         */
    private void createTree2(){
        Node n2 =  new Node(2);
        Node n3 =  new Node(3);
        Node n1 =  new Node(1);
        Node n4 =  new Node(4);
        Node n5 =  new Node(5);

        tree.root= n3;

        n2.right=n4;
        n2.left=n1;

        tree.root.right=n5;
        tree.root.left=n2;

        tree.levelOrderTraversal();
    }


    private void checkBST(){

        System.out.println("isBST : "+isBST(tree.root));
    }


    private boolean isBST(Node root){

        if(root==null){
            return true;
        }
        System.out.println("Node : "+root.data+" max :"+max(root.left,Integer.MIN_VALUE)+" min : "+min(root.right,Integer.MAX_VALUE));
        //all values in left subtree should be smaller than parent in BST
        if(root.left!=null && max(root.left,Integer.MIN_VALUE)>root.data )
            return false;

        //all values in right subtree should be larger than parent in BST
        if(root.right!=null && min(root.right,Integer.MAX_VALUE)<root.data )
            return false;

        /* false if, recursively, the left or right is not a BST */
        if (!isBST(root.left) || !isBST(root.right))
            return false;


        //rest all conditions make a bst
        return true;
    }



    private int max(Node root,int maxVal){
        if(root==null){
            return maxVal;
        }
        maxVal= Math.max(root.data,maxVal);

        maxVal = Math.max(max(root.left,maxVal),max(root.right,maxVal));

        return maxVal;
    }

    private int min(Node root,int minVal){
        if(root==null){
            return minVal;
        }
        minVal= Math.min(root.data,minVal);

        minVal = Math.min(min(root.left,minVal),min(root.right,minVal));

        return minVal;
    }


}
