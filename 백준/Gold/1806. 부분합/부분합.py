n, s = map(int, input().split())
arr = list(map(int, input().split()))

sum = arr[0]
en = 0
min = int(2e9 + 1)
for st in range(n):
    while en < n and sum < s:
        en += 1
        if en != n:
            sum += arr[en]
    if en == n:
        break
    if en - st + 1 < min:
        min = en - st + 1
    sum -= arr[st]

if min == int(2e9 + 1):
    min = 0
print(min)