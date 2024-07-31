import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))

start, end = max(arr), sum(arr)


while start <= end: 
    mid = int((start + end) / 2)
    sum, cnt = 0, 0
    
    for i in range(n):
        if sum + arr[i] > mid:
            cnt += 1
            sum = 0
        sum += arr[i]
    if sum != 0:
        cnt += 1

    if cnt > m:
        start = mid + 1
    else:
        end = mid - 1

print(start)
        
