from collections import deque

visited = [0] * (10 ** 5 + 1)

def bfs(visited):
    que = deque()
    que.append(N)

    while que:
        tmp = que.popleft()
        if tmp == K:
            return visited[tmp]
        for i in (tmp - 1, tmp + 1, tmp * 2):
            if 0 <= i <= (10 ** 5) and not visited[i]:
                visited[i] = visited[tmp] + 1
                que.append(i)

N, K = map(int, input().split())

print(bfs(visited))