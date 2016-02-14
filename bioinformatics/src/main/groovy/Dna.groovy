import groovy.transform.CompileStatic

@CompileStatic
class Dna {
  final String id
  final String sequence

  Dna(String id, String sequence) {
    this.id = id
    this.sequence = sequence
  }

  double gcRatio() {
    if (!sequence) return 0
    int cCount = NumberOfNucleotides.getNOfOccurrences(sequence, 'C' as char)
    int gCount = NumberOfNucleotides.getNOfOccurrences(sequence, 'G' as char)
    return ((double) (cCount + gCount)) / ((double) sequence.length())
  }

  /**
   * Why would we want to calculate GC content? Why does GC content even matter? At the prokaryotic level, GC
   * content correlates coding-sequence length, correlates with certain secondary RNA structures, and there is also
   * a noted bias towards low GC content in stop codons (TAG, TAA, and TGA). These are just to name a few situations
   * where rich GC regions and GC poor regions correlate with functional significance. Long coding regions in
   * vertebrates and prokaryotes are significantly correlated with GC content; long coding regions tend to be
   * GC-rich where as short coding regions tend to be GC poor. Since codons are biased towards being AT rich, mutations
   * in AT rich regions can likely lead to the generation of stop codons. Whereas in GC regions, many such mutations
   * might be required to spontaneously lead to stop codons. Therefore, conserved regions across organisms are likely
   * GC rich.
   *
   * Oliver, JL and Marin, A. A relationshiip between GC content and coding-sequence length. J Mol Evol 1996 Sep;43(3)216-23
   *
   * Andersson, SGE and Kurland CG. Genomic evolution drives the evolution of the translation system. Biochem. Cell Biol 73:775-787 (1995)
   *
   * D'Onofrio, Giuseppe and Benardy, Giorgio. A Universal Compositional correlation among Codon Positions. GENE, 110(1992)81-88
   * @return ratio of G and C nucleotides * 100
   */
  double gcContent() { gcRatio() * 100 }

  int hammingDistance(Dna dna) {
    int distance = 0
    for(int i = 0; i < sequence.length(); i++) {
      if(sequence.charAt(i) != dna.sequence.charAt(i)) {
        distance++;
      }
    }
    return distance
  }
  int getLength() {
    return sequence.length()
  }

  String toRnaString() {
    return sequence.replaceAll('T', 'U')
  }

  char getAt(int symbolPosition) {
    return sequence.charAt(symbolPosition)
  }

  List<Integer> positionsOf(String subSequence) {
    int subLength = subSequence.length()
    List<Integer> positions = new ArrayList<>();
    for (int i = 0; i < sequence.length() - subLength + 1; i++) {
      if (sequence.charAt(i) == subSequence.charAt(0)) {
        if (sequence[i..(i + subLength -1)] == subSequence) {
          positions.add(i + 1)
        }
      }
    }
    return positions
  }

  static String longestCommonSequence(List<Dna> dnas) {
    if (!dnas) return ''
    Dna longestDna = Collections.max(dnas, new BySequenceLengthComparator())
    String longestSeq = ''
    for (int startOfSeq = 0; startOfSeq < longestDna.length; startOfSeq++) {
      String commonSeq = ''
      //we don't need to check sequences shorter than existing longest seq, so starting with the same length
      for (int endOfSeq = startOfSeq + longestSeq.length(); endOfSeq < longestDna.length; endOfSeq++) {
        commonSeq = commonSeq + longestDna[endOfSeq]
        Map<Dna, List<Integer>> positions = dnas.collectEntries { Dna it -> [(it): it.positionsOf(commonSeq)] }
        if (positions.values().any { List it -> it.isEmpty() }) {
          if (longestSeq.length() < commonSeq.length()) longestSeq = commonSeq.substring(0, commonSeq.length() - 1)
          break
        } else if (endOfSeq == longestDna.length - 1) { //end of story
          if (longestSeq.length() < commonSeq.length()) longestSeq = commonSeq
        }
      }
    }
    return longestSeq
  }

  static Dna fromString(String seq) {
    return new Dna(null, seq)
  }
  static Dna dna(String seq) {
    return fromString(seq)
  }
  static List<Dna> fromStrings(String ... seq) {
    return seq.collect{String it -> fromString(it)}
  }

  static List<Dna> parseFasta(String fastaString) {
    String currentDnaId = ''
    String currentDnaSeq = ''
    List<Dna> result = []
    fastaString.eachLine { String it ->
      if (it.startsWith('>')) {//next
        if (currentDnaId) result.add(new Dna(currentDnaId, currentDnaSeq))
        currentDnaId = it.replace('>', '')
        currentDnaSeq = ''
      } else {
        currentDnaSeq += it
      }
    }
    if (currentDnaId) result.add(new Dna(currentDnaId, currentDnaSeq))
    return result
  }

  String toString() {
    return "[$id, $sequence]"
  }

  boolean equals(o) {
    if (this.is(o)) return true
    if (getClass() != o.class) return false

    Dna dna = (Dna) o

    if (sequence != dna.sequence) return false

    return true
  }

  int hashCode() {
    return (sequence != null ? sequence.hashCode() : 0)
  }

  static class ByGcRatioDescComparator implements Comparator<Dna> {
    @Override int compare(Dna o1, Dna o2) {
      return Double.compare(o2.gcRatio(), o1.gcRatio())
    }
  }

  static class BySequenceLengthComparator implements Comparator<Dna> {
    @Override int compare(Dna o1, Dna o2) {
      return Integer.compare(o1.length, o2.length)
    }
  }
}
