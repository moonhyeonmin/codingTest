import sys
input = sys.stdin.readline

N = int(input())
M = int(input())
arr = list(map(int, input().split()))
arr.sort()

start = 0
end = N - 1
cnt = 0


while start < end:
    if arr[start] + arr[end] == M:
        start += 1
        end -= 1
        cnt += 1
    
    elif arr[start] + arr[end] > M:
        end -= 1
    
    else:
        start += 1
        
print(cnt)
