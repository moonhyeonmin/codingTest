visited1 = [False] * 40
visited2 = [False] * 40
visited3 = [False] * 40

n = int(input())
cnt = 0

def func(k):
    global cnt

    if k == n:
        cnt += 1
        return

    for i in range(n):
        if not visited1[i] and not visited2[i + k] and not visited3[k - i + n - 1]:
            visited1[i] = True
            visited2[k + i] = True
            visited3[k - i + n - 1] = True
            func(k + 1)
            visited1[i] = False
            visited2[i + k] = False
            visited3[k - i + n - 1] = False


func(0)
print(cnt)

