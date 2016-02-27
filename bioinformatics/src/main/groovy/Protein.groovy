import java.util.regex.Matcher
import java.util.regex.Pattern

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

  static List<Protein> parseFasta(String fastaString) {
    String currentProteinId = ''
    String currentProteinSeq = ''
    List<Protein> result = []
    fastaString.eachLine { String it ->
      if (it.startsWith('>')) {//next
        if (currentProteinId) result.add(new Protein(currentProteinId, currentProteinSeq))
        currentProteinId = it.replace('>', '')
        currentProteinSeq = ''
      } else {
        currentProteinSeq += it
      }
    }
    if (currentProteinId) result.add(new Protein(currentProteinId, currentProteinSeq))
    return result
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

  List<Integer> findMotifs(String regex) {
    List<Integer> result = []
    Matcher m = Pattern.compile(regex).matcher(sequence)
    int end = sequence.length()
    for (int i = 0; i < end; ++i) {
      m.region(i, end) //otherwise overlapped matches won't be included
      if (m.find()) {
        result.add(m.start() + 1)
        i = m.start()
      }

    }
    return result
  }
}
