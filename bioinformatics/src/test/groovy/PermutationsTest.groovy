import org.junit.Test

class PermutationsTest {
  @Test void testPermutations() {
    ['abc', 'bac', 'bca', 'acb', 'cab', 'cba'] == Permutations.permutations('abc')
    println Permutations.permutations('abcd').size()
    print Permutations.permutations('abcd').join('\n')
  }
}
