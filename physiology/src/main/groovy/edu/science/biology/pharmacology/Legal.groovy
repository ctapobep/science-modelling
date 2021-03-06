package edu.science.biology.pharmacology

/** http://www.youtube.com/watch?v=4D-gpHluUY8&index=3&list=PLekhl8ZQS2PahYNzzQow72dLyLAXj2dDJ */
class Legal {
  class USA {
    class DrugName {
      def usp = 'United States Pharmocopia - this is a generic name for the drug'
      def registeredName = 'The brand name of the drug'
      def chemicalName = 'the name by IUPAC'
    }

    class Organizations {
      class FDA {
        def name = 'Food & Drug Administration'
        def role = 'Main legal body in USA to control drugs'
        def responsibility = ["Determines whether it requires prescription though the actual Schedule is set by $DEA"]
      }
      def USP = ['United States Pharmacopia': 'determines generic names of drugs']
      def DEA = ['': 'Figures out what drugs can be abused and puts them into Controlled Lists (Schedules)']
    }

    /**
     * Also called Legend. Legend-drug requires a prescription.
     * Expires in 6 months, person prescribing a drug has to have DEA number.
     * ScheduleN - lists of drugs that are controlled by {@link Organizations#DEA}.
     */
    class DrugPrescription {
      class Schedule1 {
        def description = 'illegal, cannot be prescribed at all'
        def examples = ['high potential for dependency and no accepted therapeutic use', 'Heroin, LSD, PCP, Ecstasy']
      }

      class Schedule2 {
        def cases = 'high potential for dependency but has accepted therapeutic use'
        def form = Forms.TamperResistant
        def features = ['requires another prescription for refill', 'no more than for 30 days', 'cannot be phoned or faxed']
        def examples = ['narcotic pain-relievers: morphine, codeine, Demeroi(R)',
                        'stimulants: cocaine, Dexedrine(R), Adderall(R)',
                        'sedatives: pentobarbital (Nembutai(R)), Seconai']
      }

      class Schedule3 {
        def form = Forms.TamperResistant
        def features = ['up to 5 refills every 6 months (if noted on prescription)', 'can be phoned-in or faxed-in']
        def examples = ['narcotic + non-narcotic combinations: Tylenol+Codeine(R); Vicodin(R)', 'anabolic steroids']
      }

      class Schedule4 {
        def form = Forms.RegularForm
        def examples = ['valium-like drugs [Xanan(R)], Ambien(R), Meridia(R)']
      }

      class Schedule5 {
        def description = 'controlled substances with little potential for abuse'
        def form = Forms.RegularForm
        def features = ['no refill limitations']
        def examples = ['Robitussin-AC(R)', 'Lomotil(R)']
      }
      /** http://www.youtube.com/watch?v=4D-gpHluUY8&index=3&list=PLekhl8ZQS2PahYNzzQow72dLyLAXj2dDJ */
      enum Forms {
        RegularForm('DEA number is still required', []),
        TamperResistant('Cannot be photo-copied', ['name of drug & dosage', 'number of pills', 'refill is possible?'])
        def heading = ['doctor info (name, address, phone)', 'patient info (name, address, phone)', 'date of prescription']
        def body = ['aka Rx (recipe)', 'name of drug & dosage', 'dispense: number of pills',
                    """SIG (signa): directions to the patient: "1 tab q(every)4-6h prn" which
                      translates to: 1 tab every 4-6 hours prorenada (as needed). This is printed on the container by pharmaciest"""]
        def closing = ['sign or prescriber (name or DEA number)', 'whether a generic can substitute the brand']

        Forms(description, content) {}
      }
    }
    /** If someone suits you, here is what for.. */
    class CivilActions {
      def misfeasanceTort = 'the action was improperly performed, but was within the practitioner legally defined ' +
        'scope of practice'
      def nonFeasanceTort = 'the action is in scope of the practitioner legally defined functions was indicated by ' +
        'situation but was not performed by the practitioner'
      def malfeasanceTort = 'the action was improperly performed and was not within the legally defined scope of the' +
        'practitioner functions'
    }
  }
}
