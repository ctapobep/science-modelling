import groovy.transform.CompileStatic

@CompileStatic
class PermutationsOnTree {
  public static void main(String[] args) {
    println signedPermutations('1234')
  }
  static int permutations(String toPermutate) {
    List<Node> rootNodes = toPermutate.toCharArray().collect { char it ->
      Node node = new Node(value: new String(it), otherChars: toPermutate - it)
      node.buildSubNodes()
      return node
    }
    new Node(otherNodes: rootNodes).printBottomNodes()

    int result = 1;
    for (int i = 2; i <= toPermutate.length(); i++) {
      result *= i
    }
    return result
  }

  static int signedPermutations(String toPermutate) {
    List<Node> rootNodes = toPermutate.toCharArray().collect { char it ->
      Node node = new Node(value: new String(it), otherChars: toPermutate - it)
      node.buildSubNodes()
      return node
    }
    new Node(otherNodes: rootNodes).printBottomNodesWithSigns()

    int result = 1;
    for (int i = 2; i <= toPermutate.length(); i++) {
      result *= i
    }
    return result * 2**toPermutate.length()
  }

  static class Node {
    String otherChars
    String value
    List<Node> otherNodes = []

    void buildSubNodes() {
      for (char ch : otherChars.toCharArray()) {
        Node node = new Node(value: value + ch, otherChars: otherChars - ch)
        node.buildSubNodes()
        otherNodes.add(node)
      }
    }

    void printBottomNodes() {
      if (!otherNodes) {
        println Arrays.asList(value.toCharArray()).join(' ')
      } else {
        otherNodes.each { Node node -> node.printBottomNodes() }
      }
    }

    void printBottomNodesWithSigns() {
      if (!otherNodes) {
        signPermutations(value.toCharArray())
      } else {
        otherNodes.each { Node node -> node.printBottomNodesWithSigns() }
      }
    }
    static void signPermutations(char[] elements) {
      for (int i = 0; i < 2**elements.length; i++) {
        List<String> row = []
        for (int j = 0; j < elements.length; j++) {
          String element = elements[j]
          element = (i & 2**j) == 0 ? element : "-${element}"
          row += element
        }
        println row.join(' ')
      }
    }
  }
}
