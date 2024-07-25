import sys
from collections import deque
input = sys.stdin.readline

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

n, m = map(int, input().split())

graph = [[0] * m for _ in range(n)]
visited = [[False] * m for _ in range(n)]

def BFS(i, j):
    visited[i][j] = True
    que = deque()
    que.append((i, j))

    while que:
        curr = que.popleft()
        
        for k in range(4):
            x = curr[0] + dx[k]
            y = curr[1] + dy[k]

            if x >= 0 and y >= 0 and x < n and y < m:
                if graph[x][y] != 0 and not visited[x][y]:
                    visited[x][y] = True
                    que.append((x, y))
                    graph[x][y] = graph[curr[0]][curr[1]] + 1

for i in range(n):
    numbers = list(input())
    for j in range(m):
        graph[i][j] = int(numbers[j])

BFS(0, 0)

print(graph[n - 1][m - 1])