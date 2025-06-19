import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int[][] visited = new int[maps.length][maps[0].length];
        
        return bfs(0, 0, maps, visited);
        
    }
    
    public int bfs(int x, int y, int[][] maps, int[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = 1;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int ax = curr[0];
            int ay = curr[1];
            
            if (ax == maps.length - 1 && ay == maps[0].length - 1)
                return visited[ax][ay];
            
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + ax;
                int ny = dy[i] + ay;
                
                if (0 <= nx && nx < maps.length && 0 <= ny && ny < maps[0].length && maps[nx][ny] == 1 && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[ax][ay] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return -1;
    }
}