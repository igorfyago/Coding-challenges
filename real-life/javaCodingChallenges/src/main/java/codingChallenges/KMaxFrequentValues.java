package codingChallenges;

import java.util.*;
import static java.util.stream.Collectors.*;

public class KMaxFrequentValues {
    // TODO: Return the K Max() frequent values in a List of Integers.
    //  example: List(3, 5, 1, 1, 1, 2, 1, 4, 4, 4, 0, 5), K=3 -> [1, 4, 5]
    
    public static void main(String[] args) {
        List<String> values = Arrays.asList("a","b","b","c","z","z","b");

        System.out.println(kMaxFrequentValues(values, 2));
    }

    private static List<String> kMaxFrequentValues(List<String> values, int K) {
        return values.stream().parallel()
                .collect(groupingBy (e -> e, counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(K)
                .map(Map.Entry::getKey)
                .collect(toList());
    }
}