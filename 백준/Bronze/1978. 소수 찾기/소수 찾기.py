n = int(input())
arr = list(map(int, input().split()))

def check(num):
    if num == 1:
        return 0
    i = 2
    while i * i <= num:
        if num % i == 0:
            return 0
        i += 1
    return 1

cnt = 0
for num in arr:
    flag = check(num)
    if flag == 1:
        cnt += 1

print(cnt)