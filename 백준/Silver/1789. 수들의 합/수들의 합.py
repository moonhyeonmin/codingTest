n = int(input())
res = 0
cnt = 0

if n <= 2:
    print(1)
for i in range(1, n):
    res += i
    cnt += 1

    if res == n:
        print(cnt)
        break
    elif res > n:
        print(cnt - 1)
        break
