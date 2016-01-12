package edu.science.biology.pharmacology

/**
 * @see edu.science.biology.nervous.NervousSystem for receptors, neurotransmitters, etc.
 */
class AutonomicDrugs {
  /**
   * You can either have a drug that
   * <ul>
   *   <li>Imitates a parasympathetic neurotransmitter (cholinergic) then it's a Parasympathomemmic drug.</li>
   *   <li>Blocks sympathetic ({@link edu.science.biology.Receptors.Adrenergic}) receptors</li>
   * </ul>
   */
  static class ParasympatheticAgonists {
    def contraIndications = ['obstruction of GI tract -> rapture of intestine', 'obstruction of urinary tract']
    def cautions = ['ulcers', 'bronchial asthma', 'heart problems']
    def integrationWithOtherDrugs = [
        increaseActivity: 'cholinergic drugs',
        decreaseActivity: 'anti-cholinergic drugs'
    ]
    def indications = [
        glaukoma: 'Decrease intra-ocular pressure - should be taken topically (eye drops)'
    ]
  }
  /**
   * <ul>
   *   <li>Muscarinic Cholinergic Blockers</li>
   *   <li></li>
   * </ul>
   */
  static class ParasympatheticAntagonists {
    def indications = [
        'dry out air passage'                : 'before the surgery to intubate',
        'dilate pupils'                      : 'before eye examination',
        'increase heart rate'                : 'to treat bradycardia',
        'inhibit emptying of urinary bladder': 'treat of urinary incontinence, enuresis, urinary spasms',
        'inhibit GI motility & secretion'    : 'ulcers, GI spasms, irritable bowel syndrome, ulcerative colitis, infant colic',
        'CNS depression'                     : 'sedation'
    ]
    /**
     * Mechanism of action
     * Atropine causes reversible blockade of cholinomimetic actions at muscarinic receptors. Atropine
     * has high affinity for muscarinic receptors and it is not selective on muscarinic receptors (does not
     * distinguish between subgroups of muscarinic receptors).
     * This mechanism explains the use as antidote in organophosphate intoxication or
     * muscarine intoxication.
     * This mechanism explains the use in small doses as adjuncts to treatment of myasthenia
     * gravis.
     */
    static def Atropine
  }
}
