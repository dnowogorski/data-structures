package org.dnowogorski.graph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DepthSearchPaths implements Paths {
    private final Graph graph;
    private final int source;
    private final boolean[] visited;
    private final int[] edgeTo;

    /**
     * Create new DepthSearchPaths instance
     *
     * @param graph  graph to be searched
     * @param source source vertex
     */
    public DepthSearchPaths(Graph graph, int source) {
        this.graph = graph;
        this.source = source;
        this.visited = new boolean[graph.getNumberOfVertices()];
        this.edgeTo = new int[graph.getNumberOfVertices()];
    }

    /**
     * Check if there is a path from source to destination
     *
     * @param dest destination vertex
     * @return true if there is a path, false otherwise
     */
    public boolean hasPathTo(int dest) {
        recursiveDFS(source);
        return visited[dest];
    }

    /**
     * Find path from source to given vertex
     *
     * @param dest destination vertex
     * @return collection of vertices if there is a path, empty collection otherwise
     */
    public Iterable<Integer> pathTo(int dest) {
        if (!visited[dest]) return Collections.emptyList();
        List<Integer> path = new LinkedList<>();
        for (int v = dest; v != source; v = edgeTo[v]) {
            path.add(v);
        }
        path.add(source);
        Collections.reverse(path);
        return path;
    }


    private void recursiveDFS(int v) {
        visited[v] = true;
        for (Integer w : graph.adj(v)) {
            if (!visited[w]) {
                edgeTo[w] = v;
                recursiveDFS(w);
            }
        }
    }

    private void iterativeDFS(int v) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        visited[v] = true;
        while (!stack.isEmpty()) {
            int x = stack.pop();
            graph.adj(x).forEach(w -> {
                if (!visited[w]) {
                    visited[w] = true;
                    edgeTo[w] = x;
                    stack.push(w);
                }
            });
        }
    }
}
