package edu.science.biology

class Drugs {
  def antiInflammatory = [
    nsaid: [
      name                      : "Non Steroid Anti-Inflammatory Drugs",
      description               : "Blocks the COX enzyme in order to stop production of Prostoglandins",
      ["analgin", "iboprofin"]  : [
        effect       : "Gets you free from fever, inflammation, pain, reduces blood clotting",
        adverseEffect: "Irritates GI tract"],
      ["paracetomol", "tylenol"]: [
        effect           : "Pain reliever, but doesn't reduce blood clotting or inflammation",
        adverseEffect    : "Is bad for liver"],
      "Excedrin": [
        effect: "Analgin+Paracetomol. Thus contains the same amount of pain relief, but hurts liver/GI less."
      ]
    ]
  ]
}
