//  듣보잡

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> nCount = new HashMap<>();
        Map<String, Integer> mCount = new HashMap<>();

        for (int i = 0; i < n + m; i++) {
            String input = br.readLine();
            if (i < n) {
                nCount.put(input, nCount.getOrDefault(input, 0) + 1);
            } else {
                mCount.put(input, mCount.getOrDefault(input, 0) + 1);
            }
        }

        List<String> res = new ArrayList<>();
        int cnt = 0;

        for (String key : nCount.keySet()) {
            if (mCount.containsKey(key)) {
                cnt++;
                res.add(key);
            }
        }

        Collections.sort(res);
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");
        for (String name : res) {
            sb.append(name).append("\n");
        }

        System.out.println(sb);
    }
}