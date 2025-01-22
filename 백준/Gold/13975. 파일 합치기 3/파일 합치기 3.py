import heapq



def solve():
    while len(arr) != 1:
        x = heapq.heappop(arr)
        y = heapq.heappop(arr)
        res.append(x + y)
        heapq.heappush(arr, x + y)

t = int(input())
for _ in range(t):
    res = []
    n = int(input())
    arr = list(map(int, input().split()))
    heapq.heapify(arr)
    solve()
    print(sum(res))
