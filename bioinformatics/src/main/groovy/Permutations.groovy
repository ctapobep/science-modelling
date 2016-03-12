class Permutations {
  static String longestIncreasingSeq(String permutation) {
    String[] stringVector = permutation.split(' ')
    int[] vector = stringVector.collect { it as int }
    List<List<Integer>> increasingVectors = [[vector[0]]]

    for (int i = 1; i < vector.length; i++) {
      int next = vector[i]
      List<List<Integer>> tailLessThanNext = increasingVectors.findAll { it.last() < next }
      List<Integer> longest = tailLessThanNext.max { it.size() }
      List<Integer> newLongest = new ArrayList<>(longest ? longest : [])
      newLongest.add(next)
      increasingVectors.add(newLongest)
    }
    return increasingVectors.max { it.size() }.join(' ')
  }

  static String longestDecreasingSeq(String permutation) {
    String[] stringVector = permutation.split(' ')
    int[] vector = stringVector.collect { it as int }
    List<List<Integer>> increasingVectors = [[vector[0]]]

    for (int i = 1; i < vector.length; i++) {
      int next = vector[i]
      List<List<Integer>> tailLessThanNext = increasingVectors.findAll { it.last() > next }
      List<Integer> longest = tailLessThanNext.max { it.size() }
      List<Integer> newLongest = new ArrayList<>(longest ? longest : [])
      newLongest.add(next)
      increasingVectors.add(newLongest)
    }
    return increasingVectors.max { it.size() }.join(' ')
  }

  static List<String> permutations(String toPermutate) {
    if (!toPermutate) return []
    if (toPermutate.length() == 1) return [toPermutate]

    List<String> permutations = [toPermutate]
    String nextPermutation = toPermutate
    String finishedPart = ''
    for (int i = 0; i < numberOfPermutations(toPermutate); i++) {
      int swapFrom = i % nextPermutation.length()
      int swapTo = (swapFrom + 1) % nextPermutation.length()
      nextPermutation = swapChars(nextPermutation, swapTo, swapFrom)

      String fullPermutation = finishedPart + nextPermutation
      if(fullPermutation == toPermutate) {
        finishedPart += nextPermutation[0]
        nextPermutation = nextPermutation[1..nextPermutation.length()-1]
      } else permutations.add(fullPermutation)
      if(nextPermutation.length() == 1) break
    }
    return permutations
  }

  private static String swapChars(String nextPermutation, int swapTo, int swapFrom) {
    char[] charsToPermutate = nextPermutation.toCharArray()
    char tmp = charsToPermutate[swapTo]
    charsToPermutate[swapTo] = charsToPermutate[swapFrom]
    charsToPermutate[swapFrom] = tmp
    return new String(charsToPermutate)
  }

  private static int numberOfPermutations(String toPermutate) {
    int nOfPermutations = 1
    for (int i = 2; i <= toPermutate.length(); i++) {
      nOfPermutations *= i
    }
    nOfPermutations
  }
}
