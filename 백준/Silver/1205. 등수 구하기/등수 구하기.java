import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        if (n > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }

        if (n == 0) {
            System.out.println(1);
            return;
        }

        int rank  = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > score) { // 점수가 작으면
                rank++;
            } else {
                break;
            }
        }

        if (n == p && score <= arr[n - 1]) {
            System.out.println(-1);
        } else {
            System.out.println(rank);
        }
    }
}