//  블로그

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int start = 1, end = x;
        int sum = 0;
        for (int i = 0; i < x; i++) {
            sum += arr[i];
        }

        int cnt = 1;
        int Max = sum;

        for (int i = 0; i < n - x; i++) {
            sum += arr[i + x];
            sum -= arr[i];

            if (sum == Max) {
                cnt += 1;
            } else if (sum > Max) {
                cnt = 1;
                Max = sum;
            }
        }

        if (Max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(Max);
            System.out.println(cnt);
        }

    }
}