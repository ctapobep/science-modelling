import org.junit.Test

class DnaToRnaTest {
  @Test void "must replace all T's with U's"() {
    assert 'GAUGGAACUUGACUACGUAAAUU' == DnaToRna.toRna(DNA)
  }

  static final String DNA = "GATGGAACTTGACTACGTAAATT"
}
