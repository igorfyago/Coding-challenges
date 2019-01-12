# Coding-challenges

see bellow, some sample solutions, to coding challenges encountered in [real life](real-life/201901/src):

```java
public class maxSubListDistinctValues {
    // TODO: Return the Max() number of Distinct() values,
    //  among the rolling consecutive subList-s of size M, 
    //  for a given List of N Integers

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 1, 3, 3, 5, 3);
        int N = values.size();
        int M = 3;

        System.out.println(maxSubListDistinctValues(values, N, M));
    }

    public static Long maxSubListDistinctValues(List<Integer> values, int N, int M) {
        return IntStream.range(0, N - M + 1)
                .parallel()
                .mapToObj(i -> values.subList(i, i + M))
                //.peek(System.out::println)
                .map(e -> e.stream()
                        .parallel()
                        .distinct()
                        .count())
                .reduce(Long::max)
                .get();
    }
}
```
...
```java
public class kMaxFrequentValues {
    // TODO: Return the K Max() frequent values in a List of Integers.
    
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(3, 5, 1, 1, 1, 2, 1, 4, 4, 4, 0, 5);
        int K = 3;

        System.out.println(kMaxFrequentValues(values, K));
    }

    public static List<Integer> kMaxFrequentValues(List<Integer> values, int K) {
        return values.stream()
                .parallel()
                //.peek(System.out::println)
                .collect(groupingByConcurrent(e -> e, counting()))
                .entrySet().stream()
                //.peek(System.out::println)
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(K)
                .map(e -> e.getKey())
                .collect(toList());
    }
}
```
