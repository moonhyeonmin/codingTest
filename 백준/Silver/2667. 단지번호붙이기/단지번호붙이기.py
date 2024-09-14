from collections import deque

n = int(input())
arr = [list(input()) for _ in range(n)]
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def bfs(c, r):
    que = deque()
    que.append((c, r))
    cnt = 1
    arr[r][c] = '0'

    while que:
        x, y = que.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            if arr[ny][nx] == '1':
                arr[ny][nx] = '0'
                que.append((nx, ny))
                cnt += 1

    return cnt

cnt1 = 0
result = []
for i in range(n):
    for j in range(n):
        if arr[i][j] =='1':
            cnt1 += 1
            result.append(bfs(j, i))
            

print(cnt1)
result.sort()
for i in result:
    print(i)