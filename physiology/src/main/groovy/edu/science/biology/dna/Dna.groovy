package edu.science.biology.dna

class Dna {
  static class Chromosome {
    static class Gene {
      def enhancer
      /** Protein that can bind to a part of DNA to promote or inhibit transcription */
      static class TranscriptionFactor {
        /** DNA Binding Domain: A part or several parts that bond to specific sequence of {@link Dna} */
        def DBD
      }
    }
  }
}
