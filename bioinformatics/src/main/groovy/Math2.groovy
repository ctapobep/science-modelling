import java.math.MathContext

class Math2 {
  static BigInteger combinations(int n, int k) {
    assert k <= n
    BigDecimal result = 1
    for (int i = 1; i <= k; i++) {
      result *= ((n + 1 - i) as double) / i
    }
    return result.round(MathContext.DECIMAL32)
  }

  static BigInteger factorial(long n) {
    BigInteger result = 1
    for (int i = 2; i <= n; i++) {
      result *= i
    }
    return result
  }
}
