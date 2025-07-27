//  진우의 달 여행 (Small)

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[][] arr;
    static int[][][] dp;
    static int n, m;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        dp = new int[n][m][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0) Arrays.fill(dp[i][j], arr[i][j]);
                else Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j != 0) {
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + arr[i][j];
                }
                dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + arr[i][j];
                if (j != m - 1) {
                    dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + arr[i][j];
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int Min = dp[n-1][i][0];
            for (int j = 1; j < 3; j++) {
                Min = Math.min(Min, dp[n-1][i][j]);
            }

            res = Math.min(res, Min);
        }

        System.out.println(res);

    }
}