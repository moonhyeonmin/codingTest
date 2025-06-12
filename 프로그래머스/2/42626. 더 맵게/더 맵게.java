import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville) {
            pq.add(s);
        }
        
        int res = 1;
        if (pq.peek() >= K) return 0;
        while (pq.size() >= 2) {
            pq.add(pq.poll() + (pq.poll() * 2));
            if (pq.peek() >= K) 
                return res;
            res++;
        }
        
        return -1;
    }
}