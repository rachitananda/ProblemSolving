package com.problem.solving.ds.tree.problem;

import com.problem.solving.ds.tree.BinaryTree;
import com.problem.solving.ds.tree.Node;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
 */
public class TreeVerticalOrder {

    private BinaryTree tree;
    //Tree map retains keys in ascending order
    java.util.TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap<>();
    java.util.TreeMap<Integer, ArrayList<Node>> treeMapLevelOrder = new TreeMap<>();

    public static void main(String[] args) {
        TreeVerticalOrder problem = new TreeVerticalOrder();
        problem.createTree();

        //   problem.printTreeVertically(problem.tree.root); //vertical traversal
        problem.verticalLevelOrder(problem.tree.root);//level order
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

    // TreeMap is sorted in the ascending order of its keys. T

    /**
     * inOrderTraversalBFS -O(n)
     * traverseLeft/Right- O(depth)
     * O(n+h1+h2)= O(n+K)
     * https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
     *
     * @param root
     */
    private void printTreeVertically(Node root) {
        treeMap = new TreeMap<>();

        int rootVerticalIndex = 0;
        int maxVerticalIndex = 0; //right most column

        rootVerticalIndex = traverseLeft(root, rootVerticalIndex);//0(h1)
        maxVerticalIndex = traverseRight(root, rootVerticalIndex); //O(h2)

        inOrderTraversalBFS(root, rootVerticalIndex);//0(n)

        //Tree map retains keys in ascending order
        for (Map.Entry<Integer, ArrayList<Integer>> entry : treeMap.entrySet()) {

            System.out.println("Column " + entry.getKey());
            for (Integer node : entry.getValue()) {
                System.out.println(" " + node);
            }

        }


    }

    private int traverseLeft(Node root, int index) {

        if (root.left != null) {
            return traverseLeft(root.left, index + 1);
        } else {
            return index;
        }
    }

    private int traverseRight(Node root, int index) {

        if (root.right != null) {
            return traverseRight(root.right, index + 1);
        } else {
            return index;
        }
    }

    /*
    O(n)
     */
    private void inOrderTraversalBFS(Node root, int index) {
        if (root == null) {
            return;
        }

        inOrderTraversalBFS(root.left, index - 1);

        //root
        ArrayList<Integer> nodes = treeMap.get(index);
        if (nodes == null) {
            nodes = new ArrayList<>();
        }
        nodes.add(root.data);
        treeMap.put(index, nodes);

        inOrderTraversalBFS(root.right, index + 1);
    }


    /**
     * 0(n)
     * https://www.geeksforgeeks.org/print-a-binary-tree-in-vertical-order-set-3-using-level-order-traversal/
     *
     * @param root
     */
    public void verticalLevelOrder(Node root) {
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
                node.left.horizontalDistance = node.horizontalDistance - 1;
                addInMap(node.horizontalDistance - 1, node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
                node.right.horizontalDistance = node.horizontalDistance + 1;
                addInMap(node.horizontalDistance + 1, node.right);
            }

        }

        printMap();
        printTopViewMap();

    }


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

    private void printTopViewMap() {
        //Tree map retains keys in ascending order
        System.out.println("TOP VIEW");
        for (Map.Entry<Integer, ArrayList<Node>> entry : treeMapLevelOrder.entrySet()) {
            //first value inserted
            System.out.println(entry.getValue().get(0).data);

        }
    }

    /**
     * https://www.geeksforgeeks.org/bottom-view-binary-tree/
     *
     * @param root
     */
    public void bottomViewTree(Node root) {

        treeMapLevelOrder = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        root.horizontalDistance = 0;
        queue.add(root);
        addInMap(0, root);

        while (!queue.isEmpty()) {

            Node node = queue.poll();

            if (node.left != null) {
                queue.add(node.left);
                node.left.horizontalDistance = node.horizontalDistance - 1;
                addInMap(node.left.horizontalDistance, node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
                node.right.horizontalDistance = node.horizontalDistance + 1;
                addInMap(node.right.horizontalDistance, node.right);
            }

        }

        printBottomViewMap();


    }

    private void printBottomViewMap() {
        //Tree map retains keys in ascending order
        System.out.println("------BOTTOM VIEW-------");
        for (Map.Entry<Integer, ArrayList<Node>> entry : treeMapLevelOrder.entrySet()) {
            //first value inserted
            int size = entry.getValue().size() - 1;
            System.out.println(entry.getValue().get(size).data);

        }
    }


}
