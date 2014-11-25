package edu.science.biology

class Cell {
  def channels
  def static mitochondria

  class Respiration {
    /**
     * Occurs in cytosol, starts with Glucose, ends with 2 Pyruvates, Works in Anaerobic
     */
    class Glycolysis {
      def location = 'cytosol'
      def reactant = ['Glucose (c6o6h12)', '2x ATP']
      def product = ['4x ATP', '2x Pyruvate', '2x NADH+', '2x H2O']

      def step1 = [enzyme  : 'hexokinase', descr: 'adds a phosphate from ATP (making it ADP) to Glucose',
                   reactant: ['Glucose', 'ATP'], product: ['Glucose-6-Phosphate', 'ADP']]
      def step2 = [enzyme : 'Phosphoglucose Isomeraze', descr: 'Changes configuration of Glucose-6-Phosphate',
                   product: 'Fructose-6-Phosphate']
      def step3 = [enzyme : 'Phosphofructokinze', descr: 'Adds a phosphate from ATP to 1st C of Fructose-6-Phosphate',
                   product: 'Fructose-1,6-bisphosphate']
      def step4 = [enzyme                          : 'Aldolase', descr: 'One of reactions that controls how much glycolysis occur',
                   inCaseThereIsTooMuchOfGlycolysis: [descr: 'a break in glycolysis', product: 'dihydroxyacetone phosphate (DHAP)'],
                   inCaseThereIsEnoughGlycolysis   : [product: 'glyceraldehyde 3-phosphate (GAP)']]
      def step5 = [enzyme  : 'Glyceraldehyde phosphate dehydrogenase', descr: 'Moves H ions, happens only if previous step decided to continue',
                   reactant: 'NAD+Pi', product: ['HADH+H+', '1,3-bisphosphoglycerate (1,3-BPG)']]
      def step6 = [enzyme  : 'Phosphoglycerate Kinase', descr: 'Creates energy by grabbing Pi from previous step and attaching it to ADP',
                   reactant: 'ADP', product: ['2x 3-Phosphoglycerate']]
      def step7 = [enzyme: 'Phosphoglyceromutase', descr: 'Changes around molecules', product: '2-Phosphoglycerate']
      def step8 = [enzyme: 'Enolase', product: ['Phosphoenolpyruvate', 'H20']]
      def step9 = [enzyme: 'Pyruvate Kinase', reactant: ['ADP', 'Prev step'], product: ['ATP', '2x Pyruvate']]
    }
    /**
     * Happens only if not enough O is available and it's not possible to break Pyruvate further in aerobic part
     * of respiration.
     */
    class Fermentation {
      def info = 'http://www.youtube.com/watch?v=7WQrDf9k1uM'
    }
    class PyruvateOxidativeDecarboxylation {
      def info = 'http://www.youtube.com/watch?v=8XpWLbCaZZ8&index=2&list=PLmgk09Oa38oo_p7DmMeeiGB85v4MHH6gZ'
      def location = 'Mitachondrial Matrix'
      def reactant = ['Pyruvate', 'CoA', 'NAD']
      def product = ['Acetyl CoA', 'NADH2']
      def enzyme = 'Pyruvate Dehydrogenase Complex'
    }
  }
}
