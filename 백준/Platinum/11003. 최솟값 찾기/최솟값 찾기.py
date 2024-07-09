from collections import deque
import sys

input = sys.stdin.readline

N, L = map(int, input().split())
arr = list(map(int, input().split()))

deq = deque()

for i in range(N):
    while deq and deq[-1][0] > arr[i]:
        deq.pop()
    deq.append((arr[i], i))
    if deq[0][1] <= i - L:
        deq.popleft()
    print(deq[0][0], end=' ')