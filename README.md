# Coding-challenges

see bellow, some sample solutions, to coding challenges encountered in [real life](real-life/scalaCodingChallenges/srcmain/scala/scalaCodingChallenges):

```scala
object MaxSlidingDistinctCount extends App {
  // TODO: Return the largest distinct count of values among the sliding sub-lists of size k

  case class Example(data: List[Any], k: Int)
  case class Examples(example: List[Example])

  val examples = Examples(List(
     Example(data=List(1, 1, 3, 3, 3, 3, 5, 3)       , k=4) // => 2, List(1, 1, 3, 3)
    ,Example(data=List("A", "A", "A", "C", 5, "C")   , k=3) // => 3, List(A, C, 5)
    ,Example(data=List("A", "A", "A")                , k=2) // => 1, List(A, A)
  ))

  val f = (data: List[Any], k: Int) => data.par.to.sliding(k).map(_.distinct.size).max

  examples.example.foreach(example=> println(f(example.data,example.k)))
}
```
...
```scala
object KMaxFrequent extends App {
  // TODO: Return the k most frequent values from the list

  case class Example(data: List[Any], k: Int)
  case class Examples(example: List[Example])

  val examples = Examples(List(
     Example(data=List(3, 5, 1, 4, 1, 2, 1, 4, 4, 1, 0, 5),  k=3) // => 1, 4, 5
    ,Example(data=List("A","B","C","C","D","C","B")       ,  k=2) // => C, B
    ,Example(data=List("A", 3, 3, 3,"D","C","B")          ,  k=4) // => 3, A, B, C
  ))

  val f = (data: List[Any], k: Int) => data.par.groupBy(i=>i).to.sortBy(-_._2.size).take(k).map(_._1).mkString(", ")

  examples.example.foreach(example=> println(f(example.data,example.k)))
}
```
