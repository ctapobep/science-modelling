package edu.science.biology.cardiovascular

class CardioVascularSystem {
    BloodPressure bloodPressure
    Map<Class<BloodVessel>, BloodVessel> bloodVessels = [:]

    BloodVessel getBloodVessel(Class<BloodVessel> type) {
        if (!bloodVessels.containsKey(type)) {
            BloodVessel newVessel = type.newInstance()
            newVessel.cardioVascularSystem = this
            bloodVessels.put(type, newVessel)
        }
        return bloodVessels.get(type)
    }

    static CardioVascularSystem humanCardioVascularSystem() {
        return new CardioVascularSystem(bloodPressure: new BloodPressure(diastolic: 80, systolic: 120))
    }

    static class BloodPressure {
        int diastolic
        int systolic

        int getMeanArterialPressure() {
            return (diastolic * (3 / 2) + systolic * (1 / 2)) / 2
        }
    }
}
