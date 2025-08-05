import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0, r = n - 1, Max = Integer.MIN_VALUE;

        while (l < r) {
            Max = Math.max(Max, (r - l - 1) * Math.min(arr[r], arr[l]));

            if (arr[l] > arr[r]) {
                r--;
            } else {
                l++;
            }

        }

        System.out.println(Max);
    }
}