import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int res = 1;
        
        for(String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }
        
        for (String key : map.keySet()) {
            res *= (map.get(key) + 1);            
        }
        
        return res - 1;
    }
}