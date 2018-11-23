package org.dnowogorski.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class IterativeDepthSearchPaths extends AbstractSearchPaths {
    /**
     * Create new DepthSearchPaths instance
     *
     * @param graph  graph to be searched
     * @param source source vertex
     */
    public IterativeDepthSearchPaths(Graph graph, int source) {
        super(graph, source);
    }

    @Override
    void search(int v) {
        Deque<Integer> stack = new ArrayDeque<>();
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
