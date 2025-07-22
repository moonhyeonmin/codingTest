//  번데기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int a ,t, s;
    static int zero, one;
    static int repeat = 2;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(br.readLine());
        t = Integer.parseInt(br.readLine());
        s = Integer.parseInt(br.readLine());

        int cnt = rotate();
        System.out.println(cnt);

    }

    static int rotate() {
        while (true) {
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) {
                    zero++;
                } else {
                    one++;
                }

                if (s == 0 && zero == t)
                    return (zero + one - 1) % a;
                if (s == 1 && one == t)
                    return (zero + one - 1) % a;
            }

            for (int i = 0; i < repeat; i++) {
                zero++;
                if (zero == t && s == 0)
                    return (zero + one - 1) % a;
            }

            for (int i = 0; i < repeat; i++) {
                one++;
                if (one == t && s == 1)
                    return (zero + one - 1) % a;
            }

            repeat++;
        }
    }
}