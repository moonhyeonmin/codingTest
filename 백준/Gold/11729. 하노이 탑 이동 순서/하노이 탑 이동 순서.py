import sys
sys.setrecursionlimit(111111)

arr = []
cnt = 0
def hanoi(n, start, dest, sub):
    global cnt

    if n == 1:
        cnt += 1
        arr.append((start, dest))

        return
    hanoi(n - 1, start, sub, dest)

    arr.append((start, dest))
    cnt += 1
    hanoi(n - 1, sub, dest, start)

n = int(input())

hanoi(n, 1, 3, 2)
print(cnt)

for i in range(cnt):
    print(arr[i][0], end = ' ')
    print(arr[i][1])
