n = int(input())
res = [0] * n
arr = list(map(int, input().split()))

for i in range(n):
    cnt = 0
    for j in range(n):
        if cnt == arr[i] and res[j] == 0:
            res[j] = i + 1
            break
        elif res[j] == 0:
            cnt += 1

print(*res)