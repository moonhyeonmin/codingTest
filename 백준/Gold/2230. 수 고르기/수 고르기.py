n, m = map(int, input().split())

arr = []
for i in range(n):
    num = int(input())
    arr.append(num)

def lower_idx(tar, len):
    start = 0
    end = len

    while start < end:
        mid = (start + end) // 2
        if arr[mid] >= tar:
            end = mid
        else:
            start = mid + 1

    return start

arr.sort()
min = int(2e9 + 1)
for i in range(n):
    flag = lower_idx(arr[i] + m, n)
    if flag < n:
        if arr[flag] - arr[i] < min:
            min = arr[flag] - arr[i]


print(min)