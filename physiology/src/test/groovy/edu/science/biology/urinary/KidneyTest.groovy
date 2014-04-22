package edu.science.biology.urinary

import edu.science.biology.Body
import edu.science.biology.urinary.nephron.AfferentArteriole
import org.junit.Test
import spock.lang.Specification

/**
 * MAP - mean arterial pressure
 */
class KidneyTest extends Specification {
    @Test
    def "if MAP is low then Efferent Arteriole should constrict"() {
        given: "normal blood pressure"
        Body.human().cardioVascularSystem.bloodPressure.systolic = systolic
        Body.human().cardioVascularSystem.bloodPressure.diastolic = diastolic

        expect: "efferent arteriole to constrict when MAP is low in order to increase pressure in glomerulus"
        assert Body.human().kidney.nephrons.getVessels(AfferentArteriole).constricted

        where:
        systolic | diastolic
        80       | 120
    }

    def "if MAP is high then Efferent Arteriole should dilate"() {
        expect: "efferent arteriole to dilate when MAP is high in order to decrease pressure in glomerulus"
        where:
        map << [100, 120]
    }

    def "if MAP is abnormal then Kidney will not get enough of blood"() {
        expect: "filtration to drop"
        where:
        map << [79, 121]
    }
}
