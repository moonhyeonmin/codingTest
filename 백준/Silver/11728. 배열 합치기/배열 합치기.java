//  배열 합치기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        int idx_a = 0, idx_b = 0;

        StringBuilder sb = new StringBuilder();
        while (idx_a < n && idx_b < m) {
            if (a[idx_a] > b[idx_b]) {
                sb.append(b[idx_b] + " ");
                idx_b++;
            } else {
                sb.append(a[idx_a] + " ");
                idx_a++;
            }
        }

        if (idx_a < n) {
            while (idx_a < n) {
                sb.append(a[idx_a] + " ");
                idx_a++;
            }
        }

        if (idx_b < m) {
            while (idx_b < m) {
                sb.append(b[idx_b] + " ");
                idx_b++;
            }
        }

        System.out.println(sb);
    }
}