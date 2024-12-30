n = int(input())
R = [0]
G = [0]
B = [0]
d = [[0] * 3 for _ in range(1005)]

for i in range(n):
    r, g, b = list(map(int, input().split()))

    R.append(r)
    G.append(g)
    B.append(b)

d[1][0] = R[1]
d[1][1] = G[1]
d[1][2] = B[1]

for i in range(2, n + 1):
    d[i][0] = min(d[i - 1][1], d[i - 1][2]) + R[i]
    d[i][1] = min(d[i - 1][0], d[i - 1][2]) + G[i]
    d[i][2] = min(d[i - 1][0], d[i - 1][1]) + B[i]
print(min(d[n]))

