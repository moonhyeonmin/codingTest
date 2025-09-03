import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) throws Exception{
        Map<String, Integer> user_map = new HashMap<>();
        Map<String, Integer> report_map = new HashMap<>();
        Map<String, Set<String>> match_map = new HashMap<>();
        
        for (String i : id_list) {
            user_map.put(i, 0);
            match_map.put(i, new HashSet<>());
        }
        
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        
        for (String r : reportSet) {
            String[] tmp = r.split(" ");
            String from = tmp[0];
            String to = tmp[1];
            
            report_map.put(to, report_map.getOrDefault(to, 0) + 1);
            match_map.get(to).add(from);
        }
        
        for (String s : report_map.keySet()) {
            if (report_map.get(s) >= k) {
                for (String from : match_map.get(s)) {
                    user_map.put(from, user_map.get(from) + 1);
                }
            }
        }
        
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = user_map.get(id_list[i]);
        }

        return answer;
    }
}