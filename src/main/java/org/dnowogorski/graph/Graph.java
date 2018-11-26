package org.dnowogorski.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    protected final int V;
    protected final List<List<Integer>> adj;

    /**
     * Create an empty graph with V vertices
     *
     * @param V number of vertices
     */
    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) adj.add(i, new LinkedList<>());
    }

    /**
     * Add edge between two vertices
     *
     * @param v first vertex
     * @param w second vertex
     */
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        if (v != w) adj.get(w).add(v);
    }

    /**
     * Return collection of vertices adjacent to v
     *
     * @param v vertex
     * @return collection of vertices
     */
    public Collection<Integer> adj(int v) {
        return adj.get(v);
    }

    /**
     * Return number of vertices
     *
     * @return number of edges
     */
    public int getNumberOfVertices() {
        return V;
    }

    /**
     * Return number of edges
     *
     * @return number of edges
     */
    public long getNumberOfEdges() {
        return adj.stream()
                .map(List::size)
                .mapToInt(Integer::intValue)
                .sum() / 2;
    }

    /**
     * Compute the degree of given vertex
     *
     * @param v vertex
     * @return degree
     */
    public int degree(int v) {
        return adj.get(v).size();
    }

    /**
     * Compute max degree in the graph
     *
     * @return max degree
     */
    public int maxDegree() {
        return adj.stream()
                .map(List::size)
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }

    /**
     * Return number of self loops in the graph
     *
     * @return number of self loops
     */
    public int getNumberOfSelfLoops() {
        int count = 0;
        for (int i = 0; i < V; i++) {
            for (int v : adj(i))
                if (i == v) count++;
        }
        return count;
    }
}
