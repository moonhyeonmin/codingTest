
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = 0;
        int[][] pos = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
        }

        int total = 0;
        int start_x = pos[0][0];
        int start_y = pos[0][1];
        for (int i = 1; i < n; i++) {
            total += Math.abs(start_x - pos[i][0]) + Math.abs(start_y - pos[i][1]);
            start_x = pos[i][0];
            start_y = pos[i][1];
        }

        int[] save = new int[n];
        for (int i = 1; i < n - 1; i++) {
            int before = Math.abs(pos[i - 1][0] - pos[i][0]) + Math.abs(pos[i - 1][1] - pos[i][1]) +
                    Math.abs(pos[i][0] - pos[i + 1][0]) + Math.abs(pos[i][1] - pos[i + 1][1]);
            int after = Math.abs(pos[i - 1][0] - pos[i + 1][0]) + Math.abs(pos[i - 1][1] - pos[i + 1][1]);
            save[i] = before - after;
        }

        Arrays.sort(save);
        res = total - save[n - 1];
        System.out.println(res);


    }
}