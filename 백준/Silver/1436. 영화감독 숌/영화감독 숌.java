//  영화감독 숌

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        int num = 666;
        while (cnt < n) {
            if (String.valueOf(num).contains("666")) {
                cnt++;
            }
            num++;
        }

        System.out.println(num - 1);
    }
}