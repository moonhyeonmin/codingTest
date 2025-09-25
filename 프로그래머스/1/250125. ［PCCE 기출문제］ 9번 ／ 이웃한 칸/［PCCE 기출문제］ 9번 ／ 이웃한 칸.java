class Solution {
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    
    public int solution(String[][] board, int h, int w) {
        int answer = bfs(board, h, w);
        return answer;
    }
    
    static int bfs(String[][] board, int h, int w) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = h + dx[i];
            int ny = w + dy[i];

            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board.length) continue;

            if (board[nx][ny].equals(board[h][w])) {
                cnt++;
            }
        }
        
        return cnt;
    }
}