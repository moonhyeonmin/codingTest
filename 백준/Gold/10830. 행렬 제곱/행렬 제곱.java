
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int MOD = 1000;
    static int n;
    static int[][] origin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        origin = new int[n][n];
        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = pow(origin, b);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                sb.append(result[i][j]).append(' ');
            }

            sb.append('\n');
        }

        System.out.println(sb);

    }

    static int[][] pow (int[][] A, long exp) {

        if (exp == 1) {
            return A;
        }

        int[][] half = pow(A, exp / 2);
        int[][] result = multiply(half, half);

        if (exp % 2 == 1) {
            result = multiply(result, origin);
        }

        return result;
    }

    static int[][] multiply(int[][] A, int[][] B) {

        int[][] half = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                for (int k = 0; k < n; k++) {
                    half[i][j] += (A[i][k] * B[k][j]) % MOD;
                }
                half[i][j] %= MOD;
            }
        }

        return half;
    }
}