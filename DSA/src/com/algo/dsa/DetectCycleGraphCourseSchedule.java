package com.algo.dsa;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleGraphCourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create graph out of prerequisites
        // visited [] to keep track of all nodes
        // visited[i] = 1 => visiting
        // visited[i] = 0 => unvisited
        // visited[i] = 2 => visited
        // while exploration using dfs if we reach a node that is in visited state => cycle => course cannot be taken

        // Step 1: Create graph from prerequisites
        List<List<Integer>> graph = new ArrayList<>();
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            visited[i] = 0;
        }
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < numCourses; i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // Step 2: Call dfs function for each node in numCourses
        for (int i = 0; i < numCourses; i++) {
                if (!dfs(i, graph, visited)) {
                    return false;
                }
        }

        return true;
    }

    public boolean dfs(int i, List<List<Integer>> graph, int[] visited) {
        if(visited[i] == 2) return true;
        if (visited[i] == 1) return false;
        else {
            visited[i] = 1; // mark as visiting
            // explore neighbors of i
            for (Integer neighbor: graph.get(i)) {
                if (!dfs(neighbor, graph, visited)) return false;
            }

            // if no cycle found, mark i as visited
            visited[i] = 2;
        }

        return true;

    }
}
