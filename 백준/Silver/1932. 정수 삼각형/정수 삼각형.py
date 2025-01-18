n = int(input())


tri = []
for i in range(n):
    arr = list(map(int, input().split()))
    tri.append(arr)


dp = [[0] * n for _ in range(n)]
dp[0][0] = tri[0][0]
for i in range(1, n):
    for j in range(i + 1):
        if 0 < j < i:
            dp[i][j] = max(dp[i - 1][j - 1] + tri[i][j], dp[i - 1][j] + tri[i][j])
        elif j == 0:
            dp[i][j] = dp[i - 1][j] + tri[i][j]
        else:
            dp[i][j] = dp[i - 1][j - 1] + tri[i][j]

print(max(dp[n - 1]))