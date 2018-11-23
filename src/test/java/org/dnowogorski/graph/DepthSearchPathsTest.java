package org.dnowogorski.graph;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class DepthSearchPathsTest extends AbstractPathsTest {

    @Test
    public void hasPathTo_pathExists_returnsTrue() {
        Paths paths = new RecursiveDepthSearchPaths(graph, 0);

        assertThat(paths.hasPathTo(4)).isTrue();
    }

    @Test
    public void hasPathTo_pathDoesNotExist_returnsFalse() {
        Paths paths = new RecursiveDepthSearchPaths(graph, 0);

        assertThat(paths.hasPathTo(6)).isFalse();
    }

    @Test
    public void pathTo_pathExists_returnsPath() {
        Paths paths = new RecursiveDepthSearchPaths(graph, 0);

        assertThat(paths.hasPathTo(4)).isTrue();
        assertThat(paths.pathTo(4)).containsExactlyInAnyOrder(0, 2, 3, 4);
    }

    @Test
    public void pathTo_pathDoesNotExist_returnsEmptyCollection() {
        Paths paths = new RecursiveDepthSearchPaths(graph, 0);

        assertThat(paths.hasPathTo(6)).isFalse();
        assertThat(paths.pathTo(6)).isEmpty();
    }
}
