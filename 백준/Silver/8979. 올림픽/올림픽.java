import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] medal = new int[n + 1][3];
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            medal[num][0] = Integer.parseInt(st.nextToken());
            medal[num][1] = Integer.parseInt(st.nextToken());
            medal[num][2] = Integer.parseInt(st.nextToken());
        }

        int rank = 1;
        for (int i = 1; i <= n; i++) {
            if (medal[i][0] > medal[k][0]) {
                rank++;
            } else if (medal[i][0] == medal[k][0] && medal[i][1] > medal[k][1]) {
                rank++;
            } else if (medal[i][0] == medal[k][0] && medal[i][1] > medal[k][1] && medal[i][2] > medal[k][2]) {
                rank++;
            }
        }

        System.out.println(rank);


    }
}