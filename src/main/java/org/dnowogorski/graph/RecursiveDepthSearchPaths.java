package org.dnowogorski.graph;

public class RecursiveDepthSearchPaths extends AbstractSearchPaths {
    /**
     * Create new DepthSearchPaths instance
     *
     * @param graph  graph to be searched
     * @param source source vertex
     */
    public RecursiveDepthSearchPaths(Graph graph, int source) {
        super(graph, source);
    }

    @Override
    public void search(int v) {
        visited[v] = true;
        for (Integer w : graph.adj(v)) {
            if (!visited[w]) {
                edgeTo[w] = v;
                search(w);
            }
        }
    }
}
