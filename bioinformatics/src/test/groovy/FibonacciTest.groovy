import groovy.transform.CompileStatic
import org.junit.Test

import static io.qala.randomized.Randomize.from

@CompileStatic
class FibonacciTest {
  @Test void 'default fibonacci with 1 pair of rabbits producing 1 pair of rabbits'() {
    assert 8g == Fibonacci.fibonacci(6)
  }
  @Test void 'when rabbits produce more than 1 couple of rabbits'() {
    assert 48127306357829g == Fibonacci.fibonacci(35, 4)
  }

  @Test void 'when rabbits die after M months'() {
    assert 1g == Fibonacci.fibonacciOfDieingRabbits(1, 3)
    assert 1g == Fibonacci.fibonacciOfDieingRabbits(2, 3)
    assert 2g == Fibonacci.fibonacciOfDieingRabbits(3, 3)
    assert 2g == Fibonacci.fibonacciOfDieingRabbits(4, 3)
    assert 3g == Fibonacci.fibonacciOfDieingRabbits(5, 3)
    assert 4g == Fibonacci.fibonacciOfDieingRabbits(6, 3)
  }

  @Test void 'if rabbits life is shorter than n of recurrences, then usual fibonacci must yield different result'() {
    int rabbitsLive = from(0).to(50).integer()
    int recurrences = rabbitsLive + 1
    assert Fibonacci.fibonacci(recurrences) != Fibonacci.fibonacciOfDieingRabbits(recurrences, rabbitsLive)
  }
  @Test void 'if rabbits life is longer than n of recurrences, then usual fibonacci must produce the same result'() {
    int rabbitsLive = from(0).to(100).integer()
    int recurrences = rabbitsLive
    assert Fibonacci.fibonacci(recurrences) == Fibonacci.fibonacciOfDieingRabbits(recurrences, rabbitsLive)
  }

  @Test void 'big number test for dieing rabbits'() {
    assert 12006358557899958370g == Fibonacci.fibonacciOfDieingRabbits(93, 16)
    assert 2880780934725894724g != Fibonacci.fibonacciOfDieingRabbits(100, 20)
  }

}
