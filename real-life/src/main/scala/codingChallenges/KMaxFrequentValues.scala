package codingChallenges

object KMaxFrequentValues extends App {

  val listOfStrings = List("a","b","b","c","z","z","b")

  def kMaxFrequentValues(values: List[String], k: Int)= {
    values
      .par
      .groupBy(identity)
      .map(c => (c._1, c._2.length))
      .toList
      .sortBy(c => -c._2)
      .take(k)
      .map(m => m._1)
  }

  println( kMaxFrequentValues(listOfStrings,2) )

}