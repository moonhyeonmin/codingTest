//  후보 추천하기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int student = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < student; i++) {
            int vote = Integer.parseInt(st.nextToken());
            map.put(vote, map.getOrDefault(vote, 0) + 1);

            if (res.contains(vote)) {
                continue;
            }

            if (res.size() < n) {
                res.add(vote);
            } else {
                int minVote = Integer.MAX_VALUE;
                int minIndex = -1;

                for (int j = 0; j < res.size(); j++) {
                    int currentVote = map.get(res.get(j));
                    if (currentVote < minVote) {
                        minVote = currentVote;
                        minIndex = j;
                    }
                }

                map.remove(res.get(minIndex));
                res.remove(minIndex);
                res.add(vote);
            }
        }

        Collections.sort(res);

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}