//  치킨 배달

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, m, arr[][];
    static boolean visited[];
    static int res = Integer.MAX_VALUE;
    static ArrayList<int[]> chicken = new ArrayList<>();
    static ArrayList<int[]> home = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    home.add(new int[]{i, j});
                } else if (arr[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        visited = new boolean[chicken.size()];
        back(0, 0);
        System.out.println(res);

    }

    static void back(int start, int cnt) {
        if (cnt == m) {
            int sum = 0;
            for (int[] h : home) {
                int minDist = Integer.MAX_VALUE;
                for (int i = 0; i < chicken.size(); i++) {
                    if (visited[i]) {
                        int dist = Math.abs(h[0] - chicken.get(i)[0]) + Math.abs(h[1] - chicken.get(i)[1]);
                        minDist = Math.min(minDist, dist);
                    }
                }

                sum += minDist;
            }
            res = Math.min(res, sum);
            return;
        }

        for (int i = start ; i < chicken.size(); i++) {
            visited[i] = true;
            back(i + 1, cnt + 1);
            visited[i] = false;
        }
    }
}