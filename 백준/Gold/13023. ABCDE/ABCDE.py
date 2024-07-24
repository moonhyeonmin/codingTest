import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [[] for _ in range(n)]
visited = [False] * (n)
flag = 0

def DFS(v, depth):
    global flag
    if depth == 4:
        flag = 1
        return
    
    visited[v] = True
    for i in graph[v]:
        if not visited[i]:
            DFS(i, depth + 1)
    visited[v] = False # 이거 한 싸이클 검사하고 또 다른 사이클에 이미 포함된 노드가 순회될 수 있어서 그러는건가?
    
for _ in range(m):
    s, e = map(int, input().split())
    graph[s].append(e)
    graph[e].append(s)

for i in range(n):
    DFS(i, 0)
    if flag == 1:
        break

if flag == 1:
    print(1)
else:
    print(0)