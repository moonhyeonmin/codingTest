import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))

M = int(input())
find = list(map(int, input().split()))

def binary(l, r, tar):
    if l > r:
        return 0
    
    m = (l + r) // 2
    if A[m] == tar:
        return 1
    elif A[m] > tar:
        return binary(l, m - 1, tar)
    else:
        return binary(m + 1, r, tar)

last = len(A) - 1
A = sorted(A)

for i in find:
    result = binary(0, last, i)
    print(result)


