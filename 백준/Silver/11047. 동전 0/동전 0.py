import sys
input = sys.stdin.readline

n, k = map(int, input().split())
price = []
cnt = 0

for _ in range(n):
    price.append(int(input()))

for i in range(n - 1, -1, -1):
    if k >= price[i]:
        cnt += int(k / price[i])
        k %= price[i]

print(cnt)