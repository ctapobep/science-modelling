class OverlappingGraph {
  Map<String, Map<String, Integer>> graph = [:]

  OverlappingGraph() {}

  OverlappingGraph(List<Dna> dnas) {
    for (Dna dna : dnas) {
      add(dna.sequence)
    }
  }

  void add(String toAdd) {
    graph[toAdd] = [:]
    for (String nextVertex : graph.keySet()) {
      if (nextVertex.is(toAdd)) continue
      graph[toAdd].put(nextVertex, Strings.overlap(toAdd, nextVertex))
      graph[nextVertex].put(toAdd, Strings.overlap(nextVertex, toAdd))
    }
  }

  void remove(String toRemove) {
    graph.remove(toRemove)
    for (Map<String, Integer> edge : graph.values()) {
      edge.remove(toRemove)
    }
  }

  int edge(String v1, String v2) {
    if (graph[v1] == null || graph[v2] == null) throw new NoSuchElementException()
    return graph[v1][v2]
  }

  Map<String, String> longestOverlap() {
    int max = 0
    String v1 = null, v2 = null
    for (Map.Entry<String, Map<String, Integer>> v1Entry : graph.entrySet()) {
      for (Map.Entry<String, Integer> v2Entry : v1Entry.value.entrySet()) {
        if (max <= v2Entry.value) {
          max = v2Entry.value
          v1 = v1Entry.key
          v2 = v2Entry.key
        }
      }
    }
    return [v1: v1, v2: v2]
  }

  String shortestSuperstring() {
    while (graph.size() > 1) {
      def vertices = longestOverlap()
      String longer = Strings.joinOverlap(vertices.v1, vertices.v2)
      this.remove(vertices.v1)
      this.remove(vertices.v2)
      this.add(longer)
    }
    return graph.keySet().iterator().next()
  }
}
