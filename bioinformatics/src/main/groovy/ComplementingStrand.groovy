import groovy.transform.CompileStatic

@CompileStatic
class ComplementingStrand {

  static String complementDna(String dnaStrand) {
    StringBuilder result = new StringBuilder()
    for (int i = dnaStrand.length() - 1; i >= 0; i--) {
      char nucleotide = dnaStrand.charAt(i)
      result.append(complementDna(nucleotide))
    }
    return result.toString()
  }


  static char complementDna(char nucleotide) {
    switch (nucleotide) {
      case ('A' as char): return 'T' as char
      case ('T' as char): return 'A' as char
      case ('G' as char): return 'C' as char
      case ('C' as char): return 'G' as char
    }
    throw new IllegalArgumentException("No such DNA nucleotide: ${nucleotide}")
  }
}