//  뒤집기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr = br.readLine();
        int[] num = new int[arr.length()];
        for (int i = 0; i < arr.length(); i++) {
            num[i] = arr.charAt(i) - '0';
        }


        int cnt = 0;
        for (int i = 0; i < num.length - 1; i++) {
            if (num[i] != num[i + 1]) {
                cnt++;
            }
        }

        if (cnt < 2) {
            System.out.println(cnt);
        } else if (cnt % 2 == 0){
            System.out.println(cnt / 2);
        } else {
            System.out.println(cnt / 2 + 1);
        }

    }
}