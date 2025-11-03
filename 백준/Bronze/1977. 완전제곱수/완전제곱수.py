M = int(input())
N = int(input())

cnt = 0
sum = 0
min = -1

for i in range(M, N + 1):
    for j in range(1, i + 1):
        if pow(j, 2) == i:
            cnt += 1
            sum += i
            if cnt == 1:
                min = i
                
if min == -1:
    print(-1)

else:
    print(sum)
    print(min)