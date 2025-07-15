//  영단어 암기는 괴로워

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.length() >= m) {
                map.put(input, map.getOrDefault(input, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue();
            }

            if (a.getKey().length() != b.getKey().length()) {
                return b.getKey().length() - a.getKey().length();
            }

            return a.getKey().compareTo(b.getKey());
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < entryList.size(); i++) {
            sb.append(entryList.get(i).getKey()).append("\n");
        }
        System.out.println(sb);
    }
}