//  전구

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] status = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            status[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                status[b] = c;
            } else if (a == 2) {
                for (int j = b; j <= c; j++) {
                    if (status[j] == 0) {
                        status[j] = 1;
                    } else {
                        status[j] = 0;
                    }
                }
            } else if (a == 3) {
                for (int j = b; j <= c; j++) {
                    status[j] = 0;
                }
            } else {
                for (int j = b; j <= c; j++) {
                    status[j] = 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(status[i] + " ");
        }
    }
}