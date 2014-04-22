package edu.science.biology

class BioObject {
  String name
  String description
  List<String> aliases = []
  Map<Channel, String> channels = [:]
  List<String> additionals

  @Override
  public String toString() {
    return name
  }
}
