import sys
input = sys.stdin.readline


n = int(input())

result = [0] * (n + 1)

for i in range(1, n + 1):
    t, p = map(int, input().split())
    result[i] = max(result[i - 1], result[i])
    if i + t <= n + 1:
        result[i + t - 1] = max(result[i - 1] + p, result[i + t - 1])


    


print(result[-1])