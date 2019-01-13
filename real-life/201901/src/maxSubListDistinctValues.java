import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class maxSubListDistinctValues {
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