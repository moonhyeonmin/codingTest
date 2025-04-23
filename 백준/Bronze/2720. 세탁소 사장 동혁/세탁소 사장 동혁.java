//  세탁소 사장 동혁

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();



        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int q = 0, d = 0, n = 0, p = 0;
            int c = Integer.parseInt(br.readLine());
            q = c / 25;
            c %= 25;
            d = c / 10;
            c %= 10;
            n = c / 5;
            c %= 5;
            p = c;

            sb.append(q + " ");
            sb.append(d + " ");
            sb.append(n + " ");
            sb.append(p + "\n");
        }
        System.out.println(sb);
    }
}