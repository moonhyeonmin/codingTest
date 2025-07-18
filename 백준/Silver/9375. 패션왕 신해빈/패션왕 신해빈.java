//  패션왕 신해빈

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String thing1 = st.nextToken();
                String thing2 = st.nextToken();
                map.put(thing2, map.getOrDefault(thing2, 0) + 1);
            }
            int cnt = 1;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                cnt = cnt * (entry.getValue() + 1);
            }
            sb.append(cnt - 1 + "\n");
        }

        System.out.println(sb);
    }
}