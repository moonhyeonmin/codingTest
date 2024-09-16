from collections import deque
import sys
input = sys.stdin.readline

m, n = map(int, input().split())
arr = []
que = deque()
res = 0
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
for _ in range(n):
    arr.append(list(map(int, input().split())))

for i in range(n):
    for j in range(m):
        if arr[i][j] == 1:
            que.append((j , i))

def bfs():
    while que:
        x, y = que.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < m and 0 <= ny < n and arr[ny][nx] == 0:
                arr[ny][nx] = arr[y][x] + 1
                que.append((nx, ny))

bfs()
for i in arr:
    for j in i:
        if j == 0:
            print(-1)
            exit(0)
    res = max(res, max(i))

print(res - 1)