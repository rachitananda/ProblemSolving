package com.problem.solving.ds.graph.problem;


import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/count-number-trees-forest/
 */
public class CountTreesInForest {

    boolean visited[];
    static int n = 5;
    Graph graph = new Graph(n);

    public static void main(String arf[]) {
        CountTreesInForest problem = new CountTreesInForest();
        problem.visited = new boolean[n];

        problem.graph.addEdge(0, 1);
        problem.graph.addEdge(0, 2);
        problem.graph.addEdge(3, 4);
        problem.graph.printGraph();
        System.out.println(" Count of trees:  "+problem.graph.getTreeCount());
    }


    class Graph {

        int V;
        LinkedList<Integer> vertices[];

        public Graph(int V) {
            this.V = V;
            vertices = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                vertices[i] = new LinkedList<>();
            }
        }

        private void addEdge(int src, int dest) {
            vertices[src].add(dest);
        }

        private void DFS(int src) {
            visited[src] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(src);
            while (!queue.isEmpty()) {
                int vertex = queue.poll();
                LinkedList<Integer> adjList = vertices[vertex];

                for (Integer adjVertex : adjList) {
                    queue.add(adjVertex);
                    visited[adjVertex] = true;
                }
            }
        }

        /**
         * O(V + E)
         * @return
         */
        private int getTreeCount(){
            int count=0;
            for (int i = 0; i <V ; i++) {
               if(!visited[i]){
                    DFS(i);
                    count++;
               }

            }
            return count;
        }

        private void printGraph() {

            for (int i = 0; i < V; i++) {
                System.out.println("SRC:" + i);
                for (int vertex : vertices[i]) {
                    System.out.print(" ->" + vertex);
                }
            }
        }

    }

}
