n, d, k, c = map(int, input().split())



sushi = [int(input()) for _ in range(n)]
eat = sushi[:k]
res = 0

for i in range(n):
    eat.pop(0)
    eat.append(sushi[(i + k) % n])
    res = max(res, len(set(eat + [c])))
    if res == d:
        break
print(res)