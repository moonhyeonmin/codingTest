import sys
input = sys.stdin.readline

n = int(input())
res = [0] * 2000001
for i in range(n):
    num = int(input())
    res[num + 1000000] += 1


for i in range(2000001):
    while res[i]:
        print(i - 1000000, end = ' ')
        res[i] -= 1
