package org.dnowogorski.graph;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class DepthSearchPathsTest {

    private Graph graph;

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

    @Test
    public void hasPathTo_pathExists_returnsTrue() {
        Paths paths = new DepthSearchPaths(graph, 0);

        assertThat(paths.hasPathTo(4)).isTrue();
    }

    @Test
    public void hasPathTo_pathDoesNotExist_returnsFalse() {
        Paths paths = new DepthSearchPaths(graph, 0);

        assertThat(paths.hasPathTo(6)).isFalse();
    }

    @Test
    public void pathTo_pathExists_returnsPath() {
        Paths paths = new DepthSearchPaths(graph, 0);

        assertThat(paths.hasPathTo(4)).isTrue();
        assertThat(paths.pathTo(4)).containsExactlyInAnyOrder(0, 2, 3, 4);
    }

    @Test
    public void pathTo_pathDoesNotExist_returnsEmptyCollection() {
        Paths paths = new DepthSearchPaths(graph, 0);

        assertThat(paths.hasPathTo(6)).isFalse();
        assertThat(paths.pathTo(6)).isEmpty();
    }

}
