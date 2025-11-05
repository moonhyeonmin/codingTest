import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        for (int i = n - 1; i > 0; i--) {
            if (i * 2 <= n) {
                if (i * 3 <= n) {
                    dp[i] = Math.min(dp[i + 1] + 1, dp[i * 2] + 1);
                    dp[i] = Math.min(dp[i], dp[i * 3] + 1);
                } else {
                    dp[i] = Math.min(dp[i + 1] + 1, dp[i * 2] + 1);
                }
            } else {
                dp[i] = dp[i + 1] + 1;
            }
        }

        System.out.println(dp[1]);

    }
}