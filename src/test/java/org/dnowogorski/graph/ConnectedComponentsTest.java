package org.dnowogorski.graph;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConnectedComponentsTest extends AbstractPathsTest {

    private ConnectedComponents connectedComponents;

    @Before
    public void createConnectedComponents() {
        connectedComponents = new ConnectedComponents(graph);
    }

    @Test
    public void connected_verticesAreConnected_returnsTrue() {
        assertThat(connectedComponents.connected(1, 3)).isTrue();
    }

    @Test
    public void connected_verticesAreNotConnected_returnsFalse() {
        assertThat(connectedComponents.connected(1, 7)).isFalse();
    }

    @Test
    public void id_returnsComponentId() {
        assertThat(connectedComponents.id(1)).isEqualTo(1);
        assertThat(connectedComponents.id(5)).isEqualTo(1);
        assertThat(connectedComponents.id(6)).isEqualTo(2);
    }

    @Test
    public void count_returnsConnectedComponentsCount() {
        assertThat(connectedComponents.count()).isEqualTo(2);
    }
}
