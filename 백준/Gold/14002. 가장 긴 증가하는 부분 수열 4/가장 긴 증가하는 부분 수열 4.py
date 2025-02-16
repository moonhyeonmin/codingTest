import copy

n = int(input())
arr = list(map(int, input().split()))
dp = [[arr[i]] for i in range(n)]

for i in range(n):
    Max = -1
    for j in range(i):
        if arr[i] > arr[j] and len(dp[j]) >= Max:
            dp[i] = copy.deepcopy(dp[j])
            dp[i].append(arr[i])
            Max = len(dp[i])

max, max_idx = -1, 0
for i in range(n):
    if len(dp[i]) > max:
        max = len(dp[i])
        max_idx = i

print(max)
print(*dp[max_idx])