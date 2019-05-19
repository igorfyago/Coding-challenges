package scalaCodingChallenges

import scalaCodingChallenges.Utils._
import scalaCodingChallenges.KMaxFrequentChallenge._
import scalaCodingChallenges.KMaxFrequentSolution._

// ToDo: Return the k most frequent values from a list

object KMaxFrequent extends App {
  examples.example map function foreach println
}

object KMaxFrequentChallenge {

  val examples = Examples(List(
      Example(data = List(3, 5, 1, 4, 1, 2, 1, 4, 4, 1, 0, 5),  k = 3) // => 1, 4, 5
    , Example(data = List("A", "B", "C", "C", "D", "C", "B"),   k = 2) // => C, B
    , Example(data = List("A", 3, 3, 3, "D", "C", "B"),         k = 4) // => 3, A, B, C
  ))
}

object KMaxFrequentSolution {
  val function: Example => String = example =>
    example.data.par
      .groupBy(i => i)
      .to.sortBy(-_._2.size)
      .take(example.k)
      .map(_._1)
      .mkString(", ")
}
