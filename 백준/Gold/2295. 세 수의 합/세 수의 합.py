import sys

n = int(input())

def binary_search(start, end, tar):
    if start > end:
        return -1

    mid = (start + end) // 2
    if sum[mid] > tar:
        end = mid - 1
    elif sum[mid] < tar:
        start = mid + 1
    else:
        return mid

    return binary_search(start, end, tar)

arr = []
for i in range(n):
    num = int(input())
    arr.append(num)

arr.sort()

sum = []
for x in arr:
    for y in arr:
        sum.append(x + y)

sum.sort()
max = -1
for i in range(n - 1, -1, -1):
    for j in range(i):
        flag = binary_search(0, len(sum) - 1, arr[i] - arr[j])
        if flag != -1:
            print(arr[i])
            sys.exit()


