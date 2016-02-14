import groovy.transform.CompileStatic

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

  static double offspringWithDominantPhenotype(int AA_AA, int AA_Aa, int AA_aa, int Aa_Aa, int Aa_aa, int aa_aa) {
    int nOfChildren = 2
    List<Map<String, Double>> matrix = [
        [nOfCouples: AA_AA, pOfDominantPheno: 1],
        [nOfCouples: AA_Aa, pOfDominantPheno: 1],
        [nOfCouples: AA_aa, pOfDominantPheno: 1],
        [nOfCouples: Aa_Aa, pOfDominantPheno: 0.75],
        [nOfCouples: Aa_aa, pOfDominantPheno: 0.5],
        [nOfCouples: aa_aa, pOfDominantPheno: 0],
    ]

    double nOfDominantOffspring = 0
    for(Map info: matrix) {
      nOfDominantOffspring += info.nOfCouples * info.pOfDominantPheno * nOfChildren
    }
    return nOfDominantOffspring
  }
}
