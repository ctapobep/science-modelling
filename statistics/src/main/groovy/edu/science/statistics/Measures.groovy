package edu.science.statistics

class Measures {
  def zTable = [confidence: 'multiplier']
  def tTable = ['sampleSize-1': [confidence: 'multiplier']]

  class ContinuousData {
    List<Integer> sample = [1, 4, 12, 5, 119, 123, 0]
    double mean = sample.sum() / sample.size()
    double variance = sample.every { Math.pow(mean - it, 2) } / (sample.size() - 1)
    double standardDeviation = Math.sqrt(variance)
    double standardError = standardDeviation/Math.sqrt(sample.size())
    /** 2 can be replaced with value from {@link Measures#zTable} if not 95% CI is required */
    def largeSizeConfidenceInterval = [mean - 2 * standardError, mean + 2 * standardError]
    /**
     * 2 MUST be replaced with value from {@link Measures#tTable} to adjust for
     * small sample size and to required CI.
     */
    def smallSizeConfidenceInterval = [mean - 2 * standardError, mean + 2 * standardError]
  }

  class BinomialData {
    List<Boolean> sample = [true, true, false, false, true, false, true, true, true]
    /** aka mean */
    double proportion = sample.findAll { it }.size() / sample.size()
    double variance = proportion * (1 - proportion)
    double standardDeviation = Math.sqrt(variance)
    double standardError = standardDeviation/Math.sqrt(sample.size())
    /** 2 can be replaced with value from {@link Measures#zTable} if not 95% CI is required */
    def largeSizeConfidenceInterval = [proportion - 2 * standardError, proportion + 2 * standardError]
    /**
     * 2 MUST be replaced with value from {@link Measures#tTable} to adjust for
     * small sample size and to required CI.
     */
    def smallSizeConfidenceInterval = [proportion - 2 * standardError, proportion + 2 * standardError]
  }

  class TimeToEventData {

  }
}
