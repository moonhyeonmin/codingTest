import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int res[], n, arr[];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            n = Integer.parseInt(st.nextToken());
            res = new int[6];
            if (n == 0)
                break;

            arr = new int[n];

            for (int i = 0; i < n; i++) {
                if (!st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
                arr[i] = Integer.parseInt(st.nextToken());
            }

            func(0, 0);
            System.out.println(sb);

        }
    }

    public static void func(int cnt, int idx) {
        if (cnt == 6) {
            for (int i : res) {
                sb.append(i).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = idx; i < n; i++) {
            res[cnt] = arr[i];
            func(cnt + 1, i + 1);
        }

    }
}