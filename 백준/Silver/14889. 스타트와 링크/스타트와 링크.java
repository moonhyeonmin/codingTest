
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(n, 0, 0);
        System.out.println(min);
    }

    static void func(int n, int k, int s) {
        if (k == n / 2) {
            cal();
            return;
        }

        for (int i = s; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                func(n, k + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    static void cal() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < visited.length; i++) {
            for (int j = i + 1; j < visited.length; j++) {
                if (visited[i] && visited[j]) {
                    start += arr[i][j];
                    start += arr[j][i];
                } else if (!visited[i] && !visited[j]){
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }

        }

        min = Math.min(min, Math.abs(start - link));
    }
}