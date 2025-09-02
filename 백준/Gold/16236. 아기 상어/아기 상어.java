
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class shark implements Comparable<shark> {
    int x, y, dist;

    public shark(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public int compareTo(shark o) {
        if (this.dist == o.dist) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }

        return this.dist - o.dist;
    }
}

public class Main {

    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] arr;
    static int n;
    static int sharkX, sharkY, sharkSize = 2, eatCnt = 0, time = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    arr[i][j] = 0;
                }
            }
        }

        while (true) {
            shark shark = bfs();
            if (shark == null) break;

            sharkX = shark.x;
            sharkY = shark.y;
            time += shark.dist;

            arr[sharkX][sharkY] = 0;
            eatCnt++;
            if (eatCnt == sharkSize) {
                sharkSize++;
                eatCnt = 0;
            }
        }

        System.out.println(time);

    }

    static shark bfs() {
        Queue<int[]> que = new ArrayDeque<>();
        visited = new boolean[n][n];
        que.offer(new int[] {sharkX, sharkY, 0});
        visited[sharkX][sharkY] = true;

        List<shark> sharks = new ArrayList<>();

        while (!que.isEmpty()) {
            int[] dir = que.poll();
            int x = dir[0];
            int y = dir[1];
            int dist = dir[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;
                if (arr[nx][ny] > sharkSize) continue;

                visited[nx][ny] = true;
                que.offer(new int[]{nx, ny, dist + 1});

                if (arr[nx][ny] != 0 && arr[nx][ny] < sharkSize) {
                    sharks.add(new shark(nx, ny, dist + 1));
                }
            }
        }

        if (sharks.isEmpty()) return null;
        Collections.sort(sharks);
        return sharks.get(0);
    }
}