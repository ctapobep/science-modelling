package edu.science.biology.chemistry

class Protein {
  /** The way AA join together is by removing OH from one AA and H from another (dehydration synthesis). */
  AminoAcid[] aminoAcids
  /**
   *                   R
   *                   |
   * (amino group) NH2-C-COOH (acid group or carobxylic acid group)
   *                   |
   *                   H
   */
  class AminoAcid {
    class Essential {}

    class NonEssential {}
  }
}
