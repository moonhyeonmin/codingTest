from collections import deque

v = int(input())
arr = [[] for _ in range(v + 1)]

for _ in range(v): # arr에 그래프 데이터 저장
    data = list(map(int, input().split()))
    idx = 0
    s = data[idx]
    idx += 1
    while True:
        e = data[idx]
        if e == -1:
            break
        V = data[idx + 1]
        arr[s].append((e, V))
        idx += 2

visited = [False] * (v + 1)
distance = [0] * (v + 1)

def BFS(v):
    visited[v] = True
    que = deque()
    que.append(v)

    while que:
        curr = que.popleft()
        for i in arr[curr]:
            if not visited[i[0]]:
                visited[i[0]] = True
                que.append(i[0])
                distance[i[0]] = distance[curr] + i[1]

BFS(1)

max = 1

for i in range(2, v + 1):
    if distance[max] < distance[i]:
        max = i

visited = [False] * (v + 1)
distance = [0] * (v + 1)

BFS(max)
distance.sort()
print(distance[v])