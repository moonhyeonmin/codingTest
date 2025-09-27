import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int cnt = 0, n, k;
    static int[] kit;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        kit = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            kit[i] = Integer.parseInt(st.nextToken());
        }

        func(0, 500);

        System.out.println(cnt);

    }

    static void func(int num, int weight) {
        if (num == kit.length) {
            cnt++;
            return;
        }

        for (int i = 0; i < kit.length; i++) {
            if (!visited[i]) {
                int next = weight - k + kit[i];
                if (next >= 500) {
                    visited[i] = true;
                    func(num + 1, next);
                    visited[i] = false;
                }
            }
        }
    }
}