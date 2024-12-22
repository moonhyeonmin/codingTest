import sys
sys.setrecursionlimit(111111111)

A, B, C = map(int, input().split())

def result(a, b, c):
    if b == 1:
        return a % c
    res = result(a, b // 2, c)
    res = res * res % c
    if b % 2 == 0:
        return res
    return res * a % c

print(result(A, B, C))