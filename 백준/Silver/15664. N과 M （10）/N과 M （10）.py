n, m = map(int, input().split())
arr = list(map(int, input().split()))

arr.sort()
res = []
visited = [False] * (n + 1)


def func(k, cnt):
    check = 0
    if k == m:
        print(*res)
        return

    for i in range(cnt, n):
        if not visited[i] and check != arr[i]:
            res.append(arr[i])
            visited[i] = True
            check = arr[i]
            func(k + 1, cnt)
            visited[i] = False
            res.pop()
        cnt += 1

func(0, 0)