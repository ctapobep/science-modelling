package edu.science.biology.pharmacology

class Routes {
  def info = "http://www.youtube.com/watch?v=NWJgacb-WAA"
  static class Enteric {
    def advantage = "Doesn't require aseptic processing, bacterias are acceptable"
    static def oral = [
      aka          : "oral, po",
      onsetOfAction: '30 mins',
      advanteges   : ['convenient', 'cheap', 'safe: no one cares about bacterias; takes time thus if error, you have time to vomit'],
      disadvanteges: ['GI irritation', 'takes time', 'you cannot know how much is absorbed', 'inactivation in the liver'],
      dosage       : [
        'tablets',
        'enteric-coated tablets(ecotrin(R) - aspirin for those who take it for long time e.g. while arthritis; children)',
        'time-release capsules',

        'exixir - sweetened hydroalcoholic solution',
        'syrup - saturated sugar solution',
        'emulsion - water & oil solution. For oil-dissolved stuff like steroids']]
    static def sublingual = [
      onsetOfAction: '10 minutes',
      advantages   : ['rapid: goes straight to the blood bypassing liver'],
      disadvanteges: ['not many drugs can dissolve in saliva', 'most of drugs are too bitter'],
      dosage       : ['lozenge', 'troche'],
      examples     : ['Nitro Glycerin which dilates the blood vessels (e.g. when you have Angina Pectoris)']]
    static def rectum = [
      aka          : 'through ass',
      advanteges   : ['can be used with infants because they cannot swallow stuff',
                      'can be used with unconscious', 'can be given to vomiting people',
                      'goes straight to the blood bypassing liver'],
      disadvanteges: ['no idea how much is actually absorbed'],
      dosage       : 'suppository']
  }
  /** Not via IG */
  static class Parenteral {
    def disadvantage = "Require aseptic processing, bacterias are not acceptable"
    static def iv = [
      aka          : 'intravenous',
      onsetOfAction: 'minutes',
      advanteges   : ['quick onset', 'you know exactly how much gets to the blood'],
      disadvanteges: ['dangerous: if the dose is wrong or wrong drug, we are in trouble - first organ is heart']
    ]
    static def im = [
      aka          : 'intramuscular',
      description  : 'Usually a lot of drug is administered and over extended period it gets spread into the blood',
      onsetOfAction: '15 minutes',
      advanteges   : ["some drugs are too irritative to be administered $iv", "it acts for long duration"],
      disadvanteges: ["some stuff can be too irritating"]
    ]
    static def sq = [
      aka          : 'subcutaneous, under the skin',
      onsetOfAction: "minutes",
      advanteges   : "",
      disadvanteges: ["can be irritating", "most allergic route since in dermis there are lots of mast cells"],
      examples     : ["insulin", "tuberculosis test", "allergy tests"]
    ]
    static def intrarterial
    static def intraArticular = [examples: 'injecting Cortico-Steroids into TMJ while operations on mouth']
    static def inhalation = [
      onsetOfAction: 'minutes',
      examples     : ['bronchodilator', 'N20 (nitric oxide)'],
      disadvanteges: ['can be dangerous since after the lungs it goes to heart'],
      dosage       : ['aerosol', 'nebulizer']
    ]
    static def transdermal = [
      aka          : 'skin patches',
      onsetOfAction: '5 mins',
      advanteges   : ['long duration of action'],
      disadvanteges: ['local irritation', 'swelling'],
      examples     : ['nictroglycerin in cases of Angina Pectoris',
                      'estradiol (estragen)',
                      'scopolamine (motion seakness)',
                      'nicotine']
    ]
    static def topical = [
      aka          : 'put right where you want',
      onsetOfAction: 'minutes',
      advanteges   : ['local actions'],
      examples     : [['dermatologic', 'opthalmic', 'nasal', 'dental & throat', 'vaginal'],
                      ['antibiotics', 'antiseptics', "${AntiInflammatoryDrugs}", 'anesthetic']]
    ]
  }
}
