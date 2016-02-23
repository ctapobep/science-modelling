import org.apache.commons.lang3.RandomUtils
import org.junit.Test

import static Math2.factorial

class Math2Test {
  @Test void testFactorial() {
    assert 1G == factorial(0)
    assert 1G == factorial(1)
    assert 2G == factorial(2)
    assert 6G == factorial(3)
    assert 24G == factorial(4)
  }

  @Test void 'check combination result against a simpler test oracle'() {
    for (int i = 0; i < 20; i++) {
      int n = RandomUtils.nextInt(0, 20)
      int k = RandomUtils.nextInt(0, n + 1)
      assert combinationWithFactorial(n, k) == Math2.combinations(n, k)
    }
  }

  @Test void test() {
    assert combinationWithFactorial(38, 7) == Math2.combinations(38, 7)
  }

  private static BigInteger combinationWithFactorial(int n, int k) {
    return factorial(n) / (factorial(n - k) * factorial(k))
  }
}
