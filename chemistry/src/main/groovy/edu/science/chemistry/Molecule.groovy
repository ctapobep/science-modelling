package edu.science.chemistry

interface Molecule {
  String formula()

  enum Molecules implements Molecule {
    HCO3('HCO3', ['Bicarbonate']), H2CO3('H2CO3', ['Carbonic Acid']), H2O('H2O', ['Water']), H('H+', ['H Proton']), CO2('CO2', ['']);
    String formula
    List<String> aliases

    Molecules(String formula, List<String> aliases) {
      this.formula = formula
    }

    @Override
    String formula() {
      return formula
    }
  }
}
