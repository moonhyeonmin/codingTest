import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] num1 = new int[] {1, 2, 3, 4, 5};
        int[] num2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] num3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int cnt_1 = 0, cnt_2 = 0, cnt_3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (num1[i % 5] == answers[i]) {
                cnt_1++;
            }
            
            if (num2[i % 8] == answers[i]) {
                cnt_2++;
            }
            
            if (num3[i % 10] == answers[i]) {
                cnt_3++;
            }
        }
        
        int max = Math.max(cnt_1, Math.max(cnt_2, cnt_3));
        List<Integer> res = new ArrayList<>();
        if (max == cnt_1) res.add(1);
        if (max == cnt_2) res.add(2);
        if (max == cnt_3) res.add(3);
        
        int[] answer = res.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}