n = int(input())

arr = []
for i in range(n):
    num = int(input())
    arr.append(num)
arr.sort()

maxVal = (2**62) * -1 - 1
maxCnt = 0
cnt = 0
for i in range(len(arr)):
    if i == 0 or arr[i - 1] == arr[i]:
        cnt += 1
    else:
        if maxCnt < cnt:
            maxCnt = cnt
            maxVal = arr[i - 1]
        cnt = 1
if cnt > maxCnt:
    maxVal = arr[n - 1]


print(maxVal)
