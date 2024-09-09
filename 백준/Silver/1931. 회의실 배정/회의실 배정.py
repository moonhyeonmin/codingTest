from queue import PriorityQueue
import sys
input = sys.stdin.readline

que = PriorityQueue()
n = int(input())
cnt, start_time = 0, 0

for _ in range(n):
    start, end = map(int, input().split())
    que.put((end, start))

while que.qsize() > 0:
    tmp = que.get()
    
    if start_time <= tmp[1]:
        start_time = tmp[0]
        cnt += 1

print(cnt)