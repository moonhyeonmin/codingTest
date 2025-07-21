//  수들의 합 4

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        long res = 0;
        map.put(0, 1);
        for (int i = 1; i < n + 1; i++) {
            res += map.getOrDefault(arr[i] - k, 0);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println(res);
    }
}