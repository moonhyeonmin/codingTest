h, w = map(int, input().split())
arr = list(map(int, input().split()))


res  = 0

for i in range(1, w - 1):
    left = max(arr[:i])
    right = max(arr[i + 1:])

    Min = min(left, right)
    if Min > arr[i]:
        res += Min - arr[i]

print(res)