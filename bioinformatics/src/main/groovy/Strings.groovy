class Strings {
  static int overlap(String s1, String s2, int minLength = 1) {
    int length = Math.min(s1.length(), s2.length())
    for (int i = length; i >= minLength; i--) {
      if(s1.endsWith(s2.substring(0, i))) return i
    }
    return 0
  }
  static String joinOverlap(String s1, String s2) {
    int overlap = overlap(s1, s2, 1)
    return s1 + s2.substring(overlap)
  }
  static int[] indicesOfSplicedString(String source, String substring) {
    int[] indices = new int[substring.length()]
    int prevIndex = 0
    for(int i = 0; i < substring.length(); i++) {
      int index = source.indexOf(substring[i], prevIndex) + 1
      prevIndex = index
      indices[i] = index
    }
    return indices
  }
}
