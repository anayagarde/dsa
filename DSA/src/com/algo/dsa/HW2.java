package com.algo.dsa;
import java.util.*;

public class HW2 {

    // Define the Edge class
    static class Edge {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    // Method to find the shortest path from source (s) to target (t)
    public static List<Integer> findShortestPath(Map<Integer, List<Edge>> graph, Map<Integer, Integer> distances, int s, int t) {
        List<Integer> path = new ArrayList<>();
        int current = t;

        // Backtrack from t to s using incoming edges
        while (current != s) {
            boolean found = false;
            for (Edge edge : graph.getOrDefault(current, new ArrayList<>())) {
                int v = edge.from;
                int u = edge.to;
                int w = edge.weight;

                // Check if this edge is part of the shortest path
                if (u == current && distances.get(current) == distances.get(v) + w) {
                    path.add(current);
                    current = v; // Move to the predecessor
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new IllegalStateException("No path found from " + s + " to " + t);
            }
        }

        // Add the source node to the path
        path.add(s);

        // Reverse the path to get it from s to t
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        // Example graph initialization
        Map<Integer, List<Edge>> graph = new HashMap<>();

        // Add edges to the graph (example)
        graph.computeIfAbsent(1, k -> new ArrayList<>()).add(new Edge(0, 1, 1));
        graph.computeIfAbsent(2, k -> new ArrayList<>()).add(new Edge(0, 2, 4));
        graph.computeIfAbsent(2, k -> new ArrayList<>()).add(new Edge(1, 2, 2));
        graph.computeIfAbsent(3, k -> new ArrayList<>()).add(new Edge(1, 3, 5));
        graph.computeIfAbsent(3, k -> new ArrayList<>()).add(new Edge(2, 3, 1));

        // Example shortest path distances (precomputed)
        Map<Integer, Integer> distances = new HashMap<>();
        distances.put(0, 0); // Distance to the source
        distances.put(1, 1);
        distances.put(2, 3);
        distances.put(3, 4);

        int s = 0; // Source
        int t = 3; // Target

        try {
            List<Integer> path = findShortestPath(graph, distances, s, t);
            System.out.println("Shortest path from " + s + " to " + t + ": " + path);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}

