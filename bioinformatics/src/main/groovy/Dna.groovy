import groovy.transform.CompileStatic

@CompileStatic
class Dna {
  final static Map<String, String> DNA_TO_PROTEIN = [
      TTT: 'F', CTT: 'L', ATT: 'I', GTT: 'V',
      TTC: 'F', CTC: 'L', ATC: 'I', GTC: 'V',
      TTA: 'L', CTA: 'L', ATA: 'I', GTA: 'V',
      TTG: 'L', CTG: 'L', ATG: 'M', GTG: 'V',
      TCT: 'S', CCT: 'P', ACT: 'T', GCT: 'A',
      TCC: 'S', CCC: 'P', ACC: 'T', GCC: 'A',
      TCA: 'S', CCA: 'P', ACA: 'T', GCA: 'A',
      TCG: 'S', CCG: 'P', ACG: 'T', GCG: 'A',
      TAT: 'Y', CAT: 'H', AAT: 'N', GAT: 'D',
      TAC: 'Y', CAC: 'H', AAC: 'N', GAC: 'D',
      TAA: 'Stop', CAA: 'Q', AAA: 'K', GAA: 'E',
      TAG: 'Stop', CAG: 'Q', AAG: 'K', GAG: 'E',
      TGT: 'C', CGT: 'R', AGT: 'S', GGT: 'G',
      TGC: 'C', CGC: 'R', AGC: 'S', GGC: 'G',
      TGA: 'Stop', CGA: 'R', AGA: 'R', GGA: 'G',
      TGG: 'W', CGG: 'R', AGG: 'R', GGG: 'G',
  ]
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

  List<Integer> positionsOf(String subSequence, int startFrom = 0) {
    int subLength = subSequence.length()
    List<Integer> positions = new ArrayList<>();
    for (int i = startFrom; i < sequence.length() - subLength + 1; i++) {
      if (sequence.charAt(i) == subSequence.charAt(0)) {
        if (sequence[i..(i + subLength -1)] == subSequence) {
          positions.add(i + 1)
        }
      }
    }
    return positions
  }

  Dna remove(List<Dna> parts) {
    String resultSeq = this.sequence
    for(Dna part: parts) {
      resultSeq -= part.sequence
    }
    return new Dna(id, resultSeq)
  }

  List<String> possibleProteinsThatCanStartAnywhere() {
    List<String> result = []
    for (int startCodonPosition : positionsOf('ATG')) {
      Dna dna = dna(sequence.substring(startCodonPosition - 1))
      String protein = dna.resultingProtein()
      if(protein) result.add(protein)
    }
    Dna complementary = this.complementaryDna()
    for (int startCodonPosition : complementary.positionsOf('ATG')) {
      Dna dna = dna(complementary.sequence.substring(startCodonPosition - 1))
      String protein = dna.resultingProtein()
      if(protein) result.add(protein)
    }
    return result.unique()
  }

  String resultingProtein() {
    String aminoAcids = ''
    boolean metStopCodon = false
    for (int i = 0; i < sequence.length();) {
      int codonEndIndex = i + 3
      if (sequence.length() < codonEndIndex) return '' //it must stop with stop codon, if it's not - the protein is invalid
      String codon = sequence.substring(i, codonEndIndex);

      String aminoAcid = DNA_TO_PROTEIN[codon]
      if (aminoAcid == 'Stop') {
        metStopCodon = true
        break
      }
      aminoAcids += aminoAcid
      i += 3
    }
    if(!metStopCodon) return ''
    return aminoAcids
  }

  Dna complementaryDna() {
    StringBuilder result = new StringBuilder()
    for (int i = sequence.length() - 1; i >= 0; i--) {
      char nucleotide = sequence.charAt(i)
      result.append(complementNucleotide(nucleotide))
    }
    return new Dna(null, result.toString())
  }

  Map<Integer, Integer> reversePalindromes() {
    Map<Integer, Integer> result = [:]
    for (int i = 0; i < sequence.length(); i++) {
      int end = Math.min(i + 12, sequence.length() - 1)
      int palindromeLength = 0

      int start = i
      while (start < end) {
        //palindromes are always even. since i starts with 0, even and odd are mixed up
        if ((end - start + 1) % 2 != 0) end--
        char endChar = sequence.charAt(end)
        char startChar = sequence.charAt(start)
        if (startChar != complementNucleotide(endChar)) {
          start = i
          // one -1 is to return back to 0-based counting and another one is so that we don't return back the the
          // {@code end} that was in this exact palindrome
          if(palindromeLength) end = start + palindromeLength - 2
          palindromeLength = 0
        } else if (palindromeLength == 0) {
          palindromeLength = end - start + 1//index begins with 0, so the length needs to be adjusted, ergo +1
          start++
        } else {
          start++
        }
        end--
      }
      if (palindromeLength >= 4) result.put(i + 1, palindromeLength)
    }
    return result
  }

  private static char complementNucleotide(char nucleotide) {
    switch (nucleotide) {
      case ('A' as char): return 'T' as char
      case ('T' as char): return 'A' as char
      case ('G' as char): return 'C' as char
      case ('C' as char): return 'G' as char
    }
    throw new IllegalArgumentException("No such DNA nucleotide: ${nucleotide}")
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
