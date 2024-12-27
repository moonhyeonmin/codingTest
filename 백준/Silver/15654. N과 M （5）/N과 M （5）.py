n, m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
res = [0] * m
visited = [False] * (n + 1)



def func(k):
    if k == m:
        print(*res)
        return

    for i in range(n):
        if arr[i] in res:
            continue
        res[k] = arr[i]
        func(k + 1)
        res[k] = 0

func(0)

