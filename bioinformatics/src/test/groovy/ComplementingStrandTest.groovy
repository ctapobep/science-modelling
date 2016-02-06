import org.junit.Test

class ComplementingStrandTest {
  @Test void 'complementary string must be reversed and have correct pairs'() {
    assert 'ACCGGGTTTT' == ComplementingStrand.complementDna('AAAACCCGGT')
  }
}
