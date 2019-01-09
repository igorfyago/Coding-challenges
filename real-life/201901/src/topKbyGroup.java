import java.util.*;
import static java.util.stream.Collectors.*;

public class topKbyGroup {
    // TODO: Return the k elements in a list of Integers, that are repeated the most, example caller: topKbyGroup(elements, 3)
    
    public static void main(String[] args) {
        List<Integer> elements = Arrays.asList(3, 5, 1, 1, 1, 2, 1, 4, 4, 4, 0, 5);
        int K = 3;

        System.out.println( topKbyGroup(elements, K) );
    }

    public static List<Integer> topKbyGroup(List<Integer> elements, int k) {
        Map<Integer, Long> groupMap = elements.stream().parallel()
                .collect(groupingBy(e -> e, counting()));

        List<Integer> keys = groupMap.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(k)
                .map(e -> e.getKey())
                .collect(toList());
        return keys;
    }
}
