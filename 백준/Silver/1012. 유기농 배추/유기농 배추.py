import sys
from collections import deque
input = sys.stdin.readline

t = int(input())
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]


def bfs(r, c):
    que = deque()
    que.append((r, c))
    arr[c][r] = 0
    cnt = 1

    while que:
        x, y = que.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= m or ny < 0 or ny >= n:
                continue
            if arr[ny][nx] == 1:
                arr[ny][nx] = 0
                que.append((nx, ny))
                cnt += 1
    return cnt


for _ in range(t):
    result = []
    m, n, k = map(int, input().split())
    arr = [[0 for _ in range(m)] for _ in range(n)]
    for _ in range(k):
        x, y = map(int, input().split())
        arr[y][x] = 1
    for i in range(m):
        for j in range(n):
            if arr[j][i] == 1:
                result.append(bfs(i, j))

    print(len(result))