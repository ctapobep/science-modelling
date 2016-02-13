import groovy.transform.CompileStatic

@CompileStatic
class Graphs {
  static List<List<Dna>> overlappedDnas(List<Dna> dnas, int overlapLength = 3) {
    List<List<Dna>> result = []
    for (Dna dna1 : dnas) {
      assertNoLongerThanOverlapLength(dna1, overlapLength)
      for (Dna dna2 : dnas) {
        if (!dna1.sequence.equals(dna2.sequence) && dna1.sequence[-3..dna1.length-1] == dna2.sequence[0..2]) {
          result.add([dna1, dna2])
        }
      }
    }
    return result
  }

  private static void assertNoLongerThanOverlapLength(Dna dna1, int overlapLength) {
    if (dna1.length < overlapLength) {
      throw new IllegalArgumentException("Sequence length ${dna1.length} was less than overlap length ${overlapLength}")
    }
  }
}
