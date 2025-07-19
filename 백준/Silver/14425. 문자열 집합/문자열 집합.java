//  문자열 집합

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> s = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            s.put(line, s.getOrDefault(line, 0) + 1);
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            if (s.containsKey(line)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}