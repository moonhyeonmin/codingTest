N = int(input())
stack = []
result = [0 for _ in range(N)]

num = list(map(int, input().split()))


for i in range(N):
    tmp = num[i]
    cnt = 0
    while(stack):
        if stack[-1][1] >num[i]:
            result[i] = stack[-1][0] + 1
            break
        else:
            stack.pop()

    stack.append((i, num[i]))

print(*result)


