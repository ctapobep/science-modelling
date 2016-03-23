package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    final Graph graph;
    final int vertex;
    final boolean[] marked;
    final int[] path;
    final Queue<Integer> toVisit = new LinkedList<Integer>();

    BreadthFirstSearch(Graph graph, int vertex) {
        this.graph = graph;
        this.vertex = vertex;
        this.marked = new boolean[graph.vertices().length];
        this.path = new int[graph.vertices().length];
        Arrays.fill(path, -1);
    }

    BreadthFirstSearch build() {
        doBuild(vertex);
        return this;
    }

    private void doBuild(int vertex) {
        marked[vertex] = true;
        for (int nextAdj : graph.adj(vertex)) {
            marked[nextAdj] = true;
            path[nextAdj] = vertex;
            for(int neighbour: graph.adj(nextAdj)) {
                if (!marked[neighbour]) {
                    marked[neighbour] = true;
                    path[neighbour] = nextAdj;
                }
            }
        }
    }
}
