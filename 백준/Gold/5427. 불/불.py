import sys
from collections import deque


dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
n = int(input())

for i in range(n):
    que_per = deque()
    que_fire = deque()
    arr = []
    flag = 0
    w, h = map(int, input().split())
    visited_per = [[-1 for _ in range(1001)] for _ in range(1001)]
    visited_fire = [[-1 for _ in range(1001)] for _ in range(1001)]

    for j in range(h):
        arr.append(input().rstrip())

    for j in range(h):
        for k in range(w):
            if arr[j][k] == '*':
                que_fire.append((j, k))
                visited_fire[j][k] = 0
            elif arr[j][k] == '@':
                que_per.append((j, k))
                visited_per[j][k] = 0

    while que_fire:
        x, y = que_fire.popleft()
        for j in range(4):
            nx = x + dx[j]
            ny = y + dy[j]

            if nx < 0 or nx >= h or ny < 0 or ny >= w:
                continue
            if visited_fire[nx][ny] > -1 or arr[nx][ny] != '.':
                continue

            visited_fire[nx][ny] = visited_fire[x][y] + 1
            que_fire.append((nx, ny))

    while que_per:
        x, y = que_per.popleft()
        for j in range(4):
            nx = x + dx[j]
            ny = y + dy[j]

            if nx < 0 or nx >= h or ny < 0 or ny >= w:
                print(visited_per[x][y] + 1)# 프린트 해야함
                flag = 1
                break
            if visited_per[nx][ny] > -1 or arr[nx][ny] != '.':
                continue
            if visited_fire[nx][ny] != -1 and visited_fire[nx][ny] <= visited_per[x][y] + 1:
                continue

            visited_per[nx][ny] = visited_per[x][y] + 1
            que_per.append((nx, ny))

        if flag == 1:
            break

    if flag == 0:
        print('IMPOSSIBLE')