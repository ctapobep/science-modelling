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

  double gcContent() { gcRatio() * 100 }

  static Dna fromString(String seq) {
    return new Dna(null, seq)
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

  static class ByGcRatioDescComparator implements Comparator<Dna> {
    @Override int compare(Dna o1, Dna o2) {
      return Double.compare(o2.gcRatio(), o1.gcRatio())
    }
  }

  String toString() {
    return "[$id, $sequence]"
  }
}
