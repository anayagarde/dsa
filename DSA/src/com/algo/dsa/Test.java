package com.algo.dsa;

import java.util.*;

public class Test {

    static class Graph {
        private final Map<Integer, List<Integer>> adjList;

        public Graph(int numVertices) {
            adjList = new HashMap<>();
            for (int i = 0; i < numVertices; i++) {
                adjList.put(i, new ArrayList<>());
            }
        }

        public void addEdge(int u, int v) {
            adjList.get(u).add(v);
            adjList.get(v).add(u); // Because the graph is undirected
        }

        public void removeEdge(int u, int v) {
            adjList.get(u).remove((Integer) v);
            adjList.get(v).remove((Integer) u);
        }

        public Map<Integer, List<Integer>> getAdjList() {
            return adjList;
        }
    }

    private static boolean isCycleContainingEdge(Graph graph, int u, int v) {
        // Create a copy of the graph and remove the edge (u, v)
        Graph tempGraph = new Graph(graph.getAdjList().size());
        for (Map.Entry<Integer, List<Integer>> entry : graph.getAdjList().entrySet()) {
            tempGraph.adjList.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        }
        tempGraph.removeEdge(u, v);

        // Perform DFS from node u to check if v is reachable
        Set<Integer> visited = new HashSet<>();
        return dfs(tempGraph, u, v, visited);
    }

    private static boolean dfs(Graph graph, int current, int target, Set<Integer> visited) {
        if (current == target) {
            return true;
        }

        visited.add(current);

        for (int neighbor : graph.getAdjList().get(current)) {
            if (!visited.contains(neighbor)) {
                if (dfs(graph, neighbor, target, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int numVertices = 6;
        Graph graph = new Graph(numVertices);

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(2, 4);
//        graph.addEdge(5, 0); // Adding a cycle edge for testing

        int u = 2;
        int v = 4;

        // Check if the graph contains a cycle including edge (u, v)
        boolean hasCycle = isCycleContainingEdge(graph, u, v);
        System.out.println("The graph contains a cycle including edge (" + u + ", " + v + "): " + hasCycle);
    }
}
