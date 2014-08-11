package edu.science.biology

import spock.lang.Specification

class MusclesTest extends Specification {
  def 'with large intensity of exercise the lactate production should increase'(){
    given: 'intensity of exercise is high'
    when: 'rate of pyruvate creation gets higher than rate of pyruvate oxidation in mitochondria'
    then: 'more pyruvate gets converged to lactate'
  }
}
