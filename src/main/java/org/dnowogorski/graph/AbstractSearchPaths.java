package org.dnowogorski.graph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractSearchPaths implements Paths {
    final Graph graph;
    final int source;
    final boolean[] visited;
    final int[] edgeTo;

    /**
     * Create new DepthSearchPaths instance
     *
     * @param graph  graph to be searched
     * @param source source vertex
     */
    public AbstractSearchPaths(Graph graph, int source) {
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
        search(source);
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

    abstract void search(int v);
}
