n = int(input())

arr = list(input())
res = 0

for _ in range(n - 1):
    compare = arr[:]
    problem = input()
    cnt = 0

    for prob in problem:
        if prob in compare:
            compare.remove(prob)
        else:
            cnt += 1

    if cnt < 2 and len(compare) < 2:
        res += 1

print(res)