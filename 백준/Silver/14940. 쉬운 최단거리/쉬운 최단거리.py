from collections import deque

n, m = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(n)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
visited = [[-1 for _ in range(m)] for _ in range(n)]

def bfs(x, y):
    que = deque()
    que.append((x, y))
    visited[x][y] = 0
    while que:
        x, y = que.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= m or visited[nx][ny] != -1:
                continue

            if arr[nx][ny] == 0:
                visited[nx][ny] = 0
            else:
                visited[nx][ny] = visited[x][y] + 1
                que.append((nx, ny))



for i in range(n):
    for j in range(m):
        if arr[i][j] == 2:
            bfs(i, j)
        elif arr[i][j] == 0:
            visited[i][j] = 0

for i in range(n):
    print(*visited[i])