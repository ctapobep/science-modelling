package edu.science.biology.pharmacology

class AntiInflammatoryDrugs {
  def nonNarcoticNsaids = [
    name            : "Non Steroid Anti-Inflammatory Drugs",
    description     : "Blocks the COX enzyme in order to stop production of Prostoglandins",
    explanation     : "http://www.youtube.com/watch?v=EtbAvz-h2X8",
    SalicylateFamily: [
      analgin  : [
        compound     : "Acetylsalicytic acid",
        effect       : "Gets you free from fever, inflammation, pain, reduces blood clotting",
        adverseEffect: "Irritates GI tract"],
      iboprofin: "Very similar to aspirin"],
    ParAminoPhenols : [
      description                                   : 'Not much difference in pain relief comparing to Salicylate Family, but side effects are different',
      ["paracetomol", "tylenol(R)", "acetaminophen"]: [
        aka          : "APAP",
        chemistry    : "N-acetly-para-aminophenol",
        effect       : ["Blocks the synthesis of prostaglandins centrally (but not peripherally).",
                        "Pain reliever, decreases fever",
                        "doesn't reduce blood clotting"],
        adventages   : ["not that allergic as aspirin"],
        disadvanteges: "less anti-inflammatory effect than with aspirin",
        adverseEffect: ["Is bad for liver", "can be a problem for diabetics"]]],
    Excedrin        : [
      effect: "Analgin+Paracetomol. Thus contains the same amount of pain relief, but hurts liver/GI less."
    ],
    cox2nsaids      : [
      description : "cause less GI irritation",
      allopurinol : [
        conditions: ["gouty arthritis (uric acid in joints)", 'kidney stones']
      ],
      methotrexate: [
        conditions   : ['rheumatoid arthritis'],
        adverseEffect: ['ulcerative stomatitis', 'gingivitis']
      ]
    ]
  ]
}
