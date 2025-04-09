n, k = map(int, input().split())
arr = [int(input()) for _ in range(n)]


dp = [100001 for _ in range(k + 1)]
dp[0] = 0
    

for i in arr:
    for j in range(i, k + 1):
        dp[j] = min(dp[j], 1 + dp[j - i])

if dp[k] == 100001:
    print(-1)
else:
    print(dp[k])