import groovy.transform.CompileStatic

@CompileStatic
class Rna {
  final static Map<String, String> RNA_TO_PROTEIN = [
      UUU: 'F', CUU: 'L', AUU: 'I', GUU: 'V',
      UUC: 'F', CUC: 'L', AUC: 'I', GUC: 'V',
      UUA: 'L', CUA: 'L', AUA: 'I', GUA: 'V',
      UUG: 'L', CUG: 'L', AUG: 'M', GUG: 'V',
      UCU: 'S', CCU: 'P', ACU: 'T', GCU: 'A',
      UCC: 'S', CCC: 'P', ACC: 'T', GCC: 'A',
      UCA: 'S', CCA: 'P', ACA: 'T', GCA: 'A',
      UCG: 'S', CCG: 'P', ACG: 'T', GCG: 'A',
      UAU: 'Y', CAU: 'H', AAU: 'N', GAU: 'D',
      UAC: 'Y', CAC: 'H', AAC: 'N', GAC: 'D',
      UAA: 'Stop', CAA: 'Q', AAA: 'K', GAA: 'E',
      UAG: 'Stop', CAG: 'Q', AAG: 'K', GAG: 'E',
      UGU: 'C', CGU: 'R', AGU: 'S', GGU: 'G',
      UGC: 'C', CGC: 'R', AGC: 'S', GGC: 'G',
      UGA: 'Stop', CGA: 'R', AGA: 'R', GGA: 'G',
      UGG: 'W', CGG: 'R', AGG: 'R', GGG: 'G',
  ]
  final static Map<String, Integer> N_OF_SEQS_FOR_PROTEINS = [:]; static {
    def values = new ArrayList(RNA_TO_PROTEIN.values())
    values.sort()
    String prevValue = null
    int nOfOccurrences = 0
    for(String value: values) {
      if(value == prevValue) nOfOccurrences++
      else {
        N_OF_SEQS_FOR_PROTEINS[prevValue] = ++nOfOccurrences
        prevValue = value
        nOfOccurrences = 0
      }
    }
    N_OF_SEQS_FOR_PROTEINS[prevValue] = ++nOfOccurrences
  }
  final String id
  final String sequence

  Rna(String id, String sequence) {
    this.id = id
    this.sequence = sequence
  }

  String resultingProtein() {
    String aminoAcids = ''
    for (int i = 0; i < sequence.length();) {
      int codonEndIndex = i + 3
      if (sequence.length() < codonEndIndex) break
      String codon = sequence.substring(i, codonEndIndex);

      String aminoAcid = RNA_TO_PROTEIN[codon]
      if (aminoAcid == 'Stop') break
      aminoAcids += aminoAcid
      i += 3
    }
    return aminoAcids
  }

  int nOfPossibleSeqsForProtein() {
    if(!this.sequence) return 0
    int result = N_OF_SEQS_FOR_PROTEINS['Stop']//stop codon is also part of DNA, but it's not in protein
    for(char next: this.sequence.toCharArray()) {
      result *= N_OF_SEQS_FOR_PROTEINS[next as String]
      if(result >= 1_000_000) {
        result %= 1_000_000
      }
    }
    return result
  }

  static Rna rna(String sequence) {
    return new Rna(null, sequence)
  }

}
