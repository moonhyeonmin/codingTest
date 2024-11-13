stack = []
arr = []
n = int(input())
tmp = 0

for i in range(n):
    arr.append(int(input()))

for i in range(n):
    while stack and stack[-1] <= arr[i]:
        stack.pop()

    stack.append(arr[i])
    tmp += len(stack) -1 

print(tmp)
    
