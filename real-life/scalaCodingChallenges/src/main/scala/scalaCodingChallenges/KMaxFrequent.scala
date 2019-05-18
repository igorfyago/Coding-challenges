package scalaCodingChallenges

object KMaxFrequent extends App {
  // TODO: Return the k most frequent values from the list

  case class Example(values: List[Any], k: Int)
  case class Examples(example: List[Example])

  val examples = Examples(List(
     Example(values=List(3, 5, 1, 4, 1, 2, 1, 4, 4, 1, 0, 5),  k=3) // => List(1, 4, 5)
    ,Example(values=List("A","B","C","C","D","C","B")       ,  k=2) // => List(C, B)
    ,Example(values=List("A", 3, 3, 3,"D","C","B")          ,  k=4) // => List(3, A, B, C)
  ))

  val kMaxFrequent = (values: List[Any], k: Int) =>
    values.par.groupBy(identity).toList.sortBy(-_._2.size).take(k).map(_._1)

  examples.example.foreach(example=> println(kMaxFrequent(example.values,example.k)))
}
