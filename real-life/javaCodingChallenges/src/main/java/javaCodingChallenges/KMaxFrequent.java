package javaCodingChallenges;

import java.util.*;
import static java.util.stream.Collectors.*;

public class KMaxFrequent {
    // TODO: Return the K Max() frequent values in a List.
    //  example_01: List(3, 5, 1, 1, 1, 2, 1, 4, 4, 4, 0, 5), K=3 -> List(1, 4, 5)
    //  example_02: List("A","B","C","C","D","C","B"), K=2 -> List(C, B)

    public static void main(String[] args) {
        List<String> values = Arrays.asList("A", "B", "C", "C", "D", "C", "B");
        int k = 2;

        System.out.println (f(values, k));
    }

    private static <T> List<T> f(List<T> data, int K) {
        return data.stream()
                .parallel()
                .collect(groupingBy(e -> e, counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(K)
                .map(Map.Entry::getKey)
                .collect(toList());
    }

}