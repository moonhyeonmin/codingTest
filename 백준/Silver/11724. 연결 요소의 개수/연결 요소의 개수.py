import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline

N, M = map(int, input().split())
arr = [[] for _ in range(N + 1)]
visited = [False] * (N + 1)

def DFS(v):
    visited[v] = True
    for i in arr[v]:
        if not visited[i]:
            DFS(i)

for _ in range(M):
    s, e = map(int, input().split())
    arr[s].append(e)
    arr[e].append(s)

cnt = 0

for i in range(1, N + 1):

    if not visited[i]:
        cnt += 1
        DFS(i)

print(cnt)
