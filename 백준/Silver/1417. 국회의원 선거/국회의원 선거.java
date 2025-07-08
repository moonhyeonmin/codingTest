//  국회의원 선거

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] votes = new int[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            votes[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(0);
            return;
        }

        while(true) {

            int maxIndex = 1;
            for (int i = 1; i < n; i++) {
                if (votes[i] > votes[maxIndex]) {
                    maxIndex = i;
                }
            }


            if (votes[0] <= votes[maxIndex]) {
                votes[maxIndex]--;
                votes[0]++;
                cnt++;
            } else {
                break;
            }
        }

        System.out.println(cnt);
    }
}