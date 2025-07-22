//  음식물 피하기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static boolean[][] visited;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m, Max = -1;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[r - 1][c - 1] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    int size = bfs(i, j);
                    Max = Math.max(size, Max);
                }
            }
        }

        System.out.println(Max);
    }

    static int bfs(int r, int c) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{r, c});
        visited[r][c] = true;
        int res = 1;

        while (!que.isEmpty()) {
            int[] num = que.poll();
            int x = num[0];
            int y = num[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] == true || arr[nx][ny] == 0) {
                    continue;
                }

                res++;
                visited[nx][ny] = true;
                que.add(new int[]{nx, ny});
            }
        }
        return res;
    }
}