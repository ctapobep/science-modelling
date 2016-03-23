package graphs;

import java.util.Arrays;

public class DepthFirstSearch {
    final Graph graph;
    final int vertex;
    final boolean[] marked;
    final int[] path;

    DepthFirstSearch(Graph graph, int vertex) {
        this.graph = graph;
        this.vertex = vertex;
        this.marked = new boolean[graph.vertices().length];
        this.path = new int[graph.vertices().length];
        Arrays.fill(path, -1);
    }

    DepthFirstSearch build() {
        doBuild(vertex);
        return this;
    }

    private void doBuild(int vertex) {
        marked[vertex] = true;
        for (int nextAdj : graph.adj(vertex)) {
            if (!marked[nextAdj]) {
                marked[nextAdj] = true;
                path[nextAdj] = vertex;
                doBuild(nextAdj);
            }
        }
    }
}
