import groovy.transform.CompileStatic

@CompileStatic
class Rna {
  final static RNA_TO_PROTEIN = [
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

  static Rna rna(String sequence) {
    return new Rna(null, sequence)
  }

}
