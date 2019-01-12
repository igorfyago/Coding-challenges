import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class uniqueSubListNM {
    // TODO: Return the max number of distinct elements among the rolling consecutive sub-lists of size M, for a given list of N integers

    public static void main(String[] args) {
        List<Integer> elements = Arrays.asList(1, 1, 3, 3, 5, 3);
        int N = elements.size();
        int M = 3;

        System.out.println( maxUniqueCount(elements, N, M) );
    }

    public static Long maxUniqueCount(List<Integer> elements, int N, int M) {
        return IntStream.range(0, N - M + 1)
                .parallel()
                .mapToObj(i -> elements.subList(i, i + M))
                //.peek(System.out::println)
                .map(e -> e.stream().distinct().count())
                .reduce(Long::max)
                .get();
    }
}