n = int(input())

road = list(map(int, input().split()))
price = list(map(int, input().split()))

Min = 10001
for i in range(n - 1):
    if Min > price[i]:
        Min = price[i]
        Min_idx = i


dis = 0
res = 0
for i in range(Min_idx, n - 1):
    dis += road[i]
res = dis * price[Min_idx]
for i in range(Min_idx):
    res += road[i] * price[i]

print(res)