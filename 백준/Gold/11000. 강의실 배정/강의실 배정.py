import heapq
import sys
input = sys.stdin.readline

n = int(input())
cnt = 0
que = []

for _ in range(n):
    start, end = map(int, input().split())
    heapq.heappush(que, (start, end))

que.sort(key = lambda x : (x[0], x[1]))

heap = [que[0][1]] # 3
for i in range(1, n):
    if heap[0] <= que[i][0]:
        heapq.heappop(heap)
    heapq.heappush(heap, que[i][1])
print(len(heap))
