import math
n = int(input())
num = []

def solve(m, n, x, y):
    if x == m:
        x = 0
    if y == n:
        y = 0
    l = math.lcm(m, n)

    for i in range(x, l + 1, m):
        if i == 0:
            continue
        if i % n == y:
            return i
    return -1


for i in range(n):
    num = list(map(int, input().split()))
    res = solve(num[0], num[1], num[2], num[3])
    print(res)
