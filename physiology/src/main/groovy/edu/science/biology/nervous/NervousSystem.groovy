package edu.science.biology.nervous

import edu.science.biology.cardiovascular.Heart
import edu.science.biology.glands.SweatGlands
import edu.science.biology.respiratory.Lung
import edu.science.biology.urinary.Ureter

import static edu.science.biology.Receptors.Adrenergic.*
import static edu.science.biology.Receptors.Muscarinic

class NervousSystem {
  class Sympathetic {
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
