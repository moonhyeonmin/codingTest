
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
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long cnt = 0;
        for (int i = 0; i < n; i++) {
            arr[i] -= b;
            cnt++;
            if (arr[i] > 0) {
                cnt += (long) (arr[i] / c);
                if (arr[i] % c != 0) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);



    }
}