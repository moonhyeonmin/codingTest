class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        StringBuilder answer = new StringBuilder();
        int v = Integer.parseInt(video_len.split(":")[0])*60 + Integer.parseInt(video_len.split(":")[1]);
        int p = Integer.parseInt(pos.split(":")[0])*60 + Integer.parseInt(pos.split(":")[1]);
        int ops = Integer.parseInt(op_start.split(":")[0])*60 + Integer.parseInt(op_start.split(":")[1]);
        int ope = Integer.parseInt(op_end.split(":")[0])*60 + Integer.parseInt(op_end.split(":")[1]);
        
        for (String command : commands) {
            if (p >= ops && p <= ope) {
                p = skipOpenning(p, ops, ope);
            }
            
            if (command.equals("next")) {
                p = moveNext(p, v);
            } else if (command.equals("prev")) {
                p = movePrev(p);
            }
            if (p >= ops && p <= ope) {
                p = skipOpenning(p, ops, ope);
            }
        }
        
        int m = p / 60;
        int s = p % 60;
        
        return String.format("%02d:%02d", m, s);
    }
    
    /*
        오프닝 건너뛰기
    */
    static int skipOpenning(int time, int ops, int ope) {
        if (time >= ops && time <= ope) {
            return ope;
        }
        return time;
    }
    /*
        10초 전으로 이동
    */
    static int movePrev(int time) {
        if (time - 10 < 0) {
            return 0;
        }
        
        return time - 10;
    }
    
    /*
        10초 뒤로 이동
    */
    static int moveNext(int time, int v) {
        if (time + 10 > v) {
            return v;
        }
        
        return time + 10;
    }
}