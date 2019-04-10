package com.problem.solving.ds.tree;

import com.problem.solving.BaseProblem;

/**
 * The worst case time complexity of search and insert operations is O(h) where h is height of Binary Search Tree.
 * In worst case, we may have to travel from root to the deepest leaf node.
 * The height of a skewed tree may become n and the time complexity of search and insert operation may become O(n).
 * https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
 * BST  PROPERTIES
 * - left<root<right
 * - no duplicates
 * -A new key is always inserted at leaf. We start searching a key from root till we hit a leaf node.
 * Once a leaf node is found, the new node is added as a child of the leaf node.
 */
public class BinarySearchTree extends BaseProblem {

    private BinaryTree tree;

    @Override
    public void execute() {

        BinaryTree tree = createTree();

//       searchBST(tree.root, new Node(1));

        tree.levelOrderTraversal();
    }

    /**
     * O(n)
     * TODO BUGS NEED TO FIX
     * @param root
     * @param node
     */
    private void searchBST(Node root, Node node) {
        if (root == null)
            return;
        if (root == node || root.data == node.data) {
            System.out.println("found " + root.data);
        }
        if (node.data < root.data) {
            searchBST(root.left, node);
        } else {
            searchBST(root.right, node);
        }
    }

    /**
     * 0(n)
     * @param root
     * @param key - item to add
     */
    private Node insertBST(Node root, int key) {
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root ;
        }

        if (key < root.data) {
            insertBST(root.left, key);
        } else {
            insertBST(root.right, key);
        }
        return root;
    }


    /*
//					8
//				/	  \
//			   3       10
//			 /   \       \
//			1     6       14
//			     /  \     /
//			    4    7    13
     */
    private BinaryTree createTree() {
//        BinaryTree tree = new BinaryTree(8);
//        Node n1 = new Node(1);
//        Node n10 = new Node(10);
//        Node n3 = new Node(3);
//        Node n4 = new Node(4);
//        Node n6 = new Node(6);
//        Node n7 = new Node(7);
//        Node n13 = new Node(13);
//        Node n14 = new Node(14);
//
//        tree.root.left = n3;
//        tree.root.right = n10;
//        n3.left = n1;
//        n3.right = n6;
//        n6.left = n4;
//        n6.right = n7;
//        n10.right = n14;
//        n14.left = n13;

//         /* Let us create following BST
//              50
//           /     \
//          30      70
//         /  \    /  \
//       20   40  60   80 */
        BinaryTree tree = new BinaryTree();
        tree.root = insertBST(tree.root,50);
       tree.root= insertBST(tree.root, 30);
        insertBST(tree.root, 20);
        insertBST(tree.root, 40);
        insertBST(tree.root, 70);
        insertBST(tree.root, 60);
        insertBST(tree.root, 80);

        return tree;

    }


}
