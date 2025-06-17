import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        
        for (String[] ticket : tickets) {
            map.putIfAbsent(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).add(ticket[1]);
        }
    
        Deque<String> stack = new ArrayDeque<>();
        stack.push("ICN");
        
        while (!stack.isEmpty()) {
            while (map.containsKey(stack.getFirst()) && !map.get(stack.getFirst()).isEmpty()) {
                stack.push(map.get(stack.getFirst()).poll());
            }
            
            res.add(0, stack.pop());
        }
        
        return res.toArray(new String[0]);
    }
}