# 17298번

n = int(input())

arr = list(map(int, input().split()))

result = [0] * n
stack = []

for i in range(n):
    while len(stack) != 0 and arr[stack[-1]] < arr[i]:
        result[stack.pop()] = arr[i]
    stack.append(i)
    
while len(stack) != 0:
    result[stack.pop()] = -1
    
print(*result, end = ' ')