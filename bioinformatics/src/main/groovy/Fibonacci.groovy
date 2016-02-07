import groovy.transform.CompileStatic

@CompileStatic
class Fibonacci {

  static BigInteger fibonacci(int recurrences, int nOfRabbitsPerOccurrence = 1) {
    if (recurrences < 1) {
      return 0
    }
    BigInteger grownRabbits = 0
    BigInteger overallRabbits = 1//this is the 1st iteration, so the loop starts with 1
    for (int i = 1; i < recurrences; i++) {
      BigInteger tmpOverallRabbits = overallRabbits
      overallRabbits += grownRabbits * nOfRabbitsPerOccurrence
      grownRabbits = tmpOverallRabbits
    }
    return overallRabbits
  }

  static BigInteger fibonacciOfDieingRabbits(int recurrences, int nOfMonthsRabbitsLive = 100) {
    if (recurrences < 1) {
      return 0
    }
    BigInteger grownRabbits = 0
    BigInteger overallRabbits = 1//this is the 1st iteration, so the loop starts with 1
    Queue<Long> rabbitsBornDuringPrevMonths = new LinkedList<>([1L])
    for (int i = 1; i < recurrences; i++) {
      if(rabbitsBornDuringPrevMonths.size() >= nOfMonthsRabbitsLive) {
        BigInteger nOfRabbitsMustDie = rabbitsBornDuringPrevMonths.poll()
        overallRabbits -= nOfRabbitsMustDie
      }
      BigInteger prevOverallRabbits = overallRabbits
      overallRabbits += grownRabbits
      grownRabbits = prevOverallRabbits
      rabbitsBornDuringPrevMonths.add(overallRabbits - grownRabbits)//newborn rabbits
    }
    return overallRabbits
  }
}
