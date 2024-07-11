from collections import deque

N = int(input())

deq = deque()

for i in range(1, N + 1):
    deq.appendleft(i)
    
while len(deq) > 1:
    deq.pop()
    deq.appendleft(deq.pop())
    
print(*deq)