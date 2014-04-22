package edu.science.biology.urinary.nephron

import edu.science.biology.Capsule
import edu.science.biology.cardiovascular.CapillaryBed

class GlomerulusCapsule extends Capsule {
    {
        name = "Glomerulus Capsule"
        description = "Filters some contents of blood plasma from ${glomerulus}"
        aliases = ["Bowman's Capsule"]
    }
    CapillaryBed glomerulus = new CapillaryBed()
}
