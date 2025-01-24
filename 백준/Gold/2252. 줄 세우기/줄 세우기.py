from collections import deque

n, m = map(int, input().split())

graph = [[] for _ in range(n + 1)]
indegree = [0] * (n + 1)
res = []

def topo_sort():
    que = deque()

    for i in range(1, n + 1):
        if indegree[i] == 0:
            que.append(i)

    while que:
        now = que.pop()
        res.append(now)
        for i in graph[now]:
            indegree[i] -= 1

            if indegree[i] == 0:
                que.append(i)

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    indegree[b] += 1

topo_sort()
print(*res)


