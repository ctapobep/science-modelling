package edu.science.biology.urinary.nephron

import edu.science.biology.WithBlood
import edu.science.biology.cardiovascular.CardioVascularSystem

class Nephron extends WithBlood {
    GlomerulusCapsule glomerulusCapsule = new GlomerulusCapsule()

    static Nephron human(CardioVascularSystem cardioVascularSystem) {
        return new Nephron(bloodVessels: [
                cardioVascularSystem.getBloodVessel(AfferentArteriole),
                cardioVascularSystem.getBloodVessel(EfferentArteriole)])
    }
    def proximalConvolutedTubule = [
            "Changes of liquid inside of the tubule is isoosmotic",
            "Na/K ATPase: 3 Na to blood for 2 K from the blood to the tubule",
            "uses 2nd active transport (via Na) for co-transport of solutes like Glucose and Amino Acids",
            "water follows Na to enter the blood",
            "HCO3 is impermeable. HCO3 + H+ => H2O + CO2 in the lumen in presence of carbonic anhydrase (c.a). " +
                    "Then H2O + CO2 => H+ + HCO3 in PCT cells where HCO3 gets into blood and H+ back into the lumen (in exchange for Na)"
    ]
    def nephronLoop = [
            thinLoop          : [
                    H2O : "can move across (and it does a lot)",
                    ions: "cannot move across the membrane",
                    ADH : "which is secreted by Pituitary can increase the number of aquaporin channels",
                    RAAS: "${maculaDensa} activates ${afferentArteriole.juxtaGlomerulalCells} which secrete Renin because of which " +
                            "Angitensin is generated and by ACE is converted into ANGI2. ANGI2 asks P. Pituitary to secrete " +
                            "ADH which adds aquaporin channels in tubules. ANGI2 also asks aldosterone to be secreted which makes Na to move into the blood from ducts"
            ],
            thickAscendingLoop: [
                    H20: "cannot move across the membrane",
                    Na : "moves into the blood from the tubule",
                    K  : "moves into the blood from the tubule",
                    Cl : "moves into the blood from the tubule"
            ],
            bottomOfLoop      : [
                    concentrationOfIons: "very high because they were taken from thick loop",
                    oncoticPressure    : "is normal because there is urea"
            ]
    ]
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
}
