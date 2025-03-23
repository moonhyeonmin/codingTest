from itertools import combinations

arr = list(input())
ind = []
stack = []
res = set()

for i in range(len(arr)):
    if arr[i] == '(':
        stack.append(i)

    elif arr[i] == ')':
        ind.append((stack.pop(), i))

for i in range(len(ind)):
    for comb in combinations(ind, i + 1):
        # print(comb)
        tmp = arr[:]
        for idx in comb:
            tmp[idx[0]] = tmp[idx[1]] = ""
            # print(tmp)
        res.add("".join(tmp))

for item in sorted(list(res)):
    print(item)

