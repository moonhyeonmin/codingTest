
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int n, min = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][n];
        int landNum = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || map[i][j] == 0)
                    continue;

                divideLand(i, j, landNum);
                landNum++;
            }
        }

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 || visited[i][j])
                    continue;

                bfs(i, j, map[i][j]);
            }
        }
        System.out.println(min);



    }

    static void divideLand(int x, int y, int landNum) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x, y});
        visited[x][y] = true;
        map[x][y] = landNum;

        while (!que.isEmpty()) {
            int[] current = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                if (visited[nx][ny] || map[nx][ny] == 0)
                    continue;

                visited[nx][ny] = true;
                map[nx][ny] = landNum;
                que.offer(new int[]{nx, ny});
            }
        }
    }

    static void bfs(int x, int y, int landNum) {
        Queue<int[]> que = new LinkedList<>();

        boolean[][] visited_water = new boolean[n][n];
        visited_water[x][y] = true;
        visited[x][y] = true;
        que.offer(new int[]{x, y, 0});

        while (!que.isEmpty()) {
            int[] curr = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                if (map[nx][ny] == landNum) {
                    visited[nx][ny] = true;
                    continue;
                }
                if (visited_water[nx][ny])
                    continue;

                if (map[nx][ny] == 0) {
                    que.offer(new int[]{nx, ny, curr[2] + 1});
                    visited_water[nx][ny] = true;
                } else if(map[nx][ny] != landNum) {
                    min = Math.min(min, curr[2]);
                    return;
                }

            }
        }
    }
}