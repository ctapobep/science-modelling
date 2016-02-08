import org.junit.Test

class PermutationsTest {
  @Test void testPermutations() {
    ['abc', 'bac', 'bca', 'acb', 'cab', 'cba'] == Permutations.permutations('abc')
    println Permutations.permutations('abcd').size()
    print Permutations.permutations('abcd').join('\n')
  }

  @Test void testPermutationsOnGraph() {
    assert 24*5*6 == PermutationsOnTree.permutations('12345')

  }
}
