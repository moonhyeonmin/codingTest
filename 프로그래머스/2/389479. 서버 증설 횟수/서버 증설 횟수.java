import java.util.*;

class Solution {
    static int curr = 0;
    
    public int solution(int[] players, int m, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        int size = 0;
        int cnt = 0;
        
        for(int i = 0; i < 24; i++) {
            while (!pq.isEmpty() && pq.peek()[0] == i) {
                size -= pq.poll()[1];
            }
            
            int need = players[i] / m;
            int more = size - need;
            
            if (more < 0) {
                more *= -1;
                size += more;
                cnt += more;
                pq.add(new int[] {i + k, more});
            }
        }
        return cnt;
    }
}