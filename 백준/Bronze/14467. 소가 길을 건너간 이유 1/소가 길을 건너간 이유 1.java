//  소가 길을 건너간 이유 1

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] cow = new int[11][1];
        int res = 0;

        for (int i = 0; i < 11; i++) {
            cow[i][0] = -1;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cowNumber = Integer.parseInt(st.nextToken());
            int line = Integer.parseInt(st.nextToken());

            if (cow[cowNumber][0] == -1) {
                cow[cowNumber][0] = line;
            } else if (cow[cowNumber][0] != line) {
                res++;
                cow[cowNumber][0] = line;
            }
        }

        System.out.println(res);
    }
}