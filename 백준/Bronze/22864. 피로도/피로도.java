//  피로도

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int hp = 0, task = 0;
        for (int i = 0; i < 24; i++) {

            if (hp + a <= m) {
                task += b;
                hp += a;
            } else {
                hp -= c;
                if (hp < 0) {
                    hp = 0;
                }
            }
        }

        System.out.println(task);

    }
}