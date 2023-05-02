package by.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 1971. Find if Path Exists in Graph
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
 * <p>
 * You want to determine if there is a valid path that exists from vertex source to vertex destination.
 * <p>
 * Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
 */
public interface PathExistsInGraph {

    boolean validPath(int n, int[][] edges, int start, int end);

    default Map<Integer, Set<Integer>> prepareGraph(final int n, final int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}

class PathExistsInGraphBFS implements PathExistsInGraph {

    public boolean validPath(int n, int[][] edges, int start, int end) {
        final boolean[] visited = new boolean[n];
        final Queue<Integer> bfsQueue = new LinkedList<>();
        Map<Integer, Set<Integer>> graph = prepareGraph(n, edges);

        bfsQueue.add(start);
        visited[start] = true;
        while (!bfsQueue.isEmpty()) {
            final int currentVertex = bfsQueue.poll();
            if (currentVertex == end) {
                return true;
            }
            final Set<Integer> neighbors = graph.get(currentVertex);
            for (final int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    bfsQueue.add(neighbor);
                }
            }
        }
        return false;
    }
}

class PathExistsInGraphDFS implements PathExistsInGraph {

    public boolean validPath(int n, int[][] edges, int start, int end) {
        if (start == end) {
            return true;
        }

        boolean[] visited = new boolean[n];
        Map<Integer, Set<Integer>> graph = prepareGraph(n, edges);

        return dfs(graph, visited, start, end);
    }

    private boolean dfs(Map<Integer, Set<Integer>> graph, boolean[] visited, int start, int end) {
        if (visited[start]) {
            return false;
        }
        visited[start] = true;

        for (int nei : graph.get(start)) {
            if (nei == end) {
                return true;
            }
            if (!visited[nei]) {
                final var result = dfs(graph, visited, nei, end);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }
}
