package com.problem.solving.ds.tree.problem;

import com.problem.solving.ds.tree.BinaryTree;
import com.problem.solving.ds.tree.Node;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/print-right-view-binary-tree-2/
 * https://www.geeksforgeeks.org/print-left-view-binary-tree/
 * O(n) - for level order trversal
 */
public class LeftRightViewTree {

    java.util.TreeMap<Integer, ArrayList<Node>> treeMapLevelOrder = new TreeMap<>();
    BinaryTree tree;

    public static void main(String args[]) {
        LeftRightViewTree problem = new LeftRightViewTree();
        problem.createTree();
        problem.viewLevelOrder(problem.tree.root);

        System.out.println("-----Tree 2-----");
        problem.createTree2();
        problem.viewLevelOrder(problem.tree.root);


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
    private void createTree() {
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
        n4.right = n5;
        n5.right = n6;
        tree.levelOrderTraversal();

    }

    /*
                        1
                       / \
                      2   3
                     / \  /\
                    4  5 6  7
                          \  \
                          8   9

     */
    private void createTree2() {
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

        tree.root = n1;
        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;
        n7.right = n9;
        n6.right = n8;

        tree.levelOrderTraversal();

    }


    /*
        O(n)
     */
    public void viewLevelOrder(Node root) {
        treeMapLevelOrder = new TreeMap<>();
        int index = 0;

        Queue<Node> queue = new LinkedList<>();//index ?
        queue.add(root);
        root.horizontalDistance = index;
        addInMap(index, root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.left != null) {
                queue.add(node.left);
                node.left.horizontalDistance = node.horizontalDistance + 1;
                addInMap(node.left.horizontalDistance, node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
                node.right.horizontalDistance = node.horizontalDistance + 1;
                addInMap(node.right.horizontalDistance, node.right);
            }

        }

        printMap();
        printRightViewMap();
        printLeftViewMap();

    }


//    private void addInMap(int key, Node node) {
//
//        //only add the left most node in a single level
//        if (!treeMapLevelOrder.containsKey(key)) {
//            treeMapLevelOrder.put(key, node.data);
//        }
//
//    }
//
//
//    private void printMap() {
//        //Tree map retains keys in ascending order
//        System.out.println("======RIGHT VIEW======");
//        for (Map.Entry<Integer, Integer> entry : treeMapLevelOrder.entrySet()) {
//
//            System.out.println("Column " + entry.getKey());
//            System.out.println(" " + entry.getValue());
//        }
//    }


    private void addInMap(int key, Node node) {

        ArrayList<Node> nodes = treeMapLevelOrder.get(key);
        if (nodes == null) {
            nodes = new ArrayList<>();
        }
        nodes.add(node);
        treeMapLevelOrder.put(key, nodes);

    }


    private void printMap() {
        //Tree map retains keys in ascending order
        for (Map.Entry<Integer, ArrayList<Node>> entry : treeMapLevelOrder.entrySet()) {

            System.out.println("Column " + entry.getKey());
            for (Node node : entry.getValue()) {
                System.out.println(" " + node.data);
            }

        }
    }

    private void printLeftViewMap() {
        //Tree map retains keys in ascending order
        System.out.println("---LEFT VIEW---");
        for (Map.Entry<Integer, ArrayList<Node>> entry : treeMapLevelOrder.entrySet()) {
            //first value inserted
            System.out.println(entry.getValue().get(0).data);

        }
    }

    private void printRightViewMap() {
        //Tree map retains keys in ascending order
        System.out.println("----RIGHT VIEW----");
        for (Map.Entry<Integer, ArrayList<Node>> entry : treeMapLevelOrder.entrySet()) {
            //first value inserted
            int size = entry.getValue().size();
            System.out.println(entry.getValue().get(size-1).data);

        }
    }


}
