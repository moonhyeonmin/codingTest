import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        long max = Long.MIN_VALUE;

        int m = n - (n % 2);
        for (int i = 0; i < m / 2; i++) {
            max = Math.max(max, arr[i] + arr[m - i - 1]);
        }

        max = Math.max(arr[n - 1], max);


        System.out.println(max);
    }
}