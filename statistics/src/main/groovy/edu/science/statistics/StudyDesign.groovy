package edu.science.statistics

class StudyDesign {
  /** Population is divided into groups by exposure and waiting whether the outcome was achieved. */
  class Cohort {
    double incidenceRatio
  }
  /**
   * Retrospective studies. We have an outcome (disease) and look retrospectively at whether the exposure (smoking)
   * was present or not.
   */
  class CaseControl {
    double oddsRatio
  }

  class RandomizedControlledStudy {
    double absoluteRiskDifference
    /**
     * Risk Ratio
     */
    double relativeRisk
  }
}
