stack = []

arr = list(input())

cnt = 0
pipe = 0

for i in range(len(arr)):
    if arr[i] == '(':
        stack.append(arr[i])
    elif arr[i] == ')':
        if arr[i-1] == '(':
            stack.pop()
            cnt += len(stack)
        else:
            stack.pop()
            cnt += 1

print(cnt)