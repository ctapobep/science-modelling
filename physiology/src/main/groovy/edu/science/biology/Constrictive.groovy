package edu.science.biology

class Constrictive extends BioObject {
    int constrictionLevel = 5//from 0 to 10
    void constrict() {
        System.out.println("${name} constricted")
    }

    void dilate() {
        System.out.println("${name} dilated")
    }

    boolean isConstricted() {
        return constrictionLevel > 5
    }
}
