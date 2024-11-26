from collections import deque

n = int(input())
dx = [-2, -2, -1, -1, 1, 1, 2, 2]
dy = [1, -1, 2, -2, 2, -2, 1, -1]
for _ in range(n):
    size = int(input())
    visited = [[0 for _ in range(size)] for _ in range(size)]
    now_x, now_y = map(int, input().rstrip().split())
    go_x, go_y = map(int, input().rstrip().split())
    flag = 0

    if now_x == go_x and now_y == go_y:
        print(0)
    else:
        que = deque()
        que.append((now_x, now_y))

        while que:
            x, y = que.popleft()
            for i in range(8):
                nx = x + dx[i]
                ny = y + dy[i]

                if nx < 0 or nx >= size or ny < 0 or ny >= size:
                    continue
                if visited[nx][ny] != 0:
                    continue

                visited[nx][ny] = visited[x][y] + 1
                que.append((nx, ny))

                if nx == go_x and ny == go_y:
                    flag = 1
                    break
            if flag == 1:
                break
        print(visited[go_x][go_y])