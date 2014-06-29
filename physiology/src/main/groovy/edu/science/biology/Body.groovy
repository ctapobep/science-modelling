package edu.science.biology

import edu.science.biology.cardiovascular.CardioVascularSystem
import edu.science.biology.urinary.Kidney

class Body {
  static class Digestive {
    static class Stomach {}

    static class Intestine {
      static class SmallIntestine {
        static def eleum
      }
    }

    static class Liver {}
  }

  static class Urinary {
    static class Kidney {}
  }
  CardioVascularSystem cardioVascularSystem
  Kidney kidney

  static Body human() {
    CardioVascularSystem system = CardioVascularSystem.humanCardioVascularSystem()
    Kidney kidney = Kidney.human(system)
    new Body(cardioVascularSystem: system, kidney: kidney)
  }
}
