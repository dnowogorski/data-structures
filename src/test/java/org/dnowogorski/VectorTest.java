package org.dnowogorski;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class VectorTest {

    private Vector<Integer> vector;

    @Before
    public void createVector() {
        vector = new Vector<>(1);
    }

    @Test
    public void capacity_returnsInitialCapacity() {
        assertThat(vector.capacity()).isEqualTo(1);
    }

    @Test
    public void capacity_returnsDefaultCapacity() {
        vector = new Vector<>();

        assertThat(vector.capacity()).isEqualTo(16);
    }

    @Test
    public void size_emptyVector_returnsZero() {
        assertThat(vector.size()).isEqualTo(0);
    }

    @Test
    public void size_returnsCurrentSize() {
        vector.push(33);

        assertThat(vector.size()).isEqualTo(1);
    }

    @Test
    public void isEmpty_emptyVector_returnsTrue() {
        assertThat(vector.isEmpty()).isTrue();
    }

    @Test
    public void push_addsNewElement() {
        vector.push(3);

        assertThat(vector.at(0)).isEqualTo(3);
    }

    @Test
    public void pop_returnsHeadElement() {
        vector.push(3);

        assertThat(vector.pop()).isEqualTo(3);
        assertThat(vector.size()).isEqualTo(0);
    }

    @Test
    public void at_indexLowerThanZero_throwsException() {
        assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class)
                .isThrownBy(() -> vector.at(-2));
    }

    @Test
    public void at_indexGreaterThanSize_throwsException() {
        assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class)
                .isThrownBy(() -> vector.at(4));
    }

    @Test
    public void at_returnElementAtGivenIndex() {
        vector.push(3);
        vector.push(4);
        vector.push(5);

        assertThat(vector.at(2)).isEqualTo(5);
    }

    @Test
    public void capacity_initialSizeExceeded_returnsNewSize() {
        vector.push(3);
        vector.push(4);
        vector.push(5);

        assertThat(vector.capacity()).isEqualTo(4);
    }

    @Test
    public void find_returnsIndexOfElement() {
        vector.push(1);
        vector.push(5);
        vector.push(3);

        assertThat(vector.find(5)).isEqualTo(1);
    }

    @Test
    public void find_elementNotFound_ReturnsMinusOne() {
        vector.push(1);
        vector.push(5);
        vector.push(3);

        assertThat(vector.find(11)).isEqualTo(-1);
    }

    @Test
    public void insert_indexLowerThanZero_throwsException() {
        assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class)
                .isThrownBy(() -> vector.insert(2, -1));
    }

    @Test
    public void insert_indexGreaterThanCurrentSize_throwsException() {
        assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class)
                .isThrownBy(() -> vector.insert(2, 32));
    }

    @Test
    public void insert_insertsNewElementAtSpecifiedIndex() {
        vector.push(1);
        vector.push(5);
        vector.push(3);

        vector.insert(11, 1);

        assertThat(vector.find(11)).isEqualTo(1);
    }

    @Test
    public void delete_indexLowerThanZero_throwsException() {
        assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class)
                .isThrownBy(() -> vector.delete(-1));
    }

    @Test
    public void delete_indexGreaterThanCurrentSize_throwsException() {
        assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class)
                .isThrownBy(() -> vector.delete(32));
    }

    @Test
    public void delete_deletesElementAtSpecifiedIndex() {
        vector.push(1);
        vector.push(5);
        vector.push(3);

        vector.delete(1);

        assertThat(vector.size()).isEqualTo(2);
        assertThat(vector.at(1)).isEqualTo(3);
    }

    @Test
    public void remove_removesElement() {
        vector.push(1);
        vector.push(5);
        vector.push(3);

        vector.remove(3);

        assertThat(vector.size()).isEqualTo(2);
    }
}
