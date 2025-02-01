from collections import deque

def bfs(x, y):
    que = deque()
    que.append((x, y))
    visited[x][y] = True
    seaList = []

    while que:
        x, y = que.popleft()
        sea = 0
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue

            if arr[nx][ny] == 0:
                sea += 1
            elif arr[nx][ny] != 0 and not visited[nx][ny]:
                que.append((nx, ny))
                visited[nx][ny] = True
        if sea > 0:
            seaList.append((x, y, sea))
    for x, y, sea in seaList:
        arr[x][y] = max(0, arr[x][y] - sea)

    return 1



dx = [ -1, 1, 0, 0]
dy = [0, 0, -1, 1]
year = 0
n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

ice = []
for i in range(n):
    for j in range(m):
        if arr[i][j] > 0:
            ice.append((i, j))

while ice:
    visited = [[False] * m for _ in range(n)]
    delList = []
    group = 0

    for i, j in ice:
        if arr[i][j] and not visited[i][j]:
            group += bfs(i, j)
        if arr[i][j] == 0:
            delList.append((i, j))

    if group > 1:
        print(year)
        break

    ice = sorted(list(set(ice) - set(delList)))
    year += 1

if group < 2:
    print(0)