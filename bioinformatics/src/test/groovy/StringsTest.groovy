import org.junit.Test

import static Strings.joinOverlap
import static Strings.overlap

class StringsTest {
  @Test void overlaptest() {
    assert 0 == overlap('', '')
    assert 0 == overlap('A', '')
    assert 0 == overlap('', 'B')
    assert 0 == overlap('A', 'B')

    assert 1 == overlap('AB', 'B')
    assert 0 == overlap('B', 'AB')
    assert 0 == overlap(' BA ', 'BA')

    assert 2 == overlap('ABA', 'BAC')
  }

  @Test void joinOverlapTest() {
    assert 'ABAC' == joinOverlap('ABA', 'BAC')
  }
  @Test void findingSplicedMotif() {
    assert SPLICED_MOTIF1.expectedIndices == Strings.indicesOfSplicedString(
        Dna.parseFasta(SPLICED_MOTIF1.sourceFasta).sequence[0],
        Dna.parseFasta(SPLICED_MOTIF1.motifFasta).sequence[0])
    assert SPLICED_MOTIF2.expectedIndices == Strings.indicesOfSplicedString(
        Dna.parseFasta(SPLICED_MOTIF2.sourceFasta).sequence[0],
        Dna.parseFasta(SPLICED_MOTIF2.motifFasta).sequence[0])
  }

  static final Map SPLICED_MOTIF1 = [
      sourceFasta: '>Rosalind_14\n' +
          'ACGTACGTGACG',
      motifFasta: '>Rosalind_18\n' +
          'GTA',
      expectedIndices: [3, 4, 5]
  ]
  static final Map SPLICED_MOTIF2 = [
      sourceFasta: '>Rosalind_4422\n' +
          'CCTCAGCACTGCTACGACGGTCCTGATGTATGTATCAGAAGTGGAATCAAGTAAGTCAAG\n' +
          'TGAAGGCCGGAGACCGACGACTGACCCCCACCGAATATTTCACATGTCGGTTAGAGGATA\n' +
          'GGTACTACCTCCGCGCAGATTGGATTAACGAGCGAAACCTCGGGTATCTTGAAGGATCAA\n' +
          'CCTATCGTCCATGCGGTTACTATCTTATCAATATCCGTCGCACGGACCAGACATAGTAGG\n' +
          'TGATCGCCCTACGTGAGAATGACATTCTCCATAGGGGGGGTCTTAAGCTTAGCCTAGTGT\n' +
          'CTATTATTGCTCGCGGCCTATGAACACGGGAAGTGTACTCCTCGTATCTGCACATGAAGC\n' +
          'CAAGCGAATCTAACTTAATAGCAGGGTCTTCTTTCACGCCCACAACCCGACGTAAAGGGT\n' +
          'GCTGATGAAGTCGTATGGTTGTCAGCGTAGGTTAACAACTTGTAGACGTGTACGAGTGTA\n' +
          'CTCTGCTTGCAGACAATCCGCGTGACAGTTACCAAATGCAACGAGGGGAAAGCCTCTAAT\n' +
          'TAATACCCAGAGCTCTTCTCACTTTACAGGGTATATCGGTGCTGAGACATATCTGGTCTA\n' +
          'GAATCCTCATGTCTTAAAGTGGATCATCAATTCCGCGCTCAGGTAGGTGTTAGTTAGGCA\n' +
          'CGAATTGAGCAAACATGCCCGTTAGAGATGAAATCAGTGCTCCACGTCCGACTCAAAGGA\n' +
          'GGACAACTTCGGGGTCTCCACTGTACAAGAATCCTCCGTTAAAGGGACGCGACCCCGGGG\n' +
          'GCGCCTTAGGGGGACCCAGAACCGTGCACTACAATCACTGATACCAGCATAAACTACCT',
      motifFasta: '>Rosalind_3378\n' +
          'TTTTCATAGCAGAAGCAGGGGTCTCGACTCGTCCCGACATGCACGAACGCTTTATAACGA\n' +
          'ATCAGCAA',
      expectedIndices: [3, 10, 13, 21, 22, 26, 27, 30, 32, 36, 37, 38, 39, 40, 41, 48, 49, 51, 55, 60, 62, 82, 85,
                        96, 101, 106, 113, 125, 126, 128, 133, 140, 149, 153, 158, 162, 166, 168, 172, 177, 187,
                        189, 191, 194, 195, 199, 202, 204, 217, 219, 234, 237, 241, 243, 244, 251, 256, 263, 274,
                        285, 286, 289, 293, 296, 297, 301, 303, 306]
  ]
}
