class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] visited;
    static int n, m, res = 0;
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        res = n * m;
        map = new char[n][m];
        
        for (int i = 0;i < n; i++) {
            map[i] = storage[i].toCharArray();
        }
        
        for (String req : requests) {
            if (req.length() == 1) {
                car(req.charAt(0));
            } else {
                crain(req.charAt(0));
            }
        }
        return res;
    }
    
    static void car(char c) {
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i][0]) dfs(i, 0, c);
            if (!visited[i][m - 1]) dfs(i, m - 1, c);
        }
        
        for (int i = 0; i < m; i++) {
            if (!visited[0][i]) dfs(0, i, c);
            if (!visited[n - 1][i]) dfs(n - 1, i, c);
        }
    }
    
    static void dfs(int x, int y, char c) {
        visited[x][y] = true;
        if (map[x][y] == 0) {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if (!visited[nx][ny]) dfs(nx, ny, c);
            }
        }
        
        if (map[x][y] == c) {
            res--;
            map[x][y] = 0;
        }
    }
    
    static void crain(char c) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == c) {
                    map[i][j] = 0;
                    res--;
                }
            }
        }
    }
}