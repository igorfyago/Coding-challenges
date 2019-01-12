# Coding-challenges

```java
// see some ecountered in real life sample challenges bellow...

public class kMaxFrequentValues {
    // TODO: Return the 'k' most frequent values in a list of Integers.
    
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(3, 5, 1, 1, 1, 2, 1, 4, 4, 4, 0, 5);
        int K = 3;

        System.out.println(kMaxFrequentValues(values, K));
    }

    public static List<Integer> kMaxFrequentValues(List<Integer> values, int K) {
        Map<Integer, Long> groupMap = values.stream()
                .parallel()
                //.peek(System.out::println)
                .collect(groupingBy(e -> e, counting()));

        return groupMap.entrySet().stream()
                //.peek(System.out::println)
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(K)
                .map(e -> e.getKey())
                .collect(toList());
    }
}

public class maxUniqueSubListValues {
    // TODO: Return the max number of unique values,
	// among the rolling consecutive sub-lists of size M, for a given list of N integers

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 1, 3, 3, 5, 3);
        int N = values.size();
        int M = 3;

        System.out.println(maxUniqueSubList(values, N, M));
    }

    public static Long maxUniqueSubList(List<Integer> values, int N, int M) {
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
