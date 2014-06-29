package edu.science.biology

import edu.science.biology.cardiovascular.CardioVascularSystem
import edu.science.biology.urinary.Kidney

class Body {
  static class DigestiveSystem {
    static class Stomach{}
    static class Intestine {
      static class SmallIntestine{
        static def eleum
      }
    }
  }
  CardioVascularSystem cardioVascularSystem
  Kidney kidney

  static Body human() {
    CardioVascularSystem system = CardioVascularSystem.humanCardioVascularSystem()
    Kidney kidney = Kidney.human(system)
    new Body(cardioVascularSystem: system, kidney: kidney)
  }
}
