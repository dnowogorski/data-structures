package org.dnowogorski.graph;

public interface Paths {
    boolean hasPathTo(int dest);
    Iterable<Integer> pathTo(int dest);
}
