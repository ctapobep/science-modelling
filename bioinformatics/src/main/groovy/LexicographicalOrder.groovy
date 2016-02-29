class LexicographicalOrder {
  static List<String> order(String alphabet, int wordsLength) {
    int n = alphabet.length() ** wordsLength
    List<String> result = []
    for (int i = 0; i < n; i++) {
      String nextNumber = Integer.toString(i, alphabet.length())
      nextNumber = fillLeftWithZeros(nextNumber, wordsLength)
      String nextWord = ''
      for(int j = 0; j < wordsLength; j++ ) {
        nextWord += alphabet.charAt(Integer.parseInt(nextNumber.charAt(j) as String))
      }
      result.add(nextWord)
    }
    return result
  }

  private static String fillLeftWithZeros(String number, int length) {
    String result = number
    for(int i = 0; i < length - number.length(); i++) {
      result = '0' + result
    }
    return result
  }
}
