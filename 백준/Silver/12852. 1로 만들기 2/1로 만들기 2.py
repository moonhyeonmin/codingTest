import sys
n = int(input())

d = [0] * (n + 5)
route = [0] * (n + 5)

d[1] = 0
for i in range(2, n + 1):
    d[i] = d[i - 1] + 1
    route[i] = i - 1

    if i % 2 == 0 and d[i // 2] + 1 < d[i]:
        d[i] = d[i // 2] + 1
        route[i] = i // 2

    if i % 3 == 0 and d[i // 3] + 1 < d[i]:
        d[i] = d[i // 3] + 1
        route[i] = i // 3

cur = n
print(d[n])

while True:
    print(cur, end = ' ')
    if cur == 1:
        break
    cur = route[cur]
