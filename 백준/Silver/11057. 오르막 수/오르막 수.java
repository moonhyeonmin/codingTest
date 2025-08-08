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

        long[][] arr = new long[n + 1][10];

        for (int i = 0; i < 10; i++) {
            arr[1][i] = 1;
        }


        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    arr[i][j] += arr[i - 1][k];
                }

                arr[i][j] %= 10007;
            }
        }

        System.out.println(Arrays.stream(arr[n]).sum() % 10007);
    }
}