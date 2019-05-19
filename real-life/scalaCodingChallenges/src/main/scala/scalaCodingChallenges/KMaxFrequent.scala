package scalaCodingChallenges

object KMaxFrequent extends App {
  // TODO: Return the k most frequent values from the list

  case class Example(data: List[Any], k: Int)
  case class Examples(example: List[Example])

  val examples = Examples(List(
     Example(data=List(3, 5, 1, 4, 1, 2, 1, 4, 4, 1, 0, 5),  k=3) // => 1, 4, 5
    ,Example(data=List("A","B","C","C","D","C","B")       ,  k=2) // => C, B
    ,Example(data=List("A", 3, 3, 3,"D","C","B")          ,  k=4) // => 3, A, B, C
  ))

  val f = (e: Example) =>
    e.data.par
      .groupBy(i => i)
      .to.sortBy(-_._2.size)
      .take(e.k)
      .map(_._1)
      .mkString(", ")

  examples.example foreach(e => println (f(e)))
}
