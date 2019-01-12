import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class maxUniqueSubListValues {
    // TODO: Return the max number of unique values among the rolling consecutive sub-lists of size M, for a given list of N integers

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