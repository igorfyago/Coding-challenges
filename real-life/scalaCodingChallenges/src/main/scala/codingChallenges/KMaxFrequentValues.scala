package codingChallenges

object KMaxFrequentValues extends App {

  val listOfStrings = List("A","B","C","C","D","C","B")

  def kMaxFrequentValues(values: List[String], k: Int)= {
    values
      .par
      .groupBy(identity)
      .toList
      .sortBy(-_._2.size)
      .take(k)
      .map(_._1)
  }

  println( kMaxFrequentValues(listOfStrings,2) )

}
