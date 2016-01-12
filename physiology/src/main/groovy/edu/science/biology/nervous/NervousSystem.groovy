package edu.science.biology.nervous

import edu.science.biology.cardiovascular.Heart
import edu.science.biology.glands.SweatGlands
import edu.science.biology.respiratory.Lung
import edu.science.biology.urinary.Ureter

import static edu.science.biology.Receptors.Adrenergic.*
import static edu.science.biology.Receptors.Muscarinic

class NervousSystem {
  /**
   * <ul>
   *   <li>Increased Heart rate (tachocardia)</li>
   *   <li>Overall vaso-constriction -> Increased blood preassure</li>
   *   <li>Vaso-dilation in coronary arteries and skeletal muscles</li>
   *   <li>Increased intra-ocular pressure</li>
   *   <li>Glycogenesis - blood sugar goes up</li>
   *   <li>Pupils dilation</li>
   *   <li>Lipolysis - breakdown of lipids</li>
   *   <li>Decrease of mucus production (saliva, lungs, nose) e.g. before operation for intubation</li>
   *   <li>Decrease of urinary and digestive tracts activity</li>
   *   <li>Orgasm</li>
   * </ul>
   */
  static class Sympathetic {
    def neurotransmitters = [
        norepinepherine: [
            [
                "${Beta1}" : [Heart],
                "${Beta2}" : [Lung],
                "${Alpha1}": [Ureter]
            ]],
        acetylcholine  : [
            [
                "${Muscarinic}": [SweatGlands]
            ]
        ],

    ]
  }

  class ParaSympathetic {}
}
