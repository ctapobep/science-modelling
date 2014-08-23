package edu.science.biology.pharmacology

class Antibiotics {
  class Penicillin {
    def penicilin = new Drug(excretion: new PharmacoKinetics.Excretion.Kidney())
  }

  class Cephalosporin {
    def registeredName = ['Keflex', 'Ceclor']
  }
  def tetracycline = [excretion: [PharmacoKinetics.Excretion.Saliva, PharmacoKinetics.Excretion.MotherMilk, 'because it binds to calcium']]
}
