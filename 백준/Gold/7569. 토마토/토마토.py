from collections import deque
import sys
input = sys.stdin.readline

m, n, h = map(int, input().split())
arr = [[] for _ in range(h)]
que = deque()
res = 0
dx = [0, 0, 0, 0, -1, 1]
dy = [0, 0, -1, 1, 0, 0]
dz = [-1, 1, 0, 0, 0, 0]
for i in range(h):
    for _ in range(n):
        arr[i].append(list(map(int, input().split())))


for k in range(h):
    for i in range(n):
        for j in range(m):
            if arr[k][i][j] == 1:
                que.append((j , i, k))

def bfs():
    while que:
        x, y, z = que.popleft()
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]
            if 0 <= nx < m and 0 <= ny < n and 0 <= nz < h and arr[nz][ny][nx] == 0:
                arr[nz][ny][nx] = arr[z][y][x] + 1
                que.append((nx, ny, nz))

bfs()

for k in range(h):
    for i in arr[k]:
        for j in i:
            if j == 0:
                print(-1)
                exit(0)
        res = max(res, max(i))

print(res - 1)