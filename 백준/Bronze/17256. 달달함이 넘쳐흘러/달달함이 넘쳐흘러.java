//  달달함이 넘쳐흘러

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[3];
        int[] c = new int[3];

        for (int i = 0; i < 3; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        sb.append(c[0] - a[2]).append(" ").append(c[1]/a[1]).append(" ").append(c[2] - a[0]);

        System.out.println(sb);
    }
}