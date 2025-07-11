
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};
    static char[][] map;
    static int[][] visited;
    static int[][] water;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new int[r][c];
        water = new int[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                water[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '*') {
                    bfs_water(i, j);
                }
            }
        }

        int res = 0;
        visited = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'S') {
                    res = bfs_people(i, j);
                }
            }
        }

        if (res > 0) {
            System.out.println(res);
        } else {
            System.out.println("KAKTUS");
        }
    }

    static void bfs_water(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        visited[r][c]++;
        water[r][c] = 0;
        queue.add(new int[]{r, c, 0});

        while (!queue.isEmpty()) {
            int[] idx = queue.poll();
            int x = idx[0];
            int y = idx[1];
            int time = idx[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < map.length && ny >= 0
                        && ny < map[0].length && map[nx][ny] == '.'
                        && visited[nx][ny] == 0) {
                    water[nx][ny] = time + 1;
                    visited[nx][ny]++;
                    queue.add(new int[]{nx, ny, time + 1});
                }
            }

        }
    }

    static int bfs_people(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        visited[r][c]++;
        queue.add(new int[]{r, c, 0});

        while (!queue.isEmpty()) {
            int[] idx = queue.poll();
            int x = idx[0];
            int y = idx[1];
            int cnt = idx[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                    if (map[nx][ny] == 'D') {
                        return cnt + 1;
                    }

                    if (map[nx][ny] == '.' && visited[nx][ny] == 0 && cnt + 1 < water[nx][ny]) {
                        visited[nx][ny]++;
                        queue.add(new int[]{nx, ny, cnt + 1});
                    }
                }
            }
        }

        return 0;
    }
}