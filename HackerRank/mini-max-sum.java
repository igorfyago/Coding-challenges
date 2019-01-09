import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(long[] arr) {
        Arrays.sort(arr); 
        
        int n = arr.length;

        long[] lwrArr = Arrays.copyOfRange(arr, 0, (n -1));
        long[] uprArr = Arrays.copyOfRange(arr, 1, n);

        long lwrSum = Arrays.stream(lwrArr).sum();
        long uprSum = Arrays.stream(uprArr).sum();
            
        System.out.print(lwrSum + " " + uprSum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        long[] arr = new long[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            long arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}