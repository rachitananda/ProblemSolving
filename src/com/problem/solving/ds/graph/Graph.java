package com.problem.solving.ds.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/graph-and-its-representations/
 * Graph   ADJACENCY  LISt
 */
public class Graph {

    int V;
    //array of linked list - each vertex has its own LL
    LinkedList<Integer> adjListArray[];

    public Graph(int v) {
        V = v;

        // define the size of array as
        // number of vertices
        adjListArray = new LinkedList[V];

        // Create a new list for each vertex
        // such that adjacent nodes can be stored

        for (int i = 0; i < V; i++) {
            adjListArray[i] = new LinkedList<>();
        }

    }

    public void addEdge(int src, int dest) {
        // Add an edge from src to dest.
        adjListArray[src].add(dest);
//        // Since graph is undirected, add an edge from dest
//        // to src also
//        adjListArray[dest].add(src);
    }

    public void printGraph() {
        for (int v = 0; v < V; v++) {
            System.out.println("Adjacency list of vertex " + v);
            System.out.print("head");
            for (Integer pCrawl : adjListArray[v]) {
                System.out.print(" -> " + pCrawl);
            }
            System.out.println("\n");
        }
    }

    /**
     * uses QUEUE
     * https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
     * @param src
     */
    public void BFS(int src) {

        System.out.println("\nGraphBFS");

        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[src] = true;
        queue.add(src);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            //node has adjacent nodes
            LinkedList<Integer> adjList = adjListArray[node];
            for (Integer dest : adjList) {
                if (!visited[dest]) {
                    visited[dest] = true;
                    queue.add(dest);
                }
            }
        }

    }

    /**
     *https://www.geeksforgeeks.org/iterative-depth-first-traversal/
     * STACK
     * @param src
     */

    public void DFS(int src) {

        System.out.println("\nGraph DFS");

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<Integer>();
        visited[src] = true;
        stack.push(src);

        while (!stack.isEmpty()) {
            int node = stack.peek();
            stack.pop();
            System.out.print(node + " ");
            //node has adjacent nodes
            LinkedList<Integer> adjList = adjListArray[node];
            for (Integer dest : adjList) {
                if (!visited[dest]) {
                    visited[dest] = true;
                    stack.push(dest);
                }
            }
        }

    }

}
