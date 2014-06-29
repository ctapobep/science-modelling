package edu.science.biology.pharmacology
/** Defines the movement of drugs in the body */
class PharmacoKinetics {
  def info = "http://www.youtube.com/watch?v=KByV2ExVSZg"
  /** Transfer of drug from site of administration across cell membranes into the bloodstream */
  class Absorption {
    def factorsDefiningRateOfAbsorption = ['route', 'dosage/concentration', 'lipid-solubility']
    class LipidSolubility {
      /**
       * They are going to be absorbed in acidic env because initially they are non-ionized, but when Acid dissociates,
       * it gives away a H+ proton which makes it ionized and thus water-soluble. Thus
       * {@link AntiInflammatoryDrugs.NonNarcoticNsaids.SalicylateFamily#analgin} which is an acid can be absorbed in
       * {@link edu.science.biology.Body.Digestive.Stomach} (which is an acidic env), but hardly in
       * {@link edu.science.biology.Body.Digestive.Intestine.SmallIntestine} (which is basic env). */
      def weakAcidicDrugs = [aka: "AH"]
      /**
       * Absorbed in alkaline envs because initially they are non-ionized and thus lipid soluble, but when they get into
       * acidic env, they accept H+ proton thus becoming ionized (RNH3+) and water soluble. Such drugs are absorbed e.g.
       * in {@link edu.science.biology.Body.Digestive.Intestine.SmallIntestine}, but are useless e.g. in inflamed
       * places where it's acidic.*/
      def weakBasicDrugs = [aka: 'RNH2']
    }
  }
  /**
   * <ul><li>Movement of the drug through the body</li>
   * <li>Sites of actions (Receptor Sites)</li>
   * <li>Inactive sites (Acceptor Sites)</li>
   * </ul> */
  class Distribution {
    /**
     * Many drugs, including most systemic antibiotics, cannot usually cross BBB formed by glial cells surrounding
     * the capillaries of the brain & spinal cord. Drugs that CAN - they need to be very lipid soluble. These drugs
     * accumulate in fat tissue and can return back especially if loosing weight.*/
    class BloodBrainBarrier {}
    /**
     * Drugs can travel from the receptor sites to inactive sites and its action may stop. */
    static class Redistribution {}
  }

  class Metabolism {}
  /**
   * {@link edu.science.biology.Body.Urinary.Kidney} might get rid of the drug itself or of metabolized form of it
   * (e.g. by {@link edu.science.biology.Body.Digestive.Liver}). */
  class Excretion {}
}
