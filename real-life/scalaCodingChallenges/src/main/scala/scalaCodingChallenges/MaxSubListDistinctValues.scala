package scalaCodingChallenges

object MaxSubListDistinctValues extends App {
  // TODO: Return the Max() number of Distinct() values, among the rolling consecutive subList-s of size M,
  //  example_01: List(1, 1, 3, 3, 5, 3), N=6, M=3 -> 2
  //  example_02: List("A", "A", "C", "C", "E", "C"), N=6, M=3 -> 2

  val values = List("A", "A", "C", "C", "E", "C")
  val n = values.size
  val m = 3

  println (maxSubListDistinctValues(values, n, m))

  private def maxSubListDistinctValues[T](values: List[T], n: Int, m: Int) = ???

}


//return IntStream.rangeClosed(0, n - m)
//.parallel()
//.mapToObj(i -> values.subList(i, i + m)
//.stream()
//.distinct()
//.count()
//)
//.reduce(Long::max)
//.orElse(0L);