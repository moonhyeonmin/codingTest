import sys
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
arr.sort()


cnt = 0

for k in range(N):
    start = 0
    end = N - 1
    find = arr[k]
    while start < end:
        if arr[start] + arr[end] == find:
            if start != k and end != k:
                cnt += 1
                break
            elif start == k:
                start += 1
            elif end == k:
                end -= 1
        elif arr[start] + arr[end] > find:
            end -= 1
        else:
            start += 1
        

        
print(cnt)