n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
arr_up = []


for i in range(n):
    for j in range(2):
        Max = max(arr[i])
        arr[i].remove(Max)
    print(max(arr[i]))



