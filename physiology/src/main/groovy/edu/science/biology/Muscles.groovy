package edu.science.biology

class Muscles {
  class GlucoseUptake{
    def supply = ['perfusion', 'blood glucose concentration']
    def transport = ['GLUT abundance', 'glucose gradient', 'GLUT activity']
    def intraCellularMetabolism = ['Hexokinase activity', 'Substrate flux']

    def insulin = 'does not impact glucose uptake during exercise since there is a different mechanism for contracting muscle'
  }
  class Fuel {
    class Glycogen {
      def glucose = "pure fuel, is broke down into $paryvateAcid within the cell cytoplasm"
      def glycogen = "stored in muscles, can be transformed into $glucose"

      def paryvateAcid = "either is oxydised inside of ${Cell.mitochondria} or is transformed into lactic acid"

      def upRegulation = ["Ca", "Pi", 'Adrenaline', 'availability of glycogen', 'high temperature']
      def downRegulation = ['free fatty acids in blood', 'time']
    }
  }
}
