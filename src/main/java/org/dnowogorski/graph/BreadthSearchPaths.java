package org.dnowogorski.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthSearchPaths extends AbstractSearchPaths {

    private final int[] distance;

    public BreadthSearchPaths(Graph graph, int source) {
        super(graph, source);
        this.distance = new int[graph.getNumberOfVertices()];
    }

    @Override
    void search(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            graph.adj(x).forEach(w -> {
                if (!visited[w]) {
                    visited[w] = true;
                    edgeTo[w] = x;
                    distance[w]++;
                    queue.add(w);
                }
            });
        }
    }

    public int getDistance(int dest) {
        return distance[dest];
    }
}
