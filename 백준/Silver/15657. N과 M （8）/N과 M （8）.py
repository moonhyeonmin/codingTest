n, m = map(int, input().split())
arr = list(map(int, input().split()))

arr.sort()
res = []
visited = [False] * (n + 1)
def func(k, cnt):
    if k == m:
        print(*res)
        return

    for i in range(cnt, n):
        if not visited[i]:
            res.append(arr[i])
            func(k + 1, cnt)
            cnt += 1
            res.pop()

func(0, 0)