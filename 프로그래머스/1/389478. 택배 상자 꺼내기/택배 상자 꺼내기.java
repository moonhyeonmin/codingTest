class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int row = (num - 1) / w;
        int wIdx = w - 1;
        int col = 0;

        
        if (row % 2 == 0) { // 짝수 행일 경우
            col = (num - 1) % w;
        } else { // 홀수 행일 경우
            col = wIdx - (num - 1) % w;
        }
        
        int maxRow = (n - 1) / w;
        int maxCol = 0;
        boolean reverse = true;
        if (maxRow % 2 == 0) {
            reverse = true;
            maxCol = (n - 1) % w;
        } else {
            reverse = false;
            maxCol = wIdx - (n - 1) % w;
        }
        
        if (!reverse) { // 홀수일 경우
            if (maxCol <= col) {
            answer = maxRow - row;
            } else {
                answer = maxRow - 1 - row;
            }
        } else { // 짝수일 경우
            if (maxCol >= col) {
                answer = maxRow - row;
            } else {
                answer = maxRow - 1 - row;
            }
        }
        
        
        return answer + 1;
    }
}