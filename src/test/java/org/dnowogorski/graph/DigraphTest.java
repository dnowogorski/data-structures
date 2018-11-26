package org.dnowogorski.graph;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DigraphTest {

    private Graph graph;

    @Before
    public void createDigraph() {
        graph = new Digraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(3, 2);
        graph.addEdge(3, 5);
        graph.addEdge(4, 3);
        graph.addEdge(5, 0);
    }

    @Test
    public void getNumberOfEdges_returnsEdgeCount() {
        assertThat(graph.getNumberOfEdges()).isEqualTo(8);
    }
}
