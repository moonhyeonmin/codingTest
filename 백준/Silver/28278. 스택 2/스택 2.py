import sys
input = sys.stdin.readline

stack = []
com = [0]

N = int(input())
cnt = 0
tmp = 0

for i in range(N):
    com = list(map(int, input().split()))
    
    if com[0] == 1: # push
        stack.append(com[1])
        cnt += 1

    elif com[0] == 2: # pop
        if cnt > 0:
            tmp = stack.pop()
            print(tmp)
            cnt -= 1
        else:
            print(-1)
            
    elif com[0] == 3: # count
        print(cnt)

    elif com[0] == 4: # empty
        if cnt > 0:
            print(0)
        else:
            print(1)

    else: # top
        if cnt > 0:
            print(stack[-1])
        else:
            print(-1)
    