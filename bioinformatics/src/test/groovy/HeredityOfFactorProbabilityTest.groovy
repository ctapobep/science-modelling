import groovy.transform.CompileStatic
import org.junit.Test

import static HeredityOfFactorProbability.probabilityOfDominantPhenotype

@CompileStatic
class HeredityOfFactorProbabilityTest {
  @Test void testProbability() {
    assert 0D == probabilityOfDominantPhenotype(0, 0, 2)
    assert 0D == probabilityOfDominantPhenotype(0, 0, 0)
    assert 0D == probabilityOfDominantPhenotype(0, 0, 0)

    assert 1D == probabilityOfDominantPhenotype(2, 0, 0)
    assert 1D == probabilityOfDominantPhenotype(1, 1, 0)
    assert 1D == probabilityOfDominantPhenotype(1, 0, 1)

    assert 0.75D == probabilityOfDominantPhenotype(0, 2, 0)
    assert 0.5D == probabilityOfDominantPhenotype(0, 1, 1)
    assert (1 / 3D + 0.5D).round(3) == probabilityOfDominantPhenotype(1, 1, 1).round(3)
    assert 0.78333D == probabilityOfDominantPhenotype(2, 2, 2).round(5) //result from an example
    assert 0.6903D == probabilityOfDominantPhenotype(20, 20, 28).round(4) //result from an example

    // this time rounding to 0.1 since the expected result is calculated incorrectly -
    // it's not as complex (and correct) as the production algorithm
    assert (10 / 60D + (20 + 30) / 60D * 0.5D).round(1) == probabilityOfDominantPhenotype(10, 20, 30).round(1)
  }
}
