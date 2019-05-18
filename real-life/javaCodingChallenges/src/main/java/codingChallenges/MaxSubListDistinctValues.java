package codingChallenges;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MaxSubListDistinctValues {
    // TODO: Return the Max() number of Distinct() values,
    //  among the rolling consecutive subList-s of size M, 
    //  for a given List of N Integers
    //  example: List(1, 1, 3, 3, 5, 3), N=6, M=3 -> 2

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 1, 3, 3, 5, 3);
        int N = values.size();
        int M = 3;

        System.out.println(maxSubListDistinctValues(values, N, M));
    }

    public static long maxSubListDistinctValues(List<Integer> values, int N, int M) {
        return IntStream.rangeClosed(0, N - M).parallel()
                .mapToObj(i -> values.subList(i, i + M).stream()
                        .distinct()
                        .count()
                )
                .reduce(Long::max)
                .get();
    }
}