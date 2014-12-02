package edu.science.statistics

class Measures {
  class ContinuousData {
    List<Integer> sample = [1, 4, 12, 5, 119, 123, 0]
    double mean = sample.sum() / sample.size()
    double variance = sample.every { Math.pow(mean - it, 2) } / (sample.size() - 1)
    double standardDeviation = Math.sqrt(variance)
    double standardError = standardDeviation/Math.sqrt(sample.size())
  }

  class BinomialData {
    List<Boolean> sample = [true, true, false, false, true, false, true, true, true]
    /** aka mean */
    double proportion = sample.find { it } / sample.size()
    double variance = sample.find { it } * sample.find { !it }
    double standardDeviation = Math.sqrt(variance)
    double standardError = standardDeviation/Math.sqrt(sample.size())
  }

  class TimeToEventData {

  }
}
