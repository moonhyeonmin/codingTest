n = int(input())

arr = []
for i in range(n):
    m = int(input())
    arr.append(m)

max = 20001
cnt = 0
for i in range(n - 1, -1, -1):
    if arr[i] < max:
        max = arr[i]
    elif arr[i] >= max:
        while arr[i] >= max:
            arr[i] -= 1
            cnt += 1
        max = arr[i]

print(cnt)