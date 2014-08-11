package edu.science.biology.pharmacology

import static edu.science.biology.pharmacology.Routes.Enteric.getOral
import static edu.science.biology.pharmacology.Routes.Parenteral.*

class AntiInflammatoryDrugs {
  static class NonNarcoticNsaids {
    def name = "Non Steroid Anti-Inflammatory Drugs"
    def description = "Blocks the COX enzyme in order to stop production of Prostoglandins"
    def explanation = "http://www.youtube.com/watch?v=EtbAvz-h2X8"
    def principles = ['Analgesics are more effective if given before pain built up to a high level',
                      'CNS Depression if the dose is big enough: sedation > hypnosis > respiratory depression > unconsciousness > general anesthesia > coma > death']
    static class SalicylateFamily {
      static def analgin = [
        compound     : "Acetylsalicytic acid",
        effect       : "Gets you free from fever, inflammation, pain, reduces blood clotting",
        adverseEffect: "Irritates GI tract"]
      static def iboprofin = "Very similar to aspirin"
    }

    class ParAminoPhenols {
      def description = 'Not much difference in pain relief comparing to Salicylate Family, but side effects are different'
      def paracetomol = [aka          : ["tylenol(R)", "acetaminophen", "APAP"],
                         chemistry    : "N-acetly-para-aminophenol",
                         effect       : ["Blocks the synthesis of prostaglandins centrally (but not peripherally).",
                                         "Pain reliever, decreases fever",
                                         "doesn't reduce blood clotting"],
                         adventages   : ["not that allergic as aspirin"],
                         disadvanteges: "less anti-inflammatory effect than with aspirin",
                         adverseEffect: ["Is bad for liver", "can be a problem for diabetics"]]
    }

    class Excedrin {
      def effect = "Analgin+Paracetomol. Thus contains the same amount of pain relief, but hurts liver/GI less."
    }

    class Cox2Nsaids {
      def description = 'cause less GI irritation'
      def allopurinol = [conditions: ['gouty arthritis (uric acid in joints)', 'kidney stones']]
      def methotrexate = [
        conditions   : ['rheumatoid arthritis'],
        adverseEffect: ['ulcerative stomatitis', 'gingivitis']
      ]
    }
  }

  class NarcoticAids {
    def explanation = 'http://www.youtube.com/watch?v=2-L6FDvD2Zs'
    def prototype = 'Morphine - mostly inhibitory - slows down processes'
    def activities = ['act like antagonist to endorphin receptor sites especially in (ventromedial) Thalamus & Limbic System',
                      'produces sedation (dizziness), lethargy, muscle relaxation, amnesia, general sense of well-being',
                      'pupillary constriction (miotic effect)', 'see adverse effects as well']
    def clinicalUsage = ['analgesic for severe pain', 'used on patients with terminal cancer, biliary colic, MI, ' +
      'gangrene, burns, fractures, post-surgical trauma & obstetrical analgesia']
    def pharmacokinetics = [absorption: "$iv, $im, $sq", metabolism: 'action terminated by liver, half-life: 3hrs']
    def adverseReactions = [
      toxicReactions         : [
        'depress cough reflex center in Medulla Oblongata (anti-tussive effect)',
        'stimulates Vomiting Reflex Center in the Medulla Oblongata (emetic effect)',
        'smooth muscle spasm (spasmogenic effect): decreases GI motility (constipation), biliary tract spasm, urinary retention',
        'mental clouding (hard to think)',
        'stimulates histamine release from mast cells which causes bronchoconstriction & generalized edema'],
      phisicalDependency     : ['morphine is Schedule II Controlled Substance'],
      psychologicalDependency: [],
      drugTolerance          : [
        'decreased effect with repeated use due to cellular and biochemical adaption',
        'cross-tolerance of Narcotic Analgesics']]
    def cautionsAndContraindications = ['respiratory disease', 'gallbladder disease', 'severe CNS depression',
                                        'history of drug dependency', 'epilepsy', 'diabetes', 'pregnancy',
                                        'patients receiving antipsychotic drugs',
                                        'patients receiving sedative-hypnotics or alcohol (both make you sleepy and will put you into coma)']
    def dosagesAndPreparations = []
    class OpiumAlkaloids {
      def description = 'Obtained from opium poppy seeds (Papaver Somniferum)'
      class Morphine {}

      class Codeine {
        def aka = 'Methylmorphine'
        def description = '1/6 as potent as Morphine, it causes everything less than morphine (except constipation)'
      }

      class Heroin {
        def aka = 'Diacetylmorphine'
        def cookbook = 'take morphine and add vinegar'
        def description = '3 times as potent as morphine, very high physical dependency'
        def legal = 'not legal in USA, legal in Canada'
      }
    }


    class OpiumSynthetics {
      def description = 'men-made, not from the opium poppy'
    }

    class OpioidSemiSynthetics {
      def cookbook = 'created from opium poppy but modified'
      class Oxycodone {
        def description = "similar to $OpiumAlkaloids.Morphine in potency & duration"
        def route = "$oral"
        def legal = 'Schedule II Controlled substances'
        def others = ['less histaminic']
      }
      /** 1/2 potent as morphine, 3x potent as {@link OpiumAlkaloids.Codeine} */
      class Hydrocodone {
        class Meperedine {}

        class Methadone {}

        class FentanylCitrate {}

        class Tramadol {}
      }
    }

    class OpiateAntagonists {
      def description = 'in case there is an overdose of narcotic pain reliever'
      class Nalaxone {}

      class Naltrexone {}
    }
  }
}
