//  단어 공부

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isAlphabetic(c)) {
                c = Character.toUpperCase(c); // 대문자로 변환
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(charCount.entrySet());
        entryList.sort((a, b) -> {
            if (b.getValue().equals(a.getValue())) {
                return Character.compare(a.getKey(), b.getKey());
            }
            return b.getValue() - a.getValue();
        });

        if (entryList.size() != 1 && entryList.get(0).getValue().equals(entryList.get(1).getValue())) {
            System.out.println("?");
        } else {
            System.out.println(entryList.get(0).getKey());
        }
    }
}