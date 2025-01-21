m, n = map(int, input().split())
stick = list(map(int, input().split()))

st = 1
en = max(stick)
res = 0

while st <= en:
    mid = (st + en) // 2
    cnt = 0
    for L in stick:
        cnt += L//mid

    if cnt >= m:
        res = max(res, mid)
        st = mid + 1
    else:
        en = mid - 1

print(res)