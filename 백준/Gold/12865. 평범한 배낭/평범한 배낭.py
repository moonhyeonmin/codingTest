n, k = map(int, input().split())

arr = []
for i in range(n):
    w, v = map(int, input().split())
    arr.append((w, v))

dp = [0 for _ in range(k + 1)]

for i in arr:
    w, v = i
    for j in range(k, w - 1, -1):
        dp[j] = max(dp[j], dp[j - w] + v)

print(dp[-1])