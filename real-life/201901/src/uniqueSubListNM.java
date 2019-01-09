import java.util.Arrays;
import java.util.List;

public class uniqueSubListNM {
    // TODO: Return for a list of N integers, the max number of distinct elements among the rolling consecutive sub-lists of size M

    public static void main(String[] args) {
        List<Integer> elements = Arrays.asList(3, 5, 3, 3, 3, 2);
        int N = elements.size();
        int M = 3;

        System.out.println( maxUniqueCount(elements, N, M) );
    }

    public static long maxUniqueCount(List<Integer> elements, int N, int M) {
        long maxUniqueCount = 1;

        for (int i = 0; i + M <= N; i++) {
            long currUniqueCount = elements.subList(i, (i + M)).stream().parallel().distinct().count();

            if (currUniqueCount > maxUniqueCount) {
                maxUniqueCount = currUniqueCount;
            }

            if (maxUniqueCount == M) { // Max has been reached
                break;
            }
        }
        return maxUniqueCount;
    }
}