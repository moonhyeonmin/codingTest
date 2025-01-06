n = int(input())

arr = []
for i in range(n):
    t = int(input())
    res = 0
    max = 0
    arr = list(map(int, input().rstrip().split()))

    for j in range(len(arr) - 1, -1, -1):
        if arr[j] > max:
            max = arr[j]
        else:
            res += max - arr[j]

    print(res)