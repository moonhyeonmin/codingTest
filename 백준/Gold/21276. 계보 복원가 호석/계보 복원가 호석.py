from collections import deque, defaultdict

def topo_sort():
    for i in name:
        res[i].append(0)
        if indegree[i] == 0:
            que.append(i)
            visited[i] = True

    print(len(que))
    print(*sorted(que), end = ' ')
    print()

    while que:
        now = que.pop()

        for item in graph[now]:
            indegree[item] -= 1

            if indegree[item] == 0:
                res[now].append(item)
                que.append(item)


    sorted_res = list(sorted(res.items()))

    for item in sorted_res:
        item[1].pop(0)
        print(item[0], len(item[1]), end = ' ')
        if item[1] != 0:
            print(*sorted(item[1]))




n = int(input())
name = list(map(str, input().split()))
graph = defaultdict(list)
visited = defaultdict(bool)
que = deque()
res = defaultdict(list)
indegree = defaultdict(int)

m = int(input())
for _ in range(m):
    child, ancestor = map(str, input().split())
    graph[ancestor].append(child)
    indegree[child] += 1


topo_sort()

