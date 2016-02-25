class Protein {
  final String id;
  final String sequence;

  Protein(String id, String sequence) {
    this.id = id;
    this.sequence = sequence;
  }

  static Protein protein(String sequence) {
    return new Protein(null, sequence);
  }

  /**
   * Excludes water mass (18.01056 da) as for now
   * @return a mass of the protein as if it conisted only of the principal isotopes and no others
   */
  double monoisotopicMass() {
    double result = 0;
    for (char next : sequence.toCharArray()) {
      AminoAcid aa = AminoAcid.valueOf(next as String)
      if (!aa) throw new IllegalArgumentException("There is no such amino acid ${next} (protein id: ${id})")
      result += aa.monoisotopicMass
    }
    return result
  }
}
