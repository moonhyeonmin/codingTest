
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static String[] title;
    static int[] power;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        title = new String[n];
        power = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            title[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int score = Integer.parseInt(br.readLine());
            binarySearch(score);
        }

        System.out.println(sb);

    }

    static void binarySearch(int score) {
        int left = 0;
        int right = n - 1;
        int idx = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (power[mid] < score) {
                left = mid + 1;
            } else if (power[mid] >= score) {
                right = mid - 1;
                idx = mid;
            }
        }

        sb.append(title[idx]).append("\n");

    }
}