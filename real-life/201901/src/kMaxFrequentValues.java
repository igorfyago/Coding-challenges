import java.util.*;
import static java.util.stream.Collectors.*;

public class kMaxFrequentValues {
    // TODO: Return the K Max() frequent values in a List of Integers.
    //  example: List(3, 5, 1, 1, 1, 2, 1, 4, 4, 4, 0, 5), K=3 -> [1, 4, 5]
    
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(3, 5, 1, 1, 1, 2, 1, 4, 4, 4, 0, 5);
        int K = 3;

        System.out.println(kMaxFrequentValues(values, K));
    }

    public static List<Integer> kMaxFrequentValues(List<Integer> values, int K) {
        return values.stream().parallel()
                .collect(groupingByConcurrent (e -> e, counting()))
                .entrySet().stream()
                //.peek(System.out::println)
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(K)
                .map(e -> e.getKey())
                .collect(toList());
    }
}