package edu.science.statistics

class StudyDesign {
  /** Just measuring an exposure in a sample. Ex: conducting a poll of how much sugar people take per day */
  class SampleStudy {}
  /** Looking for relation between variables in sample. Ex: comparing sugar intake and heart disease. */
  class ObservationalStudy {
    /**
     * Retrospective studies. We have an outcome (disease) and look retrospectively at whether the exposure (smoking)
     * was present or not.
     */
    class CaseControl {
      double oddsRatio
    }
  }
  /**
   * Intentionally exposing or not a sample of people and see how it will work. Ex: separating 2 samples of people into
   * exposed & control groups, giving the exposed group some amount of sure and compare these groups in couple of years
   * on the rate of heart disease.
   */
  class Experiment {
    /** Population is divided into groups by exposure and waiting whether the outcome was achieved. */
    class Cohort {
      def data = Measures.TimeToEventData
      double incidenceRate
    }

    class RandomizedControlledStudy {
      double absoluteRiskDifference
      /**
       * Risk Ratio
       */
      double relativeRisk
    }
  }


}
