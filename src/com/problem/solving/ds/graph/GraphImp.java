package com.problem.solving.ds.graph;


/**
 * https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 * https://www.geeksforgeeks.org/iterative-depth-first-traversal/
 */
public class GraphImp {


    public static void main(String[] args) {

        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.printGraph();
        graph.BFS(2);
        graph.DFS(2);


        Graph g = new Graph(5);

        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.BFS(0);
        g.DFS(0);


    }
}
