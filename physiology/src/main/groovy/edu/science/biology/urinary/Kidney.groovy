package edu.science.biology.urinary

import edu.science.biology.WithBlood
import edu.science.biology.cardiovascular.CardioVascularSystem
import edu.science.biology.urinary.nephron.Nephron

class Kidney extends WithBlood {
    Nephron nephrons
    def cortex
    def medulla

    static Kidney human(CardioVascularSystem cardioVascularSystem) {
        Nephron nephron = Nephron.human(cardioVascularSystem)
        return new Kidney(nephrons: nephron)
    }
}
