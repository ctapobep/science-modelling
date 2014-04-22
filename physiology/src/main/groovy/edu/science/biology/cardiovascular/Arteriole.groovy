package edu.science.biology.cardiovascular

import edu.science.biology.Cell
import edu.science.biology.Constrictive

@Mixin(Constrictive)
class Arteriole extends BloodVessel {
    List<Cell> cells = []
}
