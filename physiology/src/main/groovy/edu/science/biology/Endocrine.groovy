package edu.science.biology

class Endocrine {
  /** Water-soluble, short half-life. */
  class PeptideHormone {
    def preProHormone = "initiated in Rough Endoplasmic Reticulum"
    def proHormone = "created from ${preProHormone} when it gets to Golgi"
    def hormone = "is created from ${proHormone} in Golgi and then stored in vesicles until times come"
    def secretionSignal = 'increased Ca, etc'
  }
  /** Derivatives of Cholesterol, lipid-soluble (need a low-affinity carrier), synthesized on-demand.
   * Often are converted to more active species when they are near the target. */
  class SteroidHormones {}

  /**
   * Can be either soluble in plasma (Epinephrine) or lipid-soluble (Tyrosine)
   */
  class AminoAcidDerivatives {}

  /** Extend half-life, make hormones inactive */
  class TransportCarriers {
    def totalConcentrationOfHormone = 'free' + 'bound' //but only free are active
  }

  class Receptors {
    class TyrosineKinaseLinked {}

    class InherentTyrosineKinase {}

    class GProteinCoupled {}

    class LigandGatedIonChannel {}

    class IntracellularNuclearReceptor {}
  }

  class Trasnduction {}
}
