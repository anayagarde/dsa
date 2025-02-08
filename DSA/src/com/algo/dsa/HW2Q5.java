package com.algo.dsa;

import java.util.*;

public class HW2Q5 {

    // Dijkstra's algorithm to compute shortest distances from a source vertex
    public static Map<Integer, Integer> dijkstra(Map<Integer, List<Edge>> graph, int source) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        Map<Integer, Integer> distances = new HashMap<>();
        pq.add(new Node(source, 0));
        distances.put(source, 0);

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;
            int d = current.distance;

            if (d > distances.getOrDefault(u, Integer.MAX_VALUE)) continue;

            for (Edge edge : graph.getOrDefault(u, new ArrayList<>())) {
                int v = edge.to;
                int newDist = distances.get(u) + edge.weight;

                if (newDist < distances.getOrDefault(v, Integer.MAX_VALUE)) {
                    distances.put(v, newDist);
                    pq.add(new Node(v, newDist));
                }
            }
        }
        return distances;
    }

    // Find the best road to add for maximum distance reduction between s and t
    public static Edge findBestRoadToAdd(Map<Integer, List<Edge>> graph, int s, int t, List<Edge> candidates) {
        // Step 1: Compute shortest path distances from s and t using Dijkstra
        Map<Integer, Integer> d_s = dijkstra(graph, s); // distances from s
        Map<Integer, Integer> d_t = dijkstra(graph, t); // distances from t

        // Get the original distance from s to t
        int originalDistance = d_s.getOrDefault(t, Integer.MAX_VALUE);

        Edge bestEdge = null;
        int maxDecrease = 0;

        // Step 2: Evaluate each candidate road
        for (Edge candidate : candidates) {
            int u = candidate.from;
            int v = candidate.to;
            int w = candidate.weight;

            // Calculate the new distance via both possible paths
            int newDistance1 = d_s.getOrDefault(u, Integer.MAX_VALUE) + w + d_t.getOrDefault(v, Integer.MAX_VALUE);
            int newDistance2 = d_s.getOrDefault(v, Integer.MAX_VALUE) + w + d_t.getOrDefault(u, Integer.MAX_VALUE);

            // Choose the minimum of the two new distances
            int newDistance = Math.min(newDistance1, newDistance2);

            // Calculate the decrease in distance
            int decrease = originalDistance - newDistance;

            // Track the road that provides the maximum decrease
            if (decrease > maxDecrease) {
                maxDecrease = decrease;
                bestEdge = candidate;
            }
        }

        return bestEdge; // Return the edge that gives the maximum decrease
    }

    public static void main(String[] args) {
        // Example graph initialization
        Map<Integer, List<Edge>> graph = new HashMap<>();
        graph.computeIfAbsent(0, k -> new ArrayList<>()).add(new Edge(0, 1, 4));
        graph.computeIfAbsent(0, k -> new ArrayList<>()).add(new Edge(0, 2, 3));
        graph.computeIfAbsent(1, k -> new ArrayList<>()).add(new Edge(1, 3, 2));
        graph.computeIfAbsent(2, k -> new ArrayList<>()).add(new Edge(2, 3, 1));
        graph.computeIfAbsent(3, k -> new ArrayList<>()).add(new Edge(3, 4, 7));

        // Candidate roads (potential new edges)
        List<Edge> candidates = new ArrayList<>();
        candidates.add(new Edge(1, 4, 1));
        candidates.add(new Edge(2, 4, 5));

        int s = 0; // Source city
        int t = 4; // Target city

        // Find and output the best road to add
        Edge bestRoad = findBestRoadToAdd(graph, s, t, candidates);
        if (bestRoad != null) {
            System.out.println("Best road to add is between cities: " + bestRoad.from + " and " + bestRoad.to + " with weight " + bestRoad.weight);
        } else {
            System.out.println("No road results in any decrease.");
        }
    }
}

// Node class for priority queue in Dijkstra's algorithm
class Node {
    int vertex, distance;

    Node(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }
}

// Edge class for representing graph edges and candidate roads
class Edge {
    int from, to, weight;

    Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
