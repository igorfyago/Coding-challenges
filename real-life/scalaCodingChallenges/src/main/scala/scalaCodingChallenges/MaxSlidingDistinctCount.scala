package scalaCodingChallenges

import scalaCodingChallenges.Utils._
import scalaCodingChallenges.MaxSlidingDistinctCountChallenge._
import scalaCodingChallenges.MaxSlidingDistinctCountSolution._

// ToDo: Return the max distinct count among sliding sub-lists of size k

object MaxSlidingDistinctCount extends App {
  examples.example map function foreach println
}

object MaxSlidingDistinctCountChallenge {
  val examples = Examples(List(
      Example(data = List(1, 1, 3, 3, 3, 3, 5, 3),      k = 4) // => 2, List(1, 1, 3, 3)
    , Example(data = List("A", "A", "A", "C", 5, "C"),  k = 3) // => 3, List(A, C, 5)
    , Example(data = List("A", "A", "A"),               k = 2) // => 1, List(A, A)
  ))
}

object MaxSlidingDistinctCountSolution {
  val function: Example => Int = example =>
    example.data.par
      .to.sliding(example.k)
      .map(_.distinct.size)
      .max
}
