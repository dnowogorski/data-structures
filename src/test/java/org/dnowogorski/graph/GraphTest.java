package org.dnowogorski.graph;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class GraphTest {

    private Graph graph;

    @Before
    public void createGraph() {
        graph = new Graph(4);
        graph.addEdge(0, 0);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 1);
        graph.addEdge(2, 3);
    }

    @Test
    public void adj_returnsAdjacencyList() {
        assertThat(graph.adj(0)).contains(0, 1, 2, 3);
        assertThat(graph.adj(1)).contains(0, 1);
        assertThat(graph.adj(2)).contains(0, 3);
        assertThat(graph.adj(3)).contains(0, 2);
    }

    @Test
    public void getNumberOfEdges_returnsEdgeCount() {
        assertThat(graph.getNumberOfEdges()).isEqualTo(5);
    }

    @Test
    public void degree_returnsVertexDegree() {
        assertThat(graph.degree(0)).isEqualTo(4);
        assertThat(graph.degree(1)).isEqualTo(2);
        assertThat(graph.degree(2)).isEqualTo(2);
        assertThat(graph.degree(3)).isEqualTo(2);
    }

    @Test
    public void maxDegree_computesMaxDegree() {
        assertThat(graph.maxDegree()).isEqualTo(4);
    }

    @Test
    public void getNumberOfSelfLoops_returnsNumberOfSelfLoops() {
        assertThat(graph.getNumberOfSelfLoops()).isEqualTo(2);
    }
}
