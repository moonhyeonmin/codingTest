//  직사각형에서 탈출

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int diff_x = Math.min(w - x, x);
        int diff_y = Math.min(h - y, y);

        if (diff_x > diff_y) {
            System.out.println(diff_y);
        } else {
            System.out.println(diff_x);
        }
    }
}