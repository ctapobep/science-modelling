package edu.science.chemistry

interface Molecule {
    String formula()

    enum Molecules implements Molecule {
        BICARBONATE("H2CO3"), WATER("H20");
        String formula

        Molecules(String formula) {
            this.formula = formula
        }

        @Override
        String formula() {
            return formula
        }
    }
}
