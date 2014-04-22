package edu.science.biology.urinary.nephron

import edu.science.biology.Cell


class JuxtaGlomerulalCell extends Cell {
    JuxtaGlomerulalCell() {
        this.description = "Change size of the Afferent Arteriole. Also senses signals from Macula Densa and secretes Renin to constricts arteries"
    }

    void secreteRenin() {
        println "Secreting Renin into blood"
    }
}
