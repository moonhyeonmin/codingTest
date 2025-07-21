//  피아노 체조

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] cnt = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (arr[i] < arr[i - 1]) {
                cnt[i] ++;
            }
            cnt[i] += cnt[i - 1];
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int sum = cnt[end] - cnt[start];
            sb.append(sum + "\n");
        }

        System.out.println(sb);

    }
}