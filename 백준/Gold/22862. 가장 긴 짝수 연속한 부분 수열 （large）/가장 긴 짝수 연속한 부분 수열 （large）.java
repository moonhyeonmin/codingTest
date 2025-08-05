//  곱셈

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int num1 = Integer.parseInt(br.readLine());
//        int num2 = Integer.parseInt(br.readLine());
//
//        int origin = num2;
//        List<Integer> num = new ArrayList<>();
//        while (num2 > 0) {
//            num.add(num2 % 10);
//            num2 /= 10;
//        }
//
//        int sum = 0;
//        for (int i = 0; i < num.size(); i++) {
//            System.out.println(num1 * num.get(i));
//        }
//        System.out.println(num1 * origin);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0, r = 0, Max = 0, cnt = 0;
        while (r < n) {
            if (cnt < k) { // 바꿀 수 있음
                if (arr[r] % 2 != 0) { // 지금 홀수
                    cnt++;
                }
                r++;
                Max = Math.max(Max, r - l - cnt);
            } else if (arr[r] % 2 == 0) {
                r++;
                Max = Math.max(Max, r - l - cnt);
            } else {
                if (arr[l] % 2 != 0) {
                    cnt--;
                }

                l++;
            }
        }

        System.out.println(Max);
    }
}