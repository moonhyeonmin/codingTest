arr = input()

tmp = 1
res = 0
stack = []
for i in range(len(arr)):
    if arr[i] == '(':
        stack.append(arr[i])
        tmp *= 2

    elif arr[i] == '[':
        stack.append(arr[i])
        tmp *= 3

    elif arr[i] == ')':
        if not stack or stack[-1] == '[':
            res = 0
            break

        if arr[i - 1] == '(':
            res += tmp
        tmp //= 2
        stack.pop()

    else:
        if not stack or stack[-1] == '(':
            res = 0
            break

        if arr[i - 1] == '[':
            res += tmp
        tmp //= 3
        stack.pop()


if stack:
    print(0)
else:
    print(res)