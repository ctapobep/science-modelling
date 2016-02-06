import groovy.transform.CompileStatic
import org.junit.Test

@CompileStatic
class NumberOfNucleotidesTest {
  @Test void 'n of nucleotides should be right'() {
    assert 20 == NumberOfNucleotides.getNOfOccurrences(STRAND, 'A' as char)
    assert 12 == NumberOfNucleotides.getNOfOccurrences(STRAND, 'C' as char)
    assert 17 == NumberOfNucleotides.getNOfOccurrences(STRAND, 'G' as char)
    assert 21 == NumberOfNucleotides.getNOfOccurrences(STRAND, 'T' as char)
  }

  static final String STRAND = 'AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC'
}
