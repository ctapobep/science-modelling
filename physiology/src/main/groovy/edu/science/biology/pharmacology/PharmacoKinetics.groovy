package edu.science.biology.pharmacology
/** Defines the movement of drugs in the body */
class PharmacoKinetics {
  def info = "http://www.youtube.com/watch?v=KByV2ExVSZg"
  /** Transfer of drug from site of administration across cell membranes into the bloodstream. */
  class Absorption {
    def factorsImpactingAbsorption = [
      'route'               : 'whether the drug just has to go through the blood vessels or also it should be absorbed in the stomach',
      'dosage/concentration': '', 'lipid-solubility': '']
    /**
     * Drugs have to go through membranes because they are too big to go through the channels and there are rarely
     * transporters that would help them. */
    class LipidSolubility {
      /**
       * They are going to be absorbed in acidic env because initially they are non-ionized, but when Acid dissociates,
       * it gives away a H+ proton which makes it ionized and thus water-soluble. Thus
       * {@link AntiInflammatoryDrugs.NonNarcoticNsaids.SalicylateFamily#analgin} which is an acid can be absorbed in
       * {@link edu.science.biology.Body.Digestive.Stomach} (which is an acidic env), but hardly in
       * {@link edu.science.biology.Body.Digestive.Intestine.SmallIntestine} (which is basic env). */
      def weakAcidicDrugs = [aka: 'HA']
      /**
       * Absorbed in alkaline envs because initially they are non-ionized and thus lipid soluble, but when they get into
       * acidic env, they accept H+ proton thus becoming ionized (RNH3+) and water soluble. Such drugs are absorbed e.g.
       * in {@link edu.science.biology.Body.Digestive.Intestine.SmallIntestine}, but are useless e.g. in inflamed
       * places where it's acidic.*/
      def weakBasicDrugs = [aka: 'RNH2', 'naming': '-ine']
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

  /** Liver changes the drug into a more water-soluble form so that it less able to move across cell membranes.
   * It also facilitates metabolite excretion.
   * Info: http://www.youtube.com/watch?v=9PLhzZCry6g&index=5&list=PLekhl8ZQS2PahYNzzQow72dLyLAXj2dDJ*/
  class Metabolism {
    /** aka phase1 */
    class DestructiveReactions {
      def hydrolysis = ['water is incorporated into a chemical substance, "splitting of molecule"',
                        'associated with enzymes like esterases, dehydrogenases, amidases that hydrolize (split) '
                          + 'aromatic esters, alcohols, ketones']
      def oxidation = ['hydrogen atoms are removed from the molecule ("OIL")',
                       'cytochrome P-450 (a monooxygenase enzyme in liver cells) oxidises many substances including '
                         + 'alcohols, aldehydes & organic acids',
                       [examples: ['methanol -> formaldehyde -> formic acid', 'ethanol -> acetaldehyde -> acetic acid']]
      ]
      def reduction = ['hydrogen atoms are attached to the molecule ("RIG")']
      def deamination = ['nitrogen atoms are removed from organic molecule']
    }
    /** aka phase2. */
    class ConjugatingReactions {
      def examples = ['Transferase enzymes join glucuronic acid (amino acid) to alcohols, organic acids & amines ' +
                        'that makes them water-soluble.']
    }
    def FactorsAffectingMetabolism = ['age (elder and children are slower)', 'liver disease', 'drug tolerance']
    def halfLifeTime = ['the time it takes for the peak level of the drug in the bloodstream to fall by 1/2',
                        [examples: [penicilin    : '1hr', acetaminophen: '3hr', morphine: '4hr', tetracycline: '8hr',
                                    pentobarbital: '30hr', phenobarbital: '80hr', digitoxin: '4d']]]
  }
  /**
   * {@link edu.science.biology.Body.Urinary.Kidney} might get rid of the drug itself or of metabolized form of it
   * (e.g. by {@link edu.science.biology.Body.Digestive.Liver}). */
  static class Excretion {
    /** Glomerular filtration */
    static class Kidney extends Excretion {
      def tubularReabsorption = [
        """essentially all of the water-soluble form of a drug that has entered the renal tubules passes into the urine
        collecting ducts and is excreted in the urine.""",
        """about 1/2 of the lipid-soluble form of a drug that has entered the renal tubules passively diffuses fright
        back into the bloodstream (via the peritubular capillaries), so that only 1/2 of the lipid-soluble form of
        the drug passes into the urine collecting ducts and out into the urine."""]
      def tubularSecretion = ["weak organic acids (all $Antibiotics.Penicillin, $Antibiotics.Cephalosporin)",
                              'weak organic bases']
    }
    /** Gets with bile from the Liver to the Intestine. Such drugs have usually a larger molecular weight.*/
    static class BiliarySecretion extends Excretion {}

    static class Lungs extends Excretion {}

    static class Sweat extends Excretion {}

    static class Saliva extends Excretion {}

    static class MotherMilk extends Exception {}
  }
}
