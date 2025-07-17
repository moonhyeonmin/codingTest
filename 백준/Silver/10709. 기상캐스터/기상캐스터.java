
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        char[][] sky = new char[h][w];

        for (int i = 0; i < h; i++) {
            String line = br.readLine();
            sky[i] = line.toCharArray();
        }

        int[][] res = new int[h][w];
        for (int i = 0; i < h; i++) {
            int flag = 0;
            int cnt = -1;
            for (int j = 0; j < w; j++) {
                if (sky[i][j] == 'c') {
                    flag = 1;
                    cnt = 0;
                }
                if (flag == 0) {
                    res[i][j] = cnt;
                } else {
                    res[i][j] = cnt;
                    cnt++;
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}