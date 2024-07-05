N = int(input())
sum = 0
cnt = 1
start = 0
end = 0

while end != N:
    if sum == N:
        cnt += 1
        end += 1
        sum += end
        
    elif sum > N:
        sum -= start
        start += 1
        
    else:
        end += 1
        sum += end
        
    
print(cnt)