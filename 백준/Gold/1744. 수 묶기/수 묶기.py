from queue import PriorityQueue
import sys
input = sys.stdin.readline

plus = PriorityQueue()
minus = PriorityQueue()
zero, one, sum = 0, 0, 0

n = int(input())
for _ in range(n):
    tmp = int(input())

    if tmp > 1:
        plus.put(-1 * tmp)
    elif tmp < 0:
        minus.put(tmp)
    elif tmp == 1:
        one += 1
    else:
        zero += 1



while plus.qsize() > 1: # 양수 큐 처리
    first = plus.get() * -1
    second = plus.get() * -1
    sum += first * second

if plus.qsize() > 0:
    sum += plus.get() * -1

while minus.qsize() > 1: # 음수 큐 처리
    first = minus.get()
    second = minus.get()
    sum += first * second

if minus.qsize() > 0:
    if zero == 0:
        sum += minus.get()

sum += one

print(sum)

