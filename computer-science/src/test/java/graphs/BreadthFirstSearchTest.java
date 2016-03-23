package graphs;

import org.junit.Test;

import static graphs.TestUtils.arr;
import static org.junit.Assert.*;

public class BreadthFirstSearchTest {
    @Test public void mustFindClosestNeighbours() {
        Graph graph = new Graph(3);
        graph.add(0, 1).add(0, 2);
        BreadthFirstSearch search = new BreadthFirstSearch(graph, 0).build();
        assertArrayEquals(arr(true, true, true), arr(search.marked));
        assertArrayEquals(new int[]{-1, 0, 0}, search.path);
    }
    @Test public void mustRememberThroughLinearPath() {
        Graph graph = new Graph(3);
        graph.add(0, 1).add(1, 2);
        BreadthFirstSearch search = new BreadthFirstSearch(graph, 0).build();
        assertArrayEquals(arr(true, true, true), arr(search.marked));
        assertArrayEquals(new int[]{-1, 0, 1}, search.path);
    }
    @Test public void mustFindShortestPathAmongMultiple() {
        Graph graph = new Graph(5);
        graph.add(0, 1).add(1, 2).add(0, 3).add(3, 4).add(4, 2);
        BreadthFirstSearch search = new BreadthFirstSearch(graph, 0).build();
        assertArrayEquals(new int[]{-1, 0, 1, 0, 3}, search.path);
    }
}