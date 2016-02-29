import org.junit.Test

class LexicographicalOrderTest {
  @Test void 'lexi order'() {
    assert ['a', 'b'] == LexicographicalOrder.order('ab', 1)
    assert ['aa'] == LexicographicalOrder.order('a', 2)
    assert ['aa', 'ab', 'ba', 'bb'] == LexicographicalOrder.order('ab', 2)
    assert ['TT', 'TA', 'TG', 'TC', 'AT', 'AA', 'AG', 'AC', 'GT', 'GA', 'GG', 'GC', 'CT', 'CA', 'CG', 'CC'] ==
        LexicographicalOrder.order('TAGC', 2)
    assert ['TT', 'TA', 'TG', 'TC', 'AT', 'AA', 'AG', 'AC', 'GT', 'GA', 'GG', 'GC', 'CT', 'CA', 'CG', 'CC'] ==
        LexicographicalOrder.order('IHJYL', 4)
  }
}
