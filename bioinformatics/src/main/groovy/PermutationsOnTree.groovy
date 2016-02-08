import groovy.transform.CompileStatic

@CompileStatic
class PermutationsOnTree {
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
  }
}
