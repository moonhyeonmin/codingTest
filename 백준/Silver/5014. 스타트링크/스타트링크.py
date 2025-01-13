from collections import deque
f, s, g, u, d = map(int, input().split())

visited = [False for _ in range(f + 1)]
cnt = [0 for _ in range(f + 1)]
df = [u, -1 * d]

def bfs(tar):
    que = deque()
    que.append(tar)
    visited[tar] = True
    res = 0

    while que:
        x = que.popleft()
        for i in range(2):
            nf = x + df[i]

            if nf > f or nf < 1 or visited[nf] is True:
                continue

            cnt[nf] = cnt[x] + 1
            visited[nf] = True
            que.append(nf)

bfs(s)
if visited[g] is True:
    print(cnt[g])
else:
    print("use the stairs")

