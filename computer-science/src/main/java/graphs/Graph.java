package graphs;

import java.util.HashSet;

public class Graph {
    private final HashSet<Integer>[] graph;

    public Graph(int size) {
        //noinspection unchecked
        this.graph = new HashSet[size];
        for (int i = 0; i < size; i++) {
            this.graph[i] = new HashSet<Integer>();
        }
    }

    Graph add(int v, int w) {
        graph[v].add(w);
        graph[w].add(v);
        return this;
    }

    Iterable<Integer> adj(int v) {
        return graph[v];
    }

    int[] vertices() {
        int[] result = new int[graph.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        return result;
    }
}
