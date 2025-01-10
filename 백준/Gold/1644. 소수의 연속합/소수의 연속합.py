import math
import sys
n = int(input())
arr = [1] * (n + 1)

if n == 1:
    print(0)
    sys.exit()
    
for i in range(2, int(math.sqrt(n) + 1)):
    if arr[i] > 0:
        for j in range(i + i, n + 1, i):
            arr[j] = 0

prime = []
for i in range(2, n + 1):
    if arr[i] > 0:
        prime.append(i)


en = 1
sum = prime[0]
len_prime = len(prime)
cnt = 0
for st in range(len_prime):
    while en < len_prime and sum < n:
        sum += prime[en]
        en += 1
    if sum == n:
        cnt += 1
    if en > len_prime:
        break
    sum -= prime[st]

# if n in prime:
#     cnt += 1
print(cnt)