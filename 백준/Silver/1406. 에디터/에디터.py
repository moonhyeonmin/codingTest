import queue
import sys
input = sys.stdin.readline

arr = list(input().rstrip())
tmp = []

n = int(input())
for _ in range(n):
    com = list(input().split())


    if com[0] == 'L':
        if len(arr) != 0:
            tmp.append(arr.pop())

    elif com[0] == 'D':
        if len(tmp) != 0:
            arr.append(tmp.pop())

    elif com[0] == 'B':
        if len(arr) != 0:
            arr.pop()
    elif com[0] == 'P':
        arr.append(com[1])

while len(tmp) != 0:
    arr.append(tmp.pop())

print(*arr, sep="")