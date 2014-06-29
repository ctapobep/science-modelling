package edu.science.biology.pharmacology
/** Defines the movement of drugs in the body */
class PharmacoKinetics {
  /** Transfer of drug from site of administration across cell membranes into the bloodstream */
  class Absorption {
    def factorsDefiningRateOfAbsorption = ['route', 'dosage/concentration', 'lipid-solubility']
    class LipidSolubility {
      /**
       * They are going to be absorbed in acidic env because initially they are non-ionized, but when Acid dissociates,
       * it gives away a H+ proton which makes it ionized and thus water-soluble. Thus
       * {@link AntiInflammatoryDrugs.NonNarcoticNsaids.SalicylateFamily#analgin} which is an acid can be absorbed in
       * {@link edu.science.biology.Body.DigestiveSystem.Stomach} (which is an acidic env), but hardly in
       * {@link edu.science.biology.Body.DigestiveSystem.Intestine.SmallIntestine} (which is basic env). */
      def weakAcidicDrugs = [aka: "AH"]
      /**
       * Absorbed in alkaline envs because initially they are non-ionized and thus lipid soluble, but when they get into
       * acidic env, they accept H+ proton thus becoming ionized (RNH3+) and water soluble. Such drugs are absorbed e.g.
       * in {@link edu.science.biology.Body.DigestiveSystem.Intestine.SmallIntestine}, but are useless e.g. in inflamed
       * places where it's acidic.*/
      def weakBasicDrugs = [aka: 'RNH2']
    }
  }

  class Distribution {}

  class Metabolism {}

  class Excretion {}
}
