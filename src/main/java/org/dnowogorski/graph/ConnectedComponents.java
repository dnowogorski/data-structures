package org.dnowogorski.graph;

import java.util.Arrays;

public class ConnectedComponents {

    private final Graph graph;
    private final int[] id;
    private final boolean[] visited;

    public ConnectedComponents(Graph graph) {
        this.graph = graph;
        this.id = new int[graph.getNumberOfVertices()];
        this.visited = new boolean[graph.getNumberOfVertices()];
        int count = 1;
        for (int v = 0; v < graph.getNumberOfVertices(); v++) {
            if (!visited[v]) {
                markComponent(v, count);
                count++;
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public long count() {
        return Arrays.stream(id).distinct().count();
    }


    private void markComponent(int v, int componentId) {
        visited[v] = true;
        id[v] = componentId;
        for (int w : graph.adj(v)) {
            if (!visited[w]) {
                visited[w] = true;
                id[w] = componentId;
                markComponent(w, componentId);
            }
        }
    }
}
