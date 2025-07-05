//  달팽이는 올라가고 싶다

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int cnt = (v - b) / (a - b);
        if ((v - b) % (b - a) != 0) {
            cnt++;
        }

        System.out.println(cnt);

    }
}