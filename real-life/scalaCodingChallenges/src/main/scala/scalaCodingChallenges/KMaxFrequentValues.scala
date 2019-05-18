package scalaCodingChallenges

object KMaxFrequentValues extends App {
  // TODO: Return the K Max() frequent values in a List.
  //  example_01: List(3, 5, 1, 1, 1, 2, 1, 4, 4, 4, 0, 5), K=3 -> List(1, 4, 5)
  //  example_02: List("A","B","C","C","D","C","B"), K=2 -> List(C, B)

  case class Example(values: List[Any], k: Int)
  case class Examples(example: List[Example])

  val examples = Examples(List(
      Example(values=List(3, 5, 1, 1, 1, 2, 1, 4, 4, 4, 0, 5),  k=3),
      Example(values=List("A","B","C","C","D","C","B"),         k=2)
  ))

  val kMaxFrequentValues: (List[Any], Int) => List[Any] = (values, k)  =>
    values
    .par
    .groupBy(identity)
    .toList
    .sortBy(-_._2.size)
    .take(k)
    .map(_._1)

  examples.example.foreach(example=> println(kMaxFrequentValues(example.values,example.k)))
}
