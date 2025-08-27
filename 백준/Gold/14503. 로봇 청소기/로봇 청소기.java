
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
        int[] dc = {0, 1, 0, -1}; // 북, 동, 남, 서
        int res = 0;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if (arr[r][c] == 0) { // 현재 위치 청소
                arr[r][c] = 2;
                res++;
            }

            boolean cleaned = false;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (arr[nr][nc] == 0) { // 청소할 곳이 있는 경우
                    cleaned = true;
                }
            }

            if (cleaned) { // 청소할 곳이 있는 경우 (3)
                d = (d + 3) % 4; // 왼쪽으로 회전 (3-1)
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (arr[nr][nc] == 0) { // 방향전환하고 난 후 눈 앞에 있는 칸이 청소 안 되어있는 경우 (3-2)
                    r = nr;
                    c = nc;
                }
            } else { // 청소할 곳 없는 경우 (2)
                int back = (d + 2) % 4; // 후진 방향
                int nr = r + dr[back];
                int nc = c + dc[back];

                if (arr[nr][nc] == 1) { // 후진할 수 없는 경우 (2-2)
                    System.out.println(res);
                    return;
                } else { // 후진할 수 있는 경우 (2-1)
                    r = nr;
                    c = nc;
                }

            }
        }




    }
}