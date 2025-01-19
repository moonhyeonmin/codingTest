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
            visited[i] = True
            cnt += 1
            func(k + 1, cnt)
            res.pop()
            visited[i] = False

func(0, 0)