//  이진수

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int res = 0;
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            List<Integer> positions = new ArrayList<>();
            int pos = 0;

            while (n > 0) {
                if (n % 2 == 1) {
                    positions.add(pos);
                }

                pos++;
                n /= 2;
            }
            for (int j : positions) {
                sb.append(j).append(" ");
            }

            sb.append("\n");
        }
        System.out.println(sb);


    }
}