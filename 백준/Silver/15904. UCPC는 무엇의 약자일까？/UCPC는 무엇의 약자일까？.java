//  UCPC는 무엇의 약자일까?

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr = br.readLine();
        char[] target = new char[] {'U', 'C', 'P', 'C'};

        int idx = 0;
        for (int i = 0; i < arr.length(); i++) {
            if (arr.charAt(i) == target[idx]) {
                idx++;

                if (idx == 4)
                    break;
            }
        }

        if (idx == target.length) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }

    }
}