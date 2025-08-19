import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        arr = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = n, res = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (lightCheck(mid)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(res);

    }

    private static boolean lightCheck(int mid) {
        int prev = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - mid <= prev) {
                prev = arr[i] + mid;
            } else {
                return false;
            }
        }

        if (n - prev > 0) {
            return false;
        }
        return true;
    }
}