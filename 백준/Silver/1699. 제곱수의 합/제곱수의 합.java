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

        int[] dp = new int[n + 1];

        dp[1] = 1;
        for (int i = 2; i <= n; i++) {

            int min = Integer.MAX_VALUE;

            for (int j = 1; j <= i / 2; j++) {
                if (j * j == i) {
                    min = 1;
                    break;
                } else {
                    min = Math.min(min, dp[j] + dp[i - j]);
                }
            }

            dp[i] = min;
        }

        System.out.println(dp[n]);
    }
}