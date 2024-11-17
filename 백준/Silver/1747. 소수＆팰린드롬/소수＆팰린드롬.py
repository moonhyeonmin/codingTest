import math
n = int(input())

arr = [0] * (10000000)
for i in range(2, len(arr)):
    arr[i] = i

for i in range(2, int(math.sqrt(len(arr)) + 1)):
    if arr[i] > 0:
        for j in range(i + i, len(arr), i):
            arr[j] = 0

for i in range(n, 10000001):
    if arr[i] != 0:
        reversed_num = int(str(arr[i])[::-1])
        if arr[i] == reversed_num:
            print(arr[i])
            break
        
        