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
    ParaAminoPhenols: [
      description               : 'Not much difference in pain relief comparing to Salicylate Family, but side effects are different',
      ["paracetomol", "tylenol"]: [
        aka: "acetaminophen or APAP",
        effect       : "Pain reliever, but doesn't reduce blood clotting or inflammation",
        adverseEffect: "Is bad for liver"]],
    Excedrin        : [
      effect: "Analgin+Paracetomol. Thus contains the same amount of pain relief, but hurts liver/GI less."
    ]
  ]
}
