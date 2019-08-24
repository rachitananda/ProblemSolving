package com.problem.solving.ds.tree.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Lowest Common Ancestor
 *
 * @author rachita
 * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 * https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-tree-set-2-using-parent-pointer/
 */
public class LCA {

    static Node n20 = new Node(20);
    static Node n22 = new Node(22);
    static Node n8 = new Node(8);
    static Node n4 = new Node(4);
    static Node n12 = new Node(12);
    static Node n14 = new Node(14);
    static Node n10 = new Node(10);


    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        tree.levelOrderTraversal();
        System.out.println("LCA: Parent ptr" + tree.lowestCommonAncestorWithParentPtr(n10, n22).key);
        System.out.println("LCA:"+tree.lowestCommonAncestor(n10,n22).key);
        System.out.println("LCA: recursive "+tree.findLCA(8,14).key);


    }

    static class Node {
        Node left, right, parent;
        int key;

        public Node(int key) {
            this.key = key;
        }

    }

    static class BinaryTree {
        Node root;
        ArrayList<Node> path;

        public BinaryTree() {
            createTree();
        }

        public void createTree() {
            root = n20;
            root.right = n22;
            n22.parent = root;
            n8.left = n4;
            n8.parent = root;
            n12.right = n14;
            n12.left = n10;
            n12.parent = n8;
            n8.right = n12;
            root.left = n8;
            n10.parent = n12;
            n14.parent = n12;
            n4.parent = n8;
        }

        /*
          0(h) - height of node
         */
        public int getDepthOfNode(Node node) {
            if (root == null) {
                return -1;
            }
            int depth = 0;
            while (node.parent != null) {
                node = node.parent;
                depth++;
            }
            return depth;
        }

        public void levelOrderTraversal() {
            if (root == null)
                return;

            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                System.out.print(node.key + " ");

                if (node.left != null) {

                    queue.add(node.left);

                }//if

                if (node.right != null) {
                    queue.add(node.right);
                }

            }  //while

        }//fn

        //linear complexity 0(h) todo check
        public Node lowestCommonAncestorWithParentPtr(Node n1, Node n2) {

            int height1 = getDepthOfNode(n1);
            int height2 = getDepthOfNode(n2);
            int diff = height2 - height1;
            if (diff < 0) {
                //swap - n1 should alaways be node with less depth
                Node temp = n1;
                n1 = n2;
                n2 = temp;
            }

            //move n2 to same depth as n1

            for (int i = 0; i < Math.abs(diff); i++) {
                n2 = n2.parent;
            }
            // n1 and n2 are on same depth

            while (n2 != n1) {
                n2 = n2.parent;
                n1 = n1.parent;
            }


            return n1;
        }

        /*
          Time complexity of the  solution is O(n). The tree is traversed twice, and then path arrays are compared.
          https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
         */
        public Node lowestCommonAncestor(Node n1, Node n2)  {
            path = new ArrayList<Node>();
            getPathFromRoot(root, n1);
            ArrayList<Node> path1 = new ArrayList<Node>();
            ArrayList<Node> path2 = new ArrayList<Node>();
            path1.addAll(path);
            path = new ArrayList<Node>();
            getPathFromRoot(root, n2);
            path2.addAll(path);

            Node lca=null;
            if(path1.size() ==0 || path2.size()==0){
                return null;
            }

            outerloop:
            for(int i= path1.size()-1;i>=0;i--){
                for(int j=path2.size()-1;j>=0;j--){
                    if(path1.get(i)==path2.get(j)){
                        lca=path1.get(i);
                        break outerloop;
                    }
                }
            }

            return lca;
        }

        private boolean getPathFromRoot(Node root, Node pathTillNode) {

            if (root == null) {
                return false;
            }
            path.add(root);
            if (root == pathTillNode) {
                return true ;
            }
            //inorder traversal
            if (root.left != null &&  getPathFromRoot(root.left,pathTillNode) ) {
               return true;
            }

            if (root.right != null &&  getPathFromRoot(root.right,pathTillNode)) {
                return true;
            }
            // If not present in subtree rooted with root, remove root from
            // path[] and return false
            path.remove(path.size()-1);
            return false;

        }

        static boolean v1 = false, v2 = false;

        // This function returns pointer to LCA of two given
        // values n1 and n2.
        // v1 is set as true by this function if n1 is found
        // v2 is set as true by this function if n2 is found
        /*
        recursive O(n) withour taking extra space - traverses the tree only once
         */
        Node findLCAUtil(Node node, int n1, int n2)
        {
            // Base case
            if (node == null)
                return null;

            //Store result in temp, in case of key match so that we can search for other key also.
            Node temp=null;

            // If either n1 or n2 matches with root's key, report the presence
            // by setting v1 or v2 as true and return root (Note that if a key
            // is ancestor of other, then the ancestor key becomes LCA)
            if (node.key == n1)
            {
                v1 = true;
                temp = node;
            }
            if (node.key == n2)
            {
                v2 = true;
                temp = node;
            }

            // Look for keys in left and right subtrees
            Node left_lca = findLCAUtil(node.left, n1, n2);
            Node right_lca = findLCAUtil(node.right, n1, n2);

            if (temp != null)
                return temp;

            // If both of the above calls return Non-NULL, then one key
            // is present in once subtree and other is present in other,
            // So this node is the LCA
            if (left_lca != null && right_lca != null)
                return node;

            // Otherwise check if left subtree or right subtree is LCA
            return (left_lca != null) ? left_lca : right_lca;
        }

        // Finds lca of n1 and n2 under the subtree rooted with 'node'
        Node findLCA(int n1, int n2)
        {
            // Initialize n1 and n2 as not visited
            v1 = false;
            v2 = false;

            // Find lca of n1 and n2 using the technique discussed above
            Node lca = findLCAUtil(root, n1, n2);

            // Return LCA only if both n1 and n2 are present in tree
            if (v1 && v2)
                return lca;

            // Else return NULL
            return null;
        }
    }
}
