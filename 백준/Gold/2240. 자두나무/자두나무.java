import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][][] dp = new int[t][w + 1][3];

        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (arr[0] == 1) {
            dp[0][0][1] = 1;
            dp[0][1][2] = 0;
        } else {
            dp[0][0][1] = 0;
            dp[0][1][2] = 1;
        }

        for (int i = 1; i < t; i++) {

            if (arr[i] == 1) {
                dp[i][0][1] = dp[i - 1][0][1] + 1;
                dp[i][0][2] = dp[i - 1][0][2];

                for (int j = 1; j <= w; j++) {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]) + 1;
                    dp[i][j][2] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j][2]);
                }
            } else {
                dp[i][0][1] = dp[i - 1][0][1];
                dp[i][0][2] = dp[i - 1][0][2] + 1;

                for (int j = 1; j <= w; j++) {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]);
                    dp[i][j][2] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j][2]) + 1;
                }
            }
        }


        int res = 0;
        for (int i = 0; i <= w; i++) {
            res = Math.max(res, Math.max(dp[t - 1][i][1], dp[t - 1][i][2]));
        }
        System.out.println(res);

    }
}