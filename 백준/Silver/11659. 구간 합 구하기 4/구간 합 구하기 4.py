import sys
input = sys.stdin.readline

n, m = map(int, input().split())
number = list(map(int, input().split()))
sum_number = [0]
tmp = 0

for i in number:
    tmp = tmp + int(i)
    sum_number.append(tmp)

for i in range (0, m):
    s, e = map(int, input().split())
    
    if(s > 1):
        print(sum_number[e] - sum_number[s-1])
    else:
        print(sum_number[e])
    