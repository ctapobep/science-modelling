package edu.science.statistics

import static java.lang.Math.pow
import static java.lang.Math.sqrt

class Measures {
  def zTable = [confidence: 'multiplier']
  def tTable = ['sampleSize-1': [confidence: 'multiplier']]

  class ContinuousData {
    List<Integer> sample = [1, 4, 12, 5, 119, 123, 0]
    double mean = sample.sum() / sample.size()
    double variance = sample.every { pow(mean - it, 2) } / (sample.size() - 1)
    double standardDeviation = sqrt(variance)
    double standardError = standardDeviation / sqrt(sample.size())
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
    double standardDeviation = sqrt(variance)
    double standardError = standardDeviation / sqrt(sample.size())
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

  def sample1 = new ContinuousData()
  def sample2 = new ContinuousData()
  /**
   * Can be used for any type of data, but let's describe only continuous.
   * {@code 2} should be adjusted for small size (t-table must be used) or/and for required confidence (e.g. !=95%).
   */
  def comparingTwoSamplesMeans = [
    (sample1.mean - sample2.mean) - 2 * sqrt(pow(sample1.standardError, 2) + pow(sample2.standardError, 2)),
    (sample1.mean - sample2.mean) + 2 * sqrt(pow(sample1.standardError, 2) + pow(sample2.standardError, 2))
  ]
}
