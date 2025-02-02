def binary_search(st, en):
    sum = 0
    if st > en:
        return en

    mid = (st + en) // 2
    for hei in height:
        if hei >= mid:
            sum += (hei - mid)

    if sum == m:
        return mid
    elif sum > m:
        st = mid + 1
    else:
        en = mid - 1

    return binary_search(st, en)

n, m = map(int, input().split())
height = list(map(int, input().split()))

print(binary_search(1, max(height)))