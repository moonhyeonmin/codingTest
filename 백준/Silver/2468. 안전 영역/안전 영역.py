from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

n = int(input())
arr = []
for i in range(n):
    arr.append(list(map(int, input().split())))


def bfs(x, y, height):
    que = deque()
    que.append((x, y))
    visited[x][y] = True

    while que:
        x, y = que.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < n:
                if arr[nx][ny] > height and not visited[nx][ny]:
                    que.append((nx, ny))
                    visited[nx][ny] = True

res = []
for height in range(0, 101):
    cnt = 0
    visited = [[False] * n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            if not visited[i][j] and arr[i][j] > height:
                bfs(i, j, height)
                cnt += 1
    res.append(cnt)

print(max(res))
