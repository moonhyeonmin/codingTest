n, m = map(int, input().split())
result = [0] * m
visited = [False] * (n + 1)

def func(k, lim):
    if k == m:
        print(*result)
        return

    for i in range(1, n + 1):
        if lim <= i:
            visited[k] = True
            result[k] = i
            func(k + 1, i)
            visited[k] = False

func(0, 0)
