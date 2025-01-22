import heapq


# n = int(input())
# max_heap = [[] for _ in range(n)]
# arr = []
# for i in range(n):
#     arr = list(map(int, input().split()))
#     for j in range(n):
#         heapq.heappush(max_heap[j], (-arr[j], arr[j]))
#
# for i in range(n):
#     max = -1
#     for j in range(n):
#         if max < max_heap[j][0][1]:
#             max = max_heap[j][0][1]
#             max_idx = j
#
#     res = heapq.heappop(max_heap[max_idx])
#
# print(res[1])

n = int(input())
heap = []
for _ in range(n):
    for elem in list(map(int, input().split())):
        heapq.heappush(heap, elem)
        if len(heap) > n:
            heapq.heappop(heap)

print(heap[0])