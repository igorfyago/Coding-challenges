# Coding-challenges

```java
// see some ecountered in real life sample challenges bellow...

public class topKbyGroup {
    // TODO: Return the 'K' most frequent elements in a list of Integers.
    
    public static void main(String[] args) {
        List<Integer> elements = Arrays.asList(3, 5, 1, 1, 1, 2, 1, 4, 4, 4, 0, 5);
        int K = 3;

        System.out.println( topKbyGroup(elements, K) ); // Answer: [1, 4, 5]
    }

    public static List<Integer> topKbyGroup(List<Integer> elements, int K) {
        Map<Integer, Long> groupMap = elements.stream()
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

public class uniqueSubListNM {
    // TODO: Return the max number of distinct elements among 
    // the rolling consecutive sub-lists of size M, for a given list of N integers

    public static void main(String[] args) {
        List<Integer> elements = Arrays.asList(1, 1, 3, 3, 5, 3);
        int N = elements.size();
        int M = 3;

        System.out.println( maxUniqueCount(elements, N, M) ); // Answer: 2
    }

    public static long maxUniqueCount(List<Integer> elements, int N, int M) {
        return IntStream.range(0, N - M + 1)
                .parallel()
                .mapToObj(i -> elements.subList(i, i + M))
                //.peek(System.out::println)
                .map(e -> e.stream().distinct().count())
                .max(Long::compare).get();
    }
}
```
