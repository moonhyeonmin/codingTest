import sys
input = sys.stdin.readline
n, m = map(int, input().split())

arr = [[0] * (n + 1)]
arr_sum = [[0] * (n + 1) for _ in range(n + 1)]

for i in range(n):
    arr_row = [0] + [int(x) for x in input().split()]
    arr.append(arr_row)

for i in range(1, n + 1):
    for j in range(1, n + 1):
        arr_sum[i][j] = arr_sum[i][j - 1] + arr_sum[i - 1][j] - arr_sum[i - 1][j - 1] + arr[i][j]

for _ in range(m):
    x1, y1, x2, y2 = map(int, input().split())

    result = arr_sum[x2][y2] - arr_sum[x1 - 1][y2] - arr_sum[x2][y1 - 1] + arr_sum[x1 - 1][y1 - 1]
    print(result)
