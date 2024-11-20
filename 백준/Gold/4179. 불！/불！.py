import sys
from collections import deque

arr = []
n, m = map(int, input().split())
for i in range(n):
    arr.append(list(input().rstrip()))

visited_fire = [[-1 for _ in range(1001)] for _ in range(1001)]
visited_person = [[-1 for _ in range(1001)] for _ in range(1001)]
que_fire = deque()
que_person = deque()

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for i in range(n):
    for j in range(m):
        if arr[i][j] == 'F':
            que_fire.append((i, j))
            visited_fire[i][j] = 0
        elif arr[i][j] == 'J':
            que_person.append((i, j))
            visited_person[i][j] = 0

while que_fire:
    x, y = que_fire.popleft()
    for k in range(4):
        nx = x + dx[k]
        ny = y + dy[k]
        if nx < 0 or nx >= n or ny < 0 or ny >= m:
            continue
        if visited_fire[nx][ny] >= 0 or arr[nx][ny] == '#':
            continue

        visited_fire[nx][ny] = visited_fire[x][y] + 1
        que_fire.append((nx, ny))

while que_person:
    x, y = que_person.popleft()
    for k in range(4):
        nx = x + dx[k]
        ny = y + dy[k]
        if nx < 0 or nx >= n or ny < 0 or ny >= m:
            print(visited_person[x][y] + 1)
            sys.exit()

        if visited_person[nx][ny] >= 0 or arr[nx][ny] == '#':
            continue
        if visited_fire[nx][ny] != -1 and visited_fire[nx][ny] <= visited_person[x][y] + 1:
            continue

        visited_person[nx][ny] = visited_person[x][y] + 1
        que_person.append((nx, ny))

print("IMPOSSIBLE")


