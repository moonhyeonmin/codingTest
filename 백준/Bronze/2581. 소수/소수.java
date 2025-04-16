//  소수

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static boolean prime[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        prime = new boolean[N + 1];
        get_prime();

        int res = 0;
        int Min = 100001;

        for (int i = M; i <= N; i++) {
            if (!prime[i]) {
                res += i;
                if (Min > i) {
                    Min = i;
                }
            }
        }


        if (res == 0) {
            System.out.println(-1);
        }

        else {

        StringBuilder sb = new StringBuilder();
        sb.append(res);
        sb.append('\n');
        sb.append(Min);
        System.out.println(sb);
        }
    }

    public static void get_prime() {
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i < Math.sqrt(prime.length); i++) {
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}