package edu.science.biology.pharmacology

class AntiInflammatoryDrugs {
  public static class NonNarcoticNsaids {
    def name = "Non Steroid Anti-Inflammatory Drugs"
    def description = "Blocks the COX enzyme in order to stop production of Prostoglandins"
    def explanation = "http://www.youtube.com/watch?v=EtbAvz-h2X8"
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
      def description = "cause less GI irritation"
      def allopurinol = [conditions: ["gouty arthritis (uric acid in joints)", 'kidney stones']]
      def methotrexate = [
        conditions   : ['rheumatoid arthritis'],
        adverseEffect: ['ulcerative stomatitis', 'gingivitis']
      ]
    }
  }
}
