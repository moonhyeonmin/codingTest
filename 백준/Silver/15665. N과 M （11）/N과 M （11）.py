n, m = map(int, input().split())
arr = list(map(int, input().split()))

arr.sort()
res = []
visited = [False] * (n + 1)


def func(k):
    check = 0
    if k == m:
        print(*res)
        return

    for i in range(n):
        if not visited[i] and check != arr[i]:
            res.append(arr[i])
            check = arr[i]
            func(k + 1)
            visited[i] = False
            res.pop()

func(0)