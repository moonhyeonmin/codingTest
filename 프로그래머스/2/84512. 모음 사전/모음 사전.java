import java.util.*;

class Solution {
    
    static List<String> list = new ArrayList<>();
    static String[] chars = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        dfs("");
        
        int answer = 0;
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        
        return answer;
        
    }
    
    void dfs(String word) {
        list.add(word);
        
        if (word.length() == 5)
            return;
        
        for (int i = 0; i < 5; i++) {
            dfs(word + chars[i]);
        }
    }
}