package edu.science.statistics

class Modelling { // AKA: Creating Models from Data, Induction
  def type = ['Classification', 'Regression']
  class DataSet {
    class Case { // AKA: Example, Instance
      def independentVariable = ['Feature', 'Predictor', 'Explanatory Variables']
      def dependentVariable  = ['Target Variable']
    }
  }
  def algorithm = ['Learner Algorithm', 'Induction Algorithm']
}
