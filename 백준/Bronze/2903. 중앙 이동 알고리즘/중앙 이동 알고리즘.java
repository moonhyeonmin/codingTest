//  중앙 이동 알고리즘

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int res = 2;
        for (int i = 0; i < n; i++) {
            res = 2 * res - 1;
        }

        System.out.println(res * res);
    }
}