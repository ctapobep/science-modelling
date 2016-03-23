package graphs;

import org.junit.Test;

import static graphs.TestUtils.arr;
import static org.junit.Assert.assertArrayEquals;

public class DepthFirstSearchTest {
    @Test
    public void mustRememberLinearPath() {
        Graph graph = new Graph(3).add(0, 1).add(1, 2);
        DepthFirstSearch search = new DepthFirstSearch(graph, 0).build();
        assertArrayEquals(new int[]{-1, 0, 1}, search.path);
    }

    @Test
    public void test() {
        Graph graph = new Graph(13);
        graph.add(0, 1);
        graph.add(0, 2);
        graph.add(0, 6);
        graph.add(0, 5);

        graph.add(3, 4);

        graph.add(5, 3);
        graph.add(5, 4);

        graph.add(6, 4);
        //not connected
        graph.add(7, 8);

        graph.add(9, 10);
        graph.add(9, 11);
        graph.add(9, 12);
        graph.add(11, 12);

        DepthFirstSearch search = new DepthFirstSearch(graph, 0).build();
        assertArrayEquals(arr(true, true, true, true, true, true, true, false, false, false, false, false, false), arr(search.marked));
        assertArrayEquals(new int[]{-1, 0, 0, 5, 3, 0, 4, -1, -1, -1, -1, -1, -1}, search.path);
    }
}
