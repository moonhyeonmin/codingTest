n = int(input())
arr = list(map(int, input().split()))

cnt = 0
en = 0
visited = [False] * 100005

for st in range(n):
    while st <= en < n:
        if not visited[arr[en]]:
            visited[arr[en]] = True
            en += 1
            cnt += en - st
        else:
            visited[arr[st]] = False
            st += 1


print(cnt)