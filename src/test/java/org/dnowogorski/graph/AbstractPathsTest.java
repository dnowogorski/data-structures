package org.dnowogorski.graph;

import org.junit.Before;

public abstract class AbstractPathsTest {
    Graph graph;

    @Before
    public void createPaths() {
        graph = new Graph(8);
        graph.addEdge(0, 0);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(6, 7);
    }
}
