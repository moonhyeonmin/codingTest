import sys
from bisect import bisect_left
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
dp = [arr[0]]

for item in arr:
    if dp[-1] < item:
        dp.append(item)

    else:
        idx = bisect_left(dp, item)
        dp[idx] = item

print(len(dp))