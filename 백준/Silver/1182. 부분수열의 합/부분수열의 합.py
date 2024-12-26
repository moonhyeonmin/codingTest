n, s = map(int, input().split())
arr = list(map(int, input().split()))
cnt = 0

def func(k, sum):
    global cnt
    if k == n:
        if sum == s:
            cnt += 1
        return

    func(k + 1, sum)
    func(k + 1, sum + arr[k])

func(0, 0)
if s == 0:
    cnt -= 1
print(cnt)

