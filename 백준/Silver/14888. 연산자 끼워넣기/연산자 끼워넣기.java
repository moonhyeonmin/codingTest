import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int plus;
    static int minus;
    static int multi;
    static int divide, n;
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        plus = Integer.parseInt(st.nextToken());
        minus = Integer.parseInt(st.nextToken());
        multi = Integer.parseInt(st.nextToken());
        divide = Integer.parseInt(st.nextToken());

        func(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void func(int k, int res) {
        if (k == n) {
            max = Math.max(res, max);
            min = Math.min(res, min);
            return;
        }

        if (plus > 0) {
            plus--;
            func(k + 1, res + arr[k]);
            plus++;
        }
        if (minus > 0) {
            minus--;
            func(k + 1, res - arr[k]);
            minus++;
        }
        if (multi > 0) {
            multi--;
            func(k + 1, res * arr[k]);
            multi++;
        }
        if (divide > 0) {
            divide--;
            func(k + 1, res / arr[k]);
            divide++;
        }
    }
}