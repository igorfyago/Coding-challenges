package javaCodingChallenges;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SlidingMaxDistinctCount {
    // TODO: Return the Max() number of Distinct() values, among the rolling consecutive subList-s of size M,
    //  example_01: List(1, 1, 3, 3, 5, 3), N=6, M=3 -> 2
    //  example_02: List("A", "A", "C", "C", "E", "C"), N=6, M=3 -> 2


    public static void main(String[] args) {
        List<String> values = Arrays.asList("A", "A", "C", "C", "E", "C");
        int m = 3;

        System.out.println (slidingMaxDistinctCount(values, m));
    }

    private static <T> long slidingMaxDistinctCount(List<T> values, int m) {
        return IntStream.rangeClosed(0, values.size() - m)
                .parallel()
                .mapToObj(i -> values.subList(i, i + m)
                        .stream()
                        .distinct()
                        .count()
                )
                .reduce(Long::max)
                .orElse(0L);
    }

}