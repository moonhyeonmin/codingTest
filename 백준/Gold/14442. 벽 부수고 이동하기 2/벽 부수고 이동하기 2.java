
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, k, cnt;
    static char[][] arr;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x, y, broken, dist;
        Node(int x, int y, int broken, int dist) {
            this.x = x;
            this.y = y;
            this.broken = broken;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        visited = new boolean[n][m][k + 1];
        System.out.println(bfs(0, 0));
    }

    static int bfs(int x, int y) {
        if (n == 1 && m == 1) return 1;
        Queue<Node> que = new ArrayDeque<>();
        que.offer(new Node(x, y, 0, 1));
        visited[x][y][0] = true;
        cnt = 1;

        while (!que.isEmpty()) {
            Node cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx == n - 1 && ny == m - 1) {
                    return cur.dist + 1;
                }

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (arr[nx][ny] == '0' && !visited[nx][ny][cur.broken]) {
                    visited[nx][ny][cur.broken] = true;
                    que.offer(new Node(nx, ny, cur.broken, cur.dist + 1));
                    cnt++;
                } else if (arr[nx][ny] == '1' && cur.broken < k && !visited[nx][ny][cur.broken + 1]) {
                    visited[nx][ny][cur.broken + 1] = true;
                    que.offer(new Node(nx, ny, cur.broken + 1, cur.dist + 1));
                }
            }
        }

        return -1;
    }
}