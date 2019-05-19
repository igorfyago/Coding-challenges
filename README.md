# Coding-challenges

Sample project contents: [scala coding challenges](real-life/scalaCodingChallenges/src/main/scala/scalaCodingChallenges):

# Return the k most frequent values from a list
```scala
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

```
# Return the max distinct count among the values of each sliding sub-list of size k
```scala
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

```
