package edu.science.biology

import edu.science.biology.cardiovascular.CardioVascularSystem
import edu.science.biology.urinary.Kidney

class Body {
    CardioVascularSystem cardioVascularSystem
    Kidney kidney

    static Body human() {
        CardioVascularSystem system = CardioVascularSystem.humanCardioVascularSystem()
        Kidney kidney = Kidney.human(system)
        new Body(cardioVascularSystem: system, kidney: kidney)
    }
}
