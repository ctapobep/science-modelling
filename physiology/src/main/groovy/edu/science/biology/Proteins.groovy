package edu.science.biology

class Proteins {
  class Conventions {
    def kinase = 'means that it (ferment) adds a phosphate to a substance. Process called phosphorylation'
    def mutase = 'changes structure but does not change atoms'
  }
  /** Participates in apoptosis. There are several entities of each family which is needed for redundancy or.. they
   * have a bit different role. */
  class Bcl2Superfamily {
    /** Those that inhibit pro-apoptotic proteins which are called {@link Effectors}. Note, that some viruses make
     * proteins that are similar to guardians to make the cell live longer and not die.
     * All BH[X] domains are present in all guardians which makes them homologous.*/
    static enum Guardians {
      Bcl2, Bcl_xL, BclW, Mcl1, BclB, Bcl2A1;
      static def bh4
      /** Regions of homology which are required to bind to {@link Sensors} */
      static def bh3, bh1, bh2
      /** Hydrophobic tail. All of guardians have them. */
      static def tmDomain
    }
    /** Bind to {@link Effectors} which doesn't allow them inhibit {@link Effectors} thus are pro-apoptotic. They are
     * sensors because they sense outside signals to the cell to die. In some cases they can activate {@link Effectors}
     * directly which is called Direct Activation Model.
     * Most of them have hydrophobic tails {@link Sensors#tmDomain} */
    static enum Sensors {
      bad, bim, bid, bik, hrk, puma, noxa, bmf;
      /** Needed to bind to anti-apoptotic {@link Guardians}. Apart from that they are not homologous (similar) to the superfamily*/
      static def bh3 = [aka: "ligand domain"]
      /** Hydrophobic tail, which is not present in every sensor */
      static def tmDomain
    }
    /** Pro-apoptotic proteins, they are effectively induce apoptosis. */
    static enum Effectors {
      bax, bak, bok;
      /** Hydrophobic tail */
      static def tmDomain
      /** Regions of homology */
      static def bh1, bh2, bh3
    }
  }
}
