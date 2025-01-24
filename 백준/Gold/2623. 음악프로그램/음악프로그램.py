from collections import deque

def topo_sort():
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

n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]
que = deque()
res = []
indegree = [0] * (n + 1)

for _ in range(m):
    arr = list(map(int, input().split()))
    for i in range(1, len(arr) - 1, 1):
        graph[arr[i]].append(arr[i + 1])
        indegree[arr[i + 1]] += 1


topo_sort()
if len(res) != n:
    print(0)
else:
    for item in res:
        print(item)
