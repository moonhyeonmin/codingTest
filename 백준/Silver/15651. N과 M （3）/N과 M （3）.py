n, m = map(int, input().split())
result = [0] * m
visited = [False] * (n + 1)

def func(k):
    if k == m:
        print(*result)
        return

    for i in range(1, n + 1):
        result[k] = i
        visited[k] = True
        func(k + 1)
        visited[k] = False

func(0)