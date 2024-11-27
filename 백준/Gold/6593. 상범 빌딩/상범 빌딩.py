from collections import deque
import sys

dx = [-1, 1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]
dz = [0, 0, 0, 0, -1, 1]

def bfs(l, r, c):
    que = deque()
    que.append((l, r, c))
    flag = 0
    flag1 = 0

    while que:
        z, x, y = que.popleft()


        for k in range(6):
            nx = x + dx[k]
            ny = y + dy[k]
            nz = z + dz[k]

            if nx < 0 or nx >= R or ny < 0 or ny >= C or nz < 0 or nz >= L:
                continue
            if arr[nz][nx][ny] == '#' or visited[nz][nx][ny] != 0:
                continue

            visited[nz][nx][ny] = visited[z][x][y] + 1
            que.append((nz, nx, ny))

            if arr[nz][nx][ny] == 'E':
                res ='Escaped in ' + str(visited[nz][nx][ny]) + ' minute(s).'
                print(res)
                flag = 1
                break
        if flag == 1:
            break
    if flag == 0:
        print('Trapped!')

while True:
    L, R, C = map(int, input().split())
    arr = []
    visited = [[[0] * C for _ in range(R)] for _ in range(L)]

    if L == 0 and R == 0 and C == 0:
        break

    for i in range(L):
        arr.append([list(input().strip()) for _ in range(R)])
        temp = input()

    for i in range(L):
        for j in range(R):
            for k in range(C):
                if arr[i][j][k] == 'S':
                    bfs(i, j, k)



# 3 4 5
# S....
# .###.
# .##..
# ###.#
#
# #####
# #####
# ##.##
# ##...
#
# #####
# #####
# #.###
# ####E