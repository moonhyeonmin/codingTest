import sys
sys.setrecursionlimit(1000000)

N = int(input())
arr_N = list(map(int, input().split()))
M = int(input())
arr_M = list(map(int, input().split()))

dic = {}
for i in arr_N:
    if i in dic:
        dic[i] += 1
    else:
        dic[i] = 1

for tar in arr_M:
    res = dic.get(tar)
    if res is None:
        print(0, end = " ")
    else:
        print(res, end = " ")