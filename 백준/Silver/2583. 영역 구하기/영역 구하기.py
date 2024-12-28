from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
m, n, k = map(int, input().split())
arr = [[0] * n for _ in range(m)]
for i in range(k):
    left_x, left_y, right_x, right_y = map(int, input().split())
    for x in range(left_y, right_y):
        for y in range(left_x, right_x):
            arr[x][y] = 1

def BFS(x, y):
    que = deque()
    que.append((x, y))
    arr[x][y] = 1
    cnt = 1

    while que:
        x, y = que.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 > nx or nx >= m or 0 > ny or ny >= n:
                continue
            if arr[nx][ny] != 0:
                continue

            arr[nx][ny] = 1
            que.append((nx, ny))
            cnt += 1
    res.append(cnt)

res = []
for i in range(m):
    for j in range(n):
        if arr[i][j] == 0:
            BFS(i, j)

print(len(res))
print(*sorted(res))
