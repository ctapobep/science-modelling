import org.junit.Test

import static Strings.joinOverlap
import static Strings.overlap

class StringsTest {
  @Test void overlaptest() {
    assert 0 == overlap('', '')
    assert 0 == overlap('A', '')
    assert 0 == overlap('', 'B')
    assert 0 == overlap('A', 'B')

    assert 1 == overlap('AB', 'B')
    assert 0 == overlap('B', 'AB')
    assert 0 == overlap(' BA ', 'BA')

    assert 2 == overlap('ABA', 'BAC')
  }

  @Test void joinOverlapTest() {
    assert 'ABAC' == joinOverlap('ABA', 'BAC')
  }
}
