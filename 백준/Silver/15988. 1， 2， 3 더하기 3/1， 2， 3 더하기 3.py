T = int(input())


arr= [int(input()) for _ in range(T)]


n = max(arr)

dp = [0] * n
dp[0] = 1
dp[1] = 2
dp[2] = 4

if n > 2:
    for i in range(3, n):
        dp[i] = dp[i - 1]+ dp[i - 2] + dp[i - 3]
        dp[i] %= 1000000009

for i in arr:
    print(dp[i - 1])