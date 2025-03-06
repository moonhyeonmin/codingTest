n = int(input())

road = list(map(int, input().split()))
price = list(map(int, input().split()))

Min = price[0]
res = 0
for i in range(n - 1):
    if Min > price[i]:
        Min = price[i]

    res += Min * road[i]

print(res)