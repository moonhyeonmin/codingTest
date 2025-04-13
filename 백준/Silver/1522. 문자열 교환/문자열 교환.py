from itertools import count

arr = input()

left = 0
right = arr.count('a')
res = 1001

if right == 0:
    print(0)
else:
    for _ in range(len(arr)):
        if left % len(arr) < right % len(arr):
            res = min(res, arr.count('b', left % len(arr), right % len(arr)))
        else:
            tmp = arr.count('b', left % len(arr), len(arr))
            tmp += arr.count('b', 0, right % len(arr))
            res = min(res, tmp)

        left += 1
        right += 1

    print(res)