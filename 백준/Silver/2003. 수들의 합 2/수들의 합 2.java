//  수들의 합 2

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, cnt = 0;
        int sum = 0;

        while (right < n) {
            sum += arr[right];
            right++;

            if (sum == m) {
                cnt++;
            }

            while (sum >= m && left < right) {
                sum -= arr[left];
                left++;
                if (sum == m)
                    cnt++;
            }

        }
        System.out.println(cnt);
    }
}