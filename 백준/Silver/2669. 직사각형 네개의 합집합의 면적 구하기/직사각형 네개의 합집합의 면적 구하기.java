//  직사각형 네개의 합집합의 면적 구하기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{

        boolean[][] visited = new boolean[101][101];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            int[] arr = new int[4];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = arr[0]; j < arr[2]; j++) {
                for (int k = arr[1]; k < arr[3]; k++) {
                    visited[j][k] = true;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (visited[i][j] == true) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}