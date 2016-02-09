import groovy.transform.CompileStatic

@CompileStatic
class HeredityOfFactorProbability {
  static final double HETEROZYGOUS_RECESSIVE_PROBAB = 0.25, HETERO_AND_HOMORECESSIVE_PROBAB_OF_RECESSIVE_OFFSPRING = 0.5

  static double probabilityOfDominantPhenotype(int dominantHomozygousOrganism,
                                               int dominantHeterozygousOrganism, int recessiveHomozygousOrganism) {
    double total = dominantHeterozygousOrganism + dominantHomozygousOrganism + recessiveHomozygousOrganism
    double totalAfterFirstSample = total - 1
    if(total < 2) return 0

    double twoHeterozygousProbab = (dominantHeterozygousOrganism / total) * ((dominantHeterozygousOrganism - 1) / totalAfterFirstSample)
    double twoRecessiveHomozygousProbab = (recessiveHomozygousOrganism / total) * ((recessiveHomozygousOrganism - 1) / totalAfterFirstSample)
    double heterozygousAndRecessiveProbab =
        (dominantHeterozygousOrganism / total) * (recessiveHomozygousOrganism / totalAfterFirstSample) +
            (recessiveHomozygousOrganism / total) * (dominantHeterozygousOrganism / totalAfterFirstSample)
    double recessivePhenoProbab = twoRecessiveHomozygousProbab +
        twoHeterozygousProbab * HETEROZYGOUS_RECESSIVE_PROBAB +
        heterozygousAndRecessiveProbab * HETERO_AND_HOMORECESSIVE_PROBAB_OF_RECESSIVE_OFFSPRING
    return 1 - recessivePhenoProbab
  }
}
