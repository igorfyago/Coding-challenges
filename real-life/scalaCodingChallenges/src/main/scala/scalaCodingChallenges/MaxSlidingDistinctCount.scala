package scalaCodingChallenges

object MaxSlidingDistinctCount extends App {
  // TODO: Return the largest distinct count of values among the sliding sub-lists of size k

  case class Example(values: List[Any], k: Int)
  case class Examples(example: List[Example])

  val examples = Examples(List(
     Example(values=List(1, 1, 3, 3, 3, 3, 5, 3)       , k=4) // => 2, List(1, 1, 3, 3)
    ,Example(values=List("A", "A", "A", "C", 5, "C")   , k=3) // => 3, List(A, C, 5)
    ,Example(values=List("A", "A", "A")                , k=2) // => 1, List(A, A)
  ))

  val maxSlidingDistinctCount = (values: List[Any], k: Int) =>
    values.par.iterator.sliding(k).map(x=>(x.distinct.size,x)).maxBy(_._1)

  examples.example.foreach(example=> println(maxSlidingDistinctCount(example.values,example.k)))
}
