import math
n, m = map(int, input().split())

arr = [0] * (10000001)
for i in range(2, len(arr)):
    arr[i] = i

for i in range(2, int(math.sqrt(len(arr)) + 1)):
    if arr[i] > 0:
        for j in range(i + i, len(arr), i):
            arr[j] = 0

cnt = 0
for i in arr:
    if i != 0:
        tmp = i
        while i <= m / tmp:
            if i >= n / tmp:
                cnt += 1
            tmp *= i
print(cnt)
