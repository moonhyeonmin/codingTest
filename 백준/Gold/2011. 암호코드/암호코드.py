import sys
sys.setrecursionlimit(111111)
input = sys.stdin.readline

data = list(map(int, input().rstrip()))
dp = [0] * (len(data) + 1)
dp[0] = 1
dp[1] = 1

if data[0] == 0:
    print(0)
else:
    for i in range(1, len(data)):
        k = i + 1
        if data[i] > 0:
            dp[k] += dp[k - 1]
        if 10 <= data[i] + data[i - 1] * 10 <= 26:
            dp[k] += dp[k - 2]

    print(dp[len(data)] % 1000000)