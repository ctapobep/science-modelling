/**
 * Profile Matrix shows how many times does a symbol occur on some position in multiple string sequences.
 */
class ProfileMatrix {
  /**
   * Examples of rows:
   * A: 5, 4, 1
   * C: 2, 5, 3
   * G: 1, 2, 5
   * T: 0, 2, 7
   */
  int[][] profile = new int[4][]

  /**
   * Contains most common symbol at each position; the jjth symbol of cc therefore corresponds to the symbol having
   * the maximum value in the jj-th column of the profile matrix. Of course, there may be more than one most common
   * symbol, leading to multiple possible consensus strings.
   */
  String consensus() {
    char[] result = new char[profile[0].length]
    for (int i = 0; i < result.length; i++) {
      int[] column = profile.collect { it[i] }
      int biggestRow = indexOfMaxValue(column)
      result[i] = rowToChar(biggestRow)
    }
    return new String(result)
  }

  static ProfileMatrix fromDnas(List<Dna> dnas) {
    int length = dnas[0].length
    int[][] profile = new int[4][length]

    for (int i = 0; i < length; i++) {
      for (Dna dna : dnas) {
        int profileRow = charToArrayRow(dna[i])
        Integer value = profile[profileRow][i]
        if (value == null) value = 0
        profile[profileRow][i] = ++value
      }
    }
    return new ProfileMatrix(profile: profile)
  }

  private static int charToArrayRow(char nucleotide) {
    switch (nucleotide) {
      case 'A': return 0
      case 'C': return 1
      case 'G': return 2
      case 'T': return 3
      default: throw new IllegalArgumentException("Bad nucleotide: ${nucleotide}")
    }
  }
  private static char rowToChar(int row) {
    switch (row) {
      case 0: return 'A' as char
      case 1: return 'C' as char
      case 2: return 'G' as char
      case 3: return 'T' as char
      default: throw new IllegalArgumentException("No row more than 3 is available: ${row}")
    }
  }

  private static char indexOfMaxValue(int[] profileColumn) {
    int maxValue = -1, maxIndex = 0
    for(int i = 0; i < profileColumn.length; i++) {
      int next = profileColumn[i]
      if(maxValue < next) {
        maxValue = next
        maxIndex = i
      }
    }
    return maxIndex
  }
}
