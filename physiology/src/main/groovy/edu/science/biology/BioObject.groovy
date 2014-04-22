package edu.science.biology

class BioObject {
    String name
    String description
    List<String> aliases = []

    @Override
    public String toString() {
        return name
    }
}
