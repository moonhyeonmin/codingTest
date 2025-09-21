class Solution {
    static int[] deadline;
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        deadline = new int[schedules.length];
        checkDeadline(schedules);
        for (int i = 0; i < timelogs.length; i++) {
            boolean count = true;
            
            for (int j = 0; j < 7; j++) {
                
                if (j == 7 - startday || j == 6 - startday) continue;
                
                if (6 - startday == -1) {
                    if (j == 6) {
                        continue;
                    }
                }
                
            
                if (timelogs[i][j] > deadline[i]) {
                    count = false;
                    break;
                }
            }
            
            if (count) 
                answer++;
        }
        
        
        return answer;
    }
    
    static void checkDeadline(int[] schedules) {
        for (int i = 0; i < schedules.length; i++) {
            int h = schedules[i] / 100;
            int m = schedules[i] % 100 + 10;
            if (m >= 60) {
                h++;
                m-= 60;
            }
            deadline[i] = h * 100 + m;
        }
    }
}