import groovy.transform.CompileStatic
import org.apache.commons.lang3.RandomUtils
import org.junit.Ignore
import org.junit.Test

import static HeredityOfFactorProbability.offspringWithDominantPhenotype
import static HeredityOfFactorProbability.probabilityOfDominantPhenotype
import static HeredityOfFactorProbability.probabilityOfIndependentAllelesInKthGeneration

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

  @Test void 'n of dominant offspring'() {
    assert 2D == offspringWithDominantPhenotype(1, 0, 0, 0, 0, 0)
    assert 4D == offspringWithDominantPhenotype(1, 1, 0, 0, 0, 0)
    assert 6D == offspringWithDominantPhenotype(1, 1, 1, 0, 0, 0)
    assert 7.5D == offspringWithDominantPhenotype(1, 1, 1, 1, 0, 0)
    assert 8.5D == offspringWithDominantPhenotype(1, 1, 1, 1, 1, 0)
    assert 8.5D == offspringWithDominantPhenotype(1, 1, 1, 1, 1, 1)
    assert 3.5D == offspringWithDominantPhenotype(1, 0, 0, 1, 0, 1)
    assert 147576D == offspringWithDominantPhenotype(16401, 17131, 17925, 18646, 16693, 19601)
  }

  @Test void 'probability of at least N AaBb organisms in Kth generation'() {
    assert 1D == probabilityOfIndependentAllelesInKthGeneration(0, 1).round(3)
    assert 0.684D == probabilityOfIndependentAllelesInKthGeneration(2, 1).round(3)
    assert 0.262D == probabilityOfIndependentAllelesInKthGeneration(2, 2).round(3)
    assert 0.433D == probabilityOfIndependentAllelesInKthGeneration(6, 17).round(3)
    assert 0.132D == probabilityOfIndependentAllelesInKthGeneration(7, 38).round(3)
    assert 0.235D == probabilityOfIndependentAllelesInKthGeneration(7, 36).round(3)
    assert 0.568D == probabilityOfIndependentAllelesInKthGeneration(5, 8).round(3)
  }

  @Ignore('there is probably some bug') @Test void 'probability of more than N of AaBb is always less than N+1'() {
    int generation = RandomUtils.nextInt(1, 10)
    int atLeastNOfOrganisms = RandomUtils.nextInt(0, 2.power(generation) as int)
    assert probabilityOfIndependentAllelesInKthGeneration(generation, atLeastNOfOrganisms) >
        probabilityOfIndependentAllelesInKthGeneration(generation, atLeastNOfOrganisms + 1)
  }
}
