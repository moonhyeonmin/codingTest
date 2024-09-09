from queue import PriorityQueue
import sys
input = sys.stdin.readline

que = PriorityQueue()
sum = 0

n = int(input())

for i in range(n):
    tmp = int(input())
    que.put((tmp, -tmp))

while que.qsize() > 1:
    tmp1 = que.get()[0]
    tmp2 = que.get()[0]
    sum += tmp1 + tmp2
    que.put((tmp1 + tmp2, -(tmp1 + tmp2)))

print(sum)


