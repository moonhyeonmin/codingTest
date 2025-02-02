def binary_search(st, en):
    global max

    if st > en:
        return en

    sum = 0
    mid = (st + en) // 2
    for money in budget:
        if money > mid:
            sum += mid
        else:
            sum += money

    if sum > max_budget:
        en = mid - 1
    elif sum < max_budget:
        st = mid + 1
    else:
        return mid

    return binary_search(st, en)

n = int(input())
budget = list(map(int, input().split()))
max = -1
max_budget = int(input())
budget.sort()

print(binary_search(1, budget[n - 1]))

