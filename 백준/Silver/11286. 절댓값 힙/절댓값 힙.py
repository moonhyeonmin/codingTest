from queue import PriorityQueue
import sys
input = sys.stdin.readline
N = int(input())

que = PriorityQueue()

for i in range(N):
    x = int(input())
    if x != 0:
        que.put((abs(x), x))
        
    else:
        if que.empty():
            print(0)
        else:
            print(que.get()[1])

