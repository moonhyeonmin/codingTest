from collections import deque
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

n = int(input())
res = 0
arr = [list(input()) for _ in range(n)]

def check():
    global res

    for i in range(n):
        cnt = 1
        for j in range(n - 1):
            if arr[i][j] == arr[i][j + 1]:
                cnt += 1
                res = max(res, cnt)
            else:
                cnt = 1

    for i in range(n):
        cnt = 1
        for j in range(n - 1):
            if arr[j][i] == arr[j + 1][i]:
                cnt += 1
                res = max(res, cnt)
            else:
                cnt = 1

for i in range(n):
    for j in range(n - 1):
        arr[i][j], arr[i][j + 1] = arr[i][j + 1], arr[i][j]
        check()
        arr[i][j + 1], arr[i][j] = arr[i][j], arr[i][j + 1]

    for j in range(n - 1):
        arr[j][i], arr[j + 1][i] = arr[j + 1][i], arr[j][i]
        check()
        arr[j + 1][i], arr[j][i] = arr[j][i], arr[j + 1][i]

print(res)