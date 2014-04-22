package edu.science.biology

import edu.science.biology.cardiovascular.BloodVessel

class WithBlood extends BioObject {
    List<BloodVessel> bloodVessels = []

    public <T extends BloodVessel> T getVessels(Class<T> type) {
        return (T) bloodVessels.find { it.class == type }
    }
}
