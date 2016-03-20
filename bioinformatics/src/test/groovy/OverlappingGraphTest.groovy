import org.junit.Test

import static junit.framework.Assert.fail

class OverlappingGraphTest {
  @Test void testAdd() {
    def graph = new OverlappingGraph()
    graph.add('ABA')
    graph.add('BAC')
    assert 2 == graph.edge('ABA', 'BAC')
    assert 0 == graph.edge('BAC', 'ABA')
    assert 'ABAC' == graph.shortestSuperstring()
  }

  @Test void testRemove() {
    def graph = new OverlappingGraph()
    graph.add('ABA')
    graph.add('BAC')
    graph.remove('ABA')
    try { graph.edge('ABA', 'BAC'); fail() } catch (NoSuchElementException ignored) { }
    try { graph.edge('BAC', 'ABA'); fail() } catch (NoSuchElementException ignored) { }
  }
  @Test void testLongest() {
    def graph = new OverlappingGraph()
    graph.add('ABA')
    graph.add('BAC')
    graph.add('CCD')
    assert 'ABA' == graph.longestOverlap().v1
    assert 'BAC' == graph.longestOverlap().v2
  }

  @Test void shortestSuperstring() {
    assert SHORTEST_SUPER1.shortest == new OverlappingGraph(Dna.parseFasta(SHORTEST_SUPER1.fasta)).shortestSuperstring()
    assert SHORTEST_SUPER2.shortest == new OverlappingGraph(Dna.parseFasta(SHORTEST_SUPER2.fasta)).shortestSuperstring()
  }

  static final Map SHORTEST_SUPER1 = [
      shortest: 'ATTAGACCTGCCGGAATAC',
      fasta: '>Rosalind_56\n' +
          'ATTAGACCTG\n' +
          '>Rosalind_57\n' +
          'CCTGCCGGAA\n' +
          '>Rosalind_58\n' +
          'AGACCTGCCG\n' +
          '>Rosalind_59\n' +
          'GCCGGAATAC'
  ]
  static final Map SHORTEST_SUPER2 = [
      shortest: OverlappingGraphTest.class.getResource('/shortest_superstring.txt').text,
      fasta   : OverlappingGraphTest.class.getResource('/shortest_superstring_input.fasta').text
  ]
}
