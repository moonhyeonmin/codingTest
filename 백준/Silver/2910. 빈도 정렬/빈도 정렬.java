//  빈도 정렬

import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> firstIndex = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (!firstIndex.containsKey(num)) {
                firstIndex.put(num, i);
            }
        }

        List<Integer> res = map.entrySet().stream()
                .sorted((a, b) -> {
                    int freqCompare = b.getValue().compareTo(a.getValue()); // 빈도 내림차순
                    if (freqCompare == 0) {
                        // 빈도가 같으면 먼저 나온 순서 (첫 등장 인덱스 오름차순)
                        return firstIndex.get(a.getKey()).compareTo(firstIndex.get(b.getKey()));
                    }
                    return freqCompare;
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        for (int key : res) {
            int frequency = map.get(key);
            for (int j = 0; j < frequency; j++) {
                System.out.print(key + " ");
            }
        }
    }
}