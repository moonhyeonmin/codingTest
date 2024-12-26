n, m = map(int, input().split())
arr = [0] * m
visited = [False] * 10

def func(k, lim):
    if k == m:
        print(*arr)
        return

    for i in range(lim + 1, n + 1):
        if not visited[i]:
            arr[k] = i
            visited[i] = True
            func(k + 1, i)
            visited[i] = False

func(0, 0)
