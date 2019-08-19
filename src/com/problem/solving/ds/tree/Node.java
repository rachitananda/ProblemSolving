package com.problem.solving.ds.tree;

public class Node {

    public int data;
    public Node right, left;
    public int horizontalDistance;

    public Node(int data) {
        this.data = data;
        right = left = null;
    }

}
