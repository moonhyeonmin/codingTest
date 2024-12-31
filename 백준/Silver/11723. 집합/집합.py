import sys
input = sys.stdin.readline

S = set()

n = int(input())
for i in range(n):
    com = input().split()
    if com[0] == 'add':
        num = int(com[1])
        S.add(num)
    elif com[0] == 'remove':
        num = int(com[1])
        S.discard(num)
    elif com[0] == 'check':
        num = int(com[1])
        if num in S:
            print(1)
        else:
            print(0)

    elif com[0] == 'toggle':
        num = int(com[1])
        if num in S:
            S.remove(num)
        else:
            S.add(num)
    elif com[0] == 'all':
        S = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}

    elif com[0] == 'empty':
        S = set()
