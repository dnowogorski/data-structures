package org.dnowogorski.graph;

import java.util.List;

public class Digraph extends Graph {

    /**
     * Create an empty graph with V vertices
     *
     * @param V number of vertices
     */
    public Digraph(int V) {
        super(V);
    }

    @Override
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    @Override
    public long getNumberOfEdges() {
        return adj.stream()
                .map(List::size)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
