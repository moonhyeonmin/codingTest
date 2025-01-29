from collections import deque

n, m = map(int, input().split())
arr = [list(map(int, input())) for _ in range(n)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
visited = [[[0] * 2 for _ in range(m)] for _ in range(n)]
visited[0][0][0] = 1


def bfs(x, y, z):
    que = deque()
    que.append((x, y, z))

    while que:
        x, y, z = que.popleft()

        if x == n - 1 and y == m - 1:
            return visited[x][y][z]
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 > nx or nx >= n or 0 > ny or ny >= m:
                continue
            if arr[nx][ny] == 1 and z == 0: # 다음 이동할 곳이 벽 + 벽 부술 기회 사용 X
                visited[nx][ny][1] = visited[x][y][z] + 1
                que.append((nx, ny, 1))

            elif arr[nx][ny] == 0 and visited[nx][ny][z] == 0: # 다음 이동할 곳이 벽이 아님 + 아직 한 번도 방문 X
                visited[nx][ny][z] = visited[x][y][z] + 1
                que.append((nx, ny, z))
    return -1

print(bfs(0, 0, 0))
# if flag == 0:
#     print(-1)
# else:
#     print(max)
