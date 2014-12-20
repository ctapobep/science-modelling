package edu.science.statistics

import static java.lang.Math.*

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
    def mean_largeSize_confidenceInterval = [mean - 2 * standardError, mean + 2 * standardError]
    /**
     * 2 MUST be replaced with value from {@link Measures#tTable} to adjust for
     * small sample size and to required CI.
     */
    def mean_smallSize_confidenceInterval = [mean - 2 * standardError, mean + 2 * standardError]
  }

  class BinomialData {
    List<Boolean> sample = [true, true, false, false, true, false, true, true, true]
    /** aka mean */
    double proportion = sample.findAll { it }.size() / sample.size()
    double variance = proportion * (1 - proportion)
    double standardDeviation = sqrt(variance)
    double standardError = standardDeviation / sqrt(sample.size())
    /** 2 can be replaced with value from {@link Measures#zTable} if not 95% CI is required */
    def proportion_largeSize_confidenceInterval = [proportion - 2 * standardError, proportion + 2 * standardError]
    /**
     * 2 MUST be replaced with value from {@link Measures#tTable} to adjust for
     * small sample size and to required CI.
     */
    def proportion_smallSize_confidenceInterval = [proportion - 2 * standardError, proportion + 2 * standardError]

    int getSize() { sample.size() }

    int getRespondedSize() { sample.findAll { true }.size() }

    int getNotRespondedSize() { sample.findAll { false }.size() }

    double getEntropy() { -(proportion * log(proportion) / log(2)) }
  }

  class TimeToEventData {
    List<Date> sample = ['01-09-2009', '12-09-2009', '30-09-2009', '25-09-2009', '20-09-2009', '18-09-2009']
    int followUpPeriodInDays = 30
    /** Can be in week, month, year, 10 years, etc. But if the follow up period is smaller than 'per X' part,
     * it doesn't mean we know the rate of cases per X, we cannot extrapolate inc rate like that. Instead it's like
     * saying we had N studies with {@link #followUpPeriodInDays} each and then the inc rate summed is M/X*/
    double incidenceRatePerDay = sample.size() / followUpPeriodInDays
    double variance = '?';

    int getSize() { sample.size() }
  }

  def sample1 = new ContinuousData()
  def sample2 = new ContinuousData()
  /**
   * Can be used for any type of data, but let's describe only continuous.
   * {@code 2} should be adjusted for small size (t-table must be used) or/and for required confidence (e.g. !=95%).
   */
  def meanDifferenceCi = [
    (sample1.mean - sample2.mean) - 2 * sqrt(sample1.variance + sample2.variance),
    (sample1.mean - sample2.mean) + 2 * sqrt(sample1.variance + sample2.variance)
  ]
  //def pValue = [(sample1.mean - sample2.mean) / sample1.standardDeviation]//!!

  def sample3 = new BinomialData()
  def sample4 = new BinomialData()

  /** Because RR is not normally distributed, but its ln is, we should use ln to compute the CI and then unlog
   * the values */
  def riskRatioCi = [
    exp(
      log(sample3.proportion / sample4.proportion) - 2 *
        sqrt(1 / sample3.respondedSize - 1 / sample3.size + 1 / sample4.respondedSize - 1 / sample4.size)
    ),
    exp(
      log(sample3.proportion / sample4.proportion) + 2 *
        sqrt(1 / sample3.respondedSize - 1 / sample3.size + 1 / sample4.respondedSize - 1 / sample4.size)
    )
  ]
  def rrPValue = []

  /** Confidence Interval for Odds Ratio. Note that with small sizes 2 must be replaced with T-score. */
  def oddsRatioCi = [
    exp(
      log(sample3.respondedSize / sample3.notRespondedSize) - 2 *
        sqrt(1 / sample3.respondedSize + 1 / sample3.notRespondedSize + 1 / sample4.respondedSize + 1 / sample4.notRespondedSize)
    ),
    exp(
      log(sample3.respondedSize / sample3.notRespondedSize) + 2 *
        sqrt(1 / sample3.respondedSize + 1 / sample3.notRespondedSize + 1 / sample4.respondedSize + 1 / sample4.notRespondedSize)
    )
  ]

  def sample5 = new TimeToEventData()
  def sample6 = new TimeToEventData()
  /** Incidence Rate Ratio Confidence Interval */
  def incRateRatioCi = [
    exp(
      log(sample5.incidenceRatePerDay / sample6.incidenceRatePerDay) - 2 * sqrt(1 / sample5.size + 1 / sample6.size)
    ),
    exp(
      log(sample5.incidenceRatePerDay / sample6.incidenceRatePerDay) + 2 * sqrt(1 / sample5.size + 1 / sample6.size)
    )
  ]
}
