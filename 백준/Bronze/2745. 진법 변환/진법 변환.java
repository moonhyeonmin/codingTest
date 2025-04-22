//  진법 변환

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());


        int tmp = 1;
        int res = 0;
        for (int i = N.length() - 1; i >= 0 ; i--) {
            char c = N.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                res += (c - 'A' + 10) * tmp;
            } else {
                res += (c - '0') * tmp;
            }

            tmp *= B;
        }

        System.out.println(res);
    }
}