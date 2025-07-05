//  설탕 배달

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n < 3) {
            System.out.println(-1);
            return;
        }

        for (int five = n / 5; five >= 0; five--) {
            int remain = n - (five * 5);
            if (remain % 3 == 0) {
                int three = remain / 3;
                System.out.println(five + three);
                return;
            }
        }

        System.out.println(-1);
    }
}