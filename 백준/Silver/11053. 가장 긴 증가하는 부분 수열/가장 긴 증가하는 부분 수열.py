n = int(input())
arr = list(map(int, input().split()))
dp = [1] * n

for i in range(1, n):
    Max = -1
    for j in range(i):
        if arr[j] < arr[i] and dp[j] >= Max:
            dp[i] = dp[j] + 1
            Max = dp[j]


print(max(dp))