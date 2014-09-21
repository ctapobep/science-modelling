package edu.science.biology.chemistry

/** A repeating CH2 with CH3 in the end. */
class Lipid {
  /** Glycerol with FA attached to each of C-O of the Glycerol. */
  class Glyceride {
    def monoglyceride
    def diglyceride
    def triglyceride
  }
  /** Simply a {@link Glyceride#diglyceride} with a single C of Glycerol to be attached to PO4 */
  class Phospholipid {}
  /** E.g. soap. Works like a glue between lipid and water-soluble part */
  class Emulsifier {
    /** Water can pull this end since it's attracted by water */
    def hidrofilicMolecule = 'e.g. Na'
    /** Fat gets attached to fatty acid side since it's also fatty */
    Lipid fattyAcid
  }
  /**
   * Is taken from the animal food or can be synthesized by liver from saturated FA.
   * It's mostly a Saturated Fat looped in a ring.
   */
  class Cholesterol {}
}
