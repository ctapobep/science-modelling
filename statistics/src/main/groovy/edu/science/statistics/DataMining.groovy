package edu.science.statistics

class DataMining {
  /**
   * Calculate general entropy of an attribute. Try to split every attribute into subgroups and see whether they reduce
   * the entropy (information gain). Find the segment with the highest IG and choose it as a root node. Then recursively
   * repeat the same for other attributes - you'll get a Classification Tree with probabilities of the target attribute
   * for each of the node.
   */
  class ClassificationTreeInduction {
    def targetAttribute
    def treeOfClasses = ['node', 'leaf with probability of the target attribute']
  }
  /**
   * Aka Parameter Modeling.
   */
  class ParameterLearning {

  }
}
