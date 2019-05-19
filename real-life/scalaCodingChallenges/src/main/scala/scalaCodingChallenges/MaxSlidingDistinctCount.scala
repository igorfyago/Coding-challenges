package scalaCodingChallenges

object MaxSlidingDistinctCount extends App {
  // TODO: Return the largest distinct count of values among the sliding sub-lists of size k

  case class Example(data: List[Any], k: Int)
  case class Examples(example: List[Example])

  val examples = Examples(List(
     Example(data=List(1, 1, 3, 3, 3, 3, 5, 3)       , k=4) // => 2, List(1, 1, 3, 3)
    ,Example(data=List("A", "A", "A", "C", 5, "C")   , k=3) // => 3, List(A, C, 5)
    ,Example(data=List("A", "A", "A")                , k=2) // => 1, List(A, A)
  ))

  val f = (e: Example) =>
    e.data.par
      .to.sliding(e.k)
      .map(_.distinct.size)
      .max

  examples.example map f foreach(println(_))
}
