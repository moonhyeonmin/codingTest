
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int x = 50, y = 50, maxX = 50, maxY = 50, minX = 50, minY = 50, dir = 2;
        char[] str = br.readLine().toCharArray();
        int[][] map = new int[101][101];
        map[x][y] = 1;

        // 동남서북 0123
        for (char s : str) {
            if (s == 'R') {
                dir = (dir + 1) % 4;
            } else if (s == 'L') {
                dir--;
                if (dir == -1) dir = 3;
            } else {
                x = x + dx[dir];
                y = y + dy[dir];
                maxX = Math.max(x, maxX);
                maxY = Math.max(y, maxY);
                minX = Math.min(x, minX);
                minY = Math.min(y, minY);
                map[x][y] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                if (map[i][j] == 1) {
                    sb.append(".");
                } else {
                    sb.append("#");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}