package org.dnowogorski.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthSearchPaths implements Paths {

    private final Graph graph;
    private final int source;
    private final boolean[] visited;
    private final int[] edgeTo;
    private final int[] distance;

    public BreadthSearchPaths(Graph graph, int source) {
        this.graph = graph;
        this.source = source;
        this.visited = new boolean[graph.getNumberOfVertices()];
        this.edgeTo = new int[graph.getNumberOfVertices()];
        this.distance = new int[graph.getNumberOfVertices()];
    }

    @Override
    public boolean hasPathTo(int dest) {
        BFS();
        return visited[dest];
    }

    @Override
    public Iterable<Integer> pathTo(int dest) {
        if (!visited[dest]) return Collections.emptyList();
        List<Integer> path = new ArrayList<>();
        for (int v = dest; v != source; v = edgeTo[v])
            path.add(v);
        path.add(source);
        Collections.reverse(path);
        return path;
    }

    public int getDistance(int dest) {
        return distance[dest];
    }

    private void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            graph.adj(v).forEach(w -> {
                if (!visited[w]) {
                    visited[w] = true;
                    edgeTo[w] = v;
                    distance[w]++;
                    queue.add(w);
                }
            });
        }
    }
}
