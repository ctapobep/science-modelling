package edu.science.biology

import edu.science.biology.cardiovascular.CapillaryBed
import edu.science.biology.cardiovascular.CardioVascularSystem

import static edu.science.biology.Channel.Antiporter.Na_K_ATPase
import static edu.science.biology.Channel.CoTransporter.Na_Amino
import static edu.science.biology.Channel.CoTransporter.Na_Glucose
import static edu.science.chemistry.Molecule.Molecules.*

@SuppressWarnings("GroovyUnusedDeclaration")
class Body {
  static class Fluid {
    def partOfTotalBodyMass = 0.6
    /** More K+ */
    class IntraCellularFluid {
      def partOfTotalBodyWater = 2 / 3
    }
    /** More Na+ */
    class ExtraCellularFluid {
      def partOfTotalBodyWater = 1 / 3
      class InterstitialFluid {
        def partOfEcf = 3 / 4
      }

      class IntraVascularFluid {
        def partOfEcf = 1 / 4
      }

      class CerebroSpinalFluid {}
    }
  }
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
    static class Kidney {
      static class Nephron {
        def cortex
        def medulla
        def glomerulus = new CapillaryBed()
        def glomerulusCapsule = new Capsule(name: "Glomerulus Capsule",
          description: "Filters some contents of blood plasma from ${glomerulus}", aliases: ["Bowman's Capsule"])
        def afferentArteriole = [name       : "Kidney Afferent Arteriole",
                                 description: "Delivers blood to Nephron Glomerulus", cells: [new JuxtaGlomerulalCell()]]
        def efferentArteriole = [name       : "Kidney Efferent Arteriole",
                                 description: "Drains blood from Nephron Glomerulus and delivers it to Nephron Loop"]
        def proximalConvolutedTubule = [name       : "Proximal Convoluted Tubule", aliases: ["PCT"],
                                        description: "Changes of liquid inside of the tubule is isoosmotic",
                                        channels   : [
                                          (Na_K_ATPase): "3 Na to blood for 2 K from the blood to the tubule. " +
                                            "Water follows Na to enter the blood so the more Na leaves, the more water leaves",
                                          (Na_Glucose) : "2nd active transport: Glucose penetrates tubule cells along with Na via the co-transporter. " +
                                            "Afterwards Glu gets out of the cell into the blood via..",
                                          (Na_Amino)   : "2nd active transport: Amino acids penetrate tubule cells along with Na via the co-transporter." +
                                            " Afterwards AA gets out of the cell into the blood via.."],
                                        additionals: ["${HCO3} is impermeable, therefore first converting it: ${HCO3} + ${H} => ${H2O} + ${CO2} in the " +
                                                        "lumen in presense of carbonic anhydrase (c.a.). This stuff gets into PCT cells and then " +
                                                        "${H2O} + ${CO2} => ${H} + ${HCO3} and ${H} proton returns back into urine in exchange for Na"]]
        def nephronLoop = [
          thinLoop          : [
            H2O : "can move across (and it does a lot)",
            ions: "cannot move across the membrane",
            ADH : "which is secreted by Pituitary can increase the number of aquaporin channels",
            RAAS: "${maculaDensa} activates ${JuxtaGlomerulalCell}s which secrete Renin because of which " +
              "Angitensin is generated and by ACE is converted into ANGI2. ANGI2 asks P. Pituitary to secrete " +
              "ADH which adds aquaporin channels in tubules. ANGI2 also asks aldosterone to be secreted which makes Na to move into the blood from ducts"],
          thickAscendingLoop: [
            H20: "cannot move across the membrane",
            Na : "moves into the blood from the tubule",
            K  : "moves into the blood from the tubule",
            Cl : "moves into the blood from the tubule"],
          bottomOfLoop      : [
            concentrationOfIons: "very high because they were taken from thick loop",
            oncoticPressure    : "is normal because there is urea"]]
        def distalConvolutedTubule = [
          "organic compounds (epinephrine, toxins, waste, morphine) can go from blood to the tubule"
        ]
        def collectingDuct = [
          principalCells: "reabsorb Na and secrete K into the tubule. K secretion is increased with [Na] in the tubule. Can be catalyzed with greater flow.",
          aldosterone   : "increases Na/K channels and therefore more K can be secreted and Na reabsorbed",
          H20           : "follows Na and therefore can is reabsorbed when aldosterone is in the blood"
        ]
        /**
         * Senses
         * - the flow in the nephron tubule
         * - the [Na] in the nephron tubule
         */
        def maculaDensa

        class JuxtaGlomerulalCell {
          def description = "Change size of the Afferent Arteriole. Also senses signals from Macula Densa and secretes Renin to constricts arteries"

          void secreteRenin() {
            println "Secreting Renin into blood"
          }
        }

      }
    }
  }
  CardioVascularSystem cardioVascularSystem
}
